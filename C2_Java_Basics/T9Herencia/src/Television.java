
public class Television extends Electrodomestico {

	public double resolucion;
	public boolean sintonizadorTDT;

	public final static double RESOLUCION_PRED = 20;
	protected final static boolean SINTONIZADOR_TDT_PRED = false;

	public Television() {
		super();
		this.precioBase = PRECIO_BASE_PRED;
		this.color = COLOR_PRED;
		this.consumoEnergetico = CONSUMO_PRED;
		this.peso = PESO_PRED;
		this.resolucion = RESOLUCION_PRED;
		this.sintonizadorTDT = SINTONIZADOR_TDT_PRED;
	}

	public Television(double precioBase, double peso) {
		super(precioBase, peso);
		this.resolucion = RESOLUCION_PRED;
		this.sintonizadorTDT = SINTONIZADOR_TDT_PRED;
	}
	
	public Television(double precioBase, String color, char consumoEnergetico, double peso, double carga, double resolucion, boolean sintonizadorTDT) {
		super(precioBase, color, consumoEnergetico, peso);
		this.resolucion = resolucion;
		this.sintonizadorTDT = sintonizadorTDT;
	}

	@Override
	public double precioFinal() {
		double precioFinal = super.precioFinal();                              //llamamos al precioFinal de la clase padre
		if (resolucion > 40) {
			precioFinal *= 1.3;
		}
		if (sintonizadorTDT) {
			precioFinal += 50;
		}
		return precioFinal;
	}

}
