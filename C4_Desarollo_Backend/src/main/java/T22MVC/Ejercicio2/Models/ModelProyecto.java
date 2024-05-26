package T22MVC.Ejercicio2.Models;

public class ModelProyecto {
	
	private String ID;
    private String nombre;
    private int horas;
	
    public ModelProyecto(String ID, String nombre, int horas) {
        this.ID = ID;
        this.nombre = nombre;
        this.horas = horas;
    }
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

}
