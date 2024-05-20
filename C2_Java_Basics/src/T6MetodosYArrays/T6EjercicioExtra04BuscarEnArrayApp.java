package T6MetodosYArrays;
import java.util.Scanner;
public class T6EjercicioExtra04BuscarEnArrayApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		
		int[] array = {8, 5, 8, 15, 20, 7, 12, 51, 71, 30};

        System.out.print("Porfavor, introduce un número: ");
        int numeroParaBuscar = sc.nextInt();

        int posicion = buscarNumero(array, numeroParaBuscar);

        if (posicion != -1) {
            System.out.println("El número " + numeroParaBuscar + " esta en la posición " + posicion + " del array.");
        } else {
            System.out.println("El número " + numeroParaBuscar + " no esta en el array.");
        }
    }

    public static int buscarNumero(int[] array, int numero) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == numero) {
                return i; 
            }
        }
        return -1; 
    }
}

