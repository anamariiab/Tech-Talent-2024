import java.util.Random;

public class Password {

    private char[] contrasenya;                                     //array de caracteres para almacenar cada caracter de la passw
    private int longitud;                                           

    public Password() {
        this.longitud = 8; 
        this.contrasenya = new char[longitud];                           //creacion de nuevo array char asgurando que tiene la long 8
        
        generarConstrasenya();                                           
    }

    public Password(int longitud) {
        this.longitud = longitud;
        this.contrasenya = new char[longitud];
        
        generarConstrasenya();
    }

    private void generarConstrasenya() {
        Random random = new Random();

        for (int i = 0; i < longitud; i++) {
            contrasenya[i] = (char) (random.nextInt(94) + 33);                              //genera caracteres ascii random desde 33 hasta el 126 
        }
    }
	
	@Override
	public String toString() {
		return String.valueOf(contrasenya);
	}
}