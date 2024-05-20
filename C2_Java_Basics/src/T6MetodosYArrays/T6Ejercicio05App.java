package T6MetodosYArrays;
import java.util.Scanner;

public class T6Ejercicio05App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor, introduce un número: ");

        String num = sc.nextLine();

        int numero = Integer.parseInt(num);
        String resultadoBinario = Binario(numero);
        System.out.println(resultadoBinario);
    }

    public static String Binario(int n1) {

        String result = "";
        int resto = 0;
        do {
            resto = n1 % 2;
            n1 = n1 / 2;
            result = resto + result;
        } while (n1 > 0);
        return result;
    }
}