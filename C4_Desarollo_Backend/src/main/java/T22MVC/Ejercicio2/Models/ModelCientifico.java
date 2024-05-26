package T22MVC.Ejercicio2.Models;

public class ModelCientifico {
	
	private String DNI;
    private String nomApels;
    
    public ModelCientifico(String DNI, String nom_apels) {
        this.DNI = DNI;
        this.nomApels = nom_apels;
    }
    
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNom_apels() {
        return nomApels;
    }

    public void setNom_apels(String nom_apels) {
        this.nomApels = nomApels;
    }
}
