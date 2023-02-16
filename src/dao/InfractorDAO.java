package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.ConexionBD;
import modelo.Infractor;

/**
 * @author Barbara Ruiz
 * Clase que implementa un CRUD de la base batos
 * (Create, Read, update y delete)
 */
public class InfractorDAO {

	private ConexionBD conexion;
	
    public InfractorDAO() {
        this.conexion = new ConexionBD();
    }


    public ArrayList<Infractor> obtenerInfractores() {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		Statement consulta = null;
		ResultSet resultado = null;
		ArrayList<Infractor> lista = new ArrayList<Infractor>();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from infractores");
			
			while(resultado.next()) {
				String dni = resultado.getString("dni");
				String nombre = resultado.getString("nombre");
				String apellidos = resultado.getString("apellidos");
				int antiguedad = resultado.getInt("antiguedad");
				float sancion = resultado.getFloat("sancion");
				int puntos = resultado.getInt("puntos");
				
				Infractor infractor = new Infractor(dni, nombre, apellidos, antiguedad, sancion, puntos);
				lista.add(infractor);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre sanciones: "
					+e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return lista;
    }

    
    

    public Infractor obtenerInfractor(String dni) {
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Infractor infractor = null;
		
		try {
			consulta = con.prepareStatement("select * from infractores"
					+ " where dni = ?");
			consulta.setInt(1, dni);
			resultado=consulta.executeQuery();
			
			if (resultado.next()) {
				String nombre = resultado.getString("nombre");
				String apellidos = resultado.getString("apellidos");
				int antiguedad = resultado.getInt("antiguedad");
				float sancion = resultado.getFloat("sancion");
				int puntos = resultado.getInt("puntos");
				
				infractor = new Infractor(dni, nombre, apellidos, antiguedad, sancion, puntos);
				
			}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre una sancion: "
		         +e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return s;
    }


    public int insertarSancion(Infractor s) {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		int resultado=0;
		
		try {
			consulta = con.prepareStatement("INSERT INTO sanciones(descripcion, importe) \r\n"
					+ "VALUES\r\n"
					+ "(?,?)");
			
			consulta.setString(1, s.getDescripcion());
			consulta.setFloat(2, s.getImporte());
			
			resultado=consulta.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar la inserci�n de una sanci�n: "
		        +e.getMessage());
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;
    }

    public int actualizarSancion(Infractor s) {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		int resultado=0;
		
		try {
			consulta = con.prepareStatement("UPDATE sanciones\r\n"
					+ "SET\r\n"
					+ "descripcion = ?,\r\n"
					+ "importe = ?,\r\n"
					+ "WHERE idSancion = ?");
			

			
			consulta.setString(1, s.getDescripcion());
			consulta.setFloat(2, s.getImporte());
			consulta.setFloat(3, s.getIdSancion());
			resultado=consulta.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar la actualizacion de la sanci�n: "
					+e.getMessage());
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;
    }


    public int eliminarSancion(Infractor s) {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		int resultado=0;
		
		try {
			consulta = con.prepareStatement("DELETE FROM sanciones\r\n"
					+ "WHERE idSancion = ?");
			
			consulta.setInt(1, s.getIdSancion());
			resultado=consulta.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar el borrado de una sanci�n: "+e.getMessage());
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;
    }

}
