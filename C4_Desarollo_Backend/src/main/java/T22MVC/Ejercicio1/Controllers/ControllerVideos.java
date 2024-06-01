package T22MVC.Ejercicio1.Controllers;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import T22MVC.Ejercicio1.Models.ModelVideos;
import T22MVC.Ejercicio1.CRUD.CRUDVideos;
import T22MVC.Ejercicio1.Views.ViewVideos;
import T22MVC.Utilidades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ControllerVideos {

	private CRUDVideos videosCRUD;
	private ViewVideos videoView;
	private final Connection conexion;

	public ControllerVideos(CRUDVideos videosCRUD, ViewVideos viewVideos, Connection conexion) {
		this.conexion = conexion;
		this.videosCRUD = videosCRUD;
		this.videoView = viewVideos;
		inicializarVista();
		cargarVideos();
		asignarListeners();
	}

	private void inicializarVista() {
		videoView.setVisible(true);
	}

	private void asignarListeners() {
		videoView.agregarListenerActualizar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarVideo();
			}
		});

		videoView.agregarListenerEliminar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eliminarVideo();
			}
		});

		videoView.agregarListenerInsertar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insertarVideo();
			}
		});
	}

	private void cargarVideos() {
		try {
			List<ModelVideos> videos = videosCRUD.obtenerDatosVideos();
			videoView.mostrarVideos(videos);
		} catch (SQLException e) {
			Utilidades.mostrarMensajeError("ERROR al cargar los registros: " + e.getMessage());
		}
	}

	public void insertarVideo() {
		String title = Utilidades.obtenerEntrada("Introduce el título:");
		if (title == null) {
	        return; 
	    }
		String director = Utilidades.obtenerEntrada("Introduce el director:");
		if (director == null) {
	        return; 
	    }
		int cli_id = obtenerClienteID();

		try {
			ModelVideos video = new ModelVideos(0, title, director, cli_id);
			videosCRUD.insertarVideo(video);
			Utilidades.mostrarMensajeExito("Registro insertado correctamente.");
			videoView.actualizarListaVideos(videosCRUD.obtenerDatosVideos()); // actualizar la vista
		} catch (SQLException ex) {
			Utilidades.mostrarMensajeError("ERROR al insertar el registro: " + ex.getMessage());
		}
	}

	public void actualizarVideo() {
		JTable tablaVideos = videoView.getTablaVideos();

		int filaSeleccionada = tablaVideos.getSelectedRow();
		if (filaSeleccionada == -1) {
			Utilidades.mostrarMensajeAdvertencia("Por favor, selecciona la fila que quieres actualizar.");
			return;
		}
		int idVideo = (int) tablaVideos.getValueAt(filaSeleccionada, 0);
		String titleActual = (String) tablaVideos.getValueAt(filaSeleccionada, 1);
		String directorActual = (String) tablaVideos.getValueAt(filaSeleccionada, 2);
		int cli_idActual = (int) tablaVideos.getValueAt(filaSeleccionada, 3);

		String nuevoTitle = Utilidades.obtenerEntrada("Nuevo título:" + titleActual);
		String nuevoDirector = Utilidades.obtenerEntrada("Nuevo director:" + directorActual);
		int nuevoCli_id = obtenerClienteID();

		// si algun campo es nulo = se cancela la operacion
		if (nuevoTitle == null || nuevoDirector == null || nuevoCli_id == -1) {
			Utilidades.mostrarMensajeAdvertencia("La operación ha sido cancelada.");
			return;
		}
		ModelVideos videoActualizado = new ModelVideos(idVideo, nuevoTitle, nuevoDirector, nuevoCli_id);

		try {
			videosCRUD.actualizarVideo(videoActualizado);
			Utilidades.mostrarMensajeExito("Registro actualizado correctamente.");
			videoView.actualizarListaVideos(videosCRUD.obtenerDatosVideos()); // actualizar la vista
		} catch (SQLException ex) {
			Utilidades.mostrarMensajeError("ERROR al actualizar el registro: " + ex.getMessage());
		}
	}

	public void eliminarVideo() {
		int filaSeleccionada = videoView.getTablaVideos().getSelectedRow();
		if (filaSeleccionada == -1) {
			Utilidades.mostrarMensajeAdvertencia("Por favor, selecciona la fila que quieres eliminar.");
			return;
		}
		int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que deseas eliminar este registro?",
				"Confirmar eliminación", JOptionPane.YES_NO_OPTION);
		if (opcion == JOptionPane.YES_OPTION) {
			try {
				int idVideoAEliminar = (int) videoView.getTablaVideos().getValueAt(filaSeleccionada, 0);
				videosCRUD.eliminarVideo(idVideoAEliminar);
				Utilidades.mostrarMensajeExito("Registro eliminado correctamente.");
				videoView.actualizarListaVideos(videosCRUD.obtenerDatosVideos()); // actualizar la vista
			} catch (SQLException e) {
				Utilidades.mostrarMensajeError("ERROR al eliminar el registro: " + e.getMessage());
			}
		}
	}

	private int obtenerClienteID() {
		String cli_idStr = Utilidades.obtenerEntrada("Introduce el ID del cliente:");
		if (cli_idStr == null)
			return -1; // si se cancela la operación
		try {
			return Integer.parseInt(cli_idStr);
		} catch (NumberFormatException e) {
			Utilidades.mostrarMensajeError("El ID del cliente debe ser un número entero.");
			return -1;
		}
	}

}