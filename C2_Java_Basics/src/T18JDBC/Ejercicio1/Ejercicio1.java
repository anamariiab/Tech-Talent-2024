package T18JDBC.Ejercicio1;

import java.sql.*;

public class Ejercicio1 {

    public static void main(String[] args) {
        Connection conexion = null;
        Statement statement = null;

        ConexionBD conexionBD = new ConexionBD();

        try {
            conexionBD.connect();
            conexion = conexionBD.getConnection(); 

            statement = conexion.createStatement();

            agregarFabricantes(statement);
            agregarArticulos(statement);

            mostrarRegistros(statement, "fabricantes");
            mostrarRegistros(statement, "articulos");

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

	static void agregarFabricantes(Statement statement) {
		insertarRegistroFabricante(statement, "11", "MegaMágico Tech");
		insertarRegistroFabricante(statement, "12", "DigitalDiversión Inc.");
		insertarRegistroFabricante(statement, "13", "TechnoTravesura Solutions");
		insertarRegistroFabricante(statement, "14", "ByteBroma Innovations");
		insertarRegistroFabricante(statement, "15", "RoboRisas Tech Group");
	}

	static void agregarArticulos(Statement statement) {
		insertarRegistroArticulo(statement, "12", "Monitor Mágico", "299.99", "11");
		insertarRegistroArticulo(statement, "13", "Cámara Cómica", "129.99", "12");
		insertarRegistroArticulo(statement, "14", "Auriculares Arcoíris", "49.99", "13");
		insertarRegistroArticulo(statement, "15", "Teclado Tornado", "89.99", "14");
		insertarRegistroArticulo(statement, "16", "Ratón Rápido", "19.99", "15");
	}

	static void insertarRegistroFabricante(Statement statement, String codigo, String nombre) {
		try {
	        statement.executeUpdate("INSERT INTO fabricantes VALUES ('" + codigo + "', '" + nombre + "')");
	        System.out.println("Registro insertado en la tabla 'fabricantes'.");
    	}
    	catch(SQLException e) {
    		System.out.println("ERROR: No se ha podido insertar el fabricante " + codigo + " - " + nombre);
    	}
    }

	static void insertarRegistroArticulo(Statement statement, String codigo, String nombre, String precio, String fabricante) {
		try {
	        statement.executeUpdate("INSERT INTO articulos VALUES ('" + codigo + "', '" + nombre + "', '" + precio + "', '"
	                + fabricante + "')");
	        System.out.println("Registro insertado en la tabla 'articulos'.");
    	}
    	catch(SQLException e) {
    		System.out.println("ERROR: No se ha podido insertar el artículo " + codigo + " - " + nombre);
    	}
    }

	static void mostrarRegistros(Statement statement, String tabla) {
		try (ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tabla)) {
			System.out.println("Registros en la tabla '" + tabla + "':");
			while (resultSet.next()) {
				if (tabla.equals("fabricantes")) {
					System.out.println(
							"Código: " + resultSet.getInt("codigo") + ", Nombre: " + resultSet.getString("nombre"));
				} else if (tabla.equals("articulos")) {
					System.out.println("Código: " + resultSet.getInt("codigo") + ", Nombre: "
							+ resultSet.getString("nombre") + ", Precio: " + resultSet.getFloat("precio")
							+ ", Fabricante: " + resultSet.getInt("fabricante"));
				}
			}
		} catch (SQLException e) {
			System.out.println("ERROR al mostrar registros de la tabla '" + tabla + "'.");
		}
	}
}