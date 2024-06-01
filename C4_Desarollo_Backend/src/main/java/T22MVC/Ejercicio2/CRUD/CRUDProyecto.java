package T22MVC.Ejercicio2.CRUD;

import T22MVC.Ejercicio2.Models.ModelProyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDProyecto {

    private Connection connection;

    public CRUDProyecto(Connection connection) {
        this.connection = connection;
    }

    public void insertarProyecto(ModelProyecto proyecto) throws SQLException {
        String sql = "INSERT INTO proyecto (ID, nombre, horas) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, proyecto.getId());
            statement.setString(2, proyecto.getNombre());
            statement.setInt(3, proyecto.getHoras());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw ex; 
        }
    }

    public void actualizarProyecto(ModelProyecto proyecto) throws SQLException {
        String sql = "UPDATE proyecto SET nombre = ?, horas = ? WHERE ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, proyecto.getNombre());
            statement.setInt(2, proyecto.getHoras());
            statement.setString(3, proyecto.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw ex; 
        }
    }

    public void eliminarProyecto(String idProyecto) throws SQLException {
        String sql = "DELETE FROM proyecto WHERE ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, idProyecto);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw ex; 
        }
    }

    public List<ModelProyecto> obtenerDatosProyectos() throws SQLException {
        List<ModelProyecto> proyectos = new ArrayList<>();
        String sql = "SELECT * FROM proyecto";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                ModelProyecto proyecto = new ModelProyecto(resultSet.getString("ID"), resultSet.getString("nombre"),
                        resultSet.getInt("horas"));
                proyectos.add(proyecto);
            }
        } catch (SQLException ex) {
            throw ex; 
        }
        return proyectos;
    }
}