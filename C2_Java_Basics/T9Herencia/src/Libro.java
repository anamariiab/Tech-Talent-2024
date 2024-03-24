
public class Libro {

	protected String ISBN;
	protected String titulo;
	protected String autor;
	protected int numPag;
	
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
	
	
	 @Override
	    public String toString() {
	        return "El libro con ISBN " + ISBN + " creado por " + autor + " tiene " + numPag + " páginas.";
	    }
}
