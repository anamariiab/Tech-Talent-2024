package T22MVC.Ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	
	private static final String URL = "jdbc:mysql://localhost:3306/loscientíficos";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	private Connection conexion;

	public void connect() {
		try {
			conexion = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("La conexión con la base de datos se ha establecido con éxito.");
		} catch (SQLException e) {
			System.out.println("¡Ups! Parece que hubo un problema al conectar con la base de datos.");
		}
	}

	public void disconnect() {
		if (conexion != null) {
			try {
				conexion.close();
				System.out.println("La conexión con la base de datos se ha cerrado.");
			} catch (SQLException e) {
				System.out.println("¡ERROR al cerrar la conexión!");
			}
		}
	}

	public Connection getConnection() {
		return conexion;
	}
}
