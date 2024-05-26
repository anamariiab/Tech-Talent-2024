package T22MVC.Ejercicio2.Controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import T22MVC.Ejercicio2.ConexionBD;

public class ControllerProyecto {

	private Connection conexion;
	private Statement statement;

	public ControllerProyecto() {
		ConexionBD conexionBD = new ConexionBD();

		try {
			conexionBD.connect();
			conexion = conexionBD.getConnection();
			statement = conexion.createStatement();
		} catch (SQLException e) {
			System.out.println("¡Ups! Parece que hubo un problema al conectar con la base de datos: " + e.getMessage());
		}
	}

	public void closeConnection() {
		try {
			if (statement != null)
				statement.close();
			if (conexion != null)
				conexion.close();
			System.out.println("La conexión con la base de datos se ha cerrado.");
		} catch (SQLException e) {
			System.out.println("¡Ups! Se produjo un error al intentar cerrar la conexión: " + e.getMessage());
		}
	}

	public void insertarProyecto(String ID, String nombre, int horas) {
		try {
			statement.executeUpdate("INSERT INTO proyecto VALUES ('" + ID + "', '" + nombre + "', " + horas + ")");
			System.out.println("Proyecto agregado con éxito.");
		} catch (SQLException e) {
			System.out.println("ERROR: No se ha podido insertar el proyecto.");
			e.printStackTrace();
		}
	}

	public void mostrarProyectos() {
		try (ResultSet resultSet = statement.executeQuery("SELECT * FROM proyecto")) {
			System.out.println("Proyectos:");
			while (resultSet.next()) {
				System.out.println("ID: " + resultSet.getString("ID") + ", Nombre: " + resultSet.getString("nombre")
						+ ", Horas: " + resultSet.getInt("horas"));
			}
		} catch (SQLException e) {
			System.out.println("ERROR al mostrar registros de la tabla proyectos.");
			e.printStackTrace();
		}
	}

	public void actualizarProyecto() {
		// falta por implementar!
	}

	public void eliminarProyecto(String ID) {
		try {
			statement.executeUpdate("DELETE FROM proyecto WHERE ID = '" + ID + "'");
			System.out.println("Proyecto eliminado con éxito.");
		} catch (SQLException e) {
			System.out.println("ERROR: No se ha podido eliminar el proyecto.");
			e.printStackTrace();
		}
	}

}