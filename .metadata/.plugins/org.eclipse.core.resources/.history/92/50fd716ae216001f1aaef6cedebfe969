
public class Persona {
	
    private String nombre;
    private int edad;
    private String DNI;                                                       //atributos
    private String sexo;          
    private double peso;
    private double altura; 
    
    private final static String SEXO_PRED = "H";
    
    public Persona() {
    	
        this.nombre = "  ";
        this.edad = 0;
        this.DNI = "  ";
        this.sexo = SEXO_PRED;                                                // constructor por defecto
        this.peso = 0.0;
        this.altura = 0.0;
    }

    public Persona(String nombre, int edad, String sexo) {
    	
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = "  ";                                                
        this.sexo = sexo;
        this.peso = 0.0;
        this.altura = 0.0;
    }

    public Persona(String nombre, int edad, String DNI, String sexo, double peso, double altura) {
    	
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = DNI;                                                       
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNombre() {
    	
        return nombre;
    }

    public void setNombre(String nombre) {
    	
        this.nombre = nombre;
    }

    public int getEdad() {
    	
        return edad;
    }

    public void setEdad(int edad) {
    	
        this.edad = edad;
    }

    public String getDNI() {
    	
        return DNI;
    }

    public String getSexo() {
    	
        return sexo;
    }

    public void setSexo(String sexo) { 

        this.sexo = sexo;
    }

    public double getPeso() {
    	
        return peso;
    }

    public void setPeso(double peso) {
    	
        this.peso = peso;
    }

    public double getAltura() {
    	
        return altura;
    }

    public void setAltura(double altura) {
    	
        this.altura = altura;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nEdad: " + edad + "\nDNI: " + DNI + "\nSexo: " + sexo + "\nPeso: " + peso + "\nAltura: " + altura;
    }
}
    