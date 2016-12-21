package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {

	// public static Connection getConexion(){
	// Connection connection = null;
	// try {
	// String driverClassName = "com.mysql.jdbc.Driver";
	// String url = "jdbc:mysql://172.20.6.61:3306/moodle";
	// String user = "root";
	// String password = "hg$CbX&*!5nC";
	// Class.forName(driverClassName);
	// connection = DriverManager.getConnection(url, user, password);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return connection;
	// }

	public static void executeQuery(String query) throws SQLException {
		Connection conexion = getConexion();
		PreparedStatement consulta = null;
		try {
			consulta = conexion.prepareStatement("" + query + "");
			System.out.println(query);
			consulta.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
			consulta.close();
		}
	}

	public static Connection getConexion() {
		Connection connection = null;
		try {
			ArchivoProperties propiedades = new ArchivoProperties();
			Properties properties = propiedades.getProperties("conexion.properties");
			Class.forName(properties.getProperty("p_className"));
			connection = DriverManager.getConnection(properties.getProperty("p_url") + properties.getProperty("p_bd"),
					properties.getProperty("p_user"), properties.getProperty("p_pass"));
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return connection;
	}
}
