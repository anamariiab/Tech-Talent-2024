package T8POO;

public class MainCoche {

	public static void main(String[] args) {
		
		Coche cocheA = new Coche();
		Coche cocheB = new Coche("Toyota", "Yaris");
		Coche cocheC = new Coche("Renault", "Clio", 2020);
		Coche cocheD = new Coche("Dacia", "Sandero", 2015, "rojo");
		
		    System.out.println("===============================");
		    System.out.println("··Info. del primer coche··");
		    System.out.println(cocheA.toString());

		    System.out.println("===============================");
		    System.out.println("··Info. del segundo coche··");
		    System.out.println(cocheB.toString());

		    System.out.println("===============================");
		    System.out.println("··Info. del tercer coche··");
		    System.out.println(cocheC.toString());

		    System.out.println("===============================");
		    System.out.println("··Info. del cuarto coche··");
		    System.out.println(cocheD.toString());
		    
		}

}
