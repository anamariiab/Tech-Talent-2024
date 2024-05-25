package T21JUnit.Ejercicio1;

import java.util.ArrayList;

public class PascalCalculator {
    private ArrayList<String> historialCalculos;

    public PascalCalculator() {
        historialCalculos = new ArrayList<>();
    }

    public double sumar(double num1, double num2) {
        double resultado = num1 + num2;
        agregarAlHistorial(num1, "+", num2, resultado);
        return resultado;
    }

    public double restar(double num1, double num2) {
        double resultado = num1 - num2;
        agregarAlHistorial(num1, "-", num2, resultado);
        return resultado;
    }

    public double multiplicar(double num1, double num2) {
        double resultado = num1 * num2;
        agregarAlHistorial(num1, "*", num2, resultado);
        return resultado;
    }

    public double dividir(double num1, double num2) {
        if (num2 != 0) {
            double resultado = num1 / num2;
            agregarAlHistorial(num1, "/", num2, resultado);
            return resultado;
        } else {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
    }

    public double calcularPorcentaje(double num1, double num2) {
        double resultado = (num1 * num2) / 100;
        agregarAlHistorial(num1, "%", num2, resultado);
        return resultado;
    }

    public void agregarAlHistorial(double num1, String operador, double num2, double resultado) {
        String calculo = num1 + " " + operador + " " + num2 + " = " + resultado;
        historialCalculos.add(calculo);
    }

    public ArrayList<String> getHistorialCalculos() {
        return historialCalculos;
    }
}