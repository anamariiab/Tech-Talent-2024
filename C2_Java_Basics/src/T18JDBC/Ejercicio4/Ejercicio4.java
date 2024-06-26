package T18JDBC.Ejercicio4;

import java.sql.*;

public class Ejercicio4 {

    public static void main(String[] args) {
        Connection conexion = null;
        Statement statement = null;

        ConexionBD conexionBD = new ConexionBD();

        try {
            conexionBD.connect();
            conexion = conexionBD.getConnection();

            statement = conexion.createStatement();

            agregarPeliculas(statement);
            agregarSalas(statement);

            mostrarRegistros(statement, "peliculas");
            mostrarRegistros(statement, "salas");

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

    static void agregarPeliculas(Statement statement) {
        insertarRegistroPelicula(statement, 110, "La Sirenita", 5);
        insertarRegistroPelicula(statement, 111, "Toy Story 5", 3);
        insertarRegistroPelicula(statement, 112, "El Gran Gatsby", 12);
        insertarRegistroPelicula(statement, 113, "Cenicienta", 5);
        insertarRegistroPelicula(statement, 114, "La La Land", 12);
    }

    static void agregarSalas(Statement statement) {
        insertarRegistroSala(statement, 11, "Sala VIP", 110);
        insertarRegistroSala(statement, 12, "Sala 3D", 111);
        insertarRegistroSala(statement, 13, "Sala IMAX", 112);
        insertarRegistroSala(statement, 14, "Sala Infantil", 113);
        insertarRegistroSala(statement, 15, "Sala Premier", 114);
    }

    static void insertarRegistroPelicula(Statement statement, int codigo, String nombre, int calificacionEdad) {
        try {
            statement.executeUpdate("INSERT INTO peliculas VALUES (" + codigo + ", '" + nombre + "', " + calificacionEdad + ")");
            System.out.println("Registro insertado en la tabla 'peliculas'.");
        } catch (SQLException e) {
            System.out.println("ERROR: No se ha podido insertar la película " + codigo + " - " + nombre);
        }
    }

    static void insertarRegistroSala(Statement statement, int codigo, String nombre, int pelicula) {
        try {
            statement.executeUpdate("INSERT INTO salas VALUES (" + codigo + ", '" + nombre + "', " + pelicula + ")");
            System.out.println("Registro insertado en la tabla 'salas'.");
        } catch (SQLException e) {
            System.out.println("ERROR: No se ha podido insertar la sala " + codigo + " - " + nombre);
        }
    }

    static void mostrarRegistros(Statement statement, String tabla) {
        try (ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tabla)) {
            System.out.println("Registros en la tabla '" + tabla + "':");
            while (resultSet.next()) {
                if (tabla.equals("peliculas")) {
                    System.out.println(
                            "Código: " + resultSet.getInt("codigo") + ", Nombre: " + resultSet.getString("nombre") + ", Calificación de Edad: " + resultSet.getInt("calificacion_edad"));
                } else if (tabla.equals("salas")) {
                    System.out.println("Código: " + resultSet.getInt("codigo") + ", Nombre: "
                            + resultSet.getString("nombre") + ", Película: " + resultSet.getInt("pelicula"));
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR al mostrar registros de la tabla '" + tabla + "'.");
        }
    }
}