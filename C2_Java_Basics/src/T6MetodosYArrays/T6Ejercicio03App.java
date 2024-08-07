package T6MetodosYArrays;
import java.util.Scanner;
public class T6Ejercicio03App {

	public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, introduce un número: ");

        int numero = scanner.nextInt();
        boolean esPrimo = esNumeroPrimo(numero);

        if (esPrimo) {
            System.out.println(numero + " es un número primo.");
        } else {
            System.out.println(numero + " no es un número primo.");
        }
    }

    public static boolean esNumeroPrimo(int numero) {

        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}
