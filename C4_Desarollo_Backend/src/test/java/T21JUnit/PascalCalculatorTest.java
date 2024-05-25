package T21JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import T21JUnit.Ejercicio1.PascalCalculator;

class PascalCalculatorTest {

	   private PascalCalculator calculator;

	    @BeforeEach
	    public void setUp() {
	        calculator = new PascalCalculator();
	    }

	    public void testSumar() {
	        double num1 = 5;
	        double num2 = 3;
	        double resultadoEsperado = 8;
	        double resultadoCalculado = calculator.sumar(num1, num2);
	        assertEquals(resultadoEsperado, resultadoCalculado, "La suma de 5 y 3 debe ser 8.");
	    }

	    @Test
	    public void testRestar() {
	        double num1 = 10;
	        double num2 = 4;
	        double resultadoEsperado = 6;
	        double resultadoCalculado = calculator.restar(num1, num2);
	        assertEquals(resultadoEsperado, resultadoCalculado, "La resta de 10 y 4 debe ser 6.");
	    }

	    @Test
	    public void testMultiplicar() {
	    	double num1 = 6;
	        double num2 = 4;
	        double resultadoEsperado = 24;
	        double resultadoCalculado = calculator.multiplicar(num1, num2);
	        assertEquals(resultadoEsperado, resultadoCalculado, "La multiplicación de 6 y 4 debe ser 24.");
	    }

	    @Test
	    public void testDividir() {
	    	double num1 = 10;
	        double num2 = 2;
	        double resultadoEsperado = 5;
	        double resultadoCalculado = calculator.dividir(num1, num2);
	        assertEquals(resultadoEsperado, resultadoCalculado, "La división de 10 entre 2 debe ser 5.");
	    }

	    @Test
	    public void testCalcularPorcentaje() {
	    	double num1 = 80;
	        double num2 = 25;
	        double resultadoEsperado = 20;
	        double resultadoCalculado = calculator.calcularPorcentaje(num1, num2);
	        assertEquals(resultadoEsperado, resultadoCalculado, "El 25% de 80 debe ser 20.");
	    }
	}