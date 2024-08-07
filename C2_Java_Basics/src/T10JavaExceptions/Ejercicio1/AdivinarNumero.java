package T10JavaExceptions.Ejercicio1;

import java.util.*;

public class AdivinarNumero {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int numeroSecreto = (int) (Math.random() * 500) + 1;
		int intentos = 0;
		boolean adivinado = false;

		while (!adivinado) {
			System.out.print("Introduce un número entre 1 y 500: ");
			try {
				int intento = sc.nextInt();

				if (intento >= 1 && intento <= 500) {
					intentos++;

					if (intento == numeroSecreto) {
						adivinado = true;
						System.out.println("¡Enhorabuena! Has adivinado el número " + numeroSecreto + " en " + intentos
								+ " intentos.");
					} else if (intento < numeroSecreto) {
						System.out.println("El número secreto es mayor.");
					} else {
						System.out.println("El número secreto es menor.");
					}
				} else {
					System.out.println("¡Debes introducir un número entre 1 y 500!");
				}

			} catch (InputMismatchException e) {
				System.out.println("¡Error: El carácter que has introducido no es un número!");
				sc.next();
			}
		}
		sc.close();
	}
}
