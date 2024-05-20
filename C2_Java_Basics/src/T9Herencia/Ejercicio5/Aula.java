package T9Herencia.Ejercicio5;

import java.util.*;

public class Aula {

	protected int identificadorNumerico;
	protected String materia;

	protected Profesor profesor;                                                             //contiene info. de la clase ‘Profesor’(nombre, edad, sexo y materia)
	protected List<Estudiante> estudiantes;                                                  //contiene info. de la clase ‘Estudiante’ (nombre, edad, sexo y calificación) 

	public Aula(int identificadorNumerico, String materia, Profesor profesor, List<Estudiante> estudiantes) {
		this.identificadorNumerico = identificadorNumerico;
		this.materia = materia;
		this.profesor = profesor;
		this.estudiantes = estudiantes;
	}

	public void sePuedeDarClases() {

		if (!profesor.asisteAClase()) {                                                      //se invierte el resultado de la expr. Si devuelve true, (!) lo convierte en false
			System.out.println("El profesor no está disponible!");                           
			return;
		}

		if (!profesor.getMateria().equals(materia)) {                                       //compara la materia que imparte el profesor con la materia asignada al aula.
			System.out.println("El profesor imparte " + profesor.getMateria()
					+ " pero el aula está destinada a impartir " + materia);
			return;
		}

		int asistenciaAlumnos = asistenciaEstudiantes();
		double porcentajeOcupacion = (double) (asistenciaAlumnos * 100) / (double) estudiantes.size();   //se aumenta el valor en un factor de 100 (=porcentaje de estudiantes presentes en terminos numericos) 
		if (porcentajeOcupacion <= 50) {                                                                 //al dividir el valor se obtiene el porcentaje de ocupacion del aula
			System.out.println("Han asistido menos del 50% de alumnos al aula");
			System.out.println(
					"Solo han asistido " + asistenciaAlumnos + " alumnos de un total de " + estudiantes.size());
			return;
		}

		int alumnosAprobados = cantidadAlumnosAprobados("Masculino");
		int alumnasAprobadas = cantidadAlumnosAprobados("Femenino");
		System.out.println("Se puede dar clases!");
		System.out.println("Alumnos aprobados: " + alumnosAprobados);
		System.out.println("Alumnas aprobadas: " + alumnasAprobadas);
	}

	public int asistenciaEstudiantes() {
		int cantidad = 0;
		for (Estudiante estudiante : estudiantes) {
			if (estudiante.asisteAClase()) {
				cantidad++;
			}
		}
		return cantidad;
	}

	public int cantidadAlumnosAprobados(String sexo) {
		int cantidad = 0;
		for (Estudiante estudiante : estudiantes) {
			if (estudiante.getCalificacion() >= 5 && estudiante.getSexo().equals(sexo)) {            //si la nota es >=5 y si el sexo es igual al sexo corespondiente en el param. sexo
				cantidad++;
			}
		}
		return cantidad;
	}
}