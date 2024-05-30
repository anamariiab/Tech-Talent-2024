package T22MVC.Ejercicio1.AppMain;
import java.sql.Connection;

import T22MVC.Ejercicio1.ConexionBD;
import T22MVC.Ejercicio1.Controllers.ControllerCliente;
import T22MVC.Ejercicio1.Views.ViewCliente;

public class MainCliente {
	public static void main(String[] args) {

        ConexionBD conexionBD = new ConexionBD();
        conexionBD.connect();
        Connection conexion = conexionBD.getConnection();
        
        ViewCliente clientesView = new ViewCliente();
        ControllerCliente controller = new ControllerCliente(clientesView, conexion);
    }

}
