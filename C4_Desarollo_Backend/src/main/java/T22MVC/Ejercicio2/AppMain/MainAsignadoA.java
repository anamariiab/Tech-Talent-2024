package T22MVC.Ejercicio2.AppMain;

import java.sql.Connection;

import T22MVC.Ejercicio2.ConexionBD;
import T22MVC.Ejercicio2.Controllers.ControllerAsignadoA;
import T22MVC.Ejercicio2.Views.ViewAsignadoA;

public class MainAsignadoA {

	public static void main(String[] args) {
		ConexionBD conexionBD = new ConexionBD();
		conexionBD.connect();
		Connection conexion = conexionBD.getConnection();

		ViewAsignadoA asignadoAView = new ViewAsignadoA();
		ControllerAsignadoA controllerAsignado = new ControllerAsignadoA(asignadoAView, conexion);

		asignadoAView.setVisible(true);
	}

}
