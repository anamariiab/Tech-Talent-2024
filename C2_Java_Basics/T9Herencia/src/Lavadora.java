
public class Lavadora extends Electrodomestico {

	protected double carga;

	protected final static double CARGA_PRED = 5;

	public Lavadora() {
		super();
		this.precioBase = PRECIO_BASE_PRED;
		this.color = COLOR_PRED;
		this.consumoEnergetico = CONSUMO_PRED;
		this.peso = PESO_PRED;
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
		if (carga > 30) {
			precioFinal += 50;
		}
		return precioFinal;
	}
}
