import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T7Ejercicio02App {

		public static Scanner sc = new Scanner(System.in);
		public static double IVA;                                  //he declarado la var iva como global para poder utilizarla tanto en "agregar articulo" como en "efectuar compra"

		public static void main(String[] args) {
			
			List<String> nombresArticulos = new ArrayList<>();
			List<Integer> cantidadArticulosCarrito = new ArrayList<>();
			List<Double> precioUnidadArticulo = new ArrayList<>();

			int opcionMenu;
			double precioTotalBruto = 0;
			int numeroArticulosComprados = 0;

			do {
				mostrarMenu();                                                                                     //llamamos al metodo q imprime las opc en la consola para el user
				System.out.print("Porfavor, introduce una opción: ");
				opcionMenu = Integer.parseInt(sc.nextLine());

				switch (opcionMenu) {
				case 1:
					agregarArticulo(nombresArticulos, cantidadArticulosCarrito, precioUnidadArticulo);
					break;                                                                                  //se repite el bucle hasta que el user decide salir (opc3)
				case 2:
					efectuarCompra(nombresArticulos, cantidadArticulosCarrito, precioUnidadArticulo, precioTotalBruto, numeroArticulosComprados);
					break;
				case 3:
					System.out.println("Gracias!");
					break;
				default:
					System.out.println("Selecciona una opción válida!");
					break;
				}
			} while (opcionMenu!= 3);
			
		}

		public static void mostrarMenu() {
			System.out.println("\nOPERACIONES\n" + "===========\n" + "1. Agregar artículo al carrito\n" + "2. Efectuar compra\n" + "3. Salir\n");
			
		}

		public static void agregarArticulo(List<String> nombresArticulos, List<Integer> cantidadArticulosCarrito, List<Double> precioUnidadArticulo) {
			
			System.out.print("Porfavor, introduce el nombre del artículo: ");
			String nombreArticulo = sc.nextLine();

			System.out.print("Introduce la cantidad: ");
			int cantidad = Integer.parseInt(sc.nextLine());

			System.out.print("Introduce el precio por cada unidad: ");
			double precioPorUnidad = Double.parseDouble(sc.nextLine());

			nombresArticulos.add(nombreArticulo);
			cantidadArticulosCarrito.add(cantidad);
			precioUnidadArticulo.add(precioPorUnidad);

			IVA = obtenerIVA();                                                                   //llamamos al metodo obtener iva para obtener el tipo 

			System.out.println("Artículo añadido al carrito con un IVA del " + IVA + "%.");
		}

		public static void efectuarCompra(List<String> nombresArticulos, List<Integer> cantidadArticulosCarrito, List<Double> precioUnidadArticulo, double precioTotalBruto, int numeroArticulosComprados) {
			
			System.out.println("\nResumen de la compra:\n" + "=========================");

			for (int i = 0; i < nombresArticulos.size(); i++) {
				precioTotalBruto += cantidadArticulosCarrito.get(i) * precioUnidadArticulo.get(i);                    //recorre cada articulo del carrito, calculando el precio total bruto de la compra sumando la cantidad y el precio por unidad y cuenta el número total de artículos comprados.
				numeroArticulosComprados += cantidadArticulosCarrito.get(i);
			}

			double precioConIVA = precioTotalBruto * (1 + IVA / 100);                                               //ajuste para aplicar el iva al precio total bruto. ej: si fuera 21%: (1 + 21 / 100) = 1.21.

			System.out.println("IVA aplicado: " + IVA + "%");
			System.out.println("Precio total bruto: " + precioTotalBruto);
			System.out.println("Precio total con IVA: " + precioConIVA);
			System.out.println("Número de artículos comprados: " + numeroArticulosComprados);

			System.out.print("Introduce la cantidad pagada: ");
			double cantidadPagada = Double.parseDouble(sc.nextLine());

			double cambio = cantidadPagada - precioConIVA;
			System.out.println("Cambio a devolver al cliente: " + cambio);

		
			
		}

		public static double obtenerIVA() {
			
			System.out.print("Selecciona el tipo de IVA (21% o 4%): ");
			return Double.parseDouble(sc.nextLine());
			
		}
	}