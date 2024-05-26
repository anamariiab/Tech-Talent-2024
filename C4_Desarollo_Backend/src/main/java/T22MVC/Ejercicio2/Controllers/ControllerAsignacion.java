package T22MVC.Ejercicio2.Controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import T22MVC.Ejercicio2.ConexionBD;

public class ControllerAsignacion {

	private Connection conexion;
	private Statement statement;

	public ControllerAsignacion() {
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
	
	public void asignarProyectoACientifico(String cientifico, String proyecto) {
	    try {
	        statement.executeUpdate("INSERT INTO asignado_a VALUES ('" + cientifico + "', '" + proyecto + "')");
	        System.out.println("Proyecto asignado al científico con éxito.");
	    } catch (SQLException e) {
	        System.out.println("ERROR: No se ha podido asignar el proyecto al científico.");
	        e.printStackTrace();
	    }
	}

	public void mostrarAsignaciones() {
	    try (ResultSet resultSet = statement.executeQuery("SELECT * FROM asignado_a")) {
	        System.out.println("Asignaciones:");
	        while (resultSet.next()) {
	            System.out.println("Científico: " + resultSet.getString("cientifico") + ", Proyecto: " + resultSet.getString("proyecto"));
	        }
	    } catch (SQLException e) {
	        System.out.println("ERROR al mostrar registros.");
	        e.printStackTrace();
	    }
	}

	public void actualizarAsignacion() {
	    //mm?por implementar..
	}

	public void eliminarAsignacion(String cientifico, String proyecto) {
	    try {
	        statement.executeUpdate("DELETE FROM asignado_a WHERE cientifico = '" + cientifico + "' AND proyecto = '" + proyecto + "'");
	        System.out.println("Asignación eliminada con éxito.");
	    } catch (SQLException e) {
	        System.out.println("ERROR: No se ha podido eliminar la asignación.");
	        e.printStackTrace();
	    }
	}
}	
