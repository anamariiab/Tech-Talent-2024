import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T7EjercicioExtra01 {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Map<String, ArrayList<Integer>> estudiantesUniversidad = new HashMap<>();

		System.out.println();
		System.out.print("Por favor, introduce el número total de estudiantes: ");
		int numTotalEstudiantes = sc.nextInt();
		System.out.println("=======================================================\n");
		
		inputNombre(estudiantesUniversidad, numTotalEstudiantes);                                                                      //se llama al met que solicita y almacena info sobre cada estudiante
	    mostrarInfoEstudiantes(estudiantesUniversidad);
	}

	public static void inputNombre(Map<String, ArrayList<Integer>> estudiantesUniversidad, int numeroEstudiantes) {

		for (int i = 0; i < numeroEstudiantes; i++) {
			System.out.print("Por favor, introduce el nombre del estudiante: " + (i + 1) + ": ");
			String nombreEstudiante = sc.next();

			ArrayList<Integer> calificaciones = ingresarCalificaciones();                                                                         //se llama al met para obtener las calificaciones
			estudiantesUniversidad.put(nombreEstudiante, calificaciones);
		}
	}

	public static ArrayList<Integer> ingresarCalificaciones() {

		ArrayList<Integer> calificaciones = new ArrayList<>();

		boolean continuar = true;                                                                                      //var booleana para determinar si el user desea seguir agregando calif o finalizar el input
		while (continuar) {                                                                                            //se inicialia siempre que la boolean sea true
			System.out.print("Por favor, introduce las calificaciones (o '0' para finalizar: ");
			int inputCalificaciones = sc.nextInt();                                                                  //solicitamos calificaciones y las almacenamos en un arraylist
			System.out.println("\n");

			if (inputCalificaciones == 0) {                                                                               //si el valor ingresado es 0 se establece la boolean en false y se finaliza la entrada
				continuar = false;
			} else {
				calificaciones.add(inputCalificaciones);                                                                  
			}
		}

		return calificaciones;
	}

	public static void mostrarInfoEstudiantes(Map<String, ArrayList<Integer>> estudiantesUniversidad) {

		for (String nombreEstudiante : estudiantesUniversidad.keySet()) {
			ArrayList<Integer> calificaciones = estudiantesUniversidad.get(nombreEstudiante);                          //para cada nombre obtiene la lista de calificaciones asociada a ese estudiante

			double promedio = calcularPromedio(calificaciones);                                                        //llamamos al metodo calcularPromedio pasando la lista como argumento y almacena el resultado en la var

			System.out.println("=================================================================\n");
			System.out.println("Estudiante: " + nombreEstudiante);
			System.out.println("Calificaciones: " + calificaciones);                                     
			System.out.println("Promedio: " + promedio);

			if (promedio >= 60) {
				System.out.println("Aprobado!");                                                                            //determina si el estudiante ha aprob o no
			} else {
				System.out.println("Suspendido!");
			}

			System.out.println();

		}

	}

	public static double calcularPromedio(ArrayList<Integer> calificaciones) {
		
		int suma = 0;
        for (int calificacion : calificaciones) {
            suma += calificacion;                                                                                                  //cada calificacion se suma a la var suma
        }
        return suma / (double) calificaciones.size();                                                                              //double para garantizar que el resultado sea nr decimal
    }
}