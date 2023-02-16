package uf2181;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FuncionesDGTTest {
	private static FuncionesDGT funciones;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Iniciando tests...");
		funciones = new FuncionesDGT();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Test finalizados.");
	}

	@Test
	void testMediaPuntos() {
		int v1[] = {8,7,1,7,12,4};
		int v2[] = {0,0,0,0,0};
		int v3[] = {12,12,12,12};
		int v4[] = {};
		
		
		assertEquals(6.5,funciones.mediaPuntos(v1), "Error en el testeo: la media no se ha realizado correctamente.");
		assertEquals(0,funciones.mediaPuntos(v2), "Error en el testeo: la media no se ha realizado correctamente.");
		assertEquals(12,funciones.mediaPuntos(v3), "Error en el testeo: la media no se ha realizado correctamente.");
		assertThrows(ArrayIndexOutOfBoundsException.class, 
				()-> funciones.mediaPuntos(v4), "Error en el testeo: los vectores han de tener 6 de longitud");
		
	}

	@Test
	void testMaximaTasaPermitida() {
	 String tipoCondGeneral = "General";
	 String tipoCondNovel = "Novel";
	 
	 assertEquals(0.15, funciones.maximaTasaPermitida(tipoCondNovel, true));
	 assertEquals(0.3, funciones.maximaTasaPermitida(tipoCondNovel, false));
	 assertEquals(0.25, funciones.maximaTasaPermitida(tipoCondGeneral, true));
	 assertEquals(0.5, funciones.maximaTasaPermitida(tipoCondGeneral, false));
	}

}
