



package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import controlador.Coordinador;
import modelo.conexion.Conexion;
import VO.Nacimiento;
import VO.PersonaVo;

public class PersonaDao {

	private Coordinador miCoordinador;
	Nacimiento n = new Nacimiento();
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}

	public String registrarPersona(PersonaVo miPersona) throws SQLException {
		
		String resultado = "";
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;

		connection = conexion.getConnection();
		String consulta = "INSERT INTO persona (id_persona,nombre_persona,profesion_persona,telefono_persona,tipo_persona,nacimiento_id)"
				+ "  VALUES (?,?,?,?,?,?)";
		
		
		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setLong(1, miPersona.getIdPesona());
			preStatement.setString(2, miPersona.getNombre());
			preStatement.setString(3, miPersona.getProfesion());
			preStatement.setString(4, miPersona.getTelefono());
			preStatement.setInt(5, miPersona.getTipo());
			preStatement.setLong(6, miPersona.getNacimiento().getIdNacimiento());
			
			preStatement.execute();

			resultado = "ok";

		}catch (SQLException e) {
			e.printStackTrace();
			resultado = "No se pudo ";
		}
		catch (Exception e) {
			System.out.println("No se pudo registrar la persona: " + e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo registrar la persona";
		}
		finally {
			
			preStatement.close();
			connection.close();
			conexion.desconectar();

		}
		

		return resultado;
		
	}
	public PersonaVo consultarPersona(long idDocumento) throws SQLException {
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		PersonaVo miPersona=null;
		Nacimiento miNacimiento=null;
		
		connection=miConexion.getConnection();
		
		String consulta="SELECT * FROM persona where id_persona= ? ";
		
		try {
			if (connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setLong(1, idDocumento);
				
				result=statement.executeQuery();
				
				while(result.next()==true){
					miPersona=new PersonaVo();
					miPersona.setIdPesona(result.getLong("id_persona"));
					miPersona.setNombre(result.getString("nombre_persona"));
					miPersona.setProfesion(result.getString("profesion_persona"));
					miPersona.setTelefono(result.getString("telefono_persona"));
					miPersona.setTipo(result.getInt("tipo_persona"));
					
					miNacimiento =new Nacimiento();
					miNacimiento.setIdNacimiento(Long.parseLong(result.getString("nacimiento_id")));
					
					miPersona.setNacimiento(miNacimiento);		
					
				}		
				 
			}else{
				miPersona=null;
			}			   
		} catch (SQLException e) {
		}
		finally {
			result.close();
			statement.close();
			connection.close();
			miConexion.desconectar();

		}
			return miPersona;
	}
	
	
	
	
	public ArrayList<PersonaVo> consultarListaPersona() throws SQLException {
		ArrayList<PersonaVo> listaPersona = new ArrayList<PersonaVo>();
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		PersonaVo miPersona=null;
		Nacimiento miNacimiento=null;
				
		connection=miConexion.getConnection();
		
		String consulta = "SELECT id_persona,nombre_persona,profesion_persona,telefono_persona,tipo_persona,nacimiento_id"+" FROM persona";
		
		try {
			if (connection!=null) {
				statement=connection.prepareStatement(consulta);
				result=statement.executeQuery();
				
				while(result.next()==true){
					miPersona=new PersonaVo();
					miPersona.setIdPesona(result.getLong("id_persona"));
					miPersona.setNombre(result.getString("nombre_persona"));
					miPersona.setProfesion(result.getString("profesion_persona"));
					miPersona.setTelefono(result.getString("telefono_persona"));
					miPersona.setTipo(result.getInt("tipo_persona"));
					
					miNacimiento =new Nacimiento();
					miNacimiento.setIdNacimiento(Long.parseLong(result.getString("nacimiento_id")));
					//miPersona.setNacimiento(miNacimiento);	
					
					listaPersona.add(miPersona);
					
				}		
				   miConexion.desconectar();
			}else{
				miPersona=null;
			}			   
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la persona: "+e.getMessage());
		}
		finally {
			result.close();
			statement.close();
			connection.close();
			miConexion.desconectar();

		}
			return listaPersona;
	}
	public String actualizarPersonaVo(PersonaVo p)throws SQLException  {
		String resultado="";
		
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		
				
		connection=miConexion.getConnection();
		try {
			String consulta ="UPDATE  persona " + "SET nombre_persona = ? ," + "profesion_persona = ? ," + "telefono_persona = ? ,"+ " tipo_persona = ? " 
					+" Where id_persona = ? ;";
			System.out.println(consulta);
			statement=connection.prepareStatement(consulta);
			
			
			statement.setString(1, p.getNombre());
			statement.setString(2, p.getProfesion());
			statement.setString(3, p.getTelefono());
			statement.setInt(4, p.getTipo());
			

			statement.setLong(5,p.getIdPesona());
			System.out.println(statement);
			statement.executeUpdate();
			
			
			resultado="ok";
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("error en actualizar");
		}
		finally {
			statement.close();
			connection.close();
			miConexion.desconectar();

			
		}
		return resultado;
		
	}
	public String eliminarPersonaDao(long idDocumento) throws SQLException{
		
		System.out.println("hola");
		String respuesta="";
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
			
		connection=miConexion.getConnection();
		try {
			
			String Sentencia = " Delete from persona Where id_persona = ? ";
			
			statement=connection.prepareStatement(Sentencia);
			statement.setLong(1, idDocumento);
			statement.executeUpdate();
			System.out.println("hola jon");
			
			respuesta="ok";
			System.out.println(respuesta);
			
		} catch (Exception e) {
			System.out.println("error no dejo eliminar");
			e.printStackTrace();
		}
		finally{
			statement.close();
			connection.close();
			miConexion.desconectar();
		}
		System.out.println("estamos retornando la consulta eliminar");
		return respuesta;
		
	}
}


