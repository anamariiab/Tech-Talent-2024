package T9Herencia.Ejercicio5;
import java.util.*;

public abstract class Persona {
	
	protected String nombre;
	protected int edad;
	protected String sexo;
    protected boolean asistenciaClase = false;

    
    public Persona() {                                                                                 //genera una persona aleatoria
    	String[] nombres = {"Antonio", "Manuel", "José", "Francisco", "David", "Juan", "Jesús",
    		    "María", "Carmen", "Ana", "Isabel", "Dolores", "Josefa", "Rosa",
    		    "Lucía", "Sofía", "Martina", "Hugo", "Mateo", "Daniel"};
    	String[] sexos = {"Masculino", "Masculino", "Masculino", "Masculino", "Masculino", "Masculino", "Masculino",
    			"Femenino", "Femenino", "Femenino", "Femenino", "Femenino", "Femenino", "Femenino",
    			"Femenino", "Femenino", "Femenino", "Masculino", "Masculino", "Masculino"};

    	String[] apellidos = {
                "García", "Fernández", "López", "Martínez", "González", "Rodríguez", "Sánchez", 
                "Pérez", "Martín", "Gómez", "Ruiz", "Hernández", "Díaz", "Moreno", "Álvarez", 
                "Romero", "Jiménez", "Vázquez", "Torres", "Serrano"};
    	
    	Random random = new Random();                                                                 //se generan indices aleatorios para seleccionar un nombre y apellidos de los arrays  
    	int indiceNombre = random.nextInt(nombres.length);
    	int apellido1 = random.nextInt(apellidos.length);
    	int apellido2 = random.nextInt(apellidos.length);
    	
    	nombre = nombres[indiceNombre] + " " + apellidos[apellido1] + " " + apellidos[apellido2];     //se asignan al atributo nombre
    	sexo = sexos[indiceNombre];
    	edad = random.nextInt(18, 100);                                                               //se genera aleat
    	asistenciaAClase();                                                                           //se llama para generar aleat. el valor true o false que indica si la pers. asistio a clase o no.
    }
    
	public Persona(String nombre, int edad, String sexo) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public boolean asisteAClase() {
		return asistenciaClase;
	}

	public abstract void asistenciaAClase();
}