package cibertec.edu.pe.gen;

import java.lang.reflect.Field;

public class Generico {
	
	public static void main(String[] args) {
		Alumno alumno = new Alumno();
		alumno.setIdAlumno(1);
		
		
		Aula<Alumno> aula = new Aula<Alumno>();
		aula.aulaVacia();
		
		Aula<Profesor> aulaPro = new Aula<Profesor>();
		aulaPro.aulaVacia();
		
		MiHashMap<String, String> mi = new MiHashMap<>();
		mi.put("1", "Aldo");
		
		System.out.println(mi.get("1"));
		
		Field[] arr =  Alumno.class.getDeclaredFields();
		for(Field f : arr) {
			System.out.println(f.getName());
		}
		
	}

}
