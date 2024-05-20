package T8POO;

public class MainSerie {

	public static void main(String[] args) {
		

		Serie serie1 = new Serie();
		Serie serie2 = new Serie("Halo", " Kyle Killen");
		Serie serie3 = new Serie("Slow Horses", 3, "Drama", "James Hawes");
		

		System.out.println(
				"========================================================================================================");
		System.out.println("··Serie 1··");
		System.out.println(serie1.toString());
		
		System.out.println(
				"========================================================================================================");
		System.out.println("··Serie 2··");
		System.out.println(serie2.toString());
	
		System.out.println(
				"========================================================================================================");
		System.out.println("··Serie 3··");
		System.out.println(serie3.toString());

	}
}