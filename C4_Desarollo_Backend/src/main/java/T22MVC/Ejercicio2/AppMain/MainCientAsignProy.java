package T22MVC.Ejercicio2.AppMain;

import java.sql.Connection;

import T22MVC.Ejercicio2.ConexionBD;
import T22MVC.Ejercicio2.CRUD.CRUDCientificos;
import T22MVC.Ejercicio2.CRUD.CRUDProyecto;
import T22MVC.Ejercicio2.CRUD.CRUDAsignacion;
import T22MVC.Ejercicio2.Controllers.ControllerCientificos;
import T22MVC.Ejercicio2.Controllers.ControllerProyecto;
import T22MVC.Ejercicio2.Controllers.ControllerAsignacion;
import T22MVC.Ejercicio2.Views.ViewCientificos;
import T22MVC.Ejercicio2.Views.ViewProyecto;
import T22MVC.Ejercicio2.Views.ViewAsignacion;
import T22MVC.Ejercicio2.Views.ViewSeleccionTabla2;


public class MainCientAsignProy {

public static void main(String[] args) {
    	
    	ConexionBD conexionBD = new ConexionBD();
    	conexionBD.connect();
    	Connection conexion = conexionBD.getConnection();
    	
        ViewSeleccionTabla2 viewSeleccionTabla = new ViewSeleccionTabla2();
        
        viewSeleccionTabla.agregarListenerCientificos(e -> {
            CRUDCientificos crudCientificos = new CRUDCientificos(conexion);
            ControllerCientificos controllerCientificos = new ControllerCientificos(crudCientificos, new ViewCientificos(), conexion, viewSeleccionTabla);
        });

        viewSeleccionTabla.agregarListenerAsignaciones(e -> {
            CRUDAsignacion crudAsignacion = new CRUDAsignacion(conexion);
            ControllerAsignacion controllerAsignacion = new ControllerAsignacion(crudAsignacion, new ViewAsignacion(), conexion, viewSeleccionTabla);
        });
        
        viewSeleccionTabla.agregarListenerProyecto(e -> {
            CRUDProyecto crudProyecto = new CRUDProyecto(conexion);
            ControllerProyecto controllerProyecto = new ControllerProyecto(crudProyecto, new ViewProyecto(), conexion, viewSeleccionTabla);
        });
        
        viewSeleccionTabla.setVisible(true);
    }
}