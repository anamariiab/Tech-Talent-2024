package T22MVC.Ejercicio1.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;

import T22MVC.Ejercicio1.Views.ViewVideos;

public class ControllerVideos {
	 private final ViewVideos videosView;
	    private final Connection conexion;

	    public ControllerVideos(ViewVideos videosView, Connection conexion) {
	        this.videosView = videosView;
	        this.conexion = conexion;
	        inicializarVista();
	        cargarVideos();
	        asignarListeners();
	    }

	    private void inicializarVista() {
	        videosView.setVisible(true);
	    }

	    private void cargarVideos() {
	        try {
	            Statement statement = conexion.createStatement();
	            ResultSet resultSet = statement.executeQuery("SELECT * FROM videos");
	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String title = resultSet.getString("title");
	                String director = resultSet.getString("director");
	                int clientId = resultSet.getInt("cli_id");
	                videosView.agregarVideoATabla(id, title, director, clientId);
	            }
	            resultSet.close();
	            statement.close();
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, "Error al cargar los videos: " + e.getMessage(), "Error",
	                    JOptionPane.ERROR_MESSAGE);
	        }
	    }

	    private void asignarListeners() {
	        videosView.agregarListenerActualizar(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                actualizarVideo();
	            }
	        });

	        videosView.agregarListenerEliminar(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                eliminarVideo();
	            }
	        });

	        videosView.agregarListenerInsertar(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                insertarVideo();
	            }
	        });
	    }
	    
	    private void insertarVideo() {
	        String title = JOptionPane.showInputDialog("Introduce el título del video:");
	        if (title == null)
	            return; // si cancela, salir del método

	        String director = JOptionPane.showInputDialog("Introduce el director del video:");
	        if (director == null)
	            return;
	        int clientId;
	        String clientIdString;
	        do {
	            clientIdString = JOptionPane.showInputDialog("Introduce el ID del cliente:");
	            if (clientIdString == null)
	                return;
	            try {
	                clientId = Integer.parseInt(clientIdString);
	                // Puedes agregar más validaciones si lo consideras necesario
	            } catch (NumberFormatException e) {
	                JOptionPane.showMessageDialog(null, "El ID del cliente debe ser un número entero.", "Error",
	                        JOptionPane.ERROR_MESSAGE);
	                clientId = -1; // para repetir el bucle
	            }
	        } while (clientId == -1);

	        try {
	            String query = "INSERT INTO videos (title, director, cli_id) VALUES (?, ?, ?)";
	            PreparedStatement preparedStatement = conexion.prepareStatement(query);
	            preparedStatement.setString(1, title);
	            preparedStatement.setString(2, director);
	            preparedStatement.setInt(3, clientId);
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            JOptionPane.showMessageDialog(null, "Video insertado exitosamente.", "Éxito",
	                    JOptionPane.INFORMATION_MESSAGE);
	            videosView.mostrarVideos(obtenerDatosVideos()); // recargar los videos en la vista
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, "Error al insertar el video: " + e.getMessage(), "Error",
	                    JOptionPane.ERROR_MESSAGE);
	        }
	    }

	    private void actualizarVideo() {
	        int filaSeleccionada = videosView.getTablaVideos().getSelectedRow();
	        if (filaSeleccionada == -1) {
	            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para actualizar.", "Error",
	                    JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        int idVideo = (int) videosView.getTablaVideos().getValueAt(filaSeleccionada, 0); // obtener datos actuales
	        String titleActual = (String) videosView.getTablaVideos().getValueAt(filaSeleccionada, 1);
	        String directorActual = (String) videosView.getTablaVideos().getValueAt(filaSeleccionada, 2);
	        int clientIdActual = (int) videosView.getTablaVideos().getValueAt(filaSeleccionada, 3);

	        String nuevoTitle = JOptionPane.showInputDialog("Nuevo título:", titleActual);
	        if (nuevoTitle == null) {
	            return; // salir del método si el usuario cancela o cierra la ventana
	        }

	        String nuevoDirector = JOptionPane.showInputDialog("Nuevo director:", directorActual);
	        if (nuevoDirector == null) {
	            return;
	        }

	        int nuevoClientId;
	        String nuevoClientIdString;
	        do {
	            nuevoClientIdString = JOptionPane.showInputDialog("Nuevo ID del cliente:", clientIdActual);
	            if (nuevoClientIdString == null) {
	                return;
	            }
	            try {
	                nuevoClientId = Integer.parseInt(nuevoClientIdString);
	            } catch (NumberFormatException e) {
	                JOptionPane.showMessageDialog(null, "El ID del cliente debe ser un número entero.", "Error",
	                        JOptionPane.ERROR_MESSAGE);
	                nuevoClientId = -1; // para repetir el bucle
	            }
	        } while (nuevoClientId == -1);

	        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea actualizar los datos?",
	                "Confirmar actualización datos", JOptionPane.YES_NO_OPTION);
	        if (opcion == JOptionPane.YES_OPTION) {
	            try {
	                String query = "UPDATE videos SET title=?, director=?, cli_id=? WHERE id=?";
	                PreparedStatement preparedStatement = conexion.prepareStatement(query);
	                preparedStatement.setString(1, nuevoTitle);
	                preparedStatement.setString(2, nuevoDirector);
	                preparedStatement.setInt(3, nuevoClientId);
	                preparedStatement.setInt(4, idVideo);
	                preparedStatement.executeUpdate();
	                preparedStatement.close();

	                videosView.mostrarVideos(obtenerDatosVideos()); // recargar los videos en la vista
	            } catch (SQLException e) {
	                JOptionPane.showMessageDialog(null, "Error al actualizar el video: " + e.getMessage(), "Error",
	                        JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    }

	    private void eliminarVideo() {
	        int filaSeleccionada = videosView.getTablaVideos().getSelectedRow();
	        if (filaSeleccionada == -1) {
	            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para eliminar.", "Error",
	                    JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que deseas eliminar este video?",
	                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
	        if (opcion == JOptionPane.YES_OPTION) {
	            try {
	                int idVideoAEliminar = (int) videosView.getTablaVideos().getValueAt(filaSeleccionada, 0);
	                String query = "DELETE FROM videos WHERE id=?";
	                PreparedStatement preparedStatement = conexion.prepareStatement(query);
	                preparedStatement.setInt(1, idVideoAEliminar);
	                preparedStatement.executeUpdate();
	                preparedStatement.close();
	                JOptionPane.showMessageDialog(null, "Video eliminado con éxito.", "Éxito",
	                        JOptionPane.INFORMATION_MESSAGE);
	                videosView.mostrarVideos(obtenerDatosVideos()); // recargar los videos en la vista
	            } catch (SQLException e) {
	                JOptionPane.showMessageDialog(null, "Error al eliminar el video: " + e.getMessage(), "Error",
	                        JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    }
	    
	    private Object[][] obtenerDatosVideos() {
	        try {
	            Statement statement = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	            ResultSet resultSet = statement.executeQuery("SELECT * FROM videos");
	            resultSet.last();
	            int numRows = resultSet.getRow();
	            Object[][] datos = new Object[numRows][4]; 
	            resultSet.beforeFirst();
	            int i = 0;
	            while (resultSet.next()) {
	                datos[i][0] = resultSet.getInt("id");
	                datos[i][1] = resultSet.getString("title");
	                datos[i][2] = resultSet.getString("director");
	                datos[i][3] = resultSet.getInt("cli_id"); 
	                i++;
	            }
	            resultSet.close();
	            statement.close();
	            return datos;
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, "Error al cargar los videos: " + e.getMessage(), "Error",
	                    JOptionPane.ERROR_MESSAGE);
	            return new Object[0][0];
	        }
		}
}