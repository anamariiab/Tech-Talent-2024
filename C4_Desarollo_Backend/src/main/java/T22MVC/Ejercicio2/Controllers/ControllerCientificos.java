package T22MVC.Ejercicio2.Controllers;

import T22MVC.Ejercicio2.Models.ModelCientificos;
import T22MVC.Ejercicio2.CRUD.CRUDCientificos;
import T22MVC.Ejercicio2.Views.ViewCientificos;
import T22MVC.Utilidades;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ControllerCientificos {

	private CRUDCientificos cientificosCRUD;
	private ViewCientificos cientificosView;
	private final Connection conexion;

	public ControllerCientificos(CRUDCientificos cientificosCRUD, ViewCientificos vistaCientificos,
			Connection conexion) {
		this.conexion = conexion;
		this.cientificosCRUD = cientificosCRUD;
		this.cientificosView = vistaCientificos;
		inicializarVista();
		cargarCientificos();
		asignarListeners();
	}

	private void inicializarVista() {
		cientificosView.setVisible(true);
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

	private void cargarCientificos() {
		try {
			List<ModelCientificos> cientificos = cientificosCRUD.obtenerDatosCientificos();
			cientificosView.actualizarListaCientificos(cientificos);
		} catch (SQLException e) {
			Utilidades.mostrarMensajeError("Error al cargar los registros: " + e.getMessage());
		}
	}

	public void insertarCientifico() {
		String dni = obtenerDNI();
		if (dni == null) {
			return;
		}

		String nomApels = Utilidades.obtenerEntrada("Introduce el nombre y apellidos:");
		if (nomApels == null || nomApels.isEmpty()) {
			Utilidades.mostrarMensajeError("El nombre y los apellidos no pueden estar vacios.");
			return;
		}

		try {
			ModelCientificos cientifico = new ModelCientificos(dni, nomApels);
			cientificosCRUD.insertarCientifico(cientifico);
			Utilidades.mostrarMensajeExito("Registro insertado correctamente.");
			cientificosView.actualizarListaCientificos(cientificosCRUD.obtenerDatosCientificos()); // actualizar la
																									// vista
		} catch (SQLException ex) {
			Utilidades.mostrarMensajeError("ERROR al insertar el registro: " + ex.getMessage());
		}
	}

	public void actualizarCientifico() {
		JTable tablaCientificos = cientificosView.getTablaCientificos();

		int filaSeleccionada = tablaCientificos.getSelectedRow();
		if (filaSeleccionada == -1) {
			Utilidades.mostrarMensajeAdvertencia("Por favor, selecciona la fila que quieres actualizar.");
			return;
		}
		String dniActual = (String) tablaCientificos.getValueAt(filaSeleccionada, 0);
		String nomApelsActual = (String) tablaCientificos.getValueAt(filaSeleccionada, 1);

		String nuevoDNI = Utilidades.obtenerEntrada("Nuevo DNI:" + dniActual);
		String nuevoNomApels = Utilidades.obtenerEntrada("Nuevo nombre y apellidos:" + nomApelsActual);

		// si algun campo es nulo = se cancela la operacion
		if (nuevoDNI == null || nuevoNomApels == null) {
			Utilidades.mostrarMensajeAdvertencia("La operación ha sido cancelada.");
			return;
		}
		ModelCientificos cientificoActualizado = new ModelCientificos(nuevoDNI, nuevoNomApels);

		try {
			cientificosCRUD.actualizarCientifico(cientificoActualizado);
			Utilidades.mostrarMensajeExito("Registro actualizado correctamente.");
			cientificosView.actualizarListaCientificos(cientificosCRUD.obtenerDatosCientificos()); // actualizar la
																									// vista
		} catch (SQLException ex) {
			Utilidades.mostrarMensajeError("ERROR al actualizar el registro: " + ex.getMessage());
		}
	}

	public void eliminarCientifico() {
		int filaSeleccionada = cientificosView.getTablaCientificos().getSelectedRow();
		if (filaSeleccionada == -1) {
			Utilidades.mostrarMensajeAdvertencia("Por favor, selecciona la fila que quieres eliminar.");
			return;
		}
		int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que deseas eliminar este registro?",
				"Confirmar eliminación", JOptionPane.YES_NO_OPTION);
		if (opcion == JOptionPane.YES_OPTION) {
			try {
				String dniAEliminar = (String) cientificosView.getTablaCientificos().getValueAt(filaSeleccionada, 0);
				cientificosCRUD.eliminarCientifico(dniAEliminar);
				Utilidades.mostrarMensajeExito("Registro eliminado correctamente.");
				cientificosView.actualizarListaCientificos(cientificosCRUD.obtenerDatosCientificos()); // actualizar la
																										// vista
			} catch (SQLException e) {
				Utilidades.mostrarMensajeError("ERROR al eliminar el científico: " + e.getMessage());
			}
		}
	}

	private String obtenerDNI() {
		while (true) {
			String dni = Utilidades.obtenerEntrada("Introduce el DNI (9 caracteres):");
			if (dni == null) {
				return null; // si se cancela la operación
			}
			if (dni.length() != 9) {
				Utilidades.mostrarMensajeError("El DNI debe tener exactamente 9 caracteres.");
				continue;
			}
			return dni;
		}
	}

}