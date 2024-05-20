package T6MetodosYArrays;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class T6Ejercicio11App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

   
        System.out.print("Ingrese la dimensión de los arrays: ");
        int dimension = scanner.nextInt();


        int[] array1 = new int[dimension];
        llenarArrayConAleatorios(array1);


        int[] array2 = Arrays.copyOf(array1, array1.length);


        llenarArrayConAleatorios(array2);


        int[] resultado = multiplicarArrays(array1, array2);


        System.out.println("Contenido del primer array:");
        mostrarArray(array1);

        System.out.println("\nContenido del segundo array:");
        mostrarArray(array2);

        System.out.println("\nResultado de la multiplicación de arrays:");
        mostrarArray(resultado);
    }


    private static void llenarArrayConAleatorios(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(200); 
        }
    }

    
    private static int[] multiplicarArrays(int[] array1, int[] array2) {
        int[] resultado = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            resultado[i] = array1[i] * array2[i];
        }
        return resultado;
    }

    
    private static void mostrarArray(int[] array) {
        for (int valor : array) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }
}