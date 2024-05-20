package T6MetodosYArrays;
import java.util.Scanner;
public class T6EjercicioExtra02PromedioNotasApp {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in); 

        System.out.print("Porfavor,introduce el número de estudiantes: ");
        int numEstudiantes = sc.nextInt();

    
        double[] notas = ingresarNotas(numEstudiantes);

        double promedio = calcularPromedio(notas);

        mostrarResultado(promedio);
        
    }

    private static double[] ingresarNotas(int numEstudiantes) {
    	
    	Scanner sc = new Scanner(System.in); 
    	
        double[] notas = new double[numEstudiantes];

        for (int i = 0; i < numEstudiantes; i++) {
            System.out.print("Porfavor, introduce la nota del estudiante numero: " + (i + 1) + ": ");
            notas[i] = sc.nextDouble();
        }

        return notas;
    }

    private static double calcularPromedio(double[] notas) {
        double sumaNotas = 0;

        for (double nota : notas) {
            sumaNotas += nota;
        }

        return sumaNotas / notas.length;
    }

    private static void mostrarResultado(double promedio) {
        System.out.println("El promedio de las notas es: " + promedio);
    }

}