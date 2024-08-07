package T10JavaExceptions.Ejercicio4;

import java.util.*;

import javax.swing.JOptionPane;

public class CalculosApp {

	private static final String NEGRO = "\u001B[30m";
	private static final String ROJO = "\u001B[31m";
	private static final String AZUL_MARINO = "\u001B[34m";

	private static final String NEGRITA = "\u001B[1m";
	private static final String CURSIVA = "\u001B[3m";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int opcion = -1;

		do {
			try {
				System.out.println(NEGRITA + CURSIVA + AZUL_MARINO + "\n¡Bienvenido al Universo Matemágico!");
				System.out.println("¿Qué operación deseas realizar?\n");
				System.out.println(NEGRO + NEGRITA + "1. Suma");
				System.out.println("2. Resta");
				System.out.println("3. Multiplicación");
				System.out.println("4. División");
				System.out.println("5. Potencia");
				System.out.println("6. Raíz Cuadrada");
				System.out.println("7. Raíz Cúbica");
				System.out.println("0. Salir");
				System.out.println(NEGRITA + CURSIVA + AZUL_MARINO + "\nSelecciona una opción:");

				opcion = scanner.nextInt();
				double resultado;

				switch (opcion) {
				case 1:
					double a1 = obtenerNumValido(NEGRO + NEGRITA + "\nIngresa el primer número:", scanner);
					double b1 = obtenerNumValido(NEGRO + NEGRITA + "Ingresa el segundo número:", scanner);
					resultado = Calculos.suma(a1, b1);
					System.out.println("Resultado: " + resultado);
					break;
				case 2:
					double a2 = obtenerNumValido(NEGRO + NEGRITA + "\nIngresa el primer número:", scanner);
					double b2 = obtenerNumValido(NEGRO + NEGRITA + "Ingresa el segundo número:", scanner);
					resultado = Calculos.resta(a2, b2);
					System.out.println(NEGRITA + CURSIVA + AZUL_MARINO + "Resultado: " + resultado);
					break;
				case 3:
					double a3 = obtenerNumValido(NEGRO + NEGRITA + "\nIngresa el primer número:", scanner);
					double b3 = obtenerNumValido(NEGRO + NEGRITA + "Ingresa el segundo número:", scanner);
					resultado = Calculos.multiplicacion(a3, b3);
					System.out.println(NEGRITA + CURSIVA + AZUL_MARINO + "Resultado: " + resultado);
					break;
				case 4:
					double a4 = obtenerNumValido(NEGRO + NEGRITA + "\nIngresa el numerador:", scanner);
					double b4 = obtenerNumValido(NEGRO + NEGRITA + "Ingresa el denominador:", scanner);
					resultado = Calculos.division(a4, b4);
					System.out.println(NEGRITA + CURSIVA + AZUL_MARINO + "Resultado: " + resultado);
					break;
				case 5:
					double base = obtenerNumValido(NEGRO + NEGRITA + "\nIngresa la base:", scanner);
					double exponente = obtenerNumValido(NEGRO + NEGRITA + "Ingresa el exponente:", scanner);
					resultado = Calculos.potencia(base, exponente);
					System.out.println(NEGRITA + CURSIVA + AZUL_MARINO + "Resultado: " + resultado);
					break;
				case 6:
					double a6 = obtenerNumValido(NEGRO + NEGRITA + "\nIngresa el número:", scanner);
					resultado = Calculos.raizCuadrada(a6);
					System.out.println(NEGRITA + CURSIVA + AZUL_MARINO + "Resultado: " + resultado);
					break;
				case 7:
					double a7 = obtenerNumValido(NEGRO + NEGRITA + "\nIngresa el número:", scanner);
					resultado = Calculos.raizCubica(a7);
					System.out.println(NEGRITA + CURSIVA + AZUL_MARINO + "Resultado: " + resultado);
					break;
				case 0:
					System.out.println(AZUL_MARINO + "¡Adiós!");
					break;
				default:
					System.out.println(ROJO
							+ "\n¡Oops! Parece que has seleccionado una opción no válida. Por favor, intenta de nuevo.");
				}
			} catch (ArithmeticException e) {
				System.out.println(ROJO + e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println(ROJO + "¡Por favor, introduce un número válido!");
				scanner.next();
			}
		} while (opcion != 0);

		scanner.close();

	}

	private static double obtenerNumValido(String mensaje, Scanner scanner) {
		System.out.println(mensaje);
		while (!scanner.hasNextDouble()) {
			System.out.println(ROJO + "¡Por favor, introduce un numero válido!");
			scanner.next();
		}
		return scanner.nextDouble();
	}
}