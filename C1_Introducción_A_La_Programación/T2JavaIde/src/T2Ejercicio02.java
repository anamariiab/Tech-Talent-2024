
public class T2Ejercicio02App {

	public static void main(String[] args) {

		// Creación de un objeto Integer usando el segundo constructor
		Integer num1 = new Integer("125");

		// Creación de un objeto Integer usando el segundo constructor
		Integer num2 = new Integer(20);

		// Obtención de un objeto que almacena cada objeto integer.
		// Si no se hace esto, las lineas siguientes causarian error
		// de compilación
		int n1 = num1.intValue();
		int n2 = num2.intValue();
		System.out.println("Suma de " + n1 + " y " + n2 + " vale " + (n1 + n2));
		if (n1 + n2 > 130)
			n1++;
		else
			n1--;
		System.out.println(n1);

	}

}
