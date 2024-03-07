
public class T4Ejercicio05App {

	public static void main(String[] args) {
		// Declarar cuatro variables enteras A, B, C y D

		int A;
		int B;
		int C;
		int D;

		// Asignale un valor a cada una

		A = 2;
		System.out.println(A);

		B = 4;
		System.out.println(B);

		C = 6;
		System.out.println(C);

		D = 8;
		System.out.println(D);

		// B tome el valor de C
		B = C;
		System.out.println(B);

		// C tome el valor de A
		C = A;
		System.out.println(C);

		// A tome el valor de D
		A = D;
		System.out.println(A);

		// D tome el valor de B
		D = B;
		System.out.println(D);

	}

}