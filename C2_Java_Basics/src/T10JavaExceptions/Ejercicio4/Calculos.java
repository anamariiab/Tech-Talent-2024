package T10JavaExceptions.Ejercicio4;

public class Calculos {

	public static double suma(double a, double b) {
		return a + b;
	}

	public static double resta(double a, double b) {
		return a - b;
	}

	public static double multiplicacion(double a, double b) {
		return a * b;
	}

	public static double potencia(double base, double exponente) {
		return Math.pow(base, exponente);
	}

	public static double raizCuadrada(double a) throws ArithmeticException {
		if (a < 0) {
			throw new ArithmeticException("¡No se puede calcular la raíz cuadrada de un número negativo!");
		}
		return Math.sqrt(a);
	}

	public static double raizCubica(double a) throws ArithmeticException {
		return Math.cbrt(a);
	}

	public static double division(double a, double b) throws ArithmeticException {
		if (b == 0) {
			throw new ArithmeticException("¡No se puede dividir por cero!");
		}
		return a / b;
	}
}
