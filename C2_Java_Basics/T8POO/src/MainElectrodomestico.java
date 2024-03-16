
public class MainElectrodomestico {

	public static void main(String[] args) {
		
		Electrodomestico electroA = new Electrodomestico();
		Electrodomestico electroB = new Electrodomestico(1850, 500);
		Electrodomestico electroC = new Electrodomestico(850, 700, "rojo", 'C');
		Electrodomestico electroD = new Electrodomestico(2200, 650, "azul", 'D');
		
		System.out.println("===============================");
		System.out.println("··Nevera Samsung··");
	    System.out.println(electroA.toString());
	    
	    System.out.println("===============================");
		System.out.println("··Nevera LG··");
	    System.out.println(electroB.toString());
	
	    System.out.println("===============================");
		System.out.println("··Nevera Bosch··");
	    System.out.println(electroC.toString());
	    
	    System.out.println("===============================");
		System.out.println("··Nevera Siemens··");
	    System.out.println(electroD.toString());
	}

}
