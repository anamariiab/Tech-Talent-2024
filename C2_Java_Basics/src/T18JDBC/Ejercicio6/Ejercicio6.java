package T18JDBC.Ejercicio6;

import java.sql.*;

public class Ejercicio6 {

    public static void main(String[] args) {
        Connection conexion = null;
        Statement statement = null;

        ConexionBD conexionBD = new ConexionBD();

        try {
            conexionBD.connect();
            conexion = conexionBD.getConnection();

            statement = conexion.createStatement();

            agregarProveedores(statement);
            agregarPiezas(statement);
            agregarSuministros(statement);

            mostrarRegistros(statement, "proveedores");
            mostrarRegistros(statement, "piezas");
            mostrarRegistros(statement, "suministra");

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

    static void agregarProveedores(Statement statement) {
        insertarRegistroProveedor(statement, "A111", "Proveedor11");
        insertarRegistroProveedor(statement, "A222", "Proveedor12");
        insertarRegistroProveedor(statement, "A333", "Proveedor13");
        insertarRegistroProveedor(statement, "B222", "Proveedor14");
        insertarRegistroProveedor(statement, "B333", "Proveedor15");
    }

    static void agregarPiezas(Statement statement) {
        insertarRegistroPieza(statement, "1001", "Pieza1");
        insertarRegistroPieza(statement, "1002", "Pieza2");
        insertarRegistroPieza(statement, "1003", "Pieza3");
        insertarRegistroPieza(statement, "1004", "Pieza2");
        insertarRegistroPieza(statement, "1005", "Pieza3");
    }

    static void agregarSuministros(Statement statement) {
        insertarRegistroSuministro(statement, "1001", "A111", 10.99);
        insertarRegistroSuministro(statement, "1002", "A222", 20.99);
        insertarRegistroSuministro(statement, "1003", "A333", 30.99);
        insertarRegistroSuministro(statement, "1004", "B222", 15.99);
        insertarRegistroSuministro(statement, "1005", "B333", 25.99);
    }

    static void insertarRegistroProveedor(Statement statement, String ID, String nombre) {
        try {
            statement.executeUpdate("INSERT INTO proveedores VALUES ('" + ID + "', '" + nombre + "')");
            System.out.println("Registro insertado en la tabla 'proveedores'.");
        } catch (SQLException e) {
            System.out.println("ERROR: No se ha podido insertar el proveedor " + ID + " - " + nombre);
        }
    }

    static void insertarRegistroPieza(Statement statement, String codigo, String nombre) {
        try {
            statement.executeUpdate("INSERT INTO piezas VALUES ('" + codigo + "', '" + nombre + "')");
            System.out.println("Registro insertado en la tabla 'piezas'.");
        } catch (SQLException e) {
            System.out.println("ERROR: No se ha podido insertar la pieza " + codigo + " - " + nombre);
        }
    }

    static void insertarRegistroSuministro(Statement statement, String codigoPieza, String IDProveedor, double precio) {
        try {
            statement.executeUpdate("INSERT INTO suministra VALUES ('" + codigoPieza + "', '" + IDProveedor + "', " + precio + ")");
            System.out.println("Registro insertado en la tabla 'suministra'.");
        } catch (SQLException e) {
            System.out.println("ERROR: No se ha podido insertar el suministro.");
        }
    }

    static void mostrarRegistros(Statement statement, String tabla) {
        try (ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tabla)) {
            System.out.println("Registros en la tabla '" + tabla + "':");
            while (resultSet.next()) {
                if (tabla.equals("proveedores")) {
                    System.out.println(
                            "ID: " + resultSet.getString("ID") + ", Nombre: " + resultSet.getString("nombre"));
                } else if (tabla.equals("piezas")) {
                    System.out.println("Código: " + resultSet.getInt("codigo") + ", Nombre: "
                            + resultSet.getString("nombre"));
                } else if (tabla.equals("suministra")) {
                    System.out.println("Código de Pieza: " + resultSet.getInt("codigo_pieza") + ", ID de Proveedor: "
                            + resultSet.getString("ID_proveedor") + ", Precio: " + resultSet.getFloat("precio"));
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR al mostrar registros de la tabla '" + tabla + "'.");
        }
    }
}
