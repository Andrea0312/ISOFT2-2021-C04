package org.dominio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestComanda {

	static Comanda c;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		c = new Comanda (3, null, null, null, null, null, 3);
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
	public final void testGetIdMesa() {
		assertEquals(1, c.getIdComanda());
	}

	@Test
	public final void testSetIdMesa() {
		assertEquals(3, c.getIdComanda());
		c.setIdComanda(1);
	}

	@Test
	public final void testSetIdComanda() {
		assertEquals(3, c.getIdMesa());
		c.setIdMesa(5);
	}

	@Test
	public final void testGetIdComanda() {
		assertEquals(5, c.getIdMesa());
	}

}
