package T22MVC.Ejercicio2.AppMain;

import T22MVC.Ejercicio2.ConexionBD;
import T22MVC.Ejercicio2.CRUD.CRUDCientificos;
import T22MVC.Ejercicio2.Controllers.ControllerCientificos;
import T22MVC.Ejercicio2.Views.ViewCientificos;

import java.sql.Connection;

public class MainCientificos {

	public static void main(String[] args) {

		ConexionBD conexionBD = new ConexionBD();
		conexionBD.connect();
		Connection conexion = conexionBD.getConnection();

		CRUDCientificos crudCientificos = new CRUDCientificos(conexion);
		ViewCientificos viewCientificos = new ViewCientificos();
		ControllerCientificos controllerCientificos = new ControllerCientificos(crudCientificos, viewCientificos,
				conexion);
	}
}