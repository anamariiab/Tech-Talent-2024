import java.util.Scanner;

public class T5Ejercicio12App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Escribe una aplicación con un String que contenga una contraseña cualquiera, con 3 intentos.
		
		String contraseñaCuenta = "Alohomora";
		int nrmaximoIntentos = 3;
		
		for (int intento = 1; intento <= nrmaximoIntentos; intento++) {
	            System.out.print("Introduce la contraseña: ");
	            String contraseñaIngresada = sc.nextLine();
	            
	     if (contraseñaIngresada.equals(contraseñaCuenta)) {
	                System.out.println("Enhorabuena, ya puedes acceder tu cuenta.");
	                break;
	            } else {
	                System.out.println("Contraseña incorrecta.");
	            }

	            // Mostrar mensaje si se agotaron los intentos
	            if (intento == nrmaximoIntentos) {
	                System.out.println("Has alcanzado el numero maximo de intentos.");
	            }
	        }
	        sc.close();
	            
		}
}
