package T8POO;

public class MainElectrodomestico1 {

    public static void main(String[] args) {
		
		Electrodomestico1 electroA = new Electrodomestico1();
		Electrodomestico1 electroB = new Electrodomestico1(1850, 500);
		Electrodomestico1 electroC = new Electrodomestico1(850, 700, 
				Electrodomestico1.ColorEnum.ROJO, Electrodomestico1.ConsumoEnum.C);         //se accede y se utiliza la enumeracion Color y Consum definida en la class
		Electrodomestico1 electroD = new Electrodomestico1(2200, 650, 
				Electrodomestico1.ColorEnum.AZUL, Electrodomestico1.ConsumoEnum.D);         //se accede y se utiliza la enumeracion Color y Consum definida en la class
		
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
