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
			System.out.println("Error al realizar la consulta sobre infractores: "
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

    public int insertarInfractor(Infractor infractor) {
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		int resultado=0;
		
		try {
			consulta = con.prepareStatement("INSERT INTO infractores(dni, nombre, apellidos, antiguedad, sancion, puntos) "
					+ "VALUES "
					+ "(?,?,?,?,?,?)");
			
			consulta.setString(1, infractor.getDni());
			consulta.setString(2, infractor.getNombre());
			consulta.setString(3, infractor.getApellidos());
			consulta.setInt(4, infractor.getAntiguedad());
			consulta.setFloat(5, infractor.getSancion());
			consulta.setInt(6, infractor.getPuntos());
			
			resultado=consulta.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar la inserción de un infractor: "
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
    
    //Los siguientes métodos no los pide el ejercicio; se han añadido para futuras mejoras del proyecto.
    public Infractor obtenerInfractor(String dni) {
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Infractor infractor = null;
		
		try {
			consulta = con.prepareStatement("select * from infractores"
					+ " where dni = ?");
			consulta.setString(1, dni);
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
			System.out.println("Error al realizar la consulta sobre un infractor: "
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
		return infractor;
    }

    public int actualizarInfractor(Infractor infractor) {
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		int resultado=0;
		
		try {
			consulta = con.prepareStatement("UPDATE infractores "
					+ "SET "
					+ "nombre = ?, "
					+ "apellidos = ?, "
					+ "antiguedad = ?, "
					+ "sancion = ?, "
					+ "puntos = ?, "
					+ "WHERE dni = ?");
			
			consulta.setString(6, infractor.getDni());
			consulta.setString(1, infractor.getNombre());
			consulta.setString(2, infractor.getApellidos());
			consulta.setInt(3, infractor.getAntiguedad());
			consulta.setFloat(4, infractor.getSancion());
			consulta.setInt(5, infractor.getPuntos());
			resultado=consulta.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar la actualizacion del infractor: "
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


    public int eliminarInfractor(Infractor infractor) {
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		int resultado=0;
		
		try {
			consulta = con.prepareStatement("DELETE FROM infractores "
					+ "WHERE dni = ?");
			
			consulta.setString(1, infractor.getDni());
			resultado=consulta.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar el borrado de un infractor: "+e.getMessage());
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
