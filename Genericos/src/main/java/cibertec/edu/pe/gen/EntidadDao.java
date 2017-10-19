package cibertec.edu.pe.gen;

public interface EntidadDao<T> {

	int registrar(T t);
	
	int eliminar(T t);
	
	T buscar(T T);
}
