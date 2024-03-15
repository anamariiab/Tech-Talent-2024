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
    
    
    public static void main(String[] args) {
    	
    	
    	Serie serie1 = new Serie();
        Serie serie2 = new Serie("Halo", " Kyle Killen");
        Serie serie3 = new Serie("Slow Horses", 3, "Drama", "James Hawes");
        
        System.out.println("========================================================================================================");
        System.out.println("Serie 1:");
        System.out.println("Titulo: " + serie1.getTitulo() + ", Temporadas: " + serie1.getNumTemporadas() + ", Entregado: " + serie1.isEntregado() + ", Género: " + serie1.getGenero() + ", Creador: " + serie1.getCreador());
        System.out.println("========================================================================================================");
        System.out.println("Serie 2:");
        System.out.println("Titulo: " + serie2.getTitulo() + ", Temporadas: " + serie2.getNumTemporadas() + ", Entregado: " + serie2.isEntregado() + ", Género: " + serie2.getGenero() + ", Creador: " + serie2.getCreador());
        System.out.println("========================================================================================================");
        System.out.println("Serie 3:");
        System.out.println("Titulo: " + serie3.getTitulo() + ", Temporadas: " + serie3.getNumTemporadas() + ", Entregado: " + serie3.isEntregado() + ", Género: " + serie3.getGenero() + ", Creador: " + serie3.getCreador());
        
    }
}