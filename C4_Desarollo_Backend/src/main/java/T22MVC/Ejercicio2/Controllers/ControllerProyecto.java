package T22MVC.Ejercicio2.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;

import T22MVC.Ejercicio2.Views.ViewProyecto;

public class ControllerProyecto {

	private final ViewProyecto proyectoView;
	private final Connection conexion;

	public ControllerProyecto(ViewProyecto proyectoView, Connection conexion) {
		this.proyectoView = proyectoView;
		this.conexion = conexion;
		inicializarVista();
		cargarProyectos();
		asignarListeners();
	}

	private void inicializarVista() {
		proyectoView.setVisible(true);
	}

	private void cargarProyectos() {
		try {
			Statement statement = conexion.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM proyecto");
			while (resultSet.next()) {
				String id = resultSet.getString("ID");
				String nombre = resultSet.getString("nombre");
				int horas = resultSet.getInt("horas");
				proyectoView.agregarProyectoATabla(id, nombre, horas);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al cargar los registros: " + e.getMessage(), "¡Error!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void asignarListeners() {
		proyectoView.agregarListenerActualizar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarProyecto();
			}
		});

		proyectoView.agregarListenerEliminar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eliminarProyecto();
			}
		});

		proyectoView.agregarListenerInsertar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insertarProyecto();
			}
		});
	}

	private void insertarProyecto() {
		String nombre = JOptionPane.showInputDialog("Introduce el nombre del proyecto:");
		if (nombre == null || nombre.isEmpty()) {
			JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.", "¡Atención!",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		String id;
		do {
			id = JOptionPane.showInputDialog("Introduce el ID (4 caracteres):");
			if (id == null) {
				return;
			}
			if (id.isEmpty() || id.length() != 4) {
				JOptionPane.showMessageDialog(null, "El ID debe tener exactamente 4 caracteres y no puede estar vacío.",
						"¡Atención!", JOptionPane.WARNING_MESSAGE);
			}
		} while (id.isEmpty() || id.length() != 4);

		int horas;
		try {
			horas = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número de horas:"));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Las horas deben ser un número entero.", "¡Atención!",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		try {
			String query = "INSERT INTO proyecto (ID, nombre, horas) VALUES (?, ?, ?)";
			PreparedStatement preparedStatement = conexion.prepareStatement(query);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, nombre);
			preparedStatement.setInt(3, horas);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			JOptionPane.showMessageDialog(null, "El registro se ha insertado en la tabla.", "¡Éxito!",
					JOptionPane.INFORMATION_MESSAGE);
			proyectoView.mostrarProyectos(obtenerDatosProyectos()); // recargar los proyectos en la vista
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERROR al insertar el registro: " + e.getMessage(), "¡Error!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actualizarProyecto() {
		int filaSeleccionada = proyectoView.getTablaProyectos().getSelectedRow();
		if (filaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para actualizar.", "¡Atención!",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		String idActual = (String) proyectoView.getTablaProyectos().getValueAt(filaSeleccionada, 0);
		String nombreActual = (String) proyectoView.getTablaProyectos().getValueAt(filaSeleccionada, 1);
		int horasActuales = (int) proyectoView.getTablaProyectos().getValueAt(filaSeleccionada, 2);

		String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:", nombreActual);
		if (nuevoNombre == null) {
			return;
		}

		int nuevasHoras;
		try {
			nuevasHoras = Integer.parseInt(JOptionPane.showInputDialog("Nuevas horas:", horasActuales));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Las horas deben ser un número entero.", "¡Atención!",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas actualizar los datos?",
				"Confirmar actualización", JOptionPane.YES_NO_OPTION);
		if (opcion == JOptionPane.YES_OPTION) {
			try {
				String query = "UPDATE proyecto SET nombre=?, horas=? WHERE ID=?";
				PreparedStatement preparedStatement = conexion.prepareStatement(query);
				preparedStatement.setString(1, nuevoNombre);
				preparedStatement.setInt(2, nuevasHoras);
				preparedStatement.setString(3, idActual);
				preparedStatement.executeUpdate();
				preparedStatement.close();

				proyectoView.mostrarProyectos(obtenerDatosProyectos());
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "ERROR al actualizar el registro: " + e.getMessage(), "¡Error!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void eliminarProyecto() {
		int filaSeleccionada = proyectoView.getTablaProyectos().getSelectedRow();
		if (filaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, selecciona la fila que quieres eliminar.", "¡Atención!",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
	}

	private Object[][] obtenerDatosProyectos() {
		try {
			Statement statement = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet resultSet = statement.executeQuery("SELECT * FROM proyecto");
			resultSet.last();
			int numRows = resultSet.getRow();
			Object[][] datos = new Object[numRows][3];
			resultSet.beforeFirst();
			int i = 0;
			while (resultSet.next()) {
				datos[i][0] = resultSet.getString("ID");
				datos[i][1] = resultSet.getString("nombre");
				datos[i][2] = resultSet.getInt("horas");
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