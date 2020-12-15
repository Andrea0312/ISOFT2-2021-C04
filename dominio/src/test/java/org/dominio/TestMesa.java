package org.dominio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMesa {

	static Mesa m;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		m = new Mesa (3, null, null, 6, 0);
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
		assertEquals(3, m.getID());
	}

	@Test
	public final void testSetID() {
		m.setID(1);
		assertEquals(1, m.getID());
	}

	@Test
	public final void testGetN_Comensales() {
		assertEquals(6, m.getN_Comensales());
	}

	@Test
	public final void testSetN_Comensales() {
		m.setN_Comensales(2);
		assertEquals(2, m.getN_Comensales());
	}

}
