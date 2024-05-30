package T22MVC.Ejercicio2.AppMain;
import java.sql.Connection;

import T22MVC.Ejercicio2.ConexionBD;
import T22MVC.Ejercicio2.Controllers.ControllerCientificos;
import T22MVC.Ejercicio2.Views.ViewCientificos;

public class MainCientificos {
	
	public static void main(String[] args) {
		
		ConexionBD conexionBD = new ConexionBD();
        conexionBD.connect();
        Connection conexion = conexionBD.getConnection();
        
        ViewCientificos cientificoView = new  ViewCientificos();
        ControllerCientificos controller = new ControllerCientificos(cientificoView, conexion);
        
        cientificoView.setVisible(true);
    }
}