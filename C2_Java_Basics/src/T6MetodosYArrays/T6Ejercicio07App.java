package T6MetodosYArrays;

import java.util.Scanner;
public class T6Ejercicio07App {


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

        System.out.println("Porfavor, introduce la cantidad de euros que quieres convertir: ");
        double eurosParaConvertir = sc.nextDouble();

        System.out.println("Porfavor, introduce el tipo de moneda (dolares, yenes o libras): ");
        String moneda = sc.next();

        double pennyC = MetodoConversion(eurosParaConvertir, moneda);

        System.out.println("La cantidad " + eurosParaConvertir + " convertida a " + moneda + " es: " + pennyC);
    }

    public static double MetodoConversion(double cantidadEuros, String monedaCambio) {
        double pennies = 0.0;

        switch (monedaCambio) {
            case "dolares":
                pennies = cantidadEuros * 1.28611;
                break;

            case "yenes":
                pennies = cantidadEuros * 129.852;
                break;

            case "libras":
                pennies = cantidadEuros * 0.86;
                break;

            default:
                System.out.println("Moneda de cambio no válida.");
        }
        return pennies;
    }
}