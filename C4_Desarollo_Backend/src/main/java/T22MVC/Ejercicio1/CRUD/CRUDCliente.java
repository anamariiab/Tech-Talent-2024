package T22MVC.Ejercicio1.CRUD;
import T22MVC.Ejercicio1.Models.ModelCliente;
import T22MVC.Utilidades;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CRUDCliente {

	private Connection connection;

	public CRUDCliente(Connection connection) {
		this.connection = connection;
	}

	public void insertarCliente(ModelCliente cliente) throws SQLException {
		String sql = "INSERT INTO cliente (nombre, apellido, direccion, dni, fecha) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, cliente.getNombre());
			statement.setString(2, cliente.getApellido());
			statement.setString(3, cliente.getDireccion());
			statement.setInt(4, cliente.getDni());
			statement.setDate(5, java.sql.Date.valueOf(cliente.getFecha()));
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				Utilidades.mostrarMensajeExito("Cliente insertado correctamente.");
			}
		} catch (SQLException ex) {
			Utilidades.mostrarMensajeError("Error al insertar el cliente: " + ex.getMessage());
		}
	}

	public void actualizarCliente(ModelCliente cliente) {
		String sql = "UPDATE cliente SET nombre = ?, apellido = ?, direccion = ?, dni = ?, fecha = ? WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, cliente.getNombre());
			statement.setString(2, cliente.getApellido());
			statement.setString(3, cliente.getDireccion());
			statement.setInt(4, cliente.getDni());
			statement.setDate(5, java.sql.Date.valueOf(cliente.getFecha()));
			statement.setInt(6, cliente.getId());
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				Utilidades.mostrarMensajeExito("Cliente actualizado correctamente.");
			}
		} catch (SQLException ex) {
			Utilidades.mostrarMensajeError("Error al actualizar el cliente: " + ex.getMessage());
		}
	}

	public void eliminarCliente(int idCliente) throws SQLException {
		String sql = "DELETE FROM cliente WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, idCliente);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				Utilidades.mostrarMensajeExito("Cliente eliminado correctamente.");
			}
		} catch (SQLException ex) {
			Utilidades.mostrarMensajeError("Error al eliminar el cliente: " + ex.getMessage());
		}
	}

	public List<ModelCliente> obtenerDatosClientes() throws SQLException {
		List<ModelCliente> clientes = new ArrayList<>();
		String sql = "SELECT * FROM cliente";
		try (PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				ModelCliente cliente = new ModelCliente(resultSet.getInt("id"), resultSet.getString("nombre"),
						resultSet.getString("apellido"), resultSet.getString("direccion"), resultSet.getInt("dni"),
						resultSet.getString("fecha"));
				clientes.add(cliente);
			}
		} catch (SQLException ex) {
			Utilidades.mostrarMensajeError("Error al obtener los datos: " + ex.getMessage());
		}
		return clientes;
	}
}
