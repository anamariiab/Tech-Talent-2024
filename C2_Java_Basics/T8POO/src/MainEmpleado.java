
public class MainEmpleado {

	public static void main(String[] args) {

		Empleado empleadoA = new Empleado("Javier", 30, 1500.0);
		Empleado empleadoB = new Empleado("Emilia", 22, 1700.0);

		System.out.println("===============================");
		System.out.println("··Datos del empleado A··");
		System.out.println(empleadoA.toString());
		System.out.println("Salario anual: €" + empleadoA.calculoSalarioAnual());

		System.out.println("===============================");
		System.out.println("··Datos del empleado B··");
		System.out.println(empleadoB.toString());
		System.out.println("Salario anual: €" + empleadoB.calculoSalarioAnual());
	}
}
