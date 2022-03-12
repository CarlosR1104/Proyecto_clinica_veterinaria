package controlador;

import java.text.ParseException;

import gui.RegistrarMascotasGui;
import gui.RegistrarPersonasGui;
import gui.RegistrarProductosGui;
import gui.VentanaConsultIndividual;
import gui.VentanaPrincipal;
import modelo.dao.NacimientoDao;
import modelo.dao.PersonaDao;

public class Relaciones {

	public Relaciones() throws ParseException {
		
		
		//Se declaran las clases que van a representar instancias unicas
		
		VentanaPrincipal miVentanaPrincipal;
		VentanaConsultIndividual miVentanaConsultIndividual;
		RegistrarPersonasGui miRegistrarPersonasGui;
		RegistrarMascotasGui miRegistrarMascotasGui;
		RegistrarProductosGui miRegistrarProductosGui;
		Coordinador miCoordinador;
		PersonaDao miPersonaDao;
		NacimientoDao miNacimientoDao;
		//MascotaDao miMascotaDao;
		//ProductoDao miProductoDao;
		//PersonaProductoDao miPersonaProductoDao;
		
		
		//Se instancian por unica ocasión las clases declaradas
		
		miVentanaPrincipal= new VentanaPrincipal();
		miVentanaConsultIndividual=new VentanaConsultIndividual();
		miRegistrarPersonasGui= new RegistrarPersonasGui(miVentanaPrincipal, true);
		miRegistrarMascotasGui= new RegistrarMascotasGui(miVentanaPrincipal, true,"");
		miRegistrarProductosGui= new RegistrarProductosGui(miVentanaPrincipal, true);
		
		miCoordinador= new Coordinador();
		miPersonaDao= new PersonaDao();
		//miMascotaDao= new MascotaDao();
		miNacimientoDao= new NacimientoDao();
		//miProductoDao= new ProductoDao();
		//miPersonaProductoDao= new PersonaProductoDao();
		
		
		//Se establece la relación entre el coordinador y cada instancia unica
		//Al coordinador se le asigna el control de cada clase unica
		
		miCoordinador.setVentanaPrincipal(miVentanaPrincipal);
		miCoordinador.setMiVentanaConsultIndividual(miVentanaConsultIndividual);
		miCoordinador.setRegistrarPersonasGui(miRegistrarPersonasGui);
		miCoordinador.setRegistrarMascotasGui(miRegistrarMascotasGui);
		miCoordinador.setRegistrarProductosGui(miRegistrarProductosGui);
		miCoordinador.setPersonaDao(miPersonaDao);
		//miCoordinador.setMascotaDao(miMascotaDao);
		miCoordinador.setNacimientoDao(miNacimientoDao);
		//miCoordinador.setProductoDao(miProductoDao);
		//miCoordinador.setPersonaProductoDao(miPersonaProductoDao);
	
	
		//A cada clase unica se le asigna la unica instancia del coordinador
		miVentanaPrincipal.setCoordinador(miCoordinador);
		miVentanaConsultIndividual.setMiCoordinador(miCoordinador);
		miRegistrarPersonasGui.setCoordinador(miCoordinador);
		miRegistrarMascotasGui.setCoordinador(miCoordinador);
		miRegistrarProductosGui.setCoordinador(miCoordinador);
		miPersonaDao.setCoordinador(miCoordinador);
		miNacimientoDao.setCoordinador(miCoordinador);
		//miMascotaDao.setCoordinador(miCoordinador);
		//miProductoDao.setCoordinador(miCoordinador);
		//miPersonaProductoDao.setCoordinador(miCoordinador);

		//Se muestra la ventana principal.
		miVentanaPrincipal.setVisible(true);
	}
}
