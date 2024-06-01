package T22MVC.Ejercicio2.Controllers;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import T22MVC.Ejercicio2.Models.ModelAsignacion;
import T22MVC.Ejercicio2.CRUD.CRUDAsignacion;
import T22MVC.Ejercicio2.Views.ViewAsignacion;
import T22MVC.Utilidades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ControllerAsignacion {

	private CRUDAsignacion asignacionCRUD;
	private ViewAsignacion asignacionView;
	private final Connection conexion;

	public ControllerAsignacion(CRUDAsignacion asignacionCRUD, ViewAsignacion asignacionView, Connection conexion) {
		this.conexion = conexion;
		this.asignacionCRUD = asignacionCRUD;
		this.asignacionView = asignacionView;
		inicializarVista();
		asignarListeners();
		cargarAsignaciones();
	}

	private void inicializarVista() {
		asignacionView.setVisible(true);
	}

	private void asignarListeners() {
		asignacionView.agregarListenerInsertar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insertarAsignacion();
			}
		});

		asignacionView.agregarListenerEliminar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eliminarAsignacion();
			}
		});
	}
	
	private void cargarAsignaciones() {
	    try {
	        List<ModelAsignacion> asignaciones = asignacionCRUD.obtenerDatosAsignaciones();
	        asignacionView.actualizarListaAsignaciones(asignaciones);
	    } catch (SQLException e) {
	        Utilidades.mostrarMensajeError("Error al cargar las asignaciones: " + e.getMessage());
	    }
	}

	public void insertarAsignacion() {
		String cientifico = obtenerDniCientifico();
		if (cientifico == null) return; // la operacion se ha cancelado

		String proyecto = obtenerIdProyecto();
		if (proyecto == null) return; 

		try {
			ModelAsignacion asignacion = new ModelAsignacion(cientifico, proyecto);
			asignacionCRUD.insertarAsignacion(asignacion);
			Utilidades.mostrarMensajeExito("Asignación insertada correctamente.");
			asignacionView.actualizarListaAsignaciones(asignacionCRUD.obtenerDatosAsignaciones()); // actualizar la vista
		} catch (SQLException ex) {
			Utilidades.mostrarMensajeError("Error al insertar la asignación: " + ex.getMessage());
		}
	}

	public void eliminarAsignacion() {
		int filaSeleccionada = asignacionView.getTablaAsignaciones().getSelectedRow();
		if (filaSeleccionada == -1) {
			Utilidades.mostrarMensajeAdvertencia("Por favor, selecciona la fila que quieres eliminar.");
			return;
		}
		int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que deseas eliminar esta asignación?",
				"Confirmar eliminación", JOptionPane.YES_NO_OPTION);
		if (opcion == JOptionPane.YES_OPTION) {
			try {
				String cientifico = (String) asignacionView.getTablaAsignaciones().getValueAt(filaSeleccionada, 0);
				String proyecto = (String) asignacionView.getTablaAsignaciones().getValueAt(filaSeleccionada, 1);
				asignacionCRUD.eliminarAsignacion(cientifico, proyecto);
				Utilidades.mostrarMensajeExito("Asignación eliminada correctamente.");
				asignacionView.actualizarListaAsignaciones(asignacionCRUD.obtenerDatosAsignaciones()); // actualizar la vista
			} catch (SQLException e) {
				Utilidades.mostrarMensajeError("ERROR al eliminar la asignación: " + e.getMessage());
			}
		}
	}

	private String obtenerDniCientifico() {
		while (true) {
			String dniCientifico = Utilidades.obtenerEntrada("Introduce el DNI del científico:");
			if (dniCientifico == null) return null; 
			if (dniCientifico.length() != 9) {
				Utilidades.mostrarMensajeAdvertencia("El DNI del científico debe tener 9 caracteres.");
				continue;
			}
			return dniCientifico;
		}
	}

	private String obtenerIdProyecto() {
		while (true) {
			String idProyecto = Utilidades.obtenerEntrada("Introduce el ID del proyecto:");
			if (idProyecto == null) return null; 
			if (idProyecto.length() != 4) {
				Utilidades.mostrarMensajeAdvertencia("El ID del proyecto debe tener 4 caracteres.");
				continue;
			}
			return idProyecto;
		}
	}
}