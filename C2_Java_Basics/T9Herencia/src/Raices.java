
public class Raices {
	
	protected double a;
	protected double b;
	protected double c;
	
	public Raices() {
		this.a = 0.0;
		this.b = 0.0;
		this.c = 0.0;
	}
	
	public Raices(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public double getDiscriminante () {
		return a;
		
		
	}

	public boolean tieneRaices () {
		return getDiscriminante() >= 0;
	}
	
	public boolean tieneRaiz () {
		return getDiscriminante() == 0;	
	}
	
	public void calcular () {
		
		
	}
	
	public void obtenerRaices() {
	
	}
	
	public void obtenerRaiz() {
		
	}
	
	
}
