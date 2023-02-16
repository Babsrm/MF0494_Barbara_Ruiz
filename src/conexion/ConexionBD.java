package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Barbara Ruiz
 *
 */
public class ConexionBD {

	private static final String database = "dgt";
	private static final String usuario = "barbara";
	private static final String contrasena = "1234";
	private static final String url="jdbc:mysql://localhost/"+database;
//	create user 'barbara' IDENTIFIED by '1234';
//	grant select, insert, delete, update on dgt.* to 'barbara';
	
	private Connection conexion=null;
	
	
	public Connection getConexion() {
		if (conexion!=null) {
			return conexion;
		}
		
		// REgistra el driver de MySQL
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conexion = DriverManager.getConnection(url, usuario, contrasena);
			System.out.println("Conexion a dgt correcta");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver no registrado");
		} catch (SQLException e) {
			System.out.println("Error SQLException: "+e.getMessage());
		}
		return conexion;
	}
	
	public void desconectar() {
		try {
			conexion.close();
			conexion=null;
		} catch (SQLException e) {
			System.out.println("Erorr cerrrando la conexion "+ e.getMessage());
		}
	}

}
