package T8POO;

public class CuentaBancaria {

	private String numeroCuenta;
	private double saldo;

	public CuentaBancaria() {

		this.numeroCuenta = " ";
		this.saldo = 0.0;
	}

	public CuentaBancaria(String numeroCuenta, double saldo) {

		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
	}

	public void ingresar(double cantidad) {

		if (cantidad >= 0) {
			saldo += cantidad;
			System.out.println("Has ingresado " + cantidad + " a tu cuenta bancaria.");
		}
	}

	public void retirar(double cantidad) {

		if (cantidad >= 0) {
			saldo -= cantidad;
			System.out.println("Has retirado " + cantidad + " de tu cuenta bancaria.");
		} else {
			System.out.println("No dospones de suficentes fondos!");
		}
	}

	public double consultarSaldoFinal() {
		return saldo;

	}
	
	@Override
	public String toString() {
        return "Numero cuenta: " + numeroCuenta + "\nSaldo actual: " + saldo;
    }

}
