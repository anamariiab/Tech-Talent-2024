package T10JavaExceptions.Ejercicio5;

import java.util.*;

class Password {

	private int longitud;
	private String contrasenya;

	public Password() {
		this.longitud = 8;
		generarContrasenya();
	}

	public Password(int longitud) throws IllegalArgumentException {
		if (longitud <= 0) {
			throw new IllegalArgumentException("La longitud debe ser mayor que cero.");
		}
		this.longitud = longitud;
		generarContrasenya();
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) throws IllegalArgumentException {
		if (longitud <= 0) {
			throw new IllegalArgumentException("La longitud debe ser mayor que cero.");
		}
		this.longitud = longitud;
		generarContrasenya();
	}

	public void generarContrasenya() {
		Random r = new Random();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < longitud; i++) {
			int tipo = r.nextInt(3);
			char caracter;
			if (tipo == 0) {
				caracter = (char) (r.nextInt(26) + 'a');
			} else if (tipo == 1) {
				caracter = (char) (r.nextInt(26) + 'A');
			} else {
				caracter = (char) (r.nextInt(10) + '0');
			}
			sb.append(caracter);
		}
		contrasenya = sb.toString();
	}

	public boolean esFuerte() {
		int mayusculas = 0;
		int minusculas = 0;
		int numeros = 0;

		for (int i = 0; i < contrasenya.length(); i++) {
			char c = contrasenya.charAt(i);
			if (Character.isUpperCase(c)) {
				mayusculas++;
			} else if (Character.isLowerCase(c)) {
				minusculas++;
			} else if (Character.isDigit(c)) {
				numeros++;
			}
		}
		return mayusculas > 2 && minusculas > 1 && numeros > 5;
	}
}