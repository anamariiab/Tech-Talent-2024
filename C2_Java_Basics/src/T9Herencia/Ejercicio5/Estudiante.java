package T9Herencia.Ejercicio5;
import java.util.*;

public class Estudiante extends Persona {
	
	private int calificacion;
	
	public Estudiante() {
		super();
		Random random = new Random(); 
		edad = random.nextInt(18, 80);                                                         //genera valores aleat. 
		calificacion = random.nextInt(11);                                                     //genera valores aleat.
	}
	
	public Estudiante(String nombre, int edad, String sexo, int calificacion) {
		super(nombre, edad, sexo);
		this.calificacion = calificacion;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	
	public void asistenciaAClase() {
	    Random random = new Random();
	    asistenciaClase = (random.nextDouble() < 0.5) ? true : asistenciaClase;                         //si el número aleat. generado es menor que 0.5, la expresión se establece ‘true’--> el estudiante asistirá a clase. 
	    
	}	
//	public boolean asistenciaAClase() {
//	    Random random = new Random();
//	    return random.nextDouble() < 0.5;
//	}

}