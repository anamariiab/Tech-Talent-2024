public class Electrodomestico {

	private double precioBase;
	private Color color;
	private Consumo consumoEnergetico;
	private double peso;
	
	private final static double PRECIO_BASE_PRED = 100;
	private final static Color COLOR_PRED = Color.BLANCO;
	private final static Consumo CONSUMO_ENERGETICO_PRED = Consumo.F;
	private final static double PESO_PRED = 5;

	public enum Color {
		BLANCO, NEGRO, ROJO, AZUL, GRIS                             //enumeracion de constantes colores          
	}                                                               //!!la enumeracion es muy util cuando hay que representar un conjunto FIJO de constantes!!!
	                                                                //!!also, el ENUM puede detectar errores al intentar ingresar un valor que no esta definido en la enumeracion.
	public enum Consumo{                                            //enumeracion de constantes tipo consumo
		A, B, C, D, E, F
	}
	

	public Electrodomestico() {

		this.color = COLOR_PRED;
		this.consumoEnergetico = CONSUMO_ENERGETICO_PRED;
		this.precioBase = 100;
		this.peso = 5;
		
	}

	public Electrodomestico(double precioBase, double peso) {
		
		this.color = COLOR_PRED;
		this.consumoEnergetico = CONSUMO_ENERGETICO_PRED;
		this.precioBase = precioBase;
		this.peso = peso;

	}

	public Electrodomestico(double precioBase, double peso, Color color, Consumo consumoEnergetico) {
		
		this.color = color;
		this.consumoEnergetico = consumoEnergetico;
		this.precioBase = precioBase;
		this.peso = peso;
	}
	
	
	@Override
	public String toString() {
		return "Precio: " + precioBase + "€" + "\nColor: " + color + "\nConsumo energetico: " + consumoEnergetico + "\nPeso: "
				+ peso;
	}

}