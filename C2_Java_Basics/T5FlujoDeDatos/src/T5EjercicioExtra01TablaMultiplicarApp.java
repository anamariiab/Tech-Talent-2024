
public class T5EjercicioExtra01TablaMultiplicarApp {

	public static void main(String[] args) {

		int numero = 5;
		System.out.println("Tabla de multiplicar del numero" + numero + ":");

		for (int i = 0; i <= 10; i++) {
			int resultado = numero * i;
			System.out.println(numero + " * " + i + " = " + resultado);
		}
	}
}