import java.util.ArrayList;

public class MainElectrodomesticoLavadoraTelevision {

	public static void main(String[] args) {

		Electrodomestico[] electrodomesticos = new Electrodomestico[13];

		 electrodomesticos[0] = new Electrodomestico();
		 electrodomesticos[1] = new Electrodomestico(1250, "rojo", 'E', 85);
		 electrodomesticos[2] = new Electrodomestico(32, "gris", 'C', 90);
		 electrodomesticos[3] = new Lavadora();
		 electrodomesticos[4] = new Lavadora(660, 400);
		 electrodomesticos[5] = new Lavadora(1200, "azul", 'D', 300, 30);
		 electrodomesticos[6] = new Lavadora(850, "rojo", 'A', 320, 90);
		 electrodomesticos[7] = new Lavadora(770, "negro", 'B', 220, 250);
		 electrodomesticos[8] = new Television(); 
		 electrodomesticos[9] = new Television(1850, 125);
		 electrodomesticos[10] = new Television(1100, "gris", 'B', 113, 75, 21, true);
		 electrodomesticos[11] = new Television(950, "negro", 'C', 99, 33, 32, false);
		 electrodomesticos[12] = new Television(60, "rojo", 'F', 77, 215, 21, false);
        
        double precioTotalElectrodomesticos = 0;
        double precioTotalLavadoras = 0;
        double precioTotalTelevisiones = 0;

     // for (Electrodomestico electrodomestico : electrodomesticos) {
     // instance of?

        System.out.println("Precio total de Electrodomesticos: €" + precioTotalElectrodomesticos);
        System.out.println("Precio total de Lavadoras: €" + precioTotalLavadoras);
        System.out.println("Precio total de Televisiones: €" + precioTotalTelevisiones);
        
        System.out.println("---------------------------------------");
        System.out.printf("| %-20s | %-10s |\n", "Tipo", "Precio Total");
        System.out.println("---------------------------------------");
        System.out.printf("| %-20s | %-12.2f |\n", "Electrodomesticos", precioTotalElectrodomesticos);
        System.out.printf("| %-20s | %-12.2f |\n", "Lavadoras", precioTotalLavadoras);
        System.out.printf("| %-20s | %-12.2f |\n", "Televisiones", precioTotalTelevisiones);
        System.out.println("---------------------------------------");
    }

}