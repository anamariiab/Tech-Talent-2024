package T9Herencia.Ejercicio2;

public class MainSeriesVideojuegos {
	
    public static final String CIAN = "\033[1;36m";    
    public static final String VERDE = "\033[1;32m";  

    public static void main(String[] args) {
        Serie[] series = new Serie[5];
        Videojuego[] videojuegos = new Videojuego[5];

        series[0] = new Serie("Halo", "Kyle Killen");
        series[1] = new Serie("The Good Doctor", 4, "Drama médico", "David Shore");
        series[2] = new Serie("Sherlock Holmes", 4, "Drama", "Steven Moffat, Mark Gatiss");
        series[3] = new Serie("Slow Horses", "Morwenna Banks, Will Smith");
        series[4] = new Serie("Peripheral", 1, "Ciencia ficción", "William Gibson");

        videojuegos[0] = new Videojuego("Hogwarts", 40, "Aventura", "Warner Bros");
        videojuegos[1] = new Videojuego("The Witcher 3: Wild Hunt", 20);
        videojuegos[2] = new Videojuego("God of War", 50, "Acción-Aventura", "Santa Monica Studio");
        videojuegos[3] = new Videojuego("Ghost of Tsushima", 40);
        videojuegos[4] = new Videojuego("Uncharted", 25, "Acción-Aventura", "Naughty Dog");

        series[2].entregar();
        series[3].entregar();
        series[4].entregar();
        videojuegos[2].entregar();
        videojuegos[4].entregar();
        
        System.out.println(CIAN + "*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println(VERDE + "|                  Series y Videojuegos                      |");
        System.out.println(CIAN + "*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        
        Entregable[] entregables = obtenerEntregados(series, videojuegos);
        

        int cantidadSeriesEntregadas = contarEntregados(series);
        System.out.println(VERDE +  "  Cuantas series hay entregadas? " + cantidadSeriesEntregadas);

        int cantidadVideojuegosEntregados = contarEntregados(videojuegos);
        System.out.println(VERDE +  "  Cuantos videojuegos hay entregados? " + cantidadVideojuegosEntregados);

        System.out.println(CIAN + "|------------------------------------------------------------|");
        Serie serieConMasTemporadas = encontrarSerieConMasTemporadas(series);
        System.out.println(VERDE + "  Serie con más temporadas ");
        System.out.println(serieConMasTemporadas.toString());

        System.out.println(CIAN + "|------------------------------------------------------------|");
        Videojuego videojuegoConMasHoras = encontrarVideojuegoConMasHoras(videojuegos);
        System.out.println(VERDE + "  Videojuego con más horas estimadas ");
        System.out.println(videojuegoConMasHoras.toString());
        System.out.println(CIAN + "|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-|");
    }

    public static int contarEntregados(Entregable[] entregables) {
        int contador = 0;
        for (Entregable entregable : entregables) {
            if (entregable.isEntregado()) {
                contador++;
            }
        }
        return contador;
    }
    
    public static Entregable[] obtenerEntregados(Serie[] series, Videojuego[] videojuegos) {
        int totalEntregados = contarEntregados(series) + contarEntregados(videojuegos);
        Entregable[] entregados = new Entregable[totalEntregados];
        int indice = 0;
        
        for (Serie serie : series) {
            if (serie.isEntregado()) {
                entregados[indice] = serie;
                indice++;
            }
        }
        
        for (Videojuego videojuego : videojuegos) {
            if (videojuego.isEntregado()) {
                entregados[indice] = videojuego;
                indice++;
            }
        }
        
        return entregados;
    }

    public static Serie encontrarSerieConMasTemporadas(Serie[] series) {
        Serie serieConMasTemporadas = series[0];
        for (Serie serie : series) {
            if (serie.getNumTemporadas() > serieConMasTemporadas.getNumTemporadas()) {
                serieConMasTemporadas = serie;
            }
        }
        return serieConMasTemporadas;
    }

    public static Videojuego encontrarVideojuegoConMasHoras(Videojuego[] videojuegos) {
        Videojuego videojuegoConMasHoras = videojuegos[0];
        for (Videojuego videojuego : videojuegos) {
            if (videojuego.getHorasEstimadas() > videojuegoConMasHoras.getHorasEstimadas()) {
                videojuegoConMasHoras = videojuego;
            }
        }
        return videojuegoConMasHoras;
    }
}