package T18JDBC.Ejercicio3;

import java.sql.*;

public class Ejercicio3 {

	public static void main(String[] args) {
		Connection conexion = null;
		Statement statement = null;

		ConexionBD conexionBD = new ConexionBD();

		try {
			conexionBD.connect();
			conexion = conexionBD.getConnection();

			statement = conexion.createStatement();

			agregarAlmacenes(statement);
			agregarCajas(statement);

			mostrarRegistros(statement, "almacenes");
			mostrarRegistros(statement, "cajas");

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

	static void agregarAlmacenes(Statement statement) {
		insertarRegistroAlmacen(statement, 13, "Almacen Central", "Madrid", 11);
		insertarRegistroAlmacen(statement, 14, "Almacen Norte", "Barcelona", 15);
		insertarRegistroAlmacen(statement, 15, "Almacen Sur", "Sevilla", 2);
		insertarRegistroAlmacen(statement, 16, "Almacen Este", "Valencia", 12);
		insertarRegistroAlmacen(statement, 17, "Almacen Oeste", "La Coruña", 8);
	}

	static void agregarCajas(Statement statement) {
		insertarRegistroCaja(statement, "A001", "Electrodomésticos", 500, 13);
	    insertarRegistroCaja(statement, "A002", "Juguetes", 200, 14);
	    insertarRegistroCaja(statement, "A003", "Ropa", 150, 15);
	    insertarRegistroCaja(statement, "A004", "Libros", 300, 16);
	    insertarRegistroCaja(statement, "A005", "Herramientas", 400, 17);
	}

	static void insertarRegistroAlmacen(Statement statement, int codigo, String nombre, String lugar, int capacidad) {
		try {
			statement.executeUpdate("INSERT INTO almacenes VALUES (" + codigo + ", '" + nombre + "', '" + lugar + "', "
					+ capacidad + ")");
			System.out.println("Registro insertado en la tabla 'almacenes'.");
		} catch (SQLException e) {
			System.out.println("ERROR: No se ha podido insertar el almacén " + codigo + " - " + nombre);
		}
	}

	static void insertarRegistroCaja(Statement statement, String num_ref, String contenido, double valor, int almacen) {
		try {
			statement.executeUpdate("INSERT INTO cajas VALUES ('" + num_ref + "', '" + contenido + "', " + valor + ", "
					+ almacen + ")");
			System.out.println("Registro insertado en la tabla 'cajas'.");
		} catch (SQLException e) {
			System.out.println("ERROR: No se ha podido insertar la caja " + num_ref + " - " + contenido);
		}
	}

	static void mostrarRegistros(Statement statement, String tabla) {
		try (ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tabla)) {
			System.out.println("Registros en la tabla '" + tabla + "':");
			while (resultSet.next()) {
				if (tabla.equals("almacenes")) {
					System.out.println("Código: " + resultSet.getInt("codigo") + ", Nombre: "
							+ resultSet.getString("nombre") + ", Lugar: " + resultSet.getString("lugar")
							+ ", Capacidad: " + resultSet.getInt("capacidad"));
				} else if (tabla.equals("cajas")) {
					System.out.println("Número de Referencia: " + resultSet.getString("num_ref") + ", Contenido: "
							+ resultSet.getString("contenido") + ", Valor: " + resultSet.getDouble("valor")
							+ ", Almacén: " + resultSet.getInt("almacen"));
				}
			}
		} catch (SQLException e) {
			System.out.println("ERROR al mostrar registros de la tabla '" + tabla + "'.");
		}
	}
}