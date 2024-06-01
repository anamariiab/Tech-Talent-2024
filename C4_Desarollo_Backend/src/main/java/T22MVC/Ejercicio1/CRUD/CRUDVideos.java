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
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw ex; // se propaga y la manejamos en la clase controller
        }
    }

    public void actualizarVideo(ModelVideos video) throws SQLException {
        String sql = "UPDATE videos SET title = ?, director = ?, cli_id = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, video.getTitle());
            statement.setString(2, video.getDirector());
            statement.setInt(3, video.getCli_id());
            statement.setInt(4, video.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw ex; 
        }
    }

    public void eliminarVideo(int idVideo) throws SQLException {
        String sql = "DELETE FROM videos WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idVideo);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw ex; 
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
            throw ex; 
        }
        return videos;
    }
}