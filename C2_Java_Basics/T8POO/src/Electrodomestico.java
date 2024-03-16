
public class Electrodomestico {

	private double precioBase;
	private String color;
	private char consumoEnergetico;
	private double peso;

	public enum Color {
		BLANCO, NEGRO, ROJO, AZUL, GRIS
	}

	public Electrodomestico() {

		this.color = "blanco";
		this.consumoEnergetico = 'F';
		this.precioBase = 100;
		this.peso = 5;
	}

	public Electrodomestico(double precioBase, double peso) {
		
		this.color = "blanco";
		this.consumoEnergetico = 'F';
		this.precioBase = precioBase;
		this.peso = peso;
	}

	public Electrodomestico(double precioBase, double peso, String color, char consumoEnergetico) {
		
		this.color = color;
		this.consumoEnergetico = consumoEnergetico;
		this.precioBase = precioBase;
		this.peso = peso;
	}

	private boolean validarConsumoEnergetico(char consumoEnergetico) {
        return consumoEnergetico >= 'A' && consumoEnergetico <= 'F';
    }
	

	@Override
	public String toString() {
		return "Precio: " + precioBase + "Color: " + color + "Consumo energetico: " + consumoEnergetico + "Peso: "
				+ peso;
	}

}
