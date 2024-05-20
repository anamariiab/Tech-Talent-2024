package T5FlujoDeDatos;
import java.util.Scanner;

public class T5Ejercicio05App {

	public static void main(String[] args) {
		
		// Lee un número por teclado e indica si es divisible entre 2.
				Scanner sc = new Scanner(System.in);
				
				    System.out.println("Porfavor, introduce un numero entero:");
				
				String introNUM = sc.nextLine();
			
				sc.close();
				
				// Indica si es divisible entre 2 (resto = 0). Si no lo es, también debemos indicarlo.
		        double num = Double.parseDouble(introNUM);
				if (num % 2 == 0) {
		            System.out.println(num + " es divisible por 2.");
		        } else {
		            System.out.println(num + " no es divisible por 2.");
		        }


			}
}
