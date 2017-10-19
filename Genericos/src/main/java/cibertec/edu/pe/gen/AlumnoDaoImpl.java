package cibertec.edu.pe.gen;

public class AlumnoDaoImpl extends EntidadDaoImpl<Alumno>{
	
	public static void main(String[] args) {
		AlumnoDaoImpl d = new AlumnoDaoImpl();
		Alumno alumno = new Alumno();		
		alumno.setNombres("Aldo");
		alumno.setApellidos("Malaver1");
		alumno.setCorreo("almalaver@hotmail.com");
		alumno.setEstadoCivil(1);
		//System.out.println(d.armarConsulta(alumno));
		
//		d.registrar(alumno);
		
		EstadoCivilDaoImpl estadoCivilDaoImpl = new EstadoCivilDaoImpl();
		EstadoCivil estadoCivil = new EstadoCivil();
		estadoCivil.setNombre("Amigovio");
		estadoCivilDaoImpl.registrar(estadoCivil);
//		String arr = "abced";
//		System.out.println(arr.indexOf("abc"));
	}

}
