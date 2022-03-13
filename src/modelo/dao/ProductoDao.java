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
import VO.ProductoVo;
import controlador.Coordinador;
import modelo.conexion.Conexion;

public class ProductoDao {
	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}

	public String registrarProducto(ProductoVo miProducto) {
		
		String resultado = "";

		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;

		connection = conexion.getConnection();
		String consulta = "INSERT INTO productos (nombre_producto,precio_producto)"
				+ "  VALUES (?,?)";

		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miProducto.getNombreProducto());
			preStatement.setDouble(2, miProducto.getPrecioProducto());
			preStatement.execute();

			resultado = "ok";

		}catch (SQLException e) {
			System.out.println("No se pudo registrar el producto, verifique el id no exista: " + e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo registrar el producto";
		}
		catch (Exception e) {
			System.out.println("No se pudo registrar el producto: " + e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo registrar la persona";
		}
		finally {
			conexion.desconectar();
		}

		return resultado;
		
	}
	public ProductoVo consultarProducto(Long idProducto) {
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		ProductoVo miProducto=null;
		
		connection=miConexion.getConnection();
		
		String consulta="SELECT * FROM productos where id_producto= ? ";
		
		try {
			if (connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setLong(1, idProducto);
				
				result=statement.executeQuery();
				
				while(result.next()==true){
					miProducto=new ProductoVo();
					miProducto.setIdProducto(result.getLong("id_producto"));
					miProducto.setNombreProducto(result.getString("nombre_producto"));
					miProducto.setPrecioProducto(result.getDouble("precio_producto"));
					
				}		
				   miConexion.desconectar();
			}else{
				miProducto=null;
			}			   
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la persona: "+e.getMessage());
		}
			return miProducto;
	}
	
	public String actualizarProducto(ProductoVo miProducto) {
		
		String resultado = "";
		Long idProducto=null;
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;

		ResultSet result=null;
		
		connection = conexion.getConnection();
		String consulta = "UPDATE productos SET nombre_producto = ?, precio_producto = ? WHERE id_producto = ?";

		try {
			preStatement = connection.prepareStatement(consulta,Statement.RETURN_GENERATED_KEYS);
			preStatement.setString(1, miProducto.getNombreProducto());
			preStatement.setDouble(2, miProducto.getPrecioProducto());
			preStatement.setDouble(3, miProducto.getIdProducto());
			preStatement.execute();
			

		} catch (SQLException e) {
			System.out.println("No se pudo actualizar los datos del producto: " + e.getMessage());
			e.printStackTrace();
			idProducto = null;
		} catch (Exception e) {
			System.out.println("No se pudo actualizar los datos del producto: " + e.getMessage());
			e.printStackTrace();
			idProducto = null;
		}
		finally {
			conexion.desconectar();
		}
		return resultado;
		
	}
	
	public String borrarProducto(Long idProducto) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		connection = miConexion.getConnection();
		
		String resultado = "";
		
		ProductoVo miProducto = null;

		try {
			if (connection != null) {
				
				String consulta = "DELETE FROM productos where id_producto= ? ";
				
				statement = connection.prepareStatement(consulta);
				statement.setLong(1,idProducto);
				statement.executeUpdate();
				
				resultado = "Eliminado DAO";
			}
		} catch (SQLException e) {
			System.out.println("Error en la eliminacion del producto: " + e.getMessage());
			resultado = "error";
		} catch (Exception e) {
			System.out.println("Error en la eliminacion del producto: " + e.getMessage());
			resultado = "error";
		}
		return resultado;
	}




}
