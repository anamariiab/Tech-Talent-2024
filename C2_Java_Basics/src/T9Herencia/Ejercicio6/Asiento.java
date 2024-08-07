package T9Herencia.Ejercicio6;

public class Asiento {
	
	private Espectador espectador;                                                                  //contiene info. sobre el espectador asignado al asiento
	private char columna;
	private int fila;
	
	public Asiento(int fila, char columna) {
		espectador = null;                                                                         //inicializa el atributo espectador como null, lo que indica que inicialmente el asiento está vacío
		this.columna = columna;
		this.fila = fila;
	}
	
	public boolean isOcupado() {                                                                   //verifica si el asiento está ocupado o no. 
		return espectador != null;                                                                 //devuelve ‘true’ si hay un espectador asignado al asiento
	}
	
	public void asignarAsiento(Espectador esp) {                                                   //recibe como param. un objeto de la clase 'Espectador' y lo asigna al atributo 'espectador'
		espectador = esp;
	}

	public char getColumna() {
		return columna;
	}

	public int getFila() {
		return fila;
	}
}