package T22MVC.Ejercicio2.Models;

public class ModelCientificos {
	
	private String dni;
    private String nomApels;

    public ModelCientificos(String dni, String nomApels) {
        this.dni = dni;
        this.nomApels = nomApels;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNomApels() {
        return nomApels;
    }

    public void setNomApels(String nomApels) {
        this.nomApels = nomApels;
    }

}
