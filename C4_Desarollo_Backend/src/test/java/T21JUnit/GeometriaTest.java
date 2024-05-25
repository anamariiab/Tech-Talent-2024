package T21JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import T21JUnit.Ejercicio1.Geometria;
import T21JUnit.Ejercicio1.PascalCalculator;

class GeometriaTest {

	private Geometria geometria;

	@BeforeEach
	public void setUp() {
		geometria = new Geometria();
	}

	@Test
	public void testAreaCuadrado() {
		int lado = 5;
		int resultadoEsperado = 25;
		assertEquals(resultadoEsperado, geometria.areacuadrado(lado), "El área del cuadrado con lado 5 debe ser 25.");
	}

	@Test
	public void testAreaTriangulo() {
		int base = 4;
		int altura = 6;
		int areaEsperada = 12;
		int areaCalculada = geometria.areatriangulo(base, altura);
		assertEquals(areaEsperada, areaCalculada, "El área de un triángulo de base 4 y altura 6 debe ser 12.");

	}

	@Test
	public void testAreaPentagono() {
		int perimetro = 20;
		int apotema = 4;
		int areaEsperada = 40;
		int areaCalculada = geometria.areapentagono(perimetro, apotema);
		assertEquals(areaEsperada, areaCalculada, "El área de un pentágono con perímetro 20 y apotema 4 debe ser 40.");
	}
	
	@Test
    public void testAreaRomboide() {
        int base = 5;
        int altura = 10;
        int areaEsperada = 50;
        int areaCalculada = geometria.arearomboide(base, altura);
        assertEquals(areaEsperada, areaCalculada, "El área de un romboide con base 5 y altura 10 debe ser 50.");
    }

}
