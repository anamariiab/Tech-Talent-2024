package T8POO;

public class Electrodomestico1 {

	private double precioBase;
	private ColorEnum color;                                                        //el atributo es de tipo Color. See below enumeracion color
	private ConsumoEnum consumoEnergetico;                                          //el atributo es de tipo Consumo. See below enumeracion consumo
	private double peso;
	
	private final static double PRECIO_BASE_PRED = 100;
	private final static ColorEnum COLOR_PRED = ColorEnum.BLANCO;
	private final static ConsumoEnum CONSUMO_ENERGETICO_PRED = ConsumoEnum.F;
	private final static double PESO_PRED = 5;

	public enum ColorEnum {                                                
		BLANCO, NEGRO, ROJO, AZUL, GRIS                                     //enumeracion de constantes colores. solo puede tomar los valores de la enumeracion.  
	}                                                                       //!!la enumeracion es muy util cuando hay que representar un conjunto FIJO de constantes!!
	                                                                        //!!also, el ENUM detecta errores al intentar ingresar un valor que no esta definido en la enumeracion.
	public enum ConsumoEnum{                                                //enumeracion de constantes consumo. solo puede tomar los valores de la enumeracion.
		A, B, C, D, E, F                                                    //!!also, claridad en el codigo, mas legible
	}                                                                
	

	public Electrodomestico1() {

		this.color = COLOR_PRED;
		this.consumoEnergetico = CONSUMO_ENERGETICO_PRED;                           //constr por defecto que inicializa los atributos con los valores pred
		this.precioBase = PRECIO_BASE_PRED;
		this.peso = PESO_PRED;
		
	}

	public Electrodomestico1(double precioBase, double peso) {
		
		this.color = COLOR_PRED;                                                 
		this.consumoEnergetico = CONSUMO_ENERGETICO_PRED;
		this.precioBase = precioBase;
		this.peso = peso;

	}

	public Electrodomestico1(double precioBase, double peso, ColorEnum color, ConsumoEnum consumoEnergetico) {
		
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