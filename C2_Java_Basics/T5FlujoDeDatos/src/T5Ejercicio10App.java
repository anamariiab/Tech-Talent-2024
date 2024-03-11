import java.util.Scanner;

public class T5Ejercicio10App {

	public static void main(String[] args) {

		// Realiza una aplicación que nos pida un número de ventas a introducir,
		Scanner sc = new Scanner(System.in);

		System.out.println("Porfavor, introduce un número de ventas: ");

		int numeroVENTAS = sc.nextInt();
		double sumaVENTAS = 0;

		for (int i = 1; i <= numeroVENTAS; i++) {

			// Después nos pedirá tantas ventas por teclado como número de ventas se hayan
			// indicado.
			System.out.print("Introduce la venta " + i + ": ");
			double totalVENTAS = sc.nextDouble();

			// Al final mostrara la suma de todas las ventas.
			sumaVENTAS += totalVENTAS;

		}
		System.out.println("La suma total de las ventas es: " + sumaVENTAS);

		sc.close();

	}

}
