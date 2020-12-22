package org.dominio;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestComanda {

	// int idRestaurante, ArrayList<Bebida> bebidas,
	// ArrayList<Plato> entrantes, ArrayList<Plato> primerPlato, ArrayList<Plato>
	// segundoPlato,
	// ArrayList<Plato> postre, int idMesa

	static Comanda c;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		c = new Comanda(3, null, null, null, null, null, 3);
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
	public final void testSetIdMesa() {
		assertEquals(3, c.getIdMesa());
		c.setIdMesa(1);
	}

	@Test
	public final void testGetIdMesa() {
		assertEquals(1, c.getIdMesa());
	}

	@Test
	public final void testSetIdComanda() {
		c.setIdComanda(5);
		assertEquals(5, c.getIdComanda());
		c.setIdComanda(1);
	}

	@Test
	public final void testGetIdComanda() {
		assertEquals(1, c.getIdComanda());
	}

}
