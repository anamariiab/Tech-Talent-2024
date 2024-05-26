package T22MVC.Ejercicio2.Models;

public class ModelAsignacion {

	private String cientificoDNI;
	private String proyectoID;

	public ModelAsignacion(String cientificoDNI, String proyectoID) {
        this.cientificoDNI = cientificoDNI;
        this.proyectoID = proyectoID;
    }

    public String getCientificoDNI() {
        return cientificoDNI;
    }

    public void setCientificoDNI(String cientificoDNI) {
        this.cientificoDNI = cientificoDNI;
    }

    public String getProyectoID() {
        return proyectoID;
    }

    public void setProyectoID(String proyectoID) {
        this.proyectoID = proyectoID;
    }
}
