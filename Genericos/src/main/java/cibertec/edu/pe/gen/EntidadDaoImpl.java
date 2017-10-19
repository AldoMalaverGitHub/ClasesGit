package cibertec.edu.pe.gen;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class EntidadDaoImpl<T> implements EntidadDao<T> {

	@Override
	public int registrar(T t) {
		
		String mensaje = null;
		Conexion conn = new Conexion();
		String sql = armarConsulta(t);
		
		int nroRegistros = 0;
        try {
            Connection cn = conn.getConnection();

            if (cn == null) {
                mensaje = "No hay acceso a base de datos!";
            } else {
                Statement st = cn.createStatement();
                nroRegistros = st.executeUpdate(sql);
                cn.close();
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }

        return nroRegistros;

	}
	
	private String armarConsulta(T t) {
		StringBuilder sql = new StringBuilder("INSERT INTO ");
		Field[] fields = t.getClass().getDeclaredFields();
		Method[] methods = t.getClass().getDeclaredMethods();
		sql.append(t.getClass().getSimpleName()).append("(");
		Map<String, Object> valores = new HashMap<>();	
		StringBuilder values =  new StringBuilder(" ");
		
		for(int i = 0; i < methods.length; i++) {
			if(methods[i].getName().contains("get")) {
				try {					
					if(methods[i].getReturnType().getName().equals("java.lang.String")) {
						valores.put(methods[i].getName().substring(3).toLowerCase(), "'" + methods[i].invoke(t, new Object[] {}) + "'");
					}else {
						valores.put(methods[i].getName().substring(3).toLowerCase(), methods[i].invoke(t, new Object[] {}));
					}
					
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}		
		}
		
		for(int i = 0; i < fields.length; i++) {
			if(i == fields.length - 1) {
				sql.append(fields[i].getName().toLowerCase()).append(") VALUES(");
				values.append(valores.get(fields[i].getName().toLowerCase())).append(")");
			}else {
				sql.append(fields[i].getName().toLowerCase()).append(",");
				values.append(valores.get(fields[i].getName().toLowerCase())).append(",");
			}
		}
		
		sql.append(values);
		return sql.toString();
		
		
		
		
	}

	@Override
	public int eliminar(T t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T buscar(T T) {
		// TODO Auto-generated method stub
		return null;
	}


}
