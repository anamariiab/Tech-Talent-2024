package T22MVC.Ejercicio1.AppMain;

import T22MVC.Ejercicio1.Controllers.ControllerCliente;
import T22MVC.Ejercicio1.Controllers.ControllerVideos;
import T22MVC.Ejercicio1.CRUD.CRUDCliente;
import T22MVC.Ejercicio1.CRUD.CRUDVideos;
import T22MVC.Ejercicio1.Models.ModelCliente;
import T22MVC.Ejercicio1.Models.ModelVideos;
import T22MVC.Ejercicio1.Views.ViewCliente;
import T22MVC.Ejercicio1.Views.ViewSeleccionTabla1;
import T22MVC.Ejercicio1.Views.ViewVideos;
import T22MVC.Ejercicio1.ConexionBD;

import java.sql.Connection;


public class MainClienteYVideos {

    public static void main(String[] args) {
    	
    	ConexionBD conexionBD = new ConexionBD();
    	conexionBD.connect();
    	Connection conexion = conexionBD.getConnection();
    	
        ViewSeleccionTabla1 viewSeleccionTabla = new ViewSeleccionTabla1();
        
        viewSeleccionTabla.agregarListenerClientes(e -> {
            CRUDCliente crudClientes = new CRUDCliente(conexion);
            ControllerCliente controllerClientes = new ControllerCliente(crudClientes, new ViewCliente(), conexion, viewSeleccionTabla);
        });

        viewSeleccionTabla.agregarListenerVideos(e -> {
            CRUDVideos crudVideos = new CRUDVideos(conexion);
            ControllerVideos controllerVideos = new ControllerVideos(crudVideos, new ViewVideos(), conexion, viewSeleccionTabla);
        });

        viewSeleccionTabla.setVisible(true);
    }
}