package T9Herencia.Ejercicio6;

import java.util.*;

public class MainCineAsientoPeliculaEspectador {

	public static void main(String[] args) {
		
		Pelicula titanic = new Pelicula("Titanic", 120, 16, "James Cameron");
		Cinema cinema = new Cinema(titanic, 7.8);

		
		simulacionAsignarAsientos(cinema, 100);
        mostrarResumenOcupacionAsientos(cinema);
    }

	public static void simulacionAsignarAsientos(Cinema cinema, int numEspectadores) {
        int fila;
        char columna;
        Random random = new Random();
        for (int i = 0; i < numEspectadores; i++) {                                         //itera sobre el número de espectadores (100)
            fila = random.nextInt(1, Cinema.FILAS + 1);                                     //genera num. aleat. entre 1(la primera fila) y el num. total de filas existentes 8.
            columna = (char) ('A' + random.nextInt(Cinema.COLUMNAS));                       //genera un caract. aleat. entre A-I.  A=65(valor num. asociado ascii) -> rango 65-73 (por que son 9 columnas existentes)          
            Espectador espectador = new Espectador();                                       //creacion obj. espectador
            System.out.print("Asiento " + fila + " " + columna + ": ");
            if (cinema.asignarAsiento(fila, columna, espectador)) {
                System.out.println(espectador + ". Asiento asignado!");
            } else {
                System.out.println(espectador + ". Asiento NO asignado!");
            }
        }
    }
		
	public static void mostrarResumenOcupacionAsientos(Cinema cinema) {
        System.out.println("\nResumen de ocupación de los asientos:");
        int asientosOcupados = 0;
        int asientosLibres = 0;
        for (int i = 0; i < Cinema.FILAS; i++) {
            for (int j = 0; j < Cinema.COLUMNAS; j++) {
                if (cinema.asientos[i][j].isOcupado()) {
                    asientosOcupados++;
                } else {
                    asientosLibres++;
                }
            }
        }
        System.out.println("Asientos ocupados: " + asientosOcupados);
        System.out.println("Asientos libres: " + asientosLibres);
    }

}