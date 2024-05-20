package T9Herencia.Ejercicio4;

import java.util.*;

public class MainRaices {

	public static final String AZUL = "\033[1;34m";
	public static final String NEGRO = "\033[1;30m";

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println(AZUL + "/////////////////////////////////////////////////////////////");
		System.out.println(NEGRO + "|                  Ecuación de segundo grado                |");
		System.out.println(AZUL + "/////////////////////////////////////////////////////////////");
		System.out.print(NEGRO + "\nIntroduce el coeficiente 'a': ");
		double a = sc.nextDouble();

		System.out.print(NEGRO +"Introduce el coeficiente 'b': ");
		double b = sc.nextDouble();

		System.out.print(NEGRO + "Introduce el coeficiente 'c': ");
		double c = sc.nextDouble();

		Raices ecuacion = new Raices(a, b, c);

		System.out.println(AZUL + "\nCalculando soluciones...");
		ecuacion.calcular();

		System.out.println(NEGRO + "\nEl discriminante de la ecuación es: " + ecuacion.getDiscriminante());
		                                                                                              // !!remember: el operador ternario es como 'if-else'!!
		System.out.println(AZUL + "¿Tiene raíces? " + (ecuacion.tieneRaices() ? "✓ Sí" : "✗ No"));    // !!si la condicion 'ecuacion.tieneRaices()' es verdadera devuelve  'Si', si es falsa devuelve 'No'
		 
		
		
	 
		System.out.println(AZUL + "¿Tiene raíz única? " + (ecuacion.tieneRaiz() ? "✓ Sí" : "✗ No"));  // !!si la condicion 'ecuacion.tieneRaiz()' es verdadera devuelve 'Si', si es falsa  devuelve 'No'
																						
	}
}
