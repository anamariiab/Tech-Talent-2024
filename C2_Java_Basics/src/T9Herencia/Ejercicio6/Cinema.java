package T9Herencia.Ejercicio6;

public class Cinema {
	
	public static final int FILAS = 8;                                                                   //constante para el num. de filas 
	public static final int COLUMNAS = 9;                                                                //constante para el num. de columnas
	
	protected double precioEntrada;                                                                      
	protected Pelicula peliculaReproduciendo;                                                            //atr. de tipo 'Pelicula'. --> cada instancia de 'Cinema' tiene una relaciion directa con una instancia de 'Pelicula' 
	protected Asiento[][] asientos;                                                                      //matriz de objetos 'Asiento'
	
	
	public Cinema(Pelicula peliculaReproduciendo, double precioEntrada) {
		this.precioEntrada = precioEntrada; 
		this.peliculaReproduciendo = peliculaReproduciendo;
		asientos = new Asiento[FILAS][COLUMNAS];                                                        //se inicializa el atr asiento. cada elemento de la matriz se inicializa como un nuevo objeto ‘Asiento’.
		
		int fila = FILAS;
		for(int i = 0; i < FILAS; i++) {                                                                //recorre las filas de las matriz
			
			//Recorre la fila i
			char letraColumna = 'A';
			for(int j = 0; j < COLUMNAS; j++) {                                                         //recorre las columnas de la matriz
				asientos[i][j] = new Asiento(fila, letraColumna);                                       //se crea un nuevo objeto asiento y se asigna a la pos. correspondiente en la matriz
				letraColumna++;                                                                         //se incrementa en cada iteracion para que no haya dos asientos en la misma fila con la misma columna
			}
			
			fila--;                                                                                     //el decremento de numero de fila para que los asientos se asignen secuencialmente a las filas de arriba a bajo
		}
	}
	
	private Asiento obtenerAsiento(int fila, char columna) {                             
		
		//Recorre la matriz buscando el asiento con la misma fila y columna 
		for(int i = 0; i < FILAS; i++) {
			for(int j = 0; j < COLUMNAS; j++) {
				if(asientos[i][j].getFila() == fila && asientos[i][j].getColumna() == columna) {       //comprueba si la fila del asiento en la posición de la matriz es igual al valor de la var. ‘fila’
					return asientos[i][j];                                                             //y si la columna del asiento en la posicion de la matriz es igual al valor de la var. 'columna'
				}
			}
		}
		return null;
	}
	
	public boolean asignarAsientoLibre(Espectador espectador) {
		//Buscar el primer asiento libre y asignarle el espectador
		for(int i = 0; i < FILAS; i++) {
			for(int j = 0; j < COLUMNAS; j++) {
				if(!asientos[i][j].isOcupado()) {
					asientos[i][j].asignarAsiento(espectador);
					return true;
				}
			}
		}
		return false;  //NO hay asiento libre
	}
	
	public boolean asignarAsiento(int fila, char columna, Espectador espectador) {
		Asiento asiento = obtenerAsiento(fila, columna);
		
		if(asiento == null) {
			//Posición no válida
			return false;
		}
		
		if(espectador.getDinero() < precioEntrada ||
				espectador.getEdad() < peliculaReproduciendo.getEdadMinimaParaAsistir()) {
			return false;
		}
		
		if(asiento.isOcupado()) {
			return asignarAsientoLibre(espectador);
		}
		
		asiento.asignarAsiento(espectador);
		return true;
	}

	public double getPrecioEntrada() {
		return precioEntrada;
	}


	public void setPrecioEntrada(double precioEntrada) {
		this.precioEntrada = precioEntrada;
	}


	public Pelicula getPeliculaReproduciendo() {
		return peliculaReproduciendo;
	}


	public void setPeliculaReproduciendo(Pelicula peliculaReproduciendo) {
		this.peliculaReproduciendo = peliculaReproduciendo;
	}
}
