package org.dominio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestEmpleado {

	static Empleado e;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		e = new Empleado (4, null, "Luis", "Patiño", "632457812");
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
	public final void testGetID() {
		assertEquals(4, e.getID());
	}

	@Test
	public final void testSetID() {
		e.setID(5);
		assertEquals(5, e.getID());
	}

	@Test
	public final void testGetNombre() {
		assertEquals("Miguel", e.getNombre());
	}

	@Test
	public final void testSetNombre() {
		assertEquals("Luis", e.getNombre());
		e.setNombre("Miguel");
	}

	@Test
	public final void testGetTelefono() {
		assertEquals("632457812", e.getTelefono());
	}

	@Test
	public final void testSetTelefono() {
		e.setTelefono("632457812");
		assertEquals("632457812", e.getTelefono());
	}

}
