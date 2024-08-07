package T18JDBC.Ejercicio2;

import java.sql.*;

public class Ejercicio2 {

	public static void main(String[] args) {
		Connection conexion = null;
		Statement statement = null;

		ConexionBD conexionBD = new ConexionBD();

		try {
			conexionBD.connect();
			conexion = conexionBD.getConnection();

			statement = conexion.createStatement();

			agregarDepartamentos(statement);
			agregarEmpleados(statement);

			mostrarRegistros(statement, "departamentos");
			mostrarRegistros(statement, "empleados");
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

	static void agregarDepartamentos(Statement statement) {
		insertarRegistroDepartamento(statement, 7, "Ventas", 100000);
		insertarRegistroDepartamento(statement, 8, "Administrativo", 80000);
		insertarRegistroDepartamento(statement, 9, "Recursos Humanos", 50000);
		insertarRegistroDepartamento(statement, 10, "Desarrollo de Software", 150000);
		insertarRegistroDepartamento(statement, 11, "Finanzas", 75000);
	}

	static void agregarEmpleados(Statement statement) {
		insertarRegistroEmpleado(statement, "11111111", "Juan", "Pérez López", 7);
		insertarRegistroEmpleado(statement, "22222222", "María", "García Fernández", 8);
		insertarRegistroEmpleado(statement, "33333333", "Pedro", "Sánchez Martín", 9);
		insertarRegistroEmpleado(statement, "44444444", "Ana", "González Ruiz", 10);
		insertarRegistroEmpleado(statement, "55555555", "Luis", "Romero Navarro", 11);
	}

	static void insertarRegistroDepartamento(Statement statement, int codigo, String nombre, double presupuesto) {
		try {
			statement.executeUpdate(
					"INSERT INTO departamentos VALUES (" + codigo + ", '" + nombre + "', " + presupuesto + ")");
			System.out.println("Registro insertado en la tabla 'departamentos'.");
		} catch (SQLException e) {
			System.out.println("ERROR: No se ha podido insertar el departamento " + codigo + " - " + nombre);
		}
	}

	static void insertarRegistroEmpleado(Statement statement, String dni, String nombre, String apellidos,
			int departamento) {
		try {
			statement.executeUpdate("INSERT INTO empleados VALUES ('" + dni + "', '" + nombre + "', '" + apellidos
					+ "', " + departamento + ")");
			System.out.println("Registro insertado en la tabla 'empleados'.");
		} catch (SQLException e) {
			System.out.println("ERROR: No se ha podido insertar el empleado " + dni + " - " + nombre + " " + apellidos);
		}
	}

	static void mostrarRegistros(Statement statement, String tabla) {
		try (ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tabla)) {
			System.out.println("Registros en la tabla '" + tabla + "':");
			if (tabla.equals("departamentos")) {
				while (resultSet.next()) {
					System.out.println("Código: " + resultSet.getInt("codigo") + ", Nombre: "
							+ resultSet.getString("nombre") + ", Presupuesto: " + resultSet.getFloat("presupuesto"));
				}
			} else if (tabla.equals("empleados")) {
				while (resultSet.next()) {
					System.out.println("DNI: " + resultSet.getString("DNI") + ", Nombre: "
							+ resultSet.getString("nombre") + ", Apellidos: " + resultSet.getString("apellidos")
							+ ", Departamento: " + resultSet.getInt("departamento"));
				}
			}
		} catch (SQLException e) {
			System.out.println("ERROR al mostrar registros de la tabla '" + tabla + "'.");
		}
	}
}
