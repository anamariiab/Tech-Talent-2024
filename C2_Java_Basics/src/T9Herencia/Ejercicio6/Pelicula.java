package T9Herencia.Ejercicio6;

public class Pelicula {
	
	protected String titulo;
	protected int duracion;
	protected int edadMinimaParaAsistir;
	protected String director;
	
	public Pelicula(String titulo, int duracion, int edadMinimaParaAsistir, String director) {
		this.titulo = titulo;
		this.duracion = duracion;
		this.edadMinimaParaAsistir = edadMinimaParaAsistir;
		this.director = director;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getDuracion() {
		return duracion;
	}

	public int getEdadMinimaParaAsistir() {
		return edadMinimaParaAsistir;
	}

	public String getDirector() {
		return director;
	}
	
}
