package T6MetodosYArrays;
import java.util.Scanner;
public class T6Ejercicio08App {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in); 
		
		int matriz [] = new int [10];
		
		System.out.println("Porfavor, introduce un número para la array: ");  
		
		for (int i = 0; i < 10; i++) {
			int numero = sc.nextInt();
			matriz [i] = numero;
		}
		System.out.println(matriz[6]);  
		
		
    sc.close();	
	}

}
