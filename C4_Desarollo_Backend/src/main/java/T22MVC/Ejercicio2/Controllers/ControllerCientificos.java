package T22MVC.Ejercicio2.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;

import T22MVC.Ejercicio2.Views.ViewCientificos;

public class ControllerCientificos {

	private final ViewCientificos cientificosView;
	private final Connection conexion;

	public ControllerCientificos(ViewCientificos cientificosView, Connection conexion) {
		this.cientificosView = cientificosView;
		this.conexion = conexion;
		inicializarVista();
		cargarCientificos();
		asignarListeners();
	}

	private void inicializarVista() {
		cientificosView.setVisible(true);
	}

	private void cargarCientificos() {
		try {
			Statement statement = conexion.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM cientificos");
			while (resultSet.next()) {
				String dni = resultSet.getString("DNI");
				String nomApels = resultSet.getString("nom_apels");
				cientificosView.agregarCientificoATabla(dni, nomApels);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al cargar los registros: " + e.getMessage(), "¡Error!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void asignarListeners() {
		cientificosView.agregarListenerActualizar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarCientifico();
			}
		});

		cientificosView.agregarListenerEliminar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eliminarCientifico();
			}
		});

		cientificosView.agregarListenerInsertar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insertarCientifico();
			}
		});
	}

	private void insertarCientifico() {
		String nomApels = JOptionPane.showInputDialog("Introduce el nombre y los apellidos:");
		if (nomApels == null || nomApels.isEmpty()) {
			JOptionPane.showMessageDialog(null, "El nombre y los apellidos no pueden estar vacíos.", "¡Atención!",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		String dni;
		do {
			dni = JOptionPane.showInputDialog("Introduce el DNI (9 caracteres):");
			if (dni == null) {
				return;
			}
			if (dni.isEmpty() || dni.length() != 9) {
				JOptionPane.showMessageDialog(null,
						"El DNI debe tener exactamente 9 caracteres y no puede estar vacío.", "¡Atención!",
						JOptionPane.WARNING_MESSAGE);
			}
		} while (dni.isEmpty() || dni.length() != 9);

		try {
			String query = "INSERT INTO cientificos (DNI, nom_apels) VALUES (?, ?)";
			PreparedStatement preparedStatement = conexion.prepareStatement(query);
			preparedStatement.setString(1, dni);
			preparedStatement.setString(2, nomApels);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			JOptionPane.showMessageDialog(null, "El registro se ha insertado en la tabla.", "¡Éxito!",
					JOptionPane.INFORMATION_MESSAGE);
			cientificosView.mostrarCientificos(obtenerDatosCientificos()); // recargar los científicos en la vista
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERROR al insertar el registro: " + e.getMessage(), "¡Error!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actualizarCientifico() {
		int filaSeleccionada = cientificosView.getTablaCientificos().getSelectedRow();
		if (filaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para actualizar.", "¡Atención!",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		String dniActual = (String) cientificosView.getTablaCientificos().getValueAt(filaSeleccionada, 0); // obtener
																											// datos
																											// actuales
		String nomApelsActual = (String) cientificosView.getTablaCientificos().getValueAt(filaSeleccionada, 1);

		String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:", nomApelsActual.split(" ")[0]);
		if (nuevoNombre == null) {
			return; // salir del método si el usuario cancela o hace clic en X
		}

		String nuevoApellido = JOptionPane.showInputDialog("Nuevo apellido:", nomApelsActual.split(" ")[1]);
		if (nuevoApellido == null) {
			return;
		}

		String nuevaNomApels = nuevoNombre + " " + nuevoApellido;

		int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas actualizar los datos?",
				"Confirmar actualización", JOptionPane.YES_NO_OPTION);
		if (opcion == JOptionPane.YES_OPTION) {
			try {
				String query = "UPDATE cientificos SET nom_apels=? WHERE DNI=?";
				PreparedStatement preparedStatement = conexion.prepareStatement(query);
				preparedStatement.setString(1, nuevaNomApels);
				preparedStatement.setString(2, dniActual);
				preparedStatement.executeUpdate();
				preparedStatement.close();

				cientificosView.mostrarCientificos(obtenerDatosCientificos());
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "ERROR al actualizar el registro: " + e.getMessage(), "¡Error!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void eliminarCientifico() {
		int filaSeleccionada = cientificosView.getTablaCientificos().getSelectedRow();
		if (filaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, selecciona la fila que quieres eliminar.", "¡Atención!",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que deseas eliminar este científico?",
				"Confirmar eliminación", JOptionPane.YES_NO_OPTION);
		if (opcion == JOptionPane.YES_OPTION) {
			try {
				String dniAEliminar = (String) cientificosView.getTablaCientificos().getValueAt(filaSeleccionada, 0);
				String query = "DELETE FROM cientificos WHERE DNI=?";
				PreparedStatement preparedStatement = conexion.prepareStatement(query);
				preparedStatement.setString(1, dniAEliminar);
				preparedStatement.executeUpdate();
				preparedStatement.close();
				JOptionPane.showMessageDialog(null, "Científico eliminado con éxito.", "¡Éxito!",
						JOptionPane.INFORMATION_MESSAGE);
				cientificosView.mostrarCientificos(obtenerDatosCientificos());
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "ERROR al eliminar el científico: " + e.getMessage(), "¡Error!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private Object[][] obtenerDatosCientificos() {
		try {
			Statement statement = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet resultSet = statement.executeQuery("SELECT * FROM cientificos");
			resultSet.last();
			int numRows = resultSet.getRow();
			Object[][] datos = new Object[numRows][2];
			resultSet.beforeFirst();
			int i = 0;
			while (resultSet.next()) {
				datos[i][0] = resultSet.getString("DNI");
				datos[i][1] = resultSet.getString("nom_apels");
				i++;
			}
			resultSet.close();
			statement.close();
			return datos;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERROR al cargar los registros: " + e.getMessage(), "¡Error!",
					JOptionPane.ERROR_MESSAGE);
			return new Object[0][0];
		}
	}
}
