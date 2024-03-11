
public class T5EjercicioExtra02TablaMultiplicarNumerosApp {

	public static void main(String[] args) {

		for (int tabla = 1; tabla <= 9; tabla++) {
			System.out.println("Tabla de multiplicar del número " + tabla + ":");
			for (int i = 0; i <= 10; i++) {
				int resultado = tabla * i;
				System.out.println(tabla + " * " + i + " = " + resultado);
			}
			System.out.println();
		}
	}
}