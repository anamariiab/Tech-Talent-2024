package T5FlujoDeDatos;
import java.util.Scanner;

public class T5Ejercicio06App {

	public static void main(String[] args) {
		
		// Lee un número por teclado que pida el precio de un producto (puede tener decimales)
		Scanner sc = new Scanner(System.in);
		
		    System.out.println("Añade el precio del producto: ");
		
		String initialPROD = sc.nextLine();
		
		sc.close();
		
		// Calcula el precio final con IVA 21%
		double prod = Double.parseDouble(initialPROD);
		final double IVA = 0.21;
		double preciofinal = prod*(1+IVA);
		
		    System.out.println ("El precio final con IVA es: "+ preciofinal);
		

	}

}
