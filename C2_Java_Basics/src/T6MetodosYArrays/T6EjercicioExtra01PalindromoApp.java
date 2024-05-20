package T6MetodosYArrays;

public class T6EjercicioExtra01PalindromoApp {

	public static void main(String[] args) {
		
		String palin = "amoroooma";
		
		String palinReverse = "";
		
		int indiceRecorre = palin.length() - 1; 
		System.out.println(indiceRecorre);
		
		char caracter = palin.charAt(indiceRecorre); 
		System.out.println(caracter);
		
		for (int i = indiceRecorre; i >= 0; i--) {
			palinReverse = palinReverse.concat(palin.valueOf(caracter));

			indiceRecorre--;
			if (indiceRecorre >= 0) {
				caracter = palin.charAt(indiceRecorre);
			}
		}

		imprimePalindromo(palin,palinReverse);

	}
	
	public static void imprimePalindromo (String palindrom, String palindromInverso) {
		
		if (palindrom.equals(palindromInverso)) {
			System.out.println("Es un palindromo");
		} else {
			System.out.println("No es un palindromo");
		}

	}

}
