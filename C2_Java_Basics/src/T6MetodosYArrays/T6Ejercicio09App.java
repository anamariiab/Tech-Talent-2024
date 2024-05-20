package T6MetodosYArrays;
import java.util.Scanner;
public class T6Ejercicio09App {

	public static void main(String[] args) {
		
		 Scanner scanner = new Scanner(System.in); 
		 
		 System.out.print("Porfavor, introduce un tamaño de array: ");
		 int size = scanner.nextInt();
		
		 int array9[] = new int[size];
		 int sumarTotal = 0;
		 
		   for (int i = 0; i < array9.length; i++) {
			  array9 [i] = (int) (Math.random()*10);
			 
		 }
		 
		   for (int i = 0; i < array9.length; i++) {
			   if (i==0) {
				  System.out.print("{" + array9[i]+ ",");	 
				 
			   } else if (i < array9.length-1){
			      System.out.print (array9 [i] + ",");
			 
			   } else {
				  System.out.print (array9 [i] + "}");
			 }
			 
		 }
		 
		   for (int i = 0; i < array9.length; i++) {
			  sumarTotal = array9[i]+sumarTotal; 
	}
		 scanner.close();
		 System.out.print("\nLa suma total es: " + sumarTotal);	
		 
	}	 
		 
}