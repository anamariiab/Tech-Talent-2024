package T5FlujoDeDatos;
import javax.swing.JOptionPane;

public class T5Ejercicio13CalculadoraInversaApp {

	public static void main(String[] args) {

		int A = Integer.parseInt(JOptionPane.showInputDialog("Porfavor, introduce el primer numero entero:"));
		int B = Integer.parseInt(JOptionPane.showInputDialog("Porfavor, introduce el segundo numero entero:"));
		String signoAritmetico = JOptionPane.showInputDialog(
				"Porfavor, introduce uno de los siguientes signos aritmeticos " + "(+, -, *, /, ^, %)");
		double resultado = 0;
		switch (signoAritmetico) {
		case "+":
			resultado = A + B;

			break;
		case "-":
			resultado = A - B;

			break;
		case "*":
			resultado = A * B;
			break;
		case "/":
			if (B == 0) {
				JOptionPane.showMessageDialog(null, "Error: No se puede dividir por cero.");
			} else
				resultado = A / B;
			break;
		default:
			JOptionPane.showMessageDialog(null, "Error: Operador no válido.");

			System.out.println(resultado);

		}

	}

}