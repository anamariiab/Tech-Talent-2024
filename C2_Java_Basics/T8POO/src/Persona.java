
public class Persona {

	private String nombre;
	private int edad;
//	private final String DNI;                              //atributos
//	private char sexo;
	private int peso;
	private double altura;


	public Persona() {
		
        this.nombre = " ";
        this.edad = 0;                               //constructor por defecto
 //     this.DNI = "";
 //     this.sexo = "";
        this.peso = 0;
        this.altura = 0;
    }
	
	
	public Persona(String nombre, int edad, char sexo) {
		
        this.nombre = nombre;
        this.edad = edad;
  //    this.DNI = generaDNI();                            //constructor sin pasar dni, peso y altura
 //     this.sexo = sexo;
        this.peso = 0;
        this.altura = 0;
    }
	
	
	public Persona(String nombre, int edad, String DNI, char sexo, double peso, double altura) {
		
        this.nombre = nombre;
        this.edad = edad;
  //    this.DNI = generaDNI();                            //constructor con todos los atributos 
 //     this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }
	
	
	public String getNombre() {
        return nombre;
    }
    
    public int getEdad() {
        return edad;
    }
    
 // public String getDNI() {
//  return DNI;
//  }
    
//  public char getSexo() {
//  return sexo;
//  }
    
    public double getPeso() {
        return peso;
    }
    
    public double getAltura() {
        return altura;
    }
    
}