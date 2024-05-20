package T9Herencia.Ejercicio4;

public class Raices {

	protected double a;
	protected double b;
	protected double c;

	public Raices() {
		this.a = 0.0;
		this.b = 0.0;
		this.c = 0.0;
	}

	public Raices(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double getDiscriminante() {                                            //calcula y devuelve el discriminante de la ec. (b2-4ac)
		return b * b - 4 * a * c;
	}

	public boolean tieneRaices() {                                                //verifica si la ecuacion tiene raices mediante 'getDiscriminante'
		return getDiscriminante() > 0;
	}

	public boolean tieneRaiz() {                                                  //si el discriminante es 0 tiene unica raiz
		return getDiscriminante() == 0;
	}

	public void calcular() {
	double discriminante = getDiscriminante();
    if (discriminante >= 0) {
        double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);                //calcula la raiz1 cuadrada del valor del discriminante  (la suma para la primera posible solucion)
        double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);                //calcula la raiz2 cuadrada del valor del discriminante  (la resta para la segunda posible solucion)
        System.out.println("Las soluciones de la ecuación son: " + raiz1 + " y " + raiz2);
    } else {
        System.out.println("La ecuación no tiene solución!");                     //si el discriminante es menor que 0.
    }
	}

	public void obtenerRaices() {                                                 //verifica si la ecuacion tiene al menos una raiz. si tiene se llama al metodo 'calcular'
		if (tieneRaices()) {
	        calcular();
	    } else {
	        System.out.println("La ecuación no tiene solución!");
	    }

	}

	public void obtenerRaiz() {                                                   
		double raiz = -b / (2 * a);                                              //calcula la raíz única. 
        System.out.println("La ecuación tiene una única solución: " + raiz);
    }

}
