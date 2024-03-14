
public class Persona {
	
    private String nombre;
    private int edad;
    private String DNI;                                                       //atributos
    private String sexo;
    private double peso;
    private double altura;

    public Persona() {
    	
        this.nombre = "  ";
        this.edad = 0;
        this.DNI = "  ";
        this.sexo = " ";                                                // constructor por defecto
        this.peso = 0.0;
        this.altura = 0.0;
    }

    public Persona(String nombre, int edad, String hombre) {
    	
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = "  ";                                                
        this.sexo = hombre;
        this.peso = 0.0;
        this.altura = 0.0;
    }

    public Persona(String nombre, int edad, String DNI, String hombre, double peso, double altura) {
    	
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = DNI;                                                       
        this.sexo = hombre;
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
    
    
    
    public static void main(String[] args) {
    	
    	Persona personaA = new Persona("Cristian", 29, "H");
        Persona personaB = new Persona("Victor", 20, "H");
        Persona personaC = new Persona("Daniel", 20, "87654321Y", "H", 80, 1.80);

        System.out.println("===============================");
        System.out.println("Datos de la persona A:");
        System.out.println("Nombre: " + personaA.getNombre()); 
        System.out.println("Edad: " + personaA.getEdad()); 
        System.out.println("Sexo: " + personaA.getSexo());

        System.out.println("===============================");
        System.out.println("Datos de la persona B:");
        System.out.println("Nombre: " + personaB.getNombre()); 
        System.out.println("Edad: " + personaB.getEdad()); 
        System.out.println("Sexo: " + personaB.getSexo());
        
        System.out.println("===============================");
        System.out.println("Datos de la persona C:");
        System.out.println("Nombre: " + personaC.getNombre()); 
        System.out.println("Edad: " + personaC.getEdad()); 
        System.out.println("DNI: " + personaC.getDNI());
        System.out.println("Sexo: " + personaC.getSexo());
        System.out.println("Peso: " + personaC.getPeso());
        System.out.println("Altura: " + personaC.getAltura());
    }
    
}