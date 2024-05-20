package T18JDBC.Ejercicio5;

import java.sql.*;

public class Ejercicio5 {

    public static void main(String[] args) {
        Connection conexion = null;
        Statement statement = null;

        ConexionBD conexionBD = new ConexionBD();

        try {
            conexionBD.connect();
            conexion = conexionBD.getConnection(); 

            statement = conexion.createStatement();

            agregarDespachos(statement);
            agregarDirectores(statement);

            mostrarRegistros(statement, "despachos");
            mostrarRegistros(statement, "directores");

        } catch (SQLException e) {
            System.out.println("¡Ups! Parece que hubo un problema al conectar con la base de datos: " + e.getMessage());
        } finally {
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
    }

    static void agregarDespachos(Statement statement) {
        insertarRegistroDespacho(statement, 11, 3);
        insertarRegistroDespacho(statement, 12, 5);
        insertarRegistroDespacho(statement, 13, 2);
        insertarRegistroDespacho(statement, 14, 4);
        insertarRegistroDespacho(statement, 15, 6);
    }

    static void agregarDirectores(Statement statement) {
        insertarRegistroDirector(statement, "12345678A", "Juan Perez", null, 1);
        insertarRegistroDirector(statement, "23456789B", "Maria Gomez", "12345678A", 2);
        insertarRegistroDirector(statement, "34567890C", "Luis Martinez", "12345678A", 3);
        insertarRegistroDirector(statement, "45678901D", "Ana Lopez", "23456789B", 4);
        insertarRegistroDirector(statement, "56789012E", "Carlos Sanchez", "34567890C", 5);
    }

    static void insertarRegistroDespacho(Statement statement, int numero, int capacidad) {
        try {
            statement.executeUpdate("INSERT INTO despachos VALUES (" + numero + ", " + capacidad + ")");
            System.out.println("Registro insertado en la tabla 'despachos'.");
        } catch (SQLException e) {
            System.out.println("ERROR: No se ha podido insertar el despacho " + numero);
        }
    }

    static void insertarRegistroDirector(Statement statement, String DNI, String nom_apels, String DNI_jefe, int despacho) {
    	try {
            String query = "INSERT INTO directores (DNI, nom_apels, DNI_jefe, despacho) VALUES ('" + DNI + "', '" + nom_apels + "', " +
                    (DNI_jefe == null ? "NULL" : "'" + DNI_jefe + "'") + ", " + despacho + ")";
            statement.executeUpdate(query);
            System.out.println("Registro insertado en la tabla 'directores'.");
        } catch (SQLException e) {
            System.out.println("ERROR: No se ha podido insertar el director " + DNI + " - " + nom_apels);
        }
    }

    static void mostrarRegistros(Statement statement, String tabla) {
        try (ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tabla)) {
            System.out.println("Registros en la tabla '" + tabla + "':");
            while (resultSet.next()) {
                if (tabla.equals("despachos")) {
                    System.out.println("Número: " + resultSet.getInt("numero") + ", Capacidad: " + resultSet.getInt("capacidad"));
                } else if (tabla.equals("directores")) {
                    System.out.println("DNI: " + resultSet.getString("DNI") + ", Nombre y Apellidos: " + resultSet.getString("nom_apels") +
                            ", DNI Jefe: " + resultSet.getString("DNI_jefe") + ", Despacho: " + resultSet.getInt("despacho"));
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR al mostrar registros de la tabla '" + tabla + "'.");
        }
    }
}
