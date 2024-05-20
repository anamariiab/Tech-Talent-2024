package T6MetodosYArrays;
import java.util.Scanner;
public class T6Ejercicio04App {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); 
		
		System.out.println("Porfavor, introduce un numero: ");
		
		int numero = scanner.nextInt();
		int numeroFactorial = resultadoFactorial(numero);
		
		System.out.println("El factorial de " + numero + " es " + numeroFactorial);

	}

	public static int resultadoFactorial(int otroNumero) {
		
		if (otroNumero == 1) {
			return 1;
		} else {
			return otroNumero * resultadoFactorial(otroNumero -1);
		}
	}

}
