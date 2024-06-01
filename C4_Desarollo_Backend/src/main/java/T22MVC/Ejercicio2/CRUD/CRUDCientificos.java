package T22MVC.Ejercicio2.CRUD;

import T22MVC.Ejercicio2.Models.ModelCientificos;
import T22MVC.Utilidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDCientificos {

	private Connection connection;

	public CRUDCientificos(Connection connection) {
		this.connection = connection;
	}

	public void insertarCientifico(ModelCientificos cientifico) throws SQLException {
		String sql = "INSERT INTO cientificos (DNI, nom_apels) VALUES (?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, cientifico.getDni());
			statement.setString(2, cientifico.getNomApels());
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				Utilidades.mostrarMensajeExito("Científico insertado correctamente.");
			}
		} catch (SQLException ex) {
			Utilidades.mostrarMensajeError("Error al insertar el científico: " + ex.getMessage());
		}
	}

	public void actualizarCientifico(ModelCientificos cientifico) {
		String sql = "UPDATE cientificos SET nom_apels = ? WHERE DNI = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, cientifico.getNomApels());
			statement.setString(2, cientifico.getDni());
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				Utilidades.mostrarMensajeExito("Científico actualizado correctamente.");
			}
		} catch (SQLException ex) {
			Utilidades.mostrarMensajeError("Error al actualizar el científico: " + ex.getMessage());
		}
	}

	public void eliminarCientifico(String dni) throws SQLException {
		String sql = "DELETE FROM cientificos WHERE DNI = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, dni);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				Utilidades.mostrarMensajeExito("Científico eliminado correctamente.");
			}
		} catch (SQLException ex) {
			Utilidades.mostrarMensajeError("Error al eliminar el científico: " + ex.getMessage());
		}
	}

	public List<ModelCientificos> obtenerDatosCientificos() throws SQLException {
		List<ModelCientificos> cientificos = new ArrayList<>();
		String sql = "SELECT * FROM cientificos";
		try (PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				ModelCientificos cientifico = new ModelCientificos(resultSet.getString("DNI"),
						resultSet.getString("nom_apels"));
				cientificos.add(cientifico);
			}
		} catch (SQLException ex) {
			Utilidades.mostrarMensajeError("Error al obtener los datos: " + ex.getMessage());
		}
		return cientificos;
	}
}