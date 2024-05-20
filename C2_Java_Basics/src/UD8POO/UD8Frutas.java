package UD8POO;

public class UD8Frutas {

	// Atributos
	
	String nombre;
	String color;
	double precio;

	// Constructores
	
	public UD8Frutas() {
		
		this.nombre = "  ";
		this.color = "  ";
		this.precio = 0.0;
	}

	public UD8Frutas(String a) {
		
		this.nombre = a;
		this.color = "  ";
		this.precio = 0.0;
	}

	public UD8Frutas(String a, String b) {
		
		this.nombre = a;
		this.color = b;
		this.precio = 0.0;
	}

	public UD8Frutas(String a, double p) {
		
		this.nombre = a;
		this.color = "  ";
		this.precio = p;
	}

	public UD8Frutas(String a, String b, double p) {
		
		this.nombre = a;
		this.color = b;
		this.precio = 0.0;
	}
	

	
	public String getNombre() {       //Geters 
		return nombre;
	}

	public void setNombre(String nombre) {     //Seters
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
	
	// Metodos

	public static void main(String[] args) {
		
		UD8Frutas manzana = new UD8Frutas();
		UD8Frutas platano = new UD8Frutas("Plátano");
		UD8Frutas arandanos = new UD8Frutas("Arandanos", "lila");
		UD8Frutas albaricoque = new UD8Frutas("Albaricoque", "Naranja", 11.15);
		
		
	// Mostrar los valores iniciales despues de la instanciacion

		System.out.println(" Mi primera fruta tiene el nombre: " + manzana.nombre + " y tiene un color igual a "
				+ manzana.color + " y tiene un precio de " + manzana.precio + "€");
		System.out.println("---------------------------------------------------------------------------------------------------------");

		System.out.println(" Mi primera fruta tiene el nombre: " + platano.nombre + " y tiene un color igual a "
				+ platano.color + " y tiene un precio de " + platano.precio + "€");
		System.out.println();

		System.out.println(" Mi primera fruta tiene el nombre: " + arandanos.nombre + " y tiene un color igual a "
				+ arandanos.color + " y tiene un precio de " + arandanos.precio + "€");
		System.out.println();

		System.out.println(" Mi primera fruta tiene el nombre: " + albaricoque.nombre + " y tiene un color igual a "
				+ albaricoque.color + " y tiene un precio de " + albaricoque.precio + "€");
		System.out.println();

	// Reasignar valores

		manzana.nombre = "Manzana";
		manzana.color = "Amarilla";
		manzana.precio = 2.35;
		System.out.println(" Mi primera fruta tiene el nombre: " + manzana.nombre + " y tiene un color igual a "
				+ manzana.color + " tiene un precio de " + manzana.precio + "€");
	}
}