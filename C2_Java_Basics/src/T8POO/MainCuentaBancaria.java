package T8POO;

public class MainCuentaBancaria {

	public static void main(String[] args) {

		CuentaBancaria cuentaBanc1 = new CuentaBancaria();
        CuentaBancaria cuentaBanc2 = new CuentaBancaria();

        cuentaBanc1.ingresar(1200); 
        cuentaBanc1.retirar(700);   
        double saldoFinal1 = cuentaBanc1.consultarSaldoFinal(); 

        cuentaBanc2.ingresar(2000); 
        cuentaBanc2.retirar(200);
        double saldoFinal2 = cuentaBanc2.consultarSaldoFinal(); 

        System.out.println("================================================");
		System.out.println("·· Saldo de la primera cuenta ··");
        System.out.println("El saldo final de la primera cuenta es: " + saldoFinal1 + " €.");
        System.out.println("================================================");
		System.out.println("·· Saldo de la segunda cuenta ··");
        System.out.println("El saldo final de la segunda cuenta es: " + saldoFinal2 + " €.");
    }

}
