package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import VO.Nacimiento;
import VO.PersonaVo;
import gui.RegistrarMascotasGui;
import gui.RegistrarPersonasGui;
import gui.RegistrarProductosGui;
import gui.VentanaConsultIndividual;
import gui.VentanaPrincipal;
import modelo.dao.NacimientoDao;
import modelo.dao.PersonaDao;

public class Coordinador {

	
	VentanaPrincipal miVentanaPrincipal;
	VentanaConsultIndividual miVentanaConsultIndividual;
	RegistrarPersonasGui miRegistrarPersonasGui;
	RegistrarMascotasGui miRegistrarMascotasGui;
	RegistrarProductosGui miRegistrarProductosGui;
	PersonaDao miPersonaDao;
	NacimientoDao miNacimientoDao;
	//MascotaDao miMascotaDao;
	//ProductoDao miProductoDao;
	//PersonaProductoDao miPersonaProductoDao;

	
	public void setVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
	this.miVentanaPrincipal=miVentanaPrincipal;
	}

	public void setMiVentanaConsultIndividual(VentanaConsultIndividual miVentanaConsultIndividual) {
		this.miVentanaConsultIndividual = miVentanaConsultIndividual;
	}

	public void setRegistrarPersonasGui(RegistrarPersonasGui miRegistrarPersonasGui) {
	this.miRegistrarPersonasGui=miRegistrarPersonasGui;
	}
	
	public void setRegistrarMascotasGui(RegistrarMascotasGui miRegistrarMascotasGui) {
		this.miRegistrarMascotasGui=miRegistrarMascotasGui;
	}

	public void setRegistrarProductosGui(RegistrarProductosGui miRegistrarProductosGui){
		this.miRegistrarProductosGui=miRegistrarProductosGui;
	}

	public void setPersonaDao(PersonaDao miPersonaDao) {
		this.miPersonaDao=miPersonaDao;
	}

	public void setNacimientoDao(NacimientoDao miNacimientoDao) {
		this.miNacimientoDao=miNacimientoDao;
	}
	
	public void mostrarRegistroPersonas() {
		miRegistrarPersonasGui.setVisible(true);
	}
	
	public void mostrarRegistroMascotas() {
		miRegistrarMascotasGui.setVisible(true);
	}
	
	public void mostrarRegistroProductos() {
		miRegistrarProductosGui.setVisible(true);
	}
	
	public void mostrarConsultaIndividual() {
		miVentanaConsultIndividual.setVisible(true);
	}
	
	public String registrarPersonas(PersonaVo p) {
		String registrar="";
		try {
			
			registrar=miPersonaDao.registrarPersona(p);
			
		} catch (Exception e) {
			registrar = "NO SE HA REGISTRADO";
		}
		return registrar;
		
	}
		
	public long registrarNacimiento(Nacimiento n) {
		Long f = null;	
		try {
			
			 f = miNacimientoDao.registrarNacimiento(n);
		} catch (Exception e) {
			f =  null;
		}	
		return f;
	}
	
	public ArrayList<PersonaVo> consultar(PersonaVo miPersona) {
		try {
			return miPersonaDao.consultarListaPersona();
		} catch (Exception e) {
			return null;
		}
		
		
	}
	
	
	public PersonaVo buscarPersona (long documento) {
		
		try {
			PersonaVo p=miPersonaDao.consultarPersona(documento);
			return p;
			
		} catch (Exception e) {
			return null;
			
		}
		
	}
}
