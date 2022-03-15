package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import VO.MascotaVo;
import VO.Nacimiento;
import VO.PersonaVo;
import VO.PersonasProductosVo;
import controlador.Coordinador;
import modelo.conexion.Conexion;

public class PersonaProductoDao {
	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	public String registrarPersonaProducto(PersonasProductosVo miPersonaProducto) {

		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;

		ResultSet result = null;
		String resultado = "";
		connection = conexion.getConnection();
		String consulta = "INSERT INTO personas_productos (persona_id,producto_id)"
				+ "  VALUES (?,?)";

		try {
			preStatement = connection.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
			preStatement.setLong(1, miPersonaProducto.getPersonaId());
			preStatement.setLong(2, miPersonaProducto.getProductoId());
			preStatement.execute();
			resultado = "Ok";
		} catch (SQLException e) {
			System.out.println("No se pudo registrar los datos del nacimiento: " + e.getMessage());
			e.printStackTrace();
			resultado = "Error";
		} catch (Exception e) {
			System.out.println("No se pudo registrar los datos del nacimiento: " + e.getMessage());
			e.printStackTrace();
			resultado = "Error";
		} finally {
			conexion.desconectar();
		}
		
		return resultado;
	}
	
	public PersonasProductosVo consultarPersonasProductos(Long idPersona) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		connection = miConexion.getConnection();

		PersonasProductosVo misPersonasProductos= null;
		
		
		String consulta = "SELECT * FROM personas_productos where persona_id= ? ";

		try {
			if (connection != null) {
				statement = connection.prepareStatement(consulta);
				statement.setLong(1, idPersona);

				result = statement.executeQuery();

				while (result.next() == true) {
					misPersonasProductos = new PersonasProductosVo();
					misPersonasProductos.setPersonaId(result.getLong("persona_id"));
					misPersonasProductos.setProductoId(result.getLong("producto_id"));
				}
				miConexion.desconectar();
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta de los productos de la persona: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error en la consulta de los productos la persona: " + e.getMessage());
		}
		return misPersonasProductos;
	}
	
	public String actualizarProductosPersona(PersonasProductosVo misProductosPersona) {

		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;

		String resultado = "";
		
		ResultSet result=null;
		
		connection = conexion.getConnection();
		String consulta = "UPDATE personas_productos SET persona_id = ?, producto_id = ? WHERE persona_id = ?";

		try {
			preStatement = connection.prepareStatement(consulta,Statement.RETURN_GENERATED_KEYS);
			preStatement.setDouble(1, misProductosPersona.getPersonaId());
			preStatement.setDouble(2, misProductosPersona.getProductoId());
			preStatement.execute();
			
			resultado = "ok";
		} catch (SQLException e) {
			System.out.println("No se pudo actualizar los datos del nacimiento: " + e.getMessage());
			e.printStackTrace();
			resultado = "Error";
		} catch (Exception e) {
			System.out.println("No se pudo actualizar los datos del nacimiento: " + e.getMessage());
			e.printStackTrace();
			resultado = "Error";
		}
		finally {
			conexion.desconectar();
		}
		return resultado;
		
	}
	
	public String borrarProductosPersona(Long idPersona)throws SQLException {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		connection = miConexion.getConnection();
		
		String resultado = "";
		
		PersonasProductosVo miPersonasProductosVo= null;

		String consulta = "DELETE FROM personas_productos where persona_id = ? ";

		try {
			if (connection != null) {
				statement = connection.prepareStatement(consulta);
				statement.setLong(1, idPersona);

				result = statement.executeQuery();
				
				resultado = "ok";
				
			}
		} catch (SQLException e) {
			System.out.println("Error en la eliminacion del producto de la persona: " + e.getMessage());
			resultado = "error";
		} catch (Exception e) {
			System.out.println("Error en la eliminacion del producto de la persona: " + e.getMessage());
			resultado = "error";
		}
		finally {
			statement.close();
			connection.close();
			miConexion.desconectar();
		}
		return resultado;
	}
	
	
	/**
public PersonasProductosVo consultarPersonaproducto(Long id_persona)throws SQLException {
		
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		PersonasProductosVo p=null;
		
		connection=miConexion.getConnection();
		
		String consulta="SELECT * FROM mascotas where id_persona= ? ";
		
		try {
			if (connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setLong(1, id_persona);
				
				result=statement.executeQuery();
				
				while(result.next()==true){
					p=new PersonasProductosVo();
					p.setPersonaId(Long.parseLong(result.getString("id_persona")));
					p.setProductoId((Long.parseLong(result.getString("id_persona")))); 
			
				}
				
				
			}else{
			p=null;
			}			   
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la mascota: "+e.getMessage());
		}
		finally {
			statement.close();
			result.close();  
			miConexion.desconectar();
		}
			return p;
	}
**/
}
