package T6MetodosYArrays;
import java.util.Scanner;

public class T6Ejercicio10App {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
        System.out.println("Introduce un tamaño de array: ");
        int size = scanner.nextInt();
        int array10[] = new int[size];

        
        int rangoFinal, rangoInicial;
        System.out.println("Dame el rango inicial: ");
        rangoInicial = scanner.nextInt();
        System.out.println("Dame el rango final: ");
        rangoFinal = scanner.nextInt();

        
        for (int i = 0; i < array10.length; i++) {
            int random = generarNumeroAleatorio(rangoInicial, rangoFinal);
            while (!esPrimo(random)) {
                random = generarNumeroAleatorio(rangoInicial, rangoFinal);
            }
            array10[i] = random;
        }

        
        System.out.print("{");
        for (int i = 0; i < array10.length; i++) {
            System.out.print(array10[i]);
            if (i < array10.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("}");

        
        System.out.println("El número mayor en el array es: " + mayor(array10));
    }

    
    public static boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    
    public static int generarNumeroAleatorio(int minimo, int maximo) {
        return (int) ((Math.random() * (maximo - minimo + 1)) + minimo);
    }

    
    public static int mayor(int array[]) {
        int numeroMayor = 0;
        for (int j : array) {
            if (j > numeroMayor) {
                numeroMayor = j;
            }
        }
        return numeroMayor;
    }
}