package org.dominio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestIngrediente {
	
	static Ingrediente i;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		i= new Ingrediente (2, 3, 1,"Zanahoria");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetCantidad() {
		assertEquals(6, i.getCantidad());
	}

	@Test
	public final void testSetCantidad() {
		assertEquals(3, i.getCantidad());
		i.setCantidad(6);
	}

	@Test
	public final void testGetIdRestaurante() {
		assertEquals(2, i.getIdRestaurante());
	}

	@Test
	public final void testSetIdRestaurante() {

		assertEquals(1, i.getIdRestaurante());
		i.setIdRestaurante(2);
	}

	@Test
	public final void testGetNombre() {
		assertEquals("Tomate", i.getNombre());
	}

	@Test
	public final void testSetNombre() {
		assertEquals("Zanahoria", i.getNombre());
		i.setNombre("Tomate");
	}

}
