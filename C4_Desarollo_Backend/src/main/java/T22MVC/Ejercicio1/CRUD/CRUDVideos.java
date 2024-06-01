package T22MVC.Ejercicio1.CRUD;
import T22MVC.Ejercicio1.Models.ModelVideos;
import T22MVC.Utilidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDVideos {

    private Connection connection;

    public CRUDVideos(Connection connection) {
        this.connection = connection;
    }

    public void insertarVideo(ModelVideos video) throws SQLException {
        String sql = "INSERT INTO videos (title, director, cli_id) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, video.getTitle());
            statement.setString(2, video.getDirector());
            statement.setInt(3, video.getCli_id());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                Utilidades.mostrarMensajeExito("Video insertado correctamente.");
            }
        } catch (SQLException ex) {
            Utilidades.mostrarMensajeError("Error al insertar el video: " + ex.getMessage());
        }
    }

    public void actualizarVideo(ModelVideos video) {
        String sql = "UPDATE videos SET title = ?, director = ?, cli_id = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, video.getTitle());
            statement.setString(2, video.getDirector());
            statement.setInt(3, video.getCli_id());
            statement.setInt(4, video.getId());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                Utilidades.mostrarMensajeExito("Video actualizado correctamente.");
            }
        } catch (SQLException ex) {
            Utilidades.mostrarMensajeError("Error al actualizar el video: " + ex.getMessage());
        }
    }

    public void eliminarVideo(int idVideo) throws SQLException {
        String sql = "DELETE FROM videos WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idVideo);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                Utilidades.mostrarMensajeExito("Video eliminado correctamente.");
            }
        } catch (SQLException ex) {
            Utilidades.mostrarMensajeError("Error al eliminar el video: " + ex.getMessage());
        }
    }

    public List<ModelVideos> obtenerDatosVideos() throws SQLException {
        List<ModelVideos> videos = new ArrayList<>();
        String sql = "SELECT * FROM videos";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                ModelVideos video = new ModelVideos(resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("director"),
                        resultSet.getInt("cli_id"));
                videos.add(video);
            }
        } catch (SQLException ex) {
            Utilidades.mostrarMensajeError("Error al obtener los datos: " + ex.getMessage());
        }
        return videos;
    }
}