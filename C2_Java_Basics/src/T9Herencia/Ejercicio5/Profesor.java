package T9Herencia.Ejercicio5;
import java.util.*;

public class Profesor extends Persona{
    
	private String materia;
	
	public Profesor() {
		super();
		Random random = new Random();
		edad = random.nextInt(24, 100);                                                    //genera valores aleat.
		
		String[] materias = {"matemáticas", "filosofía", "física"};                      
		int indiceMateria = random.nextInt(materias.length);                               //genera aleat. un índice para seleccionar una materia del array
		materia = materias[indiceMateria];                                                 //se asigna al atr. la materia seleccionada anter.
	}
	
	public Profesor(String nombre, int edad, String sexo, String materia) {
		super(nombre, edad, sexo);
		this.materia = materia;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	public void asistenciaAClase() {  
		Random random = new Random();                                       
	    asistenciaClase = (random.nextDouble() < 0.2) ? false : true;                      //si el número aleat. generado es menor que 0.2 la expresión se establece ‘false’ --> el profesor no asistirá a clase. 
	}

}
