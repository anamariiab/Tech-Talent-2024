
public class Coche {

	private String marca;
	private String modelo;
	private int anyFabricacion;
	private String color;

	public Coche() {

		this.marca = "  ";
		this.modelo = "  ";
		this.anyFabricacion = 0;
		this.color = " ";

	}
	
	public Coche(String marca, String modelo) {

		this.marca = marca;
		this.modelo = modelo;
		this.anyFabricacion = 0;
		this.color = " ";

	}
	
	public Coche(String marca, String modelo, int anyFabricacion) {

		this.marca = marca;
		this.modelo = modelo;
		this.anyFabricacion = anyFabricacion;
		this.color = " ";

	}
	
	public Coche(String marca, String modelo, int anyFabricacion, String color) {

		this.marca = marca;
		this.modelo = modelo;
		this.anyFabricacion = anyFabricacion;
		this.color = color;

	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnyFabricacion() {
		return anyFabricacion;
	}

	public void setAnyFabricacion(int anyFabricacion) {
		this.anyFabricacion = anyFabricacion;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
    public String toString() {
        return "Marca: " + marca + "\nModelo: " + modelo + "\nAño de fabricación: " + anyFabricacion + "\nColor: " + color;
	}

}
