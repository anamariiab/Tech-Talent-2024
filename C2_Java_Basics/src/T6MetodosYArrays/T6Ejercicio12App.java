package T6MetodosYArrays;
import java.util.Scanner;
import java.util.Random;

public class T6Ejercicio12App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Porfavor, introduce el tamaño del array: ");
        int sizeArray = scanner.nextInt();


        int[] numeros = new int[sizeArray];
        Random random = new Random();

        for (int i = 0; i < sizeArray; i++) {
            numeros[i] = random.nextInt(300) + 1;
        }


        System.out.println("Array original:");
        mostrarArray(numeros);


        System.out.print("Porfavor, introduce el dígito a buscar: ");
        int digito = scanner.nextInt();

        
        if (digito < 0 || digito > 9) {
            System.out.println("Porfavor, introduce un dígito válido (0-9).");
            return;
        }

        
        int[] numerosFiltrados = filtrarPorDigito(numeros, digito);


        System.out.println("Números que terminan en " + digito + ":");
        mostrarArray(numerosFiltrados);
    }


    private static void mostrarArray(int[] array) {
        for (int numero : array) {
            System.out.print(numero + " ");
        }
        System.out.println();
    }


    private static int[] filtrarPorDigito(int[] array, int digito) {
        int[] resultado = new int[array.length];
        int contador = 0;

        for (int numero : array) {
            if (numero % 10 == digito) {
                resultado[contador] = numero;
                contador++;
            }
        }


        int[] numerosFiltrados = new int[contador];
        System.arraycopy(resultado, 0, numerosFiltrados, 0, contador);

        return numerosFiltrados;
    }
}