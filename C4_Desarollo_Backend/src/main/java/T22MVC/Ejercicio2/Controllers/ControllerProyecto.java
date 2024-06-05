package T22MVC.Ejercicio2.Controllers;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import T22MVC.Ejercicio2.Models.ModelProyecto;
import T22MVC.Ejercicio2.CRUD.CRUDProyecto;
import T22MVC.Ejercicio2.Views.ViewProyecto;
import T22MVC.Utilidades;
import T22MVC.Ejercicio2.Views.ViewSeleccionTabla2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ControllerProyecto {

    private CRUDProyecto proyectoCRUD;
    private ViewProyecto proyectoView;
    private ViewSeleccionTabla2 seleccionTablaView;
    private Connection conexion;

    public ControllerProyecto(CRUDProyecto proyectoCRUD, ViewProyecto viewProyecto, Connection conexion, ViewSeleccionTabla2 seleccionTablaView) {
        this.conexion = conexion;
        this.proyectoCRUD = proyectoCRUD;
        this.proyectoView = viewProyecto;
        this.seleccionTablaView = seleccionTablaView;
        inicializarVista();
        cargarProyectos();
        asignarListeners();
    }

    private void inicializarVista() {
        proyectoView.setVisible(true);
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

    private void cargarProyectos() {
        try {
            List<ModelProyecto> proyectos = proyectoCRUD.obtenerDatosProyectos();
            proyectoView.mostrarProyectos(proyectos);
        } catch (SQLException e) {
            Utilidades.mostrarMensajeError("ERROR al cargar los registros: " + e.getMessage());
        }
    }

    public void insertarProyecto() {
        String id = obtenerId();
        if (id == null) {
            return; 
        }
        String nombre = obtenerNombre();
        if (nombre == null) {
            return; 
        }
        int horas = obtenerHoras();
        if (horas == -1) {
            return; 
        }

        try {
            ModelProyecto proyecto = new ModelProyecto(id, nombre, horas);
            proyectoCRUD.insertarProyecto(proyecto);
            Utilidades.mostrarMensajeExito("Registro insertado correctamente.");
            proyectoView.actualizarListaProyectos(proyectoCRUD.obtenerDatosProyectos()); // actualizar la vista
        } catch (SQLException ex) {
            Utilidades.mostrarMensajeError("ERROR al insertar el proyecto: " + ex.getMessage());
        }
    }

    public void actualizarProyecto() {
        JTable tablaProyectos = proyectoView.getTablaProyectos();

        int filaSeleccionada = tablaProyectos.getSelectedRow();
        if (filaSeleccionada == -1) {
            Utilidades.mostrarMensajeAdvertencia("Por favor, selecciona la fila que quieres actualizar.");
            return;
        }

        String idProyecto = (String) tablaProyectos.getValueAt(filaSeleccionada, 0);
        String nombreActual = (String) tablaProyectos.getValueAt(filaSeleccionada, 1);
        int horasActuales = (int) tablaProyectos.getValueAt(filaSeleccionada, 2);

        String nuevoNombre = obtenerNombre();
        int nuevasHoras = obtenerHoras();

        if (nuevoNombre == null || nuevasHoras == -1) {
            Utilidades.mostrarMensajeAdvertencia("La operación ha sido cancelada.");
            return;
        }

        ModelProyecto proyectoActualizado = new ModelProyecto(idProyecto, nuevoNombre, nuevasHoras);

        try {
            proyectoCRUD.actualizarProyecto(proyectoActualizado);
            Utilidades.mostrarMensajeExito("Proyecto actualizado correctamente.");
            proyectoView.actualizarListaProyectos(proyectoCRUD.obtenerDatosProyectos()); // actualizar la vista
        } catch (SQLException ex) {
            Utilidades.mostrarMensajeError("ERROR al actualizar el proyecto: " + ex.getMessage());
        }
    }

    public void eliminarProyecto() {
        int filaSeleccionada = proyectoView.getTablaProyectos().getSelectedRow();
        if (filaSeleccionada == -1) {
            Utilidades.mostrarMensajeAdvertencia("Por favor, selecciona la fila que quieres eliminar.");
            return;
        }
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que deseas eliminar este registro?",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                String idProyectoAEliminar = (String) proyectoView.getTablaProyectos().getValueAt(filaSeleccionada, 0);
                proyectoCRUD.eliminarProyecto(idProyectoAEliminar);
                Utilidades.mostrarMensajeExito("Registro eliminado correctamente.");
                proyectoView.actualizarListaProyectos(proyectoCRUD.obtenerDatosProyectos()); // actualizar la vista
            } catch (SQLException e) {
                Utilidades.mostrarMensajeError("ERROR al eliminar el registro: " + e.getMessage());
            }
        }
    }

    private String obtenerId() {
        while (true) {
            String id = Utilidades.obtenerEntrada("Introduce el ID (4 caracteres):");
            if (id.length() != 4) {
                Utilidades.mostrarMensajeError("El ID debe tener exactamente 4 caracteres.");
                continue;
            }
            return id;
        }
    }

    private String obtenerNombre() {
        while (true) {
            String nombre = Utilidades.obtenerEntrada("Introduce el nombre:");
            if (nombre == null || nombre.trim().isEmpty()) {
                Utilidades.mostrarMensajeError("El nombre no puede estar vacío.");
                continue;
            }
            return nombre;
        }
    }

    private int obtenerHoras() {
        while (true) {
            String horasStr = Utilidades.obtenerEntrada("Introduce el número de horas:");
            if (horasStr == null) return -1; // si se cancela la operación
            try {
                return Integer.parseInt(horasStr);
            } catch (NumberFormatException e) {
                Utilidades.mostrarMensajeError("Las horas deben ser un número entero.");
            }
        }
    }
}