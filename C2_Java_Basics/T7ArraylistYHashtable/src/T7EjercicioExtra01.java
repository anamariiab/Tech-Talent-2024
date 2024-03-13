import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T7EjercicioExtra01 {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Map<String, ArrayList<Integer>> estudiantesUniversidad = new HashMap<>();

		System.out.print("Por favor, introduce el número total de estudiantes: ");
		int numTotalEstudiantes = sc.nextInt();
		
		inputNombre(estudiantesUniversidad, numTotalEstudiantes);
	    mostrarInfoEstudiantes(estudiantesUniversidad);
	}

	public static void inputNombre(Map<String, ArrayList<Integer>> estudiantesUniversidad, int numeroEstudiantes) {

		for (int i = 0; i < numeroEstudiantes; i++) {
			System.out.print("Por favor, introduce el nombre del estudiante " + (i + 1) + ": ");
			String nombreEstudiante = sc.next();

			ArrayList<Integer> notas = obtenerNotas();
			estudiantesUniversidad.put(nombreEstudiante, notas);
		}
	}

	public static ArrayList<Integer> obtenerNotas() {

		ArrayList<Integer> notas = new ArrayList<>();

		boolean continuar = true;
		while (continuar) {
			System.out.print("Por favor, introduce las notas (o '0' para finalizar: ");
			int inputNotas = sc.nextInt();

			if (inputNotas == 0) {
				continuar = false;
			} else {
				notas.add(inputNotas);
			}
		}

		return notas;
	}

	public static void mostrarInfoEstudiantes(Map<String, ArrayList<Integer>> estudiantesUniversidad) {

		for (String nombreEstudiante : estudiantesUniversidad.keySet()) {
			ArrayList<Integer> notas = estudiantesUniversidad.get(nombreEstudiante);

			double promedio = calcularPromedio(notas);

			System.out.println("Estudiante: " + nombreEstudiante);
			System.out.println("Notas: " + notas);
			System.out.println("Promedio: " + promedio);

			if (promedio >= 60) {
				System.out.println("Aprobado!");
			} else {
				System.out.println("Suspendido!");
			}

			System.out.println();

		}

	}

	public static double calcularPromedio(ArrayList<Integer> notas) {
		
		int suma = 0;
        for (int nota : notas) {
            suma += nota;
        }
        return suma / (double) notas.size();
    }
}