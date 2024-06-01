package T22MVC.Ejercicio2.AppMain;

import T22MVC.Ejercicio2.Controllers.ControllerAsignacion;
import T22MVC.Ejercicio2.ConexionBD;
import T22MVC.Ejercicio2.CRUD.CRUDAsignacion;
import T22MVC.Ejercicio2.Views.ViewAsignacion;
import T22MVC.Utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainAsignacion {
	public static void main(String[] args) {

		ConexionBD conexionBD = new ConexionBD();
		conexionBD.connect();
		Connection conexion = conexionBD.getConnection();

		CRUDAsignacion asignacionCRUD = new CRUDAsignacion(conexion);
		ViewAsignacion asignacionView = new ViewAsignacion();
		ControllerAsignacion asignacionController = new ControllerAsignacion(asignacionCRUD, asignacionView, conexion);
	}
}