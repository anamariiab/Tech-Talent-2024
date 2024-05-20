package T7ArraylistYHashtable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T7Ejercicio01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

        Map<String, Double[]> notasAlumnos = new HashMap<>();

        System.out.print("Por favor, introduce el número total de alumnos: ");
        int numTotalAlumnos = sc.nextInt();

        inputNombreNotas(notasAlumnos, numTotalAlumnos);
        mostrarNotasMedias(notasAlumnos);

        sc.close();
    }

	public static void inputNombreNotas(Map<String, Double[]> notasAlumnos, int cantidadAlumnos) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.print("Porfavor, introduce el nombre del alumno " + (i + 1) + ": ");       
            String nombreAlumno = sc.next();

            Double[] notas = new Double[2];             

            System.out.print("Porfavor, introduce la primera nota del alumno " + (i + 1) + ": ");
            notas[0] = sc.nextDouble();

            System.out.print("Porfavor, introduce la segunda nota del alumno " + (i + 1) + ": ");
            notas[1] = sc.nextDouble();

            notasAlumnos.put(nombreAlumno, notas);                    
        }
    }

    public static void mostrarNotasMedias(Map<String, Double[]> notasAlumnos) {
        System.out.println("\nNotas medias de los alumnos:");

        for (String nombreAlumno : notasAlumnos.keySet()) {               
            Double[] notas = notasAlumnos.get(nombreAlumno);

            double notaMedia = calcularNotaMedia(notas);                     
            System.out.println(nombreAlumno + ": " + notaMedia);                  
        }
    }

    public static double calcularNotaMedia(Double[] notas) {
        return (notas[0] + notas[1]) / 2.0;                            
    }
}

