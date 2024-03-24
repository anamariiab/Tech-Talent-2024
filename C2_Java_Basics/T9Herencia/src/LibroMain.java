import java.util.Scanner;

public class LibroMain {

	public static void main(String[] args) {

		Libro libroA = new Libro("9783161484100", "El Señor de los Anillos", "J.R.R. Tolkien", 1000);
		Libro libroB = new Libro("9781408855690", "Harry Potter y la Piedra Filosofal", "J.K. Rowling", 300);
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("··Primer libro··");
	    System.out.println(libroA.toString());
	    
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("··Segundo libro··");
	    System.out.println(libroB.toString());
	    
	                                                                                                  //!!remember: el operador ternario es como 'if-else'!! si la primera condicion no se cumple, pasa a la siguiente.
	    String libroConMasPaginas = (libroA.getNumPag() > libroB.getNumPag()) ? libroA.getTitulo() :  //!!si el numPag del libro A es mayor que el numPag del libro B --> libro A se le asigna a la var. libroConMasPaginas
	                                (libroA.getNumPag() < libroB.getNumPag()) ? libroB.getTitulo() :  //!!si el numPag del libro B es mayor que el numPag del libro A --> libro B se le asigna a la var. libroConMasPaginas
	                             	"Los dos libros tienen el mismo número de página!";  
	    
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");   
	    System.out.println("··El libro con más páginas··");                                	
	    System.out.println(libroConMasPaginas);
	}
	 

}