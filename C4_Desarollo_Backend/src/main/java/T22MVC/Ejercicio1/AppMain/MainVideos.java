package T22MVC.Ejercicio1.AppMain;
import T22MVC.Ejercicio1.Controllers.ControllerVideos;
import T22MVC.Ejercicio1.ConexionBD;
import T22MVC.Ejercicio1.CRUD.CRUDVideos;
import T22MVC.Ejercicio1.Views.ViewVideos;

import java.sql.Connection;

public class MainVideos {
	public static void main(String[] args) {

		ConexionBD conexionBD = new ConexionBD();
		conexionBD.connect();
		Connection conexion = conexionBD.getConnection();

		CRUDVideos crudVideos = new CRUDVideos(conexion);
		ViewVideos viewVideos = new ViewVideos();
		ControllerVideos controllerVideo = new ControllerVideos(crudVideos, viewVideos, conexion);
	}
}