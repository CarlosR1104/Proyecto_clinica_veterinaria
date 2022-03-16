package VO;

import java.util.ArrayList;
import java.util.List;

public class PersonaVo {

	private long idPesona;
	private String nombre;
	private String telefono;
	private String profesion;
	private int tipo;

	private Nacimiento nacimiento;
	private List<MascotaVo> listaMascotas;

	public PersonaVo() {
		this.listaMascotas = new ArrayList<MascotaVo>();
	}

	public PersonaVo(long idPesona, String nombre, String telefono, String profesion, int tipo, Nacimiento nacimiento) {
		super();
		this.idPesona = idPesona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.profesion = profesion;
		this.tipo = tipo;
		this.nacimiento = nacimiento;
		this.listaMascotas = new ArrayList<MascotaVo>();
	}

	public long getIdPesona() {
		return idPesona;
	}

	public void setIdPesona(long idPesona) {
		this.idPesona = idPesona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Nacimiento getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Nacimiento nacimiento) {
		this.nacimiento = nacimiento;
	}

	public List<MascotaVo> getListaMascotas() {
		return listaMascotas;
	}

	public void setListaMascotas(List<MascotaVo> listaMascotas) {
		this.listaMascotas = listaMascotas;
	}

	@Override
	public String toString() {
		return "Documento: " + idPesona + "\n" 
				+ "Nombre: " + nombre + "\n"+
				"Telefono: " + telefono +"\n"+ 
				"profesion: "+ profesion + "\n"+ 
				"Tipo: " + tipo + "\n" ;
	}
}
