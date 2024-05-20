package T9Herencia.Ejercicio3;

public class MainLibro {

	public static void main(String[] args) {

		Libro libroA = new Libro("9783161484100", "El Señor de los Anillos", "J.R.R. Tolkien", 1000);
		Libro libroB = new Libro("9781408855690", "Harry Potter y la Piedra Filosofal", "J.K. Rowling", 300);

		System.out.println(Libro.LILA + "··Primer libro··");
		System.out.println(libroA.toStringConColor());

		System.out.println("\n" + Libro.LILA + "··Segundo libro··");
		System.out.println(libroB.toStringConColor());
		                                                                                               //!!remember: el operador ternario es similar a 'if-else'!! 
		String libroConMasPaginas = (libroA.getNumPag() > libroB.getNumPag()) ? libroA.getTitulo() :   //!!si el numPag del libro A es mayor que el numPag del libro B --> libro A se le asigna a la var. libroConMasPaginas
				                    (libroA.getNumPag() < libroB.getNumPag()) ? libroB.getTitulo() :   //!!si el numPag del libro B es mayor que el numPag del libro A --> libro B se le asigna a la var. libroConMasPaginas
						            "Ambos libros tienen el mismo número de páginas.";

		System.out.println("\n" + Libro.LILA + "··Libro con más páginas··" + Libro.NEGRO);
		System.out.println(Libro.VERDE + libroConMasPaginas + Libro.NEGRO);
	}
}