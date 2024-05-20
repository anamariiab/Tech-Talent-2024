package UD9Herencia;

public class Circulo implements Figura {

	private double radio;
	private String color;

	public Circulo(double radio, String color) {
		this.radio = radio;
		this.color = color;
	}

	// Getters y Setters
	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// Implementación del método area para calcular el área de un círculo
	@Override
    public double area() {
        return Math.PI * radio * radio;
    }

	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return 0;
	}
}