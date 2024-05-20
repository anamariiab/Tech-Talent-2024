package T10JavaExceptions.Ejercicio5;

import java.util.*;

public class PasswordApp {

	private static final String COLOR_R = "\u001B[0m";
	private static final String LILA_B_S = "\u001B[1;4;35m";
	private static final String AMARILLO = "\u001B[33m";
	private static final String GRIS = "\u001B[90m";
	private static final String ROJO = "\u001B[31m";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tamany = obtenerCantidad(sc);

		Password[] contrasenyas = generarContrasenyas(sc, tamany);

		mostrarContrasenyas(contrasenyas);

		sc.close();
	}

	private static int obtenerCantidad(Scanner sc) {
		int numContrasenyas = 0;

		while (numContrasenyas <= 0) {
			try {
				System.out.println(LILA_B_S + "\n¡Bienvenido al Generador de Contraseñas!" + COLOR_R);
				System.out.print(AMARILLO + "¿Cuántas contraseñas deseas generar?\n" + COLOR_R);
				numContrasenyas = sc.nextInt();

				if (numContrasenyas <= 0) {
					System.out.println(ROJO + "Por favor, introduce un número mayor que cero.");
				}
			} catch (InputMismatchException e) {
				System.out.println(ROJO + "¡Por favor, introduce un valor numérico válido!");
				sc.next();
			}
		}

		return numContrasenyas;
	}

	private static Password[] generarContrasenyas(Scanner sc, int tamany) {
		Password[] contraseñas = new Password[tamany];
		for (int i = 0; i < tamany; i++) {
			int longitud = obtenerLongitud(sc, i);
			contraseñas[i] = new Password(longitud);
		}
		return contraseñas;
	}

	private static int obtenerLongitud(Scanner sc, int indice) {
		int longitud = 0;
		while (longitud <= 0) {
			try {
				System.out.print(GRIS + "Introduce la longitud de la contraseña " + (indice + 1) + ": ");
				longitud = sc.nextInt();

				if (longitud <= 0) {
					System.out.println(ROJO + "Por favor, introduce un número mayor que cero.");
				}
			} catch (InputMismatchException e) {
				System.out.println(ROJO + "¡Por favor, introduce un valor numérico válido!");
				sc.next();
			}
		}
		return longitud;
	}

	private static void mostrarContrasenyas(Password[] contrasenyas) {
		boolean[] esFuerteArray = new boolean[contrasenyas.length];

		for (int i = 0; i < contrasenyas.length; i++) {
			esFuerteArray[i] = contrasenyas[i].esFuerte();
		}
		int maxWidth = 15;
		for (Password contrasenya : contrasenyas) {
			int length = contrasenya.getContrasenya().length();
			if (length > maxWidth) {
				maxWidth = length;
			}
		}
		System.out.printf(LILA_B_S + "\n| %-" + (maxWidth + 4) + "s| %-13s|%n", "Contraseña", "¿Es Fuerte?");

		for (int i = 0; i < contrasenyas.length; i++) {
			String contrasenya = contrasenyas[i].getContrasenya();
			String esFuerte = esFuerteArray[i] ? "Sí" : "No";
			System.out.printf(AMARILLO + "| %-" + (maxWidth + 4) + "s| %-13s|%n", contrasenya, esFuerte);
		}
	}
}
