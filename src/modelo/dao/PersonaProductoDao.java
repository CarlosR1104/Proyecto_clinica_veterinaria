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
					misPersonasProductos.setCodigo(result.getLong("codigo"));
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
	
	
	
	public String borrarProductosPersona(Long idPersona)throws SQLException {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		connection = miConexion.getConnection();
		
		String resultado = "";
		
		

		String consulta = "DELETE FROM personas_productos where persona_id = ? ";

		try {
			
			System.out.println("hola bb");
			if (connection != null) {
				statement = connection.prepareStatement(consulta);
				statement.setLong(1, idPersona);

				statement.executeUpdate();
				
				System.out.println("mirando que es"+statement);
				resultado = "ok";
				
				
			}
		} catch (SQLException e) {
			System.out.println("Error en la eliminacion del produc: " + e.getMessage());
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
		System.out.println("EEEEEE"+resultado);
		return resultado;
	}
	
	
public PersonasProductosVo consultarPersonaproducto(Long id_producto)throws SQLException {
		System.out.println(id_producto+"tttt");
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		PersonasProductosVo p=null;
		
		connection=miConexion.getConnection();
		
		String consulta="SELECT * FROM personas_productos where producto_id= ? ";
		
		try {
			if (connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setLong(1, id_producto);
				
				result=statement.executeQuery();
				
				while(result.next()==true){
					
					p=new PersonasProductosVo();
					p.setPersonaId(Long.parseLong(result.getString("persona_id")));
					p.setProductoId(Long.parseLong(result.getString("producto_id"))); 
			
				}
				
				
			}else{
				System.out.println("holas dd");
			
			}			   
		} catch (SQLException e) {
			System.out.println("Error en la consulta : "+e.getMessage());
		}
		finally {
			statement.close();
			result.close();  
			miConexion.desconectar();
		}
			return p;
	}
}
