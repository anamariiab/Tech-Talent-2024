package T22MVC.Ejercicio2.Controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import T22MVC.Ejercicio2.ConexionBD;

public class ControllerCientifico {

    private Connection conexion;
    private Statement statement;

    public ControllerCientifico() {
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
    
    public void insertarCientifico(String DNI, String nom_apels) {
        try {
            statement.executeUpdate("INSERT INTO cientificos VALUES ('" + DNI + "', '" + nom_apels + "')");
            System.out.println("Registro insertado en la tabla 'cientificos'.");
        } catch (SQLException e) {
            System.out.println("ERROR: No se ha podido insertar el científico ");
            e.printStackTrace();
        }
    }
    
    public void mostrarCientificos() {
        try (ResultSet resultSet = statement.executeQuery("SELECT * FROM cientificos")) {
            System.out.println("Científicos:");
            while (resultSet.next()) {
                System.out.println("DNI: " + resultSet.getString("DNI") + ", Nombre: " + resultSet.getString("nom_apels"));
            }
        } catch (SQLException e) {
            System.out.println("ERROR al mostrar registros de la tabla.");
            e.printStackTrace();
        }
    }

    public void actualizarCientifico(String DNI, String nuevoNomApels) {   //mm y si quiero actualizar dni?
        try {
            statement.executeUpdate("UPDATE cientificos SET nom_apels = '" + nuevoNomApels + "' WHERE DNI = '" + DNI + "'");
            System.out.println("Científico actualizado con éxito.");
        } catch (SQLException e) {
            System.out.println("ERROR: No se han podido actualizar los datos.");
            e.printStackTrace();
        }
    }

    public void eliminarCientifico(String DNI) {
        try {
            statement.executeUpdate("DELETE FROM cientificos WHERE DNI = '" + DNI + "'");
            System.out.println("Científico eliminado con éxito.");
        } catch (SQLException e) {
            System.out.println("ERROR: No se ha podido eliminar el científico.");
            e.printStackTrace();
        }
    }
}