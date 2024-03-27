
public class Videojuego implements Entregable {

	public String titulo;
	public int horasEstimadas;
	public boolean entregado;
	public String genero;
	public String companyia;

	public final int HORAS_ESTIMADAS_PRED = 10;
	public final static boolean ENTREGADO_PRED = false;

	public Videojuego() {
		this.titulo = " ";
		this.horasEstimadas = 10;
		this.entregado = ENTREGADO_PRED;
		this.genero = " ";
		this.companyia = " ";
	}

	public Videojuego(String titulo, int horasEstimadas) {
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
		this.entregado = ENTREGADO_PRED;
		this.genero = " ";
		this.companyia = " ";
	}

	public Videojuego(String titulo, int horasEstimadas, String genero, String companyia) {
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
		this.genero = genero;
		this.companyia = companyia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getHorasEstimadas() {
		return horasEstimadas;
	}

	public void setHorasEstimadas(int horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCompanyia() {
		return companyia;
	}

	public void setCompanyia(String companyia) {
		this.companyia = companyia;
	}

	@Override
	public String toString() {
		return "  Titulo: " + titulo + "\n  Horas estimadas: " + horasEstimadas + "\n  Entregado: " + entregado + "\n  Genero: "
				+ genero + "\n  Compañia: " + companyia;
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
	public int compareTo(Object o) {   
		Videojuego otherVideojuego = (Videojuego) o;
        return Integer.compare(this.horasEstimadas, otherVideojuego.getHorasEstimadas());
	}

}