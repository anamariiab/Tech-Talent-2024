package T22MVC.Ejercicio2.CRUD;

import T22MVC.Ejercicio2.Models.ModelProyecto;
import T22MVC.Utilidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDProyecto {

	private Connection connection;

	public CRUDProyecto(Connection connection) {
		this.connection = connection;
	}

	public void insertarProyecto(ModelProyecto proyecto) throws SQLException {
		String sql = "INSERT INTO proyecto (ID, nombre, horas) VALUES (?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, proyecto.getId());
			statement.setString(2, proyecto.getNombre());
			statement.setInt(3, proyecto.getHoras());
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				Utilidades.mostrarMensajeExito("Proyecto insertado correctamente.");
			}
		} catch (SQLException ex) {
			Utilidades.mostrarMensajeError("Error al insertar el proyecto: " + ex.getMessage());
		}
	}

	public void actualizarProyecto(ModelProyecto proyecto) {
		String sql = "UPDATE proyecto SET nombre = ?, horas = ? WHERE ID = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, proyecto.getNombre());
			statement.setInt(2, proyecto.getHoras());
			statement.setString(3, proyecto.getId());
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				Utilidades.mostrarMensajeExito("Proyecto actualizado correctamente.");
			}
		} catch (SQLException ex) {
			Utilidades.mostrarMensajeError("Error al actualizar el proyecto: " + ex.getMessage());
		}
	}

	public void eliminarProyecto(String idProyecto) throws SQLException {
		String sql = "DELETE FROM proyecto WHERE ID = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, idProyecto);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				Utilidades.mostrarMensajeExito("Proyecto eliminado correctamente.");
			}
		} catch (SQLException ex) {
			Utilidades.mostrarMensajeError("Error al eliminar el proyecto: " + ex.getMessage());
		}
	}

	public List<ModelProyecto> obtenerDatosProyectos() throws SQLException {
		List<ModelProyecto> proyectos = new ArrayList<>();
		String sql = "SELECT * FROM proyecto";
		try (PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				ModelProyecto proyecto = new ModelProyecto(resultSet.getString("ID"), resultSet.getString("nombre"),
						resultSet.getInt("horas"));
				proyectos.add(proyecto);
			}
		} catch (SQLException ex) {
			Utilidades.mostrarMensajeError("Error al obtener los datos: " + ex.getMessage());
		}
		return proyectos;
	}
}