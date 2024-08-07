package T6MetodosYArrays;
import java.util.Scanner;

public class T6Ejercicio01App {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); 
		
		System.out.println("Porfavor, indica la figura que quieres calcular  (circulo, triangulo, cuadrado): ");
		String figura = scanner.nextLine();
		
		double area = 0.0;
		
		switch (figura) {
		  case "circulo":
		     area = calcularAreaCirculo();
            break;
		  case "triangulo":
		     area = calcularAreaTriangulo();
             break;
		  case "cuadrado":
		     area = calcularAreaCuadrado();
             break;
		  default:
              System.out.println("Figura no correcta.");
             return;
		}
		System.out.println("El area de la figura es: " + area);
              
		}

	public static double calcularAreaCirculo() {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el radio del círculo: ");
        double radio = scanner.nextDouble();

        return Math.PI * Math.pow(radio, 2);
    }
	
	 public static double calcularAreaTriangulo() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Introduce la base del triángulo: ");
	        double base = scanner.nextDouble();

	        System.out.print("Introduce la altura del triángulo: ");
	        double altura = scanner.nextDouble();

	        return (base * altura) / 2;
	    }
	 
	 public static double calcularAreaCuadrado() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Introduce el lado del cuadrado: ");
	        double lado = scanner.nextDouble();

	        return (lado * lado);
	    }
	}
	
