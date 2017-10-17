package com.colas.example;

import java.io.Serializable;
import java.util.Optional;

public class Alumno implements Serializable {
	
	private static final long serialVersionUID = -8357679005993635891L;
	private Integer idAlumno;
	private String nombres;
	private String apellidos;
	private String estadoCivil;
	
	public Alumno() {
		Optional<Alumno> al = Optional.ofNullable(new Alumno());
		if(al.isPresent()) {
			Alumno alumno = al.get();
		}
	}

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

}
