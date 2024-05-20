package T9Herencia.Ejercicio1;

public class Television extends Electrodomestico {

	private double resolucion;
	private boolean sintonizadorTDT;

	private final static double RESOLUCION_PRED = 20;
	private final static boolean SINTONIZADOR_TDT_PRED = false;

	public Television() {
		super();
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
	    double precioFinal = super.precioFinal(); 
	    precioFinal *= (resolucion > 40) ? 1.3 : 1.0;
	    precioFinal += (sintonizadorTDT) ? 50 : 0;

	    return precioFinal;
	}

}
