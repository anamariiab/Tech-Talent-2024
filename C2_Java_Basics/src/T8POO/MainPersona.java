package T8POO;

public class MainPersona {

	public static void main(String[] args) {

		Persona personaA = new Persona();
		Persona personaB = new Persona("Cristian", 29, "H");
		Persona personaC = new Persona("Victor", 25, "H");
		Persona personaD = new Persona("Maria", 20, "87654321X", "M", 80, 1.80);
		
		    System.out.println("===============================");
		    System.out.println("··Datos de la persona A··");
		    System.out.println(personaA.toString());

		    System.out.println("===============================");
		    System.out.println("··Datos de la persona B··");
		    System.out.println(personaB.toString());

		    System.out.println("===============================");
		    System.out.println("··Datos de la persona C··");
		    System.out.println(personaC.toString());

		    System.out.println("===============================");
		    System.out.println("··Datos de la persona D··");
		    System.out.println(personaD.toString());
		    
		}

}