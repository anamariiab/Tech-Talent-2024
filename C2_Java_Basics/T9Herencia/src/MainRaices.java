
public class MainRaices {

	public static void main(String[] args) {

		Raices ecuacion = new Raices(1, -5, 2);

		System.out.println("~~ECUACIÓN DE SEGUNDO GRADO~~\n");
        System.out.println("El discriminante de la ecuación es: " + ecuacion.getDiscriminante());
                                                                                                //!!remember: el operador ternario es como 'if-else'!! 
        System.out.println("¿Tiene raíces? " + (ecuacion.tieneRaices() ? "✓ Sí" : "✗ No"));    //!!si la condicion 'ecuacion.tieneRaices()' es verdadera devuelve 'Si', si es falsa devuelve 'No'       
        System.out.println("¿Tiene raíz única? " + (ecuacion.tieneRaiz() ? "✓ Sí" : "✗ No"));  //!!si la condicion 'ecuacion.tieneRaiz()' es verdadera devuelve 'Si', si es falsa devuelve 'No'   
	}

}
