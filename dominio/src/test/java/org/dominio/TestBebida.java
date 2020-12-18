package org.dominio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestBebida {
	
	static Bebida bebida;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bebida = new Bebida(1, 2.25, 2, 2, "Coca Cola");
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
	public final void testGetIdBebida() {
		assertEquals(4, bebida.getIdBebida());
	}

	@Test
	public final void testSetIdBebida() {
		assertEquals(1, bebida.getIdBebida());
		bebida.setIdBebida(4);
	}

	@Test
	public final void testGetCantidad() {
		assertEquals(5, bebida.getCantidad());

	}

	@Test
	public final void testSetCantidad() {
		assertEquals(2, bebida.getCantidad());
		bebida.setCantidad(5);
	}
	@Test
	public final void testGetNombre() {
		assertEquals("Fanta", bebida.getNombre());
	}
	@Test
	public final void testSetNombre() {
		assertEquals("Coca Cola", bebida.getNombre());
		bebida.setNombre("Fanta");
	}


}
