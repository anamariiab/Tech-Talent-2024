package T8POO;

public class MainLibro {

	public static void main(String[] args) {
		
		Libro libroA = new Libro();
		Libro libroB = new Libro("La trena", "Drama", "Laetitia Colombani");
		Libro libroC = new Libro("L'estiu Que Comença", "Novel·la romàntica", "Sílvia Soler", 2014);
		Libro libroD = new Libro("Algú com tu", "Novel·la romàntica", "Xavier Bosch", 2015);
		
		    System.out.println("===============================");
		    System.out.println("··Info. del primer libro··");
		    System.out.println(libroA.toString());

		    System.out.println("===============================");
		    System.out.println("··Info. del segundo libro··");
		    System.out.println(libroB.toString());

		    System.out.println("===============================");
		    System.out.println("··Info. del tercer libro··");
		    System.out.println(libroC.toString());

		    System.out.println("===============================");
		    System.out.println("··Info. del cuarto libro··");
		    System.out.println(libroD.toString());
		    
		}

}
