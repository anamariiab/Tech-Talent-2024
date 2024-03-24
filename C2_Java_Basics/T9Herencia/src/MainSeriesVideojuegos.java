
public class MainSeriesVideojuegos {

	public static void main(String[] args) {
		
		Serie[] series = new Serie[5];
        Videojuego[] videojuegos = new Videojuego[5];

        series[0] = new Serie();
        series[1] = new Serie("Halo", "Kyle Killen");
        series[2] = new Serie("The Good Doctor", 4, "Drama médico", "David Shore");
        series[3] = new Serie("Sherlock Holmes", 4, "Drama", "Steven Moffat, Mark Gatiss");
        series[4] = new Serie("Slow Horses", "Morwenna Banks, Will Smith");
        series[5] = new Serie("Peripheral", 1, "Ciencia ficción", "William Gibson"); 

        videojuegos[0] = new Videojuego();
        videojuegos[1] = new Videojuego("Hogwarts", 40, "Aventura", "Warner Bros. Interactive Entertainment");
        videojuegos[1] = new Videojuego("The Witcher 3: Wild Hunt", 70);
        videojuegos[3] = new Videojuego("God of War", 50, "Acción-Aventura", "Santa Monica Studio");
        videojuegos[4] = new Videojuego("Ghost of Tsushima", 40);
        videojuegos[5] = new Videojuego("Uncharted", 25, "Acción-Aventura", "Naughty Dog");
        
        series[1].entregar();
        series[5].entregar();
        videojuegos[2].entregar();     //se tiene que acabar!!!
        videojuegos[5].entregar();


	}

}
