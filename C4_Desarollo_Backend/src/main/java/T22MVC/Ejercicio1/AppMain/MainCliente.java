package T22MVC.Ejercicio1.AppMain;

import T22MVC.Ejercicio1.Controllers.ControllerCliente;
import T22MVC.Ejercicio1.ConexionBD;
import T22MVC.Ejercicio1.CRUD.CRUDCliente;
import T22MVC.Ejercicio1.Views.ViewCliente;

import java.sql.Connection;

public class MainCliente {
	public static void main(String[] args) {

		ConexionBD conexionBD = new ConexionBD();
		conexionBD.connect();
		Connection conexion = conexionBD.getConnection();

		CRUDCliente crudCliente = new CRUDCliente(conexion);
		ViewCliente viewCliente = new ViewCliente();
		ControllerCliente controllerCliente = new ControllerCliente(crudCliente, viewCliente, conexion);
	}

}
