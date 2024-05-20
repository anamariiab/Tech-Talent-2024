package T9Herencia.Ejercicio6;

import java.util.Random;

public class Espectador {
	
	protected String nombre;
	protected int edad;
	protected double dinero;
	
	public Espectador(){                                                                                                //genera un espectador aleatorio
		String[] nombres = {"Antonio", "Manuel", "José", "Francisco", "David", "Juan", "Jesús",
    		    "María", "Carmen", "Ana", "Isabel", "Dolores", "Josefa", "Rosa",
    		    "Lucía", "Sofía", "Martina", "Hugo", "Mateo", "Daniel"};
		
    	String[] apellidos = {
                "García", "Fernández", "López", "Martínez", "González", "Rodríguez", "Sánchez", 
                "Pérez", "Martín", "Gómez", "Ruiz", "Hernández", "Díaz", "Moreno", "Álvarez", 
                "Romero", "Jiménez", "Vázquez", "Torres", "Serrano"};
    	
    	Random random = new Random();                                                                                   //se generan indices aleatorios para seleccionar un nombre y apellidos de los arrays  
    	int indiceNombre = random.nextInt(nombres.length);
    	int apellido1 = random.nextInt(apellidos.length);
    	int apellido2 = random.nextInt(apellidos.length);
    	
    	nombre = nombres[indiceNombre] + " " + apellidos[apellido1] + " " + apellidos[apellido2];                       //se asignan al atributo nombre
    	edad = random.nextInt(100);                                                                                     //se genera aleat
    	dinero = random.nextDouble(30);                                                                                 //se genera aleat
	}
	
	public Espectador(String nombre, int edad, double dinero) {
		this.nombre = nombre;
		this.edad = edad;
		this.dinero = dinero;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public double getDinero() {
		return dinero;
	}

	@Override
	public String toString() {
		return nombre + ", edad=" + edad + ", dinero=" + dinero;
	}
	

}