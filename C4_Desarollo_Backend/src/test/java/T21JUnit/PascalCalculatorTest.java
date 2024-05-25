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

	    @Test
	    public void testSumar() {
	        double resultado = calculator.sumar(5, 3);
	        assertEquals(8, resultado, "La suma de 5 y 3 debe ser 8.");
	    }

	    @Test
	    public void testRestar() {
	        double resultado = calculator.restar(10, 4);
	        assertEquals(6, resultado, "La resta de 10 y 4 debe ser 6."); 
	    }

	    @Test
	    public void testMultiplicar() {
	        double resultado = calculator.multiplicar(6, 4);
	        assertEquals(24, resultado, "La multiplicación de 6 y 4 debe ser 24."); 
	    }

	    @Test
	    public void testDividir() {
	        double resultado = calculator.dividir(10, 2);
	        assertEquals(5, resultado, "La división de 10 entre 2 debe ser 5."); 
	    }

	    @Test
	    public void testCalcularPorcentaje() {
	        double resultado = calculator.calcularPorcentaje(80, 25);
	        assertEquals(20, resultado, "El 25% de 80 debe ser 20.");
	    }
	}