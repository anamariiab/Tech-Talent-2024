package T22MVC.Ejercicio2.Models;

public class ModelAsignacion {

	private String cientifico;
	private String proyecto;

	public ModelAsignacion(String cientifico, String proyecto) {
		this.cientifico = cientifico;
		this.proyecto = proyecto;
	}

	public String getCientifico() {
		return cientifico;
	}

	public void setCientifico(String cientifico) {
		this.cientifico = cientifico;
	}

	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

}
