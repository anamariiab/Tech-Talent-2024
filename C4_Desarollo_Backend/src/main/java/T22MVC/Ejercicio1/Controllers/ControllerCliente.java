package T22MVC.Ejercicio1.Controllers;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import T22MVC.Ejercicio1.Models.ModelCliente;
import T22MVC.Ejercicio1.CRUD.CRUDCliente;
import T22MVC.Ejercicio1.Views.ViewCliente;
import T22MVC.Utilidades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ControllerCliente {

	private CRUDCliente clienteCRUD;
	private ViewCliente clienteView;
	private final Connection conexion;

	public ControllerCliente(CRUDCliente clienteCRUD, ViewCliente viewCliente, Connection conexion) {
		this.conexion = conexion;
		this.clienteCRUD = clienteCRUD;
		this.clienteView = viewCliente;
		inicializarVista();
		cargarClientes();
		asignarListeners();
	}

	private void inicializarVista() {
		clienteView.setVisible(true);
	}

	private void asignarListeners() {
		clienteView.agregarListenerActualizar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarCliente();
			}
		});

		clienteView.agregarListenerEliminar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eliminarCliente();
			}
		});

		clienteView.agregarListenerInsertar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insertarCliente();
			}
		});
	}

	private void cargarClientes() {
		try {
			List<ModelCliente> clientes = clienteCRUD.obtenerDatosClientes();
			clienteView.mostrarClientes(clientes);
		} catch (SQLException e) {
			Utilidades.mostrarMensajeError("ERROR al cargar los registros: " + e.getMessage());
		}
	}

	public void insertarCliente() {
		String nombre = Utilidades.obtenerEntrada("Introduce el nombre:");
		if (nombre == null) {
	        return;             //para que el usuario pueda cancelar
	    }
		String apellido = Utilidades.obtenerEntrada("Introduce el apellido:");
		if (apellido == null) {
	        return; 
	    }
		String direccion = Utilidades.obtenerEntrada("Introduce la dirección:");
		if (direccion == null) {
	        return; 
	    }
		int dni = obtenerDNI();
		if (dni == -1) {
	        return; 
	    }
		java.sql.Date fecha = obtenerFecha();
		if (fecha == null) {
	        return;
	    }

		try {
			ModelCliente cliente = new ModelCliente(0, nombre, apellido, direccion, dni, fecha.toString());
			clienteCRUD.insertarCliente(cliente);
			Utilidades.mostrarMensajeExito("Registro insertado correctamente.");
			clienteView.actualizarListaClientes(clienteCRUD.obtenerDatosClientes()); // actualizar la vista
		} catch (SQLException ex) {
			Utilidades.mostrarMensajeError("ERROR al insertar el registro: " + ex.getMessage());
		}
	}

	public void actualizarCliente() {
		JTable tablaClientes = clienteView.getTablaClientes();

		int filaSeleccionada = tablaClientes.getSelectedRow();
		if (filaSeleccionada == -1) {
			Utilidades.mostrarMensajeAdvertencia("Por favor, selecciona la fila que quieres actualizar.");
			return;
		}
		int idCliente = (int) tablaClientes.getValueAt(filaSeleccionada, 0);
		String nombreActual = (String) tablaClientes.getValueAt(filaSeleccionada, 1);
		String apellidoActual = (String) tablaClientes.getValueAt(filaSeleccionada, 2);
		String direccionActual = (String) tablaClientes.getValueAt(filaSeleccionada, 3);
		int dniActual = (int) tablaClientes.getValueAt(filaSeleccionada, 4);
		java.sql.Date fechaActual = (java.sql.Date) tablaClientes.getValueAt(filaSeleccionada, 5);

		String nuevoNombre = Utilidades.obtenerEntrada("Nuevo nombre:" + nombreActual);
		String nuevoApellido = Utilidades.obtenerEntrada("Nuevo apellido:" + apellidoActual);
		String nuevaDireccion = Utilidades.obtenerEntrada("Nueva dirección:" + direccionActual);
		int nuevoDNI = obtenerDNI();
		java.sql.Date nuevaFecha = obtenerFecha();

		
		if (nuevoNombre == null || nuevoApellido == null || nuevaDireccion == null || nuevoDNI == -1
				|| nuevaFecha == null) {
			Utilidades.mostrarMensajeAdvertencia("Los campos no se han actualizado."); 
			return;                         //para que el usuario pueda cancelar la operacion
		}
		ModelCliente clienteActualizado = new ModelCliente(idCliente, nuevoNombre, nuevoApellido, nuevaDireccion,
				nuevoDNI, nuevaFecha.toString());

		try {
			clienteCRUD.actualizarCliente(clienteActualizado);
			Utilidades.mostrarMensajeExito("Registro actualizado correctamente.");
			clienteView.actualizarListaClientes(clienteCRUD.obtenerDatosClientes()); // actualizar la vista
		} catch (SQLException ex) {
			Utilidades.mostrarMensajeError("ERROR al actualizar el registro: " + ex.getMessage());
		}
	}

	public void eliminarCliente() {
		int filaSeleccionada = clienteView.getTablaClientes().getSelectedRow();
		if (filaSeleccionada == -1) {
			Utilidades.mostrarMensajeAdvertencia("Por favor, selecciona la fila que quieres eliminar.");
			return;
		}
		int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que deseas eliminar este registro?",
				"Confirmar eliminación", JOptionPane.YES_NO_OPTION);
		if (opcion == JOptionPane.YES_OPTION) {
			try {
				int idClienteAEliminar = (int) clienteView.getTablaClientes().getValueAt(filaSeleccionada, 0);
				clienteCRUD.eliminarCliente(idClienteAEliminar);
				Utilidades.mostrarMensajeExito("Registro eliminado correctamente.");
				clienteView.actualizarListaClientes(clienteCRUD.obtenerDatosClientes()); // actualizar la vista
			} catch (SQLException e) {
				Utilidades.mostrarMensajeError("ERROR al eliminar el registro: " + e.getMessage());
			}
		}
	}

	private int obtenerDNI() {
		while (true) {
			String dniStr = Utilidades.obtenerEntrada("Introduce el DNI (8 dígitos):");
			if (dniStr == null)
				return -1; // si se cancela la operación
			if (dniStr.length() != 8 || !esNumeroEntero(dniStr)) {
				Utilidades.mostrarMensajeError("El DNI debe tener exactamente 8 dígitos y ser un número entero.");
				continue;
			}
			return Integer.parseInt(dniStr);
		}
	}

	private java.sql.Date obtenerFecha() {
		while (true) {
			String fechaStr = Utilidades.obtenerEntrada("Introduce la fecha (YYYY-MM-DD):");
			if (fechaStr == null)
				return null; //
			try {
				return java.sql.Date.valueOf(fechaStr);
			} catch (IllegalArgumentException e) {
				Utilidades.mostrarMensajeError("Fecha incorrecta. Usa el formato YYYY-MM-DD.");
			}
		}
	}

	private boolean esNumeroEntero(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}