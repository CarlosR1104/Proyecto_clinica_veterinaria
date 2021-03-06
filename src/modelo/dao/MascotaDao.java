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
import controlador.Coordinador;
import modelo.conexion.Conexion;

public class MascotaDao {
	private Coordinador miCoordinador;
	private PersonaVo miPersona;
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	public String registrarMascota(MascotaVo miMascota) {
		String resultado="";
		Long idMascota = null;
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		Statement s=null;
		ResultSet result = null;
		connection = conexion.getConnection();
		String consulta = "INSERT INTO mascotas (color,nombre,raza,sexo,persona_id)"
				+ "  VALUES (?,?,?,?,?)";

		try {
			preStatement = connection.prepareStatement(consulta, s.RETURN_GENERATED_KEYS);
			preStatement.setString(1, miMascota.getColorMascota());
			preStatement.setString(2, miMascota.getNombre());
			preStatement.setString(3, miMascota.getRaza());
			preStatement.setString(4, miMascota.getSexo());
			preStatement.setLong(5, miMascota.getPersona().getIdPesona());
			preStatement.execute();

			result = preStatement.getGeneratedKeys();
			if (result.next()) {
				idMascota = result.getLong(1);
			}
			
			resultado="ok";

		} catch (SQLException e) {
			System.out.println("No se pudo registrar los datos del nacimiento: " + e.getMessage());
			e.printStackTrace();
			idMascota = null;
		} catch (Exception e) {
			System.out.println("No se pudo registrar los datos del nacimiento: " + e.getMessage());
			e.printStackTrace();
			idMascota = null;
		} finally {
			conexion.desconectar();
		}
		System.out.println("El ID de la mascota es: " + idMascota);
		return resultado;

	}
	
	public MascotaVo consultarMascota(String nombre) {
		
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		PersonaVo miPersona=null;
		MascotaVo miMascota=null;
		
		connection=miConexion.getConnection();
		
		String consulta="SELECT * FROM mascotas where nombre= ? ";
		
		try {
			if (connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setString(1, nombre);
				
				result=statement.executeQuery();
				
				while(result.next()==true){
					miMascota=new MascotaVo();
					miMascota.setIdMascota(result.getLong("id_mascota"));
					miMascota.setColorMascota(result.getString("color"));
					miMascota.setNombre(result.getString("nombre"));
					miMascota.setRaza(result.getString("raza"));
					miMascota.setSexo(result.getString("sexo"));
					
					miPersona = new PersonaVo();
					miPersona.setIdPesona(Long.parseLong(result.getString("persona_id")));
					miMascota.setPersona(miPersona);		
				}		
				statement.close();
				result.close();  
				miConexion.desconectar();
			}else{
				miPersona=null;
			}			   
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la mascota: "+e.getMessage());
		}
			return miMascota;
	}
	
	public String actualizarMascota(MascotaVo miMascota) throws SQLException {
		
		String resultado = "";
		Long idMascota=null;
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		Statement s = null;
		ResultSet result=null;
		connection = conexion.getConnection();
		System.out.println("MASCOTA DAO "+miMascota);
		
		try {			
			String consulta = "UPDATE mascotas "+ "SET color = ? ," + "nombre = ? ," +"raza = ? ," +"sexo = ?" + "Where id_mascota = ? ;";

			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miMascota.getColorMascota());
			preStatement.setString(2, miMascota.getNombre());
			preStatement.setString(3, miMascota.getRaza());
			preStatement.setString(4, miMascota.getSexo());
			preStatement.setLong(5, miMascota.getIdMascota());
			preStatement.executeUpdate();
			
			resultado = "ok";
		} catch (SQLException e) {
			System.out.println("No se pudo actualizar los datos de la mascota sql: " + e.getMessage());
			e.printStackTrace();
			idMascota = null;
			resultado = "ERROR";
		} catch (Exception e) {
			System.out.println("No se pudo actualizar los datos de la mascota: " + e.getMessage());
			e.printStackTrace();
			idMascota = null;
			resultado = "ERROR";
			
		}
		finally {
			preStatement.close();
			result.close();
			conexion.desconectar();
		}
		return resultado;
		
	}
	
	public String borrarMascota(Long persona_id)throws SQLException  {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement st = null;
		connection = miConexion.getConnection();
		
		ResultSet result = null;
		String resultado = "";
		
		
		try {
			if (connection != null) {
				
				String ejecutar = "DELETE FROM mascotas WHERE persona_id = ?";
				
				st = connection.prepareStatement(ejecutar);
				st.setLong(1,persona_id);
				st.executeUpdate();
				
				resultado = "ok";
			}
		} catch (SQLException e) {
			System.out.println("Error en la eliminacion de la mascota sql: " + e.getMessage());
			resultado = "error";
		} catch (Exception e) {
			System.out.println("Error en la eliminacion de la mascota: " + e.getMessage());
			resultado = "error";
		}
		finally {
			st.close();
			connection.close();
			miConexion.desconectar();
		}
		return resultado;
	}

	public MascotaVo consultarMascotaIdPersona(long idPesona) {
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		PersonaVo miPersona=null;
		MascotaVo miMascota=null;
		
		connection=miConexion.getConnection();
		
		String consulta="SELECT * FROM mascotas where persona_id= ? ";
		
		try {
			if (connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setLong(1, idPesona);
				
				result=statement.executeQuery();
				
				while(result.next()==true){
					miMascota=new MascotaVo();
					miMascota.setIdMascota(result.getLong("id_mascota"));
					miMascota.setColorMascota(result.getString("color"));
					miMascota.setNombre(result.getString("nombre"));
					miMascota.setRaza(result.getString("raza"));
					miMascota.setSexo(result.getString("sexo"));
					
					miPersona = new PersonaVo();
					miPersona.setIdPesona(Long.parseLong(result.getString("persona_id")));
					miMascota.setPersona(miPersona);		
				}		
				statement.close();
				result.close();  
				miConexion.desconectar();
			}else{
				miPersona=null;
			}			   
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la mascota: "+e.getMessage());
		}
			return miMascota;
	
	}

	
}
