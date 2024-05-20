package T8POO;

public class Serie {
	
    private String titulo;
    private int numTemporadas;
    private boolean entregado;
    private String genero;
    private String creador;

    
    public Serie() {
    	
        this.titulo = " ";                                         //constructor por defecto
        this.numTemporadas = 3;
        this.entregado = false;
        this.genero = " ";
        this.creador = " ";
    }


    public Serie(String titulo, String creador) {
    	
        this.titulo = titulo;
        this.numTemporadas = 3;
        this.entregado = false;
        this.genero = " ";
        this.creador = creador;
    }


    public Serie(String titulo, int numTemporadas, String genero, String creador) {
    	
        this.titulo = titulo;
        this.numTemporadas = numTemporadas;
        this.entregado = false;
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


    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
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
        return "Titulo: " + titulo + "\nNúmero de temporada: " + numTemporadas + "\nEntregado: " + entregado + "\nGenero: " + genero + "\nCreador: " + creador;
    } 
}    