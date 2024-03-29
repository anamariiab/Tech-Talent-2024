import java.util.ArrayList;

public class MainElectrodomesticoLavadoraTelevision {

	public static void main(String[] args) {

		Electrodomestico[] electrodomesticos = new Electrodomestico[10];

		electrodomesticos[0] = new Electrodomestico(1250, "rojo", 'E', 85);
		electrodomesticos[1] = new Electrodomestico(32, "gris", 'C', 90);
		electrodomesticos[2] = new Lavadora(660, 400);
		electrodomesticos[3] = new Lavadora(1200, "azul", 'D', 300, 30);
		electrodomesticos[4] = new Lavadora(850, "rojo", 'A', 320, 90);
		electrodomesticos[5] = new Lavadora(770, "negro", 'B', 220, 250);
		electrodomesticos[6] = new Television(700, "gris", 'B', 113, 75, 40, true);
		electrodomesticos[7] = new Television(1850, 125);
		electrodomesticos[8] = new Television(1100, "gris", 'B', 113, 75, 21, true);
		electrodomesticos[9] = new Television(950, "negro", 'C', 99, 33, 32, false);

		double precioTotalElectrodomesticos = 0;
		double precioTotalLavadoras = 0;
		double precioTotalTelevisiones = 0;

		for (Electrodomestico electrodomestico : electrodomesticos) {
        	if(electrodomestico instanceof Lavadora) {
        		precioTotalLavadoras += electrodomestico.precioFinal();
        	}
        	
        	if(electrodomestico instanceof Television) {
        		precioTotalTelevisiones += electrodomestico.precioFinal();
        	}
        	
        	precioTotalElectrodomesticos += electrodomestico.precioFinal();
        }

        System.out.println("---------------------------------------");
        System.out.printf("| %-20s | %-10s |\n", "Tipo", "Precio Total");
        System.out.println("---------------------------------------");
        System.out.printf("| %-20s | %-12.2f |\n", "Electrodomesticos", precioTotalElectrodomesticos);
        System.out.printf("| %-20s | %-12.2f |\n", "Lavadoras", precioTotalLavadoras);
        System.out.printf("| %-20s | %-12.2f |\n", "Televisiones", precioTotalTelevisiones);
        System.out.println("---------------------------------------");
    }

}