import java.util.Random;

public class Password {
	
	private int longitud;  
    private char[] contrasenya;                                     //atr array de caracteres para almacenar cada caracter de la passw
                                             

    public Password() {
        this.longitud = 8;                                               //inicializa la long
        this.contrasenya = new char[longitud];                           //creacion de nuevo array char asgurando que tiene la long 8
        
        generarConstrasenya();                                           
    }

    public Password(int longitud) {                                       //se pasa como parametro la long que sera proporc por el user
        this.longitud = longitud;
        this.contrasenya = new char[longitud];
        
        generarConstrasenya();
    }

    private void generarConstrasenya() {
        Random random = new Random();

        for (int i = 0; i < longitud; i++) {                                                
            contrasenya[i] = (char) (random.nextInt(94) + 33);                              //en cada iteracion genera un nr aleat dentro del rango ascii desde 33 hasta el 126
                                                                                            //se convierte el num en un caracter y lo asigna en la posicion corespondiente
        }
    }
	
	@Override
	public String toString() {
		return String.valueOf(contrasenya);
	}
}