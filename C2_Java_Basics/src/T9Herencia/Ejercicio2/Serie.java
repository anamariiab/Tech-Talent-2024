package T9Herencia.Ejercicio2;

public class Serie implements Entregable {

	private String titulo;
	private int numTemporadas;
	private boolean entregado;
	private String genero;
	private String creador;

	private final int NUM_TEMPORADAS_PRED = 3;
	private final static boolean ENTREGADO_PRED = false;

	public Serie() {
		this.titulo = " ";
		this.numTemporadas = NUM_TEMPORADAS_PRED;
		this.entregado = ENTREGADO_PRED;
		this.genero = " ";
		this.creador = " ";
	}

	public Serie(String titulo, String creador) {
		this.titulo = titulo;
		this.numTemporadas = NUM_TEMPORADAS_PRED;
		this.entregado = ENTREGADO_PRED;
		this.genero = " ";
		this.creador = creador;
	}

	public Serie(String titulo, int numTemporadas, String genero, String creador) {
		this.titulo = titulo;
		this.numTemporadas = numTemporadas;
		this.genero = genero;
		this.creador = creador;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumTemporadas() {
		return numTemporadas;
	}

	public void setNumTemporadas(int numTemporadas) {
		this.numTemporadas = numTemporadas;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	@Override
	public String toString() {
		return "  Titulo: " + titulo + "\n  Número de temporada: " + numTemporadas + "\n  Entregado: " + entregado
				+ "\n  Genero: " + genero + "\n  Creador: " + creador;
	}

	@Override
	public void entregar() {
		this.entregado = true;
	}

	@Override
	public void devolver() {
		this.entregado = false;
	}

	@Override
	public boolean isEntregado() {
		return this.entregado;
	}

	@Override
    public int compareTo(Object obj) {
		Serie otraSerie = (Serie)obj;
		return this.numTemporadas - otraSerie.numTemporadas;
    }

}