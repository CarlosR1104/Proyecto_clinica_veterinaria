package controlador;

import java.text.ParseException;

import gui.ConsultarPersonas;
import gui.RegistrarMascotasGui;
import gui.RegistrarPersonasGui;
import gui.RegistrarProductosGui;
import gui.VentanaConsultIndividual;
import gui.VentanaEliminar;
import gui.VentanaEliminarProductos;
import gui.VentanaPrincipal;
import modelo.dao.MascotaDao;
import modelo.dao.NacimientoDao;
import modelo.dao.PersonaDao;
import modelo.dao.ProductoDao;

public class Relaciones {

	public Relaciones() throws ParseException {
		
		
		//Se declaran las clases que van a representar instancias unicas
		
		VentanaPrincipal miVentanaPrincipal;
		VentanaConsultIndividual miVentanaConsultIndividual;
		VentanaEliminar miVentanaEliminar;
		RegistrarPersonasGui miRegistrarPersonasGui;
		RegistrarMascotasGui miRegistrarMascotasGui;
		RegistrarProductosGui miRegistrarProductosGui;
		Coordinador miCoordinador;
		PersonaDao miPersonaDao;
		NacimientoDao miNacimientoDao;
		MascotaDao miMascotaDao;
		ProductoDao miProductoDao;
		VentanaEliminarProductos miVentanaEliminarP;
		ConsultarPersonas consultarPersonas;
		//PersonaProductoDao miPersonaProductoDao;
		
		
		//Se instancian por unica ocasi�n las clases declaradas
		
		miVentanaPrincipal= new VentanaPrincipal();
		miVentanaConsultIndividual=new VentanaConsultIndividual();
		miVentanaEliminar = new VentanaEliminar();
		miRegistrarPersonasGui= new RegistrarPersonasGui(miVentanaPrincipal, true);
		miRegistrarMascotasGui= new RegistrarMascotasGui(miVentanaPrincipal, true,"");
		miRegistrarProductosGui= new RegistrarProductosGui(miVentanaPrincipal, true);
		miVentanaEliminarP = new VentanaEliminarProductos();
		consultarPersonas = new ConsultarPersonas();
		
		miCoordinador= new Coordinador();
		miPersonaDao= new PersonaDao();
		miMascotaDao= new MascotaDao();
		miNacimientoDao= new NacimientoDao();
		miProductoDao= new ProductoDao();
		//miPersonaProductoDao= new PersonaProductoDao();
		
		
		//Se establece la relaci�n entre el coordinador y cada instancia unica
		//Al coordinador se le asigna el control de cada clase unica
		
		miCoordinador.setVentanaPrincipal(miVentanaPrincipal);
		miCoordinador.setMiVentanaConsultIndividual(miVentanaConsultIndividual);
		miCoordinador.setVentanaEliminar(miVentanaEliminar);
		miCoordinador.setRegistrarPersonasGui(miRegistrarPersonasGui);
		miCoordinador.setRegistrarMascotasGui(miRegistrarMascotasGui);
		miCoordinador.setRegistrarProductosGui(miRegistrarProductosGui);
		miCoordinador.setPersonaDao(miPersonaDao);
		miCoordinador.setMascotaDao(miMascotaDao);
		miCoordinador.setNacimientoDao(miNacimientoDao);
		miCoordinador.setProductoDao(miProductoDao);
		miCoordinador.setVentanaEliminarP(miVentanaEliminarP);
		miCoordinador.setConsultarPersonas(consultarPersonas);
		//miCoordinador.setPersonaProductoDao(miPersonaProductoDao);
	
	
		//A cada clase unica se le asigna la unica instancia del coordinador
		miVentanaPrincipal.setCoordinador(miCoordinador);
		miVentanaConsultIndividual.setMiCoordinador(miCoordinador);
		miVentanaEliminar.setCoordinador(miCoordinador);
		miRegistrarPersonasGui.setCoordinador(miCoordinador);
		miRegistrarMascotasGui.setCoordinador(miCoordinador);
		miRegistrarProductosGui.setCoordinador(miCoordinador);
		miPersonaDao.setCoordinador(miCoordinador);
		miNacimientoDao.setCoordinador(miCoordinador);
		miMascotaDao.setCoordinador(miCoordinador);
		miProductoDao.setCoordinador(miCoordinador);
		miVentanaEliminarP.setCoordinador(miCoordinador);
		consultarPersonas.setCoordinador(miCoordinador);
		//miPersonaProductoDao.setCoordinador(miCoordinador);

		//Se muestra la ventana principal.
		miVentanaPrincipal.setVisible(true);
	}
}
