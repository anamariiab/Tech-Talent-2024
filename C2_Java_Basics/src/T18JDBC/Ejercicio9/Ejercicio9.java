package T18JDBC.Ejercicio9;

import java.sql.*;

public class Ejercicio9 {

	public static void main(String[] args) {
		Connection conexion = null;
		Statement statement = null;

		ConexionBD conexionBD = new ConexionBD();

		try {
			conexionBD.connect();
			conexion = conexionBD.getConnection();

			statement = conexion.createStatement();

			agregarFacultades(statement);
			agregarInvestigadores(statement);
			agregarEquipos(statement);
			agregarReservas(statement);

			mostrarRegistros(statement, "facultad");
			mostrarRegistros(statement, "investigadores");
			mostrarRegistros(statement, "equipos");
			mostrarRegistros(statement, "reserva");

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

	static void agregarFacultades(Statement statement) {
		insertarFacultad(statement, 21, "Facultad de Economía");
		insertarFacultad(statement, 22, "Facultad de Derecho");
		insertarFacultad(statement, 23, "Facultad de Humanidades");
		insertarFacultad(statement, 24, "Facultad de Ciencias de la Salud");
		insertarFacultad(statement, 25, "Facultad de Arquitectura");
	}

	static void agregarInvestigadores(Statement statement) {
		insertarInvestigador(statement, "111111111", "Pedro García", 21);
		insertarInvestigador(statement, "222222222", "Ana Martínez", 22);
		insertarInvestigador(statement, "333333333", "Carlos Rodríguez", 23);
		insertarInvestigador(statement, "444444444", "Laura Sánchez", 24);
		insertarInvestigador(statement, "555555555", "Javier López", 25);
	}

	static void agregarEquipos(Statement statement) {
		insertarEquipo(statement, "0003", "Equipo 3", 3);
		insertarEquipo(statement, "0004", "Equipo 4", 4);
		insertarEquipo(statement, "0005", "Equipo 5", 5);
		insertarEquipo(statement, "0006", "Equipo 6", 1);
		insertarEquipo(statement, "0007", "Equipo 7", 2);
	}

	static void agregarReservas(Statement statement) {
		insertarReserva(statement, "111111111", "0003", "2024-05-19 10:00:00", "2024-05-19 12:00:00");
		insertarReserva(statement, "222222222", "0004", "2024-05-20 09:00:00", "2024-05-20 11:00:00");
		insertarReserva(statement, "333333333", "0005", "2024-05-21 13:00:00", "2024-05-21 15:00:00");
		insertarReserva(statement, "444444444", "0006", "2024-05-22 10:30:00", "2024-05-22 12:30:00");
		insertarReserva(statement, "555555555", "0007", "2024-05-23 14:00:00", "2024-05-23 16:00:00");
	}

	static void insertarFacultad(Statement statement, int codigo, String nombre) {
		try {
			statement.executeUpdate("INSERT INTO facultad VALUES (" + codigo + ", '" + nombre + "')");
			System.out.println("Registro insertado en la tabla 'facultad'.");
		} catch (SQLException e) {
			System.out.println(
					"ERROR: No se ha podido insertar la facultad con código " + codigo + " y nombre " + nombre);
		}
	}

	static void insertarInvestigador(Statement statement, String DNI, String nom_apels, int facultad) {
		try {
			statement.executeUpdate(
					"INSERT INTO investigadores VALUES ('" + DNI + "', '" + nom_apels + "', " + facultad + ")");
			System.out.println("Registro insertado en la tabla 'investigadores'.");
		} catch (SQLException e) {
			System.out.println(
					"ERROR: No se ha podido insertar el investigador con DNI " + DNI + " y nombre " + nom_apels);
		}
	}

	static void insertarEquipo(Statement statement, String num_serie, String nombre, int facultad) {
		try {
			statement.executeUpdate(
					"INSERT INTO equipos VALUES ('" + num_serie + "', '" + nombre + "', " + facultad + ")");
			System.out.println("Registro insertado en la tabla 'equipos'.");
		} catch (SQLException e) {
			System.out.println("ERROR: No se ha podido insertar el equipo con número de serie " + num_serie
					+ " y nombre " + nombre);
		}
	}

	static void insertarReserva(Statement statement, String DNI, String num_serie, String comienzo, String fin) {
		try {
			statement.executeUpdate("INSERT INTO reservas (DNI, num_serie, comienzo, fin) VALUES ('" + DNI + "', '"
					+ num_serie + "', '" + comienzo + "', '" + fin + "')");
			System.out.println("Registro insertado en la tabla 'reservas'.");
		} catch (SQLException e) {
			System.out.println("ERROR: No se ha podido insertar la reserva para el investigador con DNI " + DNI
					+ " y equipo con número de serie. " + num_serie);
		}
	}

	static void mostrarRegistros(Statement statement, String tabla) {
		try (ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tabla)) {
			System.out.println("Registros en la tabla '" + tabla + "':");
			while (resultSet.next()) {
				if (tabla.equals("facultad")) {
					System.out.println(
							"Código: " + resultSet.getInt("codigo") + ", Nombre: " + resultSet.getString("nombre"));
				} else if (tabla.equals("investigadores")) {
					System.out.println("DNI: " + resultSet.getString("DNI") + ", Nombre: "
							+ resultSet.getString("nom_apels") + ", Facultad: " + resultSet.getInt("facultad"));
				} else if (tabla.equals("equipos")) {
					System.out.println("Número de Serie: " + resultSet.getString("num_serie") + ", Nombre: "
							+ resultSet.getString("nombre") + ", Facultad: " + resultSet.getInt("facultad"));
				} else if (tabla.equals("reserva")) {
					System.out.println("DNI: " + resultSet.getString("DNI") + ", Número de Serie: "
							+ resultSet.getString("num_serie") + ", Comienzo: " + resultSet.getTimestamp("comienzo")
							+ ", Fin: " + resultSet.getTimestamp("fin"));
				}
			}
		} catch (SQLException e) {
			System.out.println("Error al mostrar registros de la tabla '" + tabla + "'.");
		}
	}
}