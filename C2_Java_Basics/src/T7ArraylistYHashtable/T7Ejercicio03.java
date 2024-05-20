package T7ArraylistYHashtable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T7Ejercicio03 {

		public static Scanner sc = new Scanner(System.in);

		public static void main(String[] args) {

			Map<String, Integer> inventarioTienda = new HashMap<>();

			inventarioTienda.put("Chocolate", 9);
			inventarioTienda.put("Galletas", 2);
			inventarioTienda.put("Queso", 1);
			inventarioTienda.put("Pan", 7);                         //los 10 articulos iniciales y sus cantidades
			inventarioTienda.put("Leche", 11);
			inventarioTienda.put("Macarrones", 19);
			inventarioTienda.put("Lentejas", 22);
			inventarioTienda.put("Pipas", 3);
			inventarioTienda.put("Magdalenas", 3);
			inventarioTienda.put("Fuet", 6);

			int opcionMenu;
			do {
				mostrarMenu();
				System.out.print("Porfavor, introduce una opción: ");
				opcionMenu = Integer.parseInt(sc.nextLine());

				switch (opcionMenu) {

				case 1:
					agregarArticulo(inventarioTienda);
					break;                                                      //se repite el bucle hasta que el user decide salir (opc4)
				case 2:
					consultarArticulo(inventarioTienda);
					break;
				case 3:
					listarArticulos(inventarioTienda); 
					break;
				case 4:
					System.out.println("Gracias!");
					break;
				default:
					System.out.println("Selecciona una opción válida!");
					break;
				}
			} while (opcionMenu != 4);
		}

		public static void mostrarMenu() {

			System.out.println("\nOPERACIONES\n" + "===========\n" + "1. Agregar articulo\n" + "2. Consultar articulo\n" + "3. Listar articulos\n" + "4. Salir");
		}

		private static void agregarArticulo(Map<String, Integer> inventarioTienda) {

			System.out.print("Porfavor, introduce el artículo que quieres añadir: ");
			String nombreArticulo = sc.nextLine();
	                                                                                  //metodo que permite añadir un articulo nuevo o actualizar la cantidad existente
			System.out.print("Introduce la cantidad: ");
			int cantidadInput = Integer.parseInt(sc.nextLine());

			if (inventarioTienda.containsKey(nombreArticulo)) {                           //verificamos si ya existe el articulo en el inventario. 

				int cantidadExistente = inventarioTienda.get(nombreArticulo);             //si existe se actualiza la cant
																		 
				inventarioTienda.put(nombreArticulo, cantidadExistente + cantidadInput);
				System.out.println("Se ha actualizado el stock. Has añadido " + cantidadInput + " unidades de " + nombreArticulo);
			} else {
				inventarioTienda.put(nombreArticulo, cantidadInput);
				System.out.println("Se ha actualizado el stock. Has añadido un nuevo artículo. " + cantidadInput
						+ " unidades de " + nombreArticulo);
			}
		}

		private static void consultarArticulo(Map<String, Integer> inventarioTienda) {

			System.out.print("Porfavor, introduce el artículo que quieres consultar: ");
			String nombreArticulo = sc.nextLine();

			if (inventarioTienda.containsKey(nombreArticulo)) {                         //metodo que permite  verificar la cantidad existente de un articulo.
				int cantidad = inventarioTienda.get(nombreArticulo);
				System.out.println("Hay " + cantidad + " unidades de " + nombreArticulo + " en el inventario.");
			} else {
				System.out.println("El artículo " + nombreArticulo + " no se encuentra en el inventario.");            // + si el articulo no existe
			}
		}

		private static void listarArticulos(Map<String, Integer> inventarioTienda) {

			System.out.println("\nInventario de la tienda:\n=========================");              //muestra la lista completa de articulos y la cantidad

			for (Map.Entry<String, Integer> articulo : inventarioTienda.entrySet()) {
				System.out.println(articulo.getKey() + ": " + articulo.getValue() + " unidades");

			}

		}
	}