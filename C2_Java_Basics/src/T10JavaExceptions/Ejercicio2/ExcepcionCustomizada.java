package T10JavaExceptions.Ejercicio2;

public class ExcepcionCustomizada extends Exception {
	
	private String mensaje;
	
	public ExcepcionCustomizada(String mensaje) {
        super(mensaje);
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}