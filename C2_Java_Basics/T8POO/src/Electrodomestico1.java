public class Electrodomestico1 {

	private double precioBase;
	private Color color;                                                        //el atributo es de tipo Color. See below enumeracion color
	private Consumo consumoEnergetico;                                          //el atributo es de tipo Consumo. See below enumeracion consumo
	private double peso;
	
	private final static double PRECIO_BASE_PRED = 100;
	private final static Color COLOR_PRED = Color.BLANCO;
	private final static Consumo CONSUMO_ENERGETICO_PRED = Consumo.F;
	private final static double PESO_PRED = 5;

	public enum Color {                                                
		BLANCO, NEGRO, ROJO, AZUL, GRIS                                     //enumeracion de constantes colores. solo puede tomar los valores de la enumeracion.  
	}                                                                       //!!la enumeracion es muy util cuando hay que representar un conjunto FIJO de constantes!!
	                                                                        //!!also, el ENUM detecta errores al intentar ingresar un valor que no esta definido en la enumeracion.
	public enum Consumo{                                                    //enumeracion de constantes consumo. solo puede tomar los valores de la enumeracion.
		A, B, C, D, E, F                                                    //!!also, claridad en el codigo, mas legible
	}                                                                
	

	public Electrodomestico1() {

		this.color = COLOR_PRED;
		this.consumoEnergetico = CONSUMO_ENERGETICO_PRED;                           //constr por defecto que inicializa los atributos con los valores pred
		this.precioBase = 100;
		this.peso = 5;
		
	}

	public Electrodomestico1(double precioBase, double peso) {
		
		this.color = COLOR_PRED;                                                 
		this.consumoEnergetico = CONSUMO_ENERGETICO_PRED;
		this.precioBase = precioBase;
		this.peso = peso;

	}

	public Electrodomestico1(double precioBase, double peso, Color color, Consumo consumoEnergetico) {
		
		this.color = color;
		this.consumoEnergetico = consumoEnergetico;                                 //constr con todos los parametros
		this.precioBase = precioBase;
		this.peso = peso;
	}
	
	
	@Override
	public String toString() {                                                      //‘toString’ devuelve una cadena con los detalles del electrodomestico
		return "Precio: " + precioBase + "€" + "\nColor: " + color + "\nConsumo energetico: " + consumoEnergetico + "\nPeso: "
				+ peso;
	}

}