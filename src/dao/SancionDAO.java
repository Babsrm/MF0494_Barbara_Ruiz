/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.ConexionBD;
import modelo.Sancion;

/**
 * @author David
 * Clase que implementa un CRUD de la base batos
 * (Create, Read, update y delete)
 */
public class SancionDAO {

	private ConexionBD conexion;
	
    public SancionDAO() {
        this.conexion = new ConexionBD();
    }


    public ArrayList<Sancion> obtenerSanciones() {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		Statement consulta = null;
		ResultSet resultado = null;
		ArrayList<Sancion> lista = new ArrayList<Sancion>();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from sanciones");
			
			// Bucle para recorrer todas las filas que devuelve la consulta
			while(resultado.next()) {
				int idSancion = resultado.getInt("idSancion");
				String descripcion = resultado.getString("descripcion");
				float importe = resultado.getFloat("importe");
				
				Sancion s = new Sancion(idSancion, descripcion, importe);
				lista.add(s);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre sanciones: "+e.getMessage());
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

    
    

    public Sancion obtenerSancion(int idSancion) {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Sancion s = null;
		
		try {
			consulta = con.prepareStatement("select * from sanciones"
					+ " where idSancion = ?");
			consulta.setInt(1, idSancion);
			resultado=consulta.executeQuery();
			
			// Bucle para recorrer todas las filas que devuelve la consulta
			if (resultado.next()) {
				String descripcion = resultado.getString("descripcion");
				float importe = resultado.getFloat("importe");
				
				s = new Sancion(idSancion, descripcion, importe);
				
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


    public int insertarSancion(Sancion s) {
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
			System.out.println("Error al realizar la inserción de una sanción: "
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

    public int actualizarSancion(Sancion s) {
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
			System.out.println("Error al realizar la actualizacion de la sanción: "
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


    public int eliminarSancion(Sancion s) {
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
			System.out.println("Error al realizar el borrado de una sanción: "+e.getMessage());
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
