import java.util.Random;

public class Password {

	private String contrasenya;
	private int longitud;
	
	
	public Password() {
		
		this.contrasenya = generarConstrasenya(longitud);
		this.longitud = 8;
	}

	public Password(int longitud) {
		
		this.contrasenya = generarConstrasenya(longitud);
		this.longitud = longitud;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	
	private String generarConstrasenya(int longitud) {
		
		Random random = new Random();
		StringBuilder constrasenyaGenerada = new StringBuilder();

		for (int i = 0; i < longitud; i++) {
			int num = random.nextInt(9);
			constrasenyaGenerada.append(num);
		}

		return constrasenyaGenerada.toString();
	}
}