package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import VO.MascotaVo;
import VO.Nacimiento;
import VO.PersonaVo;
import gui.RegistrarMascotasGui;
import gui.RegistrarPersonasGui;
import gui.RegistrarProductosGui;
import gui.VentanaConsultIndividual;
import gui.VentanaEliminar;
import gui.VentanaPrincipal;
import modelo.dao.MascotaDao;
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
	MascotaDao miMascotaDao;
	VentanaEliminar miVentanaEliminar;
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
	
	public void setMascotaDao(MascotaDao miMascotaDao) {
		this.miMascotaDao=miMascotaDao;
	}
	
	public void setVentanaEliminar(VentanaEliminar miVentanaEliminar) {
		this.miVentanaEliminar = miVentanaEliminar;
	}
	
	public void mostrarRegistroPersonas() {
		miRegistrarPersonasGui.setVisible(true);
	}
	
	public void mostrarEliminarPersonas() {
		miVentanaEliminar.setVisible(true);
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
		
	public long registrarMascota(MascotaVo m) {
		Long h= null;
		try {
			h=miMascotaDao.registrarMascota(m);
		} catch (Exception e) {
			h = null;
		}
		return h;
		
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
	public MascotaVo buscarMascota (long idMascota) {
		
		try {
			MascotaVo m=miMascotaDao.consultarMascota(idMascota);
			return m;
			
		} catch (Exception e) {
			return null;
			
		}
		
	}
	
	public String eliminarMascota (Long idMascota) {
		String em = null;
		try {
			em = miMascotaDao.borrarMascota(idMascota);
			em = "Eliminado";
		} catch (Exception e) {
			em = "error";
		}
		
		return em;
	}
	
	public String eliminarPersona(long idDocumento) {
		String validar="";
		try {
			validar=miPersonaDao.eliminarPersonaDao(idDocumento);
			System.out.println(validar);
		} catch (Exception e) {
			validar="error al validar una persona para eliminar";
		}
		return validar;
	}

	public String eliminarNaciminto(Long idNacimiento) {
		String validar="";
		try {
			validar=miNacimientoDao.eliminarNacimientoDao(idNacimiento);
		} catch (Exception e) {
			validar="error con eliminar mi nacimiento";
		}
		return null;
	}

	public String actualizaPersona(PersonaVo encontrado) {
		 String resultado="";
		 try {
			resultado=miPersonaDao.actualizarPersonaVo(encontrado);
		} catch (Exception e) {
			resultado="error en cordinador al actualizar";
		}
		return resultado;
	}

	public Nacimiento buscarNacimiento(Long idNacimiento) {
		Nacimiento nacimiento=null;
		try {
			nacimiento=miNacimientoDao.consultarNacimiento(idNacimiento);
		} catch (Exception e) {
			e.printStackTrace();
			nacimiento=null;
		}
		return nacimiento;
	}

}
