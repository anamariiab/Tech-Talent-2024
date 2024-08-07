package T9Herencia.Ejercicio1;

public class Electrodomestico {

	protected double precioBase;
	protected String color;
	protected char consumoEnergetico;
	protected double peso;                                         

	protected static final double PRECIO_BASE_PRED = 100;
	protected static final String COLOR_PRED = "blanco";
	protected static final char CONSUMO_PRED = 'F';
	protected static final double PESO_PRED = 5;

	protected static final char[] LETRAS_CONSUMO = { 'A', 'B', 'C', 'D', 'E', 'F' };
	protected static final String[] COLORES = { "blanco", "negro", "rojo", "azul", "gris" };

	public Electrodomestico() {
		this.precioBase = PRECIO_BASE_PRED;
		this.color = COLOR_PRED;
		this.consumoEnergetico = CONSUMO_PRED;
		this.peso = PESO_PRED;
	}

	public Electrodomestico(double precioBase, double peso) {
		this.precioBase = precioBase;
		this.color = COLOR_PRED;
		this.consumoEnergetico = CONSUMO_PRED;
		this.peso = peso;
	}

	public Electrodomestico(double precioBase, String color, char consumoEnergetico, double peso) {
		this.precioBase = precioBase;
		this.color = color;
		this.consumoEnergetico = consumoEnergetico; 
		this.peso = peso; 
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public String getColor() {
		return color;
	}

	public char getConsumoEnergetico() {
		return consumoEnergetico;
	}

	public double getPeso() {
		return peso;
	}

	private boolean comprobarConsumoEnergetico(char letra) {
		for (int i = 0; i < LETRAS_CONSUMO.length; i++) {
			if (letra == LETRAS_CONSUMO[i]) {
				return true;
			}
		}
		return false;
	}

	private boolean comprobarColor(String color) {
		for (int i = 0; i < COLORES.length; i++) {
			if (color.equalsIgnoreCase(COLORES[i])) {
				return true;
			}
		}
		return false;
	}
	
	public double precioFinal() {
	    double precioFinal = precioBase;

	    switch (consumoEnergetico) {
	        case 'A':
	            precioFinal += 100; 
	            break;
	        case 'B':
	            precioFinal += 80; 
	            break;
	        case 'C':
	            precioFinal += 60; 
	            break;
	        case 'D':
	            precioFinal += 50; 
	            break;
	        case 'E':
	            precioFinal += 30; 
	            break;
	        case 'F':
	            precioFinal += 10; 
	            break;
	    }
	   
	    if (peso >= 0 && peso <= 19) {
	        precioFinal += 10; 
	    } else if (peso >= 20 && peso <= 49) {
	        precioFinal += 50; 
	    } else if (peso >= 50 && peso <= 79) {
	        precioFinal += 80; 
	    } else if (peso >= 80) { 
	        precioFinal += 100; 
	    }
	    return precioFinal;
	}

}