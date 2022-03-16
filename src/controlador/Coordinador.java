package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import VO.MascotaVo;
import VO.Nacimiento;
import VO.PersonaVo;
import VO.PersonasProductosVo;
import VO.ProductoVo;
import gui.ConsultarPersonas;
import gui.RegistrarMascotasGui;
import gui.RegistrarPersonasGui;
import gui.RegistrarProductosGui;
import gui.VentanaActualizarPersona;
import gui.VentanaConsultIndividual;
import gui.VentanaEliminar;
import gui.VentanaEliminarProductos;
import gui.VentanaPrincipal;
import modelo.dao.MascotaDao;
import modelo.dao.NacimientoDao;
import modelo.dao.PersonaDao;
import modelo.dao.PersonaProductoDao;
import modelo.dao.ProductoDao;

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
	ProductoDao miProductoDao;
	VentanaActualizarPersona miVentanaActualizarPersona;
	VentanaEliminarProductos miVentanaEliminarP;
	PersonaProductoDao miPersonaProductoDao;
	ConsultarPersonas consultarPersonas;
	

	public void setMiPersonaProductoDao(PersonaProductoDao miPersonaProductoDao) {
		this.miPersonaProductoDao = miPersonaProductoDao;
	}

	public void setVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}

	public void setMiVentanaActualizarPersona(VentanaActualizarPersona miVentanaActualizarPersona) {
		this.miVentanaActualizarPersona = miVentanaActualizarPersona;
	}

	public void setMiVentanaConsultIndividual(VentanaConsultIndividual miVentanaConsultIndividual) {
		this.miVentanaConsultIndividual = miVentanaConsultIndividual;
	}

	public void setRegistrarPersonasGui(RegistrarPersonasGui miRegistrarPersonasGui) {
		this.miRegistrarPersonasGui = miRegistrarPersonasGui;
	}

	public void setRegistrarMascotasGui(RegistrarMascotasGui miRegistrarMascotasGui) {
		this.miRegistrarMascotasGui = miRegistrarMascotasGui;
	}

	public void setRegistrarProductosGui(RegistrarProductosGui miRegistrarProductosGui) {
		this.miRegistrarProductosGui = miRegistrarProductosGui;
	}

	public void setPersonaDao(PersonaDao miPersonaDao) {
		this.miPersonaDao = miPersonaDao;
	}

	public void setProductoDao(ProductoDao miProductoDao) {
		this.miProductoDao = miProductoDao;
	}

	public void setNacimientoDao(NacimientoDao miNacimientoDao) {
		this.miNacimientoDao = miNacimientoDao;
	}

	public void setVentanaEliminarP(VentanaEliminarProductos miVentanaEliminarProductos) {
		this.miVentanaEliminarP = miVentanaEliminarProductos;
	}

	public void setMascotaDao(MascotaDao miMascotaDao) {
		this.miMascotaDao = miMascotaDao;
	}

	public void setVentanaEliminar(VentanaEliminar miVentanaEliminar) {
		this.miVentanaEliminar = miVentanaEliminar;
	}


	
	public void setConsultarPersonas(ConsultarPersonas consultarPersonas) {
		this.consultarPersonas = consultarPersonas;
	}


	public void mostrarRegistroPersonas() {
		miRegistrarPersonasGui.setVisible(true);
	}

	public void mostrarEliminarMascotas() {
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

	public void mostrarVenActualizar() {
		miVentanaActualizarPersona.setVisible(true);
	}

	public void mostrarEliminarProductos() {
		miVentanaEliminarP.setVisible(true);
	}

	
	public void mostrarConsultarPersonas() {
		consultarPersonas.setVisible(true);
	}
	

	public String registrarPersonas(PersonaVo p) {
		String registrar = "";
		try {

			registrar = miPersonaDao.registrarPersona(p);

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
			f = null;
		}
		return f;
	}

	public String registrarMascota(MascotaVo m) {
		String resultado = "";
		try {
			resultado = miMascotaDao.registrarMascota(m);
		} catch (Exception e) {
			System.out.println("errror");
		}
		return resultado;

	}

	public String registrarProductos(ProductoVo p) {
		String registrar = "";
		try {

			registrar = miProductoDao.registrarProducto(p);

		} catch (Exception e) {
			registrar = "NO SE HA REGISTRADO";
		}
		return registrar;

	}

	public ArrayList<PersonaVo> consultar(PersonaVo miPersona) {
		try {
			return miPersonaDao.consultarListaPersona();
		} catch (Exception e) {
			return null;
		}

	}

	public PersonaVo buscarPersona(long documento) {

		try {
			PersonaVo p = miPersonaDao.consultarPersona(documento);
			return p;

		} catch (Exception e) {
			return null;

		}

	}

	public ProductoVo buscarProducto(String nombre) {
		ProductoVo p;
		try {
			p = miProductoDao.consultarProducto(nombre);

		} catch (Exception e) {
			p = null;
		}
		return p;
	}

	public MascotaVo buscarMascota(String nombre) {
		MascotaVo m;
		try {
			m = miMascotaDao.consultarMascota(nombre);

		} catch (Exception e) {
			m = null;
		}
		return m;
	}

	public String eliminarMascota(Long idpersona) {
		String em = null;
		try {
			em = miMascotaDao.borrarMascota(idpersona);
		} catch (Exception e) {
			em = "error";
		}

		return em;
	}

	public String eliminarPersona(long idDocumento) {
		String validar = "";
		try {
			validar = miPersonaDao.eliminarPersonaDao(idDocumento);
			System.out.println(validar);
		} catch (Exception e) {
			validar = "error al eliminar personavo";
		}
		return validar;
	}

	public String eliminarNaciminto(Long idNacimiento) {
		String validar = "";
		try {
			validar = miNacimientoDao.eliminarNacimientoDao(idNacimiento);
		} catch (Exception e) {
			validar = "error con eliminar mi nacimiento";
		}
		return validar;
	}

	public String actualizaPersona(PersonaVo encontrado) {
		String resultado = "";
		try {
			resultado = miPersonaDao.actualizarPersonaVo(encontrado);
		} catch (Exception e) {
			resultado = "error en cordinador al actualizar";
		}
		return resultado;
	}

	public Nacimiento buscarNacimiento(Long idNacimiento) {
		Nacimiento nacimiento = null;
		try {
			nacimiento = miNacimientoDao.consultarNacimiento(idNacimiento);
		} catch (Exception e) {
			e.printStackTrace();
			nacimiento = null;
		}
		return nacimiento;
	}

	public String eliminarProducto(String nombre) {
		String em = null;
		try {
			em = miProductoDao.borrarProducto(nombre);

		} catch (Exception e) {
			System.out.println("error en el proceso");
		}

		return em;
	}

	public String actualizarMascota(MascotaVo miMascota) {
		String r = null;
		try {
			r = miMascotaDao.actualizarMascota(miMascota);
			r = "ok";
			System.out.println(miMascota);
		} catch (Exception e) {
			r = "ERROR";
			miMascota = null;
		}
		return r;
	}

	public String actualizarProducto(ProductoVo miProducto) {
		String r = null;
		try {
			r = miProductoDao.actualizarProducto(miProducto);
			r = "ok";
			System.out.println(miProducto);
		} catch (Exception e) {
			r = "ERROR";
			miProducto = null;
		}
		return r;
	}

	public String eliminarProductoPersona(Long id_persona) {
		String validar = "";
		try {
			validar = miPersonaProductoDao.borrarProductosPersona(id_persona);
		} catch (Exception e) {
			validar = "error con eliminar persona producto dao";
		}
		return validar;
	}

	public PersonasProductosVo buscarPersonaProducto(Long id_persona) {
		PersonasProductosVo p = null;
		try {
			p = miPersonaProductoDao.consultarPersonasProductos(id_persona);

		} catch (Exception e) {
			System.out.println("Error en cordinador");

		}
		return p;
	}

	public String eliminarProduct(Long id_persona) {
		String em = "";
		try {
			em = miProductoDao.borrarProduct(id_persona);

		} catch (Exception e) {
			System.out.println("error en el proceso");
		}

		return em;
	}

	public String actualizarNacimiento(Nacimiento encontradoNacimiento) {
		String encontrado = "";
		try {
			encontrado = miNacimientoDao.actualizarNacimiento(encontradoNacimiento);
		} catch (Exception e) {
			System.out.println("error al actualizar el nacimiento");
		}
		return encontrado;
	}



	public ArrayList<PersonaVo> consultarPersonas() {
		try {
			ArrayList<PersonaVo> LISTApersonas = miPersonaDao.consultarListaPersona();
			return LISTApersonas;
		} catch (Exception e) {
			return null;
		}
	
	}
	
}
