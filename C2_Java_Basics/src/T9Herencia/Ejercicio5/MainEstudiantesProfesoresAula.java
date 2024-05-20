package T9Herencia.Ejercicio5;

import java.util.*;

public class MainEstudiantesProfesoresAula {

	public static void main(String[] args) {

		simulacionAulas();

	}

	public static void simulacionAulas() {

		Random random = new Random();

		for (int i = 1; i <= 10; i++) {                                                           //itera sobre 10 aulas
			System.out.println("Aula " + i);

			List<Estudiante> estudiantes = new ArrayList<>();                                     //para cada aula se crea una lista de estudiantes
			for (int j = 0; j < 30; j++) {                                                        //itera sobre 30 estudiantes con las calif. aleat.
				int calificacion = random.nextInt(11);                      
				Estudiante estudiante = new Estudiante();                                         //cada estudiante se instancia como un objeto 'estudiante'
				estudiante.setCalificacion(calificacion);
				estudiantes.add(estudiante);                                                      
			}

			String[] materias = { "matemáticas", "filosofía", "física" };
			String materiaAula = materias[random.nextInt(materias.length)];                       //genera aleat. un índice para seleccionar aleat. una materia del array
			Profesor profesor = new Profesor();                                                   //inst de obj. profesor
			Aula aula = new Aula(i, materiaAula, profesor, estudiantes);                          //creacion obj. aula (i=num aula, materia, prof. y lista estudiantes)

			aula.sePuedeDarClases();                                                              //comprueba condiciones para dar clases

			System.out.println();
		}
	}

}
