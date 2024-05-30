package T22MVC.Ejercicio1.AppMain;

import java.sql.Connection;

import T22MVC.Ejercicio1.ConexionBD;
import T22MVC.Ejercicio1.Controllers.ControllerVideos;
import T22MVC.Ejercicio1.Views.ViewVideos;

public class MainVideos {
    public static void main(String[] args) {
    
    	ConexionBD conexionBD = new ConexionBD();
        conexionBD.connect();
        Connection conexion = conexionBD.getConnection();

        ViewVideos videosView = new ViewVideos();
        ControllerVideos videoController = new ControllerVideos(videosView, conexion);
    }
}