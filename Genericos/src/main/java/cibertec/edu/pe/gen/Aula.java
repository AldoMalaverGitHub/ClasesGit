package cibertec.edu.pe.gen;

public class Aula<T> {
	
	private int contenido;
	
	public Aula<T> aulaVacia() {
		return new Aula<T>();
	}
	
	public int getContenido() {
		return this.contenido;
	}
	
	public void setContenido(int contenido) {
		this.contenido = contenido;
	}

}
