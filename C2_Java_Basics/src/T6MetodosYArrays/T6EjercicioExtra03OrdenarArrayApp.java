package T6MetodosYArrays;
import java.util.Arrays;
import java.util.Scanner;
public class T6EjercicioExtra03OrdenarArrayApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		
		int[] numeros = {7, 1, 9, 2, 4};
      
        ordenarArray(numeros);

        System.out.println("El array ordenado de menor a mayor:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
    }
 
    public static void ordenarArray(int[] array) {
        Arrays.sort(array);
    }
}
		