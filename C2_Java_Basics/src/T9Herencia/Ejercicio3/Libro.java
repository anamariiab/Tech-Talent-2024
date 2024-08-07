package T9Herencia.Ejercicio3;

public class Libro {
	
    private String ISBN;
    private String titulo;
    private String autor;
    private int numPag;

    public static final String LILA = "\033[0;35m";                                                       //ANSI codes for color. 
    public static final String VERDE= "\033[0;32m";
    public static final String CIAN = "\033[0;36m";
    public static final String NEGRO = "\033[0m";

    public Libro(String ISBN, String titulo, String autor, int numPag) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.numPag = numPag;
    }

    public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNumPag() {
		return numPag;
	}

	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}

	public String toStringConColor() {
        return CIAN + "ISBN: " + NEGRO + ISBN + "\n" + CIAN + "Título: " + NEGRO + titulo  + "\n" + 
        	   CIAN + "Autor: " + NEGRO + autor + "\n" + CIAN + "Número de páginas: " + NEGRO + numPag;
    }
}