package T22MVC.Ejercicio1.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;

import T22MVC.Ejercicio1.Views.ViewCliente;

public class ControllerCliente {
	private final ViewCliente clientesView;
	private final Connection conexion;

	public ControllerCliente(ViewCliente clientesView, Connection conexion) {
		this.clientesView = clientesView;
		this.conexion = conexion;
		inicializarVista();
		cargarClientes();
		asignarListeners();
	}

	private void inicializarVista() {
		clientesView.setVisible(true);
	}

	private void cargarClientes() {
		try {
			Statement statement = conexion.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM cliente");
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nombre = resultSet.getString("nombre");
				String apellido = resultSet.getString("apellido");
				String direccion = resultSet.getString("direccion");
				int dni = resultSet.getInt("dni");
				Date fecha = resultSet.getDate("fecha");
				clientesView.agregarClienteATabla(id, nombre, apellido, direccion, dni, fecha);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al cargar los registros: " + e.getMessage(), "¡Error!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void asignarListeners() {
		clientesView.agregarListenerActualizar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarCliente();
			}
		});

		clientesView.agregarListenerEliminar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eliminarCliente();
			}
		});

		clientesView.agregarListenerInsertar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insertarCliente();
			}
		});
	}

	private void insertarCliente() {
		String nombre = JOptionPane.showInputDialog("Introduce el nombre:");
		if (nombre == null)
			return; // si cancela, salir del método

		String apellido = JOptionPane.showInputDialog("Introduce el apellido:");
		if (apellido == null)
			return;

		String direccion = JOptionPane.showInputDialog("Introduce la dirección:");
		if (direccion == null)
			return;

		String dniString;
		int dni;
		do {
			dniString = JOptionPane.showInputDialog("Introduce el DNI (8 dígitos):");
			if (dniString == null)
				return;
			try {
				dni = Integer.parseInt(dniString);
				if (dniString.length() != 8) {
					JOptionPane.showMessageDialog(null, "El DNI debe tener exactamente 8 dígitos.", "¡Atención!",
							JOptionPane.WARNING_MESSAGE);
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "El DNI debe ser un número entero.", "¡Error!",
						JOptionPane.ERROR_MESSAGE);
				dni = -1;                                          //para repetir el bucle
			}
		} while (dniString.length() != 8 || dni == -1);

		String fechaString;
		java.sql.Date fecha;
		while (true) {
			fechaString = JOptionPane.showInputDialog("Introduce la fecha (YYYY-MM-DD):");
			if (fechaString == null)
				return;
			try {
				fecha = java.sql.Date.valueOf(fechaString);
				break;                                                           // salir del bucle si la fecha es valida
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Usa el formato YYYY-MM-DD.", "¡Error!",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		try {
			String query = "INSERT INTO cliente (nombre, apellido, direccion, dni, fecha) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = conexion.prepareStatement(query);
			preparedStatement.setString(1, nombre);
			preparedStatement.setString(2, apellido);
			preparedStatement.setString(3, direccion);
			preparedStatement.setInt(4, dni);
			preparedStatement.setDate(5, fecha);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			JOptionPane.showMessageDialog(null, "El registro se ha insertado en la tabla.", "¡Éxito!",
					JOptionPane.INFORMATION_MESSAGE);
			clientesView.mostrarClientes(obtenerDatosClientes()); // recargar los clientes en la vista
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERROR al insertar el registro: " + e.getMessage(), "¡Error!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actualizarCliente() {
		int filaSeleccionada = clientesView.getTablaClientes().getSelectedRow();
		if (filaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para actualizar.", "¡Atención!",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		int idCliente = (int) clientesView.getTablaClientes().getValueAt(filaSeleccionada, 0); // obtener datos actuales
		String nombreActual = (String) clientesView.getTablaClientes().getValueAt(filaSeleccionada, 1);
		String apellidoActual = (String) clientesView.getTablaClientes().getValueAt(filaSeleccionada, 2);
		String direccionActual = (String) clientesView.getTablaClientes().getValueAt(filaSeleccionada, 3);
		int dniActual = (int) clientesView.getTablaClientes().getValueAt(filaSeleccionada, 4);
		Date fechaActual = (Date) clientesView.getTablaClientes().getValueAt(filaSeleccionada, 5);

		String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:", nombreActual);
		if (nuevoNombre == null) {
			return; // sale del metodo si el usuario cancela o clica en x
		}

		String nuevoApellido = JOptionPane.showInputDialog("Nuevo apellido:", apellidoActual);
		if (nuevoApellido == null) {
			return;
		}

		String nuevaDireccion = JOptionPane.showInputDialog("Nueva dirección:", direccionActual);
		if (nuevaDireccion == null) {
			return;
		}
		String nuevoDNIString;
		int nuevoDNI = -1;
		while (true) {
			nuevoDNIString = JOptionPane.showInputDialog("Nuevo DNI:");
			if (nuevoDNIString == null) {
				return;
			}
			try {
				nuevoDNI = Integer.parseInt(nuevoDNIString);
				if (nuevoDNIString.length() != 8) {
					JOptionPane.showMessageDialog(null, "El DNI debe tener exactamente 8 dígitos.", "¡Atención!",
							JOptionPane.WARNING_MESSAGE);
				} else {
					break; 
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "El DNI debe ser un número entero.", "¡Error!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		String nuevaFechaString = JOptionPane.showInputDialog("Introduce la nueva fecha (formato: YYYY-MM-DD):",
				fechaActual.toString());
		Date nuevaFecha;
		try {
			nuevaFecha = Date.valueOf(nuevaFechaString);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Utiliza el formato YYYY-MM-DD.",
					"¡Error!", JOptionPane.ERROR_MESSAGE);
			return;
		}

		int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas actualizar los datos?",
				"Confirmar actualización", JOptionPane.YES_NO_OPTION);
		if (opcion == JOptionPane.YES_OPTION) {
			try {
				String query = "UPDATE cliente SET nombre=?, apellido=?, direccion=?, dni=?, fecha=? WHERE id=?";
				PreparedStatement preparedStatement = conexion.prepareStatement(query);
				preparedStatement.setString(1, nuevoNombre);
				preparedStatement.setString(2, nuevoApellido);
				preparedStatement.setString(3, nuevaDireccion);
				preparedStatement.setInt(4, nuevoDNI);
				preparedStatement.setDate(5, nuevaFecha);
				preparedStatement.setInt(6, idCliente);
				preparedStatement.executeUpdate();
				preparedStatement.close();

				clientesView.mostrarClientes(obtenerDatosClientes());
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "ERROR al actualizar el registro: " + e.getMessage(), "¡Error!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void eliminarCliente() {
		int filaSeleccionada = clientesView.getTablaClientes().getSelectedRow();
		if (filaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, selecciona la fila que quieres eliminar.", "¡Atención!",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que deseas eliminar este cliente?",
				"Confirmar eliminación", JOptionPane.YES_NO_OPTION);
		if (opcion == JOptionPane.YES_OPTION) {
			try {
				int idClienteAEliminar = (int) clientesView.getTablaClientes().getValueAt(filaSeleccionada, 0);
				String query = "DELETE FROM cliente WHERE id=?";
				PreparedStatement preparedStatement = conexion.prepareStatement(query);
				preparedStatement.setInt(1, idClienteAEliminar);
				preparedStatement.executeUpdate();
				preparedStatement.close();
				JOptionPane.showMessageDialog(null, "Registro eliminado con exito.", "¡Éxito!",
						JOptionPane.INFORMATION_MESSAGE);
				clientesView.mostrarClientes(obtenerDatosClientes());
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "ERROR al eliminar el registro: " + e.getMessage(), "¡Error!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private Object[][] obtenerDatosClientes() {
		try {
			Statement statement = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,   //permitir la navegacion bidireccional
																								
					ResultSet.CONCUR_READ_ONLY);
			ResultSet resultSet = statement.executeQuery("SELECT * FROM cliente");
			resultSet.last();
			int numRows = resultSet.getRow();
			Object[][] datos = new Object[numRows][6];
			resultSet.beforeFirst();
			int i = 0;
			while (resultSet.next()) {
				datos[i][0] = resultSet.getInt("id");
				datos[i][1] = resultSet.getString("nombre");
				datos[i][2] = resultSet.getString("apellido");
				datos[i][3] = resultSet.getString("direccion");
				datos[i][4] = resultSet.getInt("dni");
				datos[i][5] = resultSet.getDate("fecha");
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