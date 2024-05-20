package T6MetodosYArrays;

import java.util.Scanner;
public class T6Ejercicio06App {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); 
		
		System.out.println("Por favor, introduce un numero entero positivo válido: ");
		
		int numero = scanner.nextInt();
		int numCifras = cuentaCifras(numero);
		
		     if (numCifras == 1) {
			
	    System.out.println("El numero " + numero + " tiene " + numCifras + " cifra.");
	        } else {
	    System.out.println("El numero " + numero + " tiene " + numCifras + " cifras.");
	}
}

	private static int cuentaCifras (int n1) {
		int contador = 0;
		for (int i = n1; i > 0; i/=10) {
			contador++;
		}
		return contador;
	}
		

	}
