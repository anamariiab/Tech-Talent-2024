package T4PruebaApp;

public class T4Ejercicio02App {

	public static void main(String[] args) {
		// Declara una variable N de tipo int, una variable A de tipo double y una
		// variable C de tipo char
		int N;
		double A;
		char C;

		// Asigna a cada una un valor
		N = 1;
		A = 2.5;
		C = 'Y';

		System.out.println("N" + N);
		System.out.println("A" + A);
		System.out.println("C" + C);

		// La suma de N + A
		double suma = N + A;

		System.out.println(suma);

		// La diferencia de A - N
		double resta = A - N;

		System.out.println(resta);

		// El valor numérico correspondiente al carácter que contiene la variable C
		System.out.println("Valor numérico del carácter" + "=" + (int) C);

	}

}