import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T7Ejercicio02 {

		public static Scanner sc = new Scanner(System.in);
		public static double IVA;                                  //he declarado la var iva como global para poder utilizarla tanto en "agregar articulo" como en "efectuar compra"

		public static void main(String[] args) {
			
			List<String> nombresArticulos = new ArrayList<>();
			List<Integer> cantidadArticulosCarrito = new ArrayList<>();
			List<Double> precioUnidadArticulo = new ArrayList<>();
			List<Double> ivaArticulo = new ArrayList<>();                                    //almacenamos el iva de cada articulo

			int opcionMenu;
		
			do {
				mostrarMenu();                                                                                     //llamamos al metodo q imprime las opc en la consola para el user
				System.out.print("Porfavor, introduce una opción: ");
				opcionMenu = Integer.parseInt(sc.nextLine());

				switch (opcionMenu) {
				case 1:
					agregarArticulo(nombresArticulos, cantidadArticulosCarrito, precioUnidadArticulo, ivaArticulo);
					break;                                                                                  //se repite el bucle hasta que el user decide salir (opc3)
				case 2:
					efectuarCompra(nombresArticulos, cantidadArticulosCarrito, precioUnidadArticulo, ivaArticulo);
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

		public static void agregarArticulo(List<String> nombresArticulos, List<Integer> cantidadArticulosCarrito, List<Double> precioUnidadArticulo, List<Double> ivaArticulo) {
			
			System.out.print("Porfavor, introduce el nombre del artículo: ");                                                                                //solicitamos al usuario ingresar detalles del articulo
			String nombreArticulo = sc.nextLine();

			System.out.print("Introduce la cantidad: ");
			int cantidad = Integer.parseInt(sc.nextLine());

			System.out.print("Introduce el precio por cada unidad: ");
			double precioPorUnidad = Double.parseDouble(sc.nextLine());

			nombresArticulos.add(nombreArticulo);
			cantidadArticulosCarrito.add(cantidad);                                                                             //añadimos los detalles correspondientes de cada articulo a las listas
			precioUnidadArticulo.add(precioPorUnidad);

			ivaArticulo.add(obtenerIVA());                                                                         

			System.out.println("Artículo añadido al carrito con un IVA del " + ivaArticulo + "%.");
		}

		public static void efectuarCompra(List<String> nombresArticulos, List<Integer> cantidadArticulosCarrito, 
				List<Double> precioUnidadArticulo, List<Double> ivaArticulo) {
			
			System.out.println("\nResumen de la compra:\n" + "=========================");
				
			double precioTotalBruto = 0;
			double precioTotalIVA = 0;
			int numeroArticulosComprados = 0;
			
			for (int i = 0; i < nombresArticulos.size(); i++) {                                                                         //recorremos los elementos de las listas 
				precioTotalBruto += cantidadArticulosCarrito.get(i) * precioUnidadArticulo.get(i);                                      
				precioTotalIVA += cantidadArticulosCarrito.get(i) * precioUnidadArticulo.get(i) * (1 + ivaArticulo.get(i) / 100);
				numeroArticulosComprados += cantidadArticulosCarrito.get(i);
			}

			System.out.println("Precio total bruto: " + precioTotalBruto);                             
			System.out.println("Precio total con IVA: " + precioTotalIVA);
			System.out.println("Número de artículos comprados: " + numeroArticulosComprados);

			System.out.print("Introduce la cantidad pagada: ");
			double cantidadPagada = Double.parseDouble(sc.nextLine());

			double cambio = cantidadPagada - precioTotalIVA;
			System.out.println("Cambio a devolver al cliente: " + cambio);
			
		}

		public static double obtenerIVA() {
			
			System.out.print("Selecciona el tipo de IVA (21% o 4%): ");
			return Double.parseDouble(sc.nextLine());
			
		}
	}