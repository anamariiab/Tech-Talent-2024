package T8POO;

public class Libro {

	private String titulo;
	private String genero;
	private String autor;
	private int anyPublicacion;

	public Libro() {

		this.titulo = "  ";
		this.genero = "  ";
		this.autor = "  ";
		this.anyPublicacion = 0;

	}
	
	public Libro(String titulo, String genero, String autor) {

		this.titulo = titulo;
		this.genero = genero;
		this.autor = autor;
		this.anyPublicacion = 0;

	}
	

	public Libro(String titulo, String genero, String autor, int anyPublicacion) {

		this.titulo = titulo;
		this.genero = genero;
		this.autor = autor;
		this.anyPublicacion = anyPublicacion;

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnyPublicacion() {
		return anyPublicacion;
	}

	public void setAnyPublicacion(int anyPublicacion) {
		this.anyPublicacion = anyPublicacion;
	}
	
	
	@Override
    public String toString() {
        return "Titulo: " + titulo + "\nGenero: " + genero + "\nAutor: " + autor + "\nAño publicación: " + anyPublicacion;
    }
	
}
