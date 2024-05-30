package T22MVC.Ejercicio2.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;

import T22MVC.Ejercicio2.Views.ViewAsignadoA;

public class ControllerAsignadoA {

    private final ViewAsignadoA asignadoAView;
    private final Connection conexion;

    public ControllerAsignadoA(ViewAsignadoA asignadoAView, Connection conexion) {
        this.asignadoAView = asignadoAView;
        this.conexion = conexion;
        inicializarVista();
        cargarAsignaciones();
        asignarListeners();
    }

    private void inicializarVista() {
        asignadoAView.setVisible(true);
    }

    private void cargarAsignaciones() {
        try {
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM asignado_a");
            while (resultSet.next()) {
                String cientifico = resultSet.getString("cientifico");
                String proyecto = resultSet.getString("proyecto");
                asignadoAView.agregarAsignacionATabla(cientifico, proyecto);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar las asignaciones: " + e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void asignarListeners() {
        asignadoAView.agregarListenerAsignar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                asignarCientificoAProyecto();
            }
        });

        asignadoAView.agregarListenerEliminarAsignacion(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarAsignacion();
            }
        });
    }

    private void asignarCientificoAProyecto() {
        String cientifico = JOptionPane.showInputDialog("Introduce el DNI del científico:");
        if (cientifico == null || cientifico.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El DNI no puede estar vacío.", "¡Atención!",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        String proyecto = JOptionPane.showInputDialog("Introduce el ID del proyecto:");
        if (proyecto == null || proyecto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El ID del proyecto no puede estar vacío.", "¡Atención!",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String query = "INSERT INTO asignado_a (cientifico, proyecto) VALUES (?, ?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setString(1, cientifico);
            preparedStatement.setString(2, proyecto);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            JOptionPane.showMessageDialog(null, "Asignación realizada con éxito.", "¡Éxito!",
                    JOptionPane.INFORMATION_MESSAGE);
            asignadoAView.mostrarAsignaciones(obtenerDatosAsignaciones()); // recargar las asignaciones en la vista
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR al realizar la asignación: " + e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarAsignacion() {
        int filaSeleccionada = asignadoAView.getTablaAsignaciones().getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona la fila que quieres eliminar.", "¡Atención!",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que deseas eliminar esta asignación?",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                String cientifico = (String) asignadoAView.getTablaAsignaciones().getValueAt(filaSeleccionada, 0);
                String proyecto = (String) asignadoAView.getTablaAsignaciones().getValueAt(filaSeleccionada, 1);

                String query = "DELETE FROM asignado_a WHERE cientifico = ? AND proyecto = ?";
                PreparedStatement preparedStatement = conexion.prepareStatement(query);
                preparedStatement.setString(1, cientifico);
                preparedStatement.setString(2, proyecto);
                preparedStatement.executeUpdate();
                preparedStatement.close();

                JOptionPane.showMessageDialog(null, "Asignación eliminada con éxito.", "¡Éxito!",
                        JOptionPane.INFORMATION_MESSAGE);
                asignadoAView.mostrarAsignaciones(obtenerDatosAsignaciones()); // recargar las asignaciones en la vista
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR al eliminar la asignación: " + ex.getMessage(), "¡Error!",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private Object[][] obtenerDatosAsignaciones() {
        try {
            Statement statement = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM asignado_a");
            resultSet.last();
            int numRows = resultSet.getRow();
            Object[][] datos = new Object[numRows][2];
            resultSet.beforeFirst();
            int i = 0;
            while (resultSet.next()) {
                datos[i][0] = resultSet.getString("cientifico");
                datos[i][1] = resultSet.getString("proyecto");
                i++;
            }
            resultSet.close();
            statement.close();
            return datos;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR al cargar las asignaciones: " + e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return new Object[0][0];
        }
    }
}