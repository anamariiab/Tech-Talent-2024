package T9Herencia.Ejercicio1;

public class Lavadora extends Electrodomestico {

	private double carga;

	private final static double CARGA_PRED = 5;

	public Lavadora() {
		super();
		this.carga = CARGA_PRED;
	}

	public Lavadora(double precioBase, double peso) {
		super(precioBase, peso);
		this.carga = CARGA_PRED;
	}

	public Lavadora(double precioBase, String color, char consumoEnergetico, double peso, double carga) {
		super(precioBase, color, consumoEnergetico, peso);
		this.carga = carga;
	}

	public double getCarga() {
		return carga;
	}

	@Override
	public double precioFinal() {
	    double precioFinal = super.precioFinal(); 
	    precioFinal += (carga > 30) ? 50 : 0;

	    return precioFinal;
	}
}
