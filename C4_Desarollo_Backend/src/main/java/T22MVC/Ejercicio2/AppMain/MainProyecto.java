package T22MVC.Ejercicio2.AppMain;

import T22MVC.Ejercicio2.Controllers.ControllerProyecto;
import T22MVC.Ejercicio2.ConexionBD;
import T22MVC.Ejercicio2.CRUD.CRUDProyecto;
import T22MVC.Ejercicio2.Views.ViewProyecto;

import java.sql.Connection;

public class MainProyecto {
    public static void main(String[] args) {

        ConexionBD conexionBD = new ConexionBD();
        conexionBD.connect();
        Connection conexion = conexionBD.getConnection();

        CRUDProyecto crudProyecto = new CRUDProyecto(conexion);
        ViewProyecto viewProyecto = new ViewProyecto();
        ControllerProyecto controllerProyecto = new ControllerProyecto(crudProyecto, viewProyecto, conexion);
    }
}