package T10JavaExceptions.Ejercicio2;

public class ExcepcionCustomizadaApp {

	public static void main(String[] args) {

		boolean excepcionCapturada = false;

		while (!excepcionCapturada) {
			try {
				System.out.println("Mensaje mostrado por pantalla.");
				throw new ExcepcionCustomizada("Esto es un objeto Excepcion.");
			} catch (ExcepcionCustomizada e) {
				System.out.println("Se capturó la excepción: " + e.getMensaje());
				excepcionCapturada = true;	
			} finally {
				System.out.println("Programa terminado.");
			}
		}
	}
}
