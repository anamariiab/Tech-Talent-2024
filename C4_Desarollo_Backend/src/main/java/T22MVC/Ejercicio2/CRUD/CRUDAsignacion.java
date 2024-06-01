package T22MVC.Ejercicio2.CRUD;

import T22MVC.Ejercicio2.Models.ModelAsignacion;
import T22MVC.Utilidades;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CRUDAsignacion {

    private Connection connection;

    public CRUDAsignacion(Connection connection) {
        this.connection = connection;
    }

    public void insertarAsignacion(ModelAsignacion asignacion) throws SQLException {
        String sql = "INSERT INTO asignado_a (cientifico, proyecto) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, asignacion.getCientifico());
            statement.setString(2, asignacion.getProyecto());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                Utilidades.mostrarMensajeExito("Asignación insertada correctamente.");
            }
        } catch (SQLException ex) {
            Utilidades.mostrarMensajeError("Error al insertar la asignación: " + ex.getMessage());
        }
    }

    public void eliminarAsignacion(String cientifico, String proyecto) throws SQLException {
        String sql = "DELETE FROM asignado_a WHERE cientifico = ? AND proyecto = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cientifico);
            statement.setString(2, proyecto);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                Utilidades.mostrarMensajeExito("Asignación eliminada correctamente.");
            }
        } catch (SQLException ex) {
            Utilidades.mostrarMensajeError("Error al eliminar la asignación: " + ex.getMessage());
        }
    }

    public List<ModelAsignacion> obtenerDatosAsignaciones() throws SQLException {
        List<ModelAsignacion> asignaciones = new ArrayList<>();
        String sql = "SELECT * FROM asignado_a";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                ModelAsignacion asignacion = new ModelAsignacion(
                        resultSet.getString("cientifico"),
                        resultSet.getString("proyecto")
                );
                asignaciones.add(asignacion);
            }
        } catch (SQLException ex) {
            Utilidades.mostrarMensajeError("Error al obtener los datos: " + ex.getMessage());
        }
        return asignaciones;
    }
}