package T18JDBC.Ejercicio7;

import java.sql.*;

public class Ejercicio7 {

    public static void main(String[] args) {
        Connection conexion = null;
        Statement statement = null;

        ConexionBD conexionBD = new ConexionBD();

        try {
            conexionBD.connect();
            conexion = conexionBD.getConnection();

            statement = conexion.createStatement();

            agregarCientificos(statement);
            agregarProyectos(statement);
            asignarProyectos(statement);

            mostrarRegistros(statement, "cientificos");
            mostrarRegistros(statement, "proyecto");
            mostrarRegistros(statement, "asignado_a");

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

    static void agregarCientificos(Statement statement) {
        insertarRegistroCientifico(statement, "123456789", "María López");
        insertarRegistroCientifico(statement, "987654321", "Juan Martínez");
        insertarRegistroCientifico(statement, "111222333", "Laura Rodríguez");
        insertarRegistroCientifico(statement, "444555666", "Pablo García");
        insertarRegistroCientifico(statement, "777888999", "Ana Fernández");
    }

    static void agregarProyectos(Statement statement) {
        insertarRegistroProyecto(statement, "P001", "Proyecto1", 100);
        insertarRegistroProyecto(statement, "P002", "Proyecto2", 150);
        insertarRegistroProyecto(statement, "P003", "Proyecto3", 200);
        insertarRegistroProyecto(statement, "P004", "Proyecto4", 120);
        insertarRegistroProyecto(statement, "P005", "Proyecto5", 180);
    }

    static void asignarProyectos(Statement statement) {
        asignarProyecto(statement, "123456789", "P001");
        asignarProyecto(statement, "987654321", "P002");
        asignarProyecto(statement, "111222333", "P003");
        asignarProyecto(statement, "444555666", "P004");
        asignarProyecto(statement, "777888999", "P005");
    }

    static void insertarRegistroCientifico(Statement statement, String DNI, String nom_apels) {
        try {
            statement.executeUpdate("INSERT INTO cientificos VALUES ('" + DNI + "', '" + nom_apels + "')");
            System.out.println("Registro insertado en la tabla 'cientificos'.");
        } catch (SQLException e) {
            System.out.println("ERROR: No se ha podido insertar el científico " + DNI + " - " + nom_apels);
        }
    }

    static void insertarRegistroProyecto(Statement statement, String ID, String nombre, int horas) {
        try {
            statement.executeUpdate("INSERT INTO proyecto VALUES ('" + ID + "', '" + nombre + "', " + horas + ")");
            System.out.println("Registro insertado en la tabla 'proyecto'.");
        } catch (SQLException e) {
            System.out.println("ERROR: No se ha podido insertar el proyecto " + ID + " - " + nombre);
        }
    }

    static void asignarProyecto(Statement statement, String cientifico, String proyecto) {
        try {
            statement.executeUpdate("INSERT INTO asignado_a VALUES ('" + cientifico + "', '" + proyecto + "')");
            System.out.println("Proyecto asignado al científico.");
        } catch (SQLException e) {
            System.out.println("ERROR: No se ha podido asignar el proyecto al científico.");
        }
    }

    static void mostrarRegistros(Statement statement, String tabla) {
        try (ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tabla)) {
            System.out.println("Registros en la tabla '" + tabla + "':");
            while (resultSet.next()) {
                if (tabla.equals("cientificos")) {
                    System.out.println(
                            "DNI: " + resultSet.getString("DNI") + ", Nombre: " + resultSet.getString("nom_apels"));
                } else if (tabla.equals("proyecto")) {
                    System.out.println("ID: " + resultSet.getString("ID") + ", Nombre: "
                            + resultSet.getString("nombre") + ", Horas: " + resultSet.getInt("horas"));
                } else if (tabla.equals("asignado_a")) {
                    System.out.println("Científico: " + resultSet.getString("cientifico") + ", Proyecto: "
                            + resultSet.getString("proyecto"));
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR al mostrar registros de la tabla '" + tabla + "'.");
        }
    }
}