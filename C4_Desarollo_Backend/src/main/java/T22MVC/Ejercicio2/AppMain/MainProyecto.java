package T22MVC.Ejercicio2.AppMain;

import java.sql.Connection;

import T22MVC.Ejercicio2.ConexionBD;
import T22MVC.Ejercicio2.Controllers.ControllerProyecto;
import T22MVC.Ejercicio2.Views.ViewProyecto;

public class MainProyecto {

	public static void main(String[] args) {
		ConexionBD conexionBD = new ConexionBD();
        conexionBD.connect();
        Connection conexion = conexionBD.getConnection();
        
        ViewProyecto proyectoView = new ViewProyecto();
        ControllerProyecto controller = new ControllerProyecto(proyectoView, conexion);
        
        proyectoView.setVisible(true);

	}

}
