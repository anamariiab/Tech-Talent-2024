package T18JDBC.Ejercicio8;

import java.sql.*;

public class Ejercicio8 {

	public static void main(String[] args) {
		Connection conexion = null;
		Statement statement = null;

		ConexionBD conexionBD = new ConexionBD();

		try {
			conexionBD.connect();
			conexion = conexionBD.getConnection();

			statement = conexion.createStatement();

			agregarCajeros(statement);
			agregarProductos(statement);
			agregarMaquinasRegistradoras(statement);
			agregarVentas(statement);

			mostrarRegistros(statement, "cajeros");
			mostrarRegistros(statement, "productos");
			mostrarRegistros(statement, "maquinas_registradoras");
			mostrarRegistros(statement, "venta");

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

	static void agregarCajeros(Statement statement) {
		insertarCajero(statement, 1, "Ana López");
		insertarCajero(statement, 2, "Javier García");
		insertarCajero(statement, 3, "Marta Fernández");
		insertarCajero(statement, 4, "David Ruiz");
		insertarCajero(statement, 5, "Cristina Sánchez");
	}

	static void agregarProductos(Statement statement) {
		insertarProducto(statement, 1, "Paraguas invisible", 10.99);
		insertarProducto(statement, 2, "Sombrero con ventilador incorporado", 20.99);
		insertarProducto(statement, 3, "Reloj despertador que te lanza almohadas", 30.99);
		insertarProducto(statement, 4, "Zapatillas con luces intermitentes", 40.99);
		insertarProducto(statement, 5, "Camiseta que cambia de color", 50.99);
	}

	static void agregarMaquinasRegistradoras(Statement statement) {
		insertarMaquinaRegistradora(statement, 1, 1);
		insertarMaquinaRegistradora(statement, 2, 2);
		insertarMaquinaRegistradora(statement, 3, 3);
		insertarMaquinaRegistradora(statement, 4, 1);
		insertarMaquinaRegistradora(statement, 5, 2);
	}

	static void agregarVentas(Statement statement) {
		insertarVenta(statement, 1, 1, 1);
		insertarVenta(statement, 2, 2, 2);
		insertarVenta(statement, 3, 3, 3);
		insertarVenta(statement, 4, 4, 4);
		insertarVenta(statement, 5, 5, 5);
	}

	static void insertarCajero(Statement statement, int codigo, String nomApels) {
		try {
			statement.executeUpdate("INSERT INTO cajeros VALUES (" + codigo + ", '" + nomApels + "')");
			System.out.println("Registro insertado en la tabla 'cajeros'.");
		} catch (SQLException e) {
			System.out
					.println("ERROR: No se ha podido insertar el cajero con código " + codigo + ": " + e.getMessage());
		}
	}

	static void insertarProducto(Statement statement, int codigo, String nombre, double precio) {
		try {
			statement.executeUpdate("INSERT INTO productos VALUES (" + codigo + ", '" + nombre + "', " + precio + ")");
			System.out.println("Registro insertado en la tabla 'productos'.");
		} catch (SQLException e) {
			System.out.println(
					"ERROR: No se ha podido insertar el producto con código " + codigo + ": " + e.getMessage());
		}
	}

	static void insertarMaquinaRegistradora(Statement statement, int codigo, int piso) {
		try {
			statement.executeUpdate("INSERT INTO maquinas_registradoras VALUES (" + codigo + ", " + piso + ")");
			System.out.println("Registro insertado en la tabla 'maquinas_registradoras'.");
		} catch (SQLException e) {
			System.out.println("ERROR: No se ha podido insertar la máquina registradora con código " + codigo + ": "
					+ e.getMessage());
		}
	}

	static void insertarVenta(Statement statement, int cajero, int maquina, int producto) {
		try {
			statement.executeUpdate("INSERT INTO venta VALUES (" + cajero + ", " + maquina + ", " + producto + ")");
			System.out.println("Registro insertado en la tabla 'venta'.");
		} catch (SQLException e) {
			System.out.println("ERROR: No se ha podido insertar la venta: " + e.getMessage());
		}
	}

	static void mostrarRegistros(Statement statement, String tabla) {
		try (ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tabla)) {
			System.out.println("Registros en la tabla '" + tabla + "':");
			while (resultSet.next()) {
				if (tabla.equals("cajeros")) {
					System.out.println(
							"Código: " + resultSet.getInt("codigo") + ", Nombre: " + resultSet.getString("nom_apels"));
				} else if (tabla.equals("productos")) {
					System.out.println("Código: " + resultSet.getInt("codigo") + ", Nombre: "
							+ resultSet.getString("nombre") + ", Precio: " + resultSet.getFloat("precio"));
				} else if (tabla.equals("maquinas_registradoras")) {
					System.out.println("Código: " + resultSet.getInt("codigo") + ", Piso: " + resultSet.getInt("piso"));
				} else if (tabla.equals("venta")) {
					System.out.println("Cajero: " + resultSet.getInt("cajero") + ", Máquina: "
							+ resultSet.getInt("maquina") + ", Producto: " + resultSet.getInt("producto"));
				}
			}
		} catch (SQLException e) {
			System.out.println("ERROR al mostrar registros de la tabla '" + tabla + "'.");
		}
	}
}
