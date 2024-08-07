package T10JavaExceptions.Ejercicio3;

import java.util.*;

public class NumParImparApp {

	public static void main(String[] args) {
		try {
			Random rand = new Random();
			int numeroAleatorio = rand.nextInt(1000);

			System.out.println("Generando número aleatorio...");
			System.out.println("El número generado es: " + numeroAleatorio);

			if (numeroAleatorio % 2 == 0) {
				throw new ExcepcionPar("Es par!");
			} else {
				throw new ExcepcionImpar("Es impar!");
			}
		} catch (ExcepcionPar e) {
			System.out.println(e.getMessage());
		} catch (ExcepcionImpar e) {
			System.out.println(e.getMessage());
		}
	}
}