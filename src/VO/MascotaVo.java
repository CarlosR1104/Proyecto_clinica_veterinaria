package VO;

public class MascotaVo {
	
	private Long idMascota;
	private String nombre;
	private String raza;
	private String colorMascota;
	private String sexo;
	private PersonaVo Persona;

	public MascotaVo() {
		
	}
	
	//Creamos el constructor con parametros sin el id	
	public MascotaVo(String nombre, String raza, String colorMascota, String sexo, PersonaVo duenio) {
		super();
		this.nombre = nombre;
		this.raza = raza;
		this.colorMascota = colorMascota;
		this.sexo = sexo;
		
	}
	

	public PersonaVo getPersona() {
		return Persona;
	}

	public void setPersona(PersonaVo Persona) {
		this.Persona = Persona;
	}

	public Long getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(Long idMascota) {
		this.idMascota = idMascota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColorMascota() {
		return colorMascota;
	}

	public void setColorMascota(String colorMascota) {
		this.colorMascota = colorMascota;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Mascota[idMascota=" + idMascota + "\n"
				+"nombre=" + nombre + "\n"
				+"raza=" + raza +"\n"
				+ "colorMascota="+ colorMascota +"\n" 
				+"sexo=" + sexo + "\n"+
				"Dueño "+Persona+"]";
	}
	
	public String cadenaMascota() {
		return "  ID: " + idMascota + "\n"+
				"  Nombre: " + nombre + "\n"
				+"  Raza: " + raza +"\n"
				+"  Color: "+ colorMascota +"\n" 
				+"  Sexo: " + sexo ;
				
	}

}
