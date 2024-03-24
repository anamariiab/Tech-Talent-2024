import java.util.ArrayList;

public class MainElectrodomestico {

	public static void main(String[] args) {

		ArrayList<Electrodomestico> electrodomesticos = new ArrayList<>();

		electrodomesticos.add(new Electrodomestico());
        electrodomesticos.add(new Electrodomestico(1250, "rojo", 'E', 85));
        electrodomesticos.add(new Electrodomestico(932, "gris", 'C', 90));
        electrodomesticos.add(new Lavadora());
        electrodomesticos.add(new Lavadora(660, 400));
        electrodomesticos.add(new Lavadora(1200, "azul", 'D', 300, 30));
        electrodomesticos.add(new Lavadora(850, "rojo", 'A', 320, 90));
        electrodomesticos.add(new Lavadora(770, "negro", 'B', 220, 250));
        electrodomesticos.add(new Television()); 
        electrodomesticos.add(new Television(1850, 125));
        electrodomesticos.add(new Television(1100, "gris", 'B', 113, 75, 21, true));
        electrodomesticos.add(new Television(950, "negro", 'C', 99, 33, 32, false));
        electrodomesticos.add(new Television(60, "rojo", 'F', 77, 215, 21, false));
        
        double precioTotalElectrodomesticos = 0;
        double precioTotalLavadoras = 0;
        double precioTotalTelevisiones = 0;

        //..instanceof??

        System.out.println("Precio total de Electrodomesticos: €" + precioTotalElectrodomesticos);
        System.out.println("Precio total de Lavadoras: €" + precioTotalLavadoras);
        System.out.println("Precio total de Televisiones: €" + precioTotalTelevisiones);
    }

}