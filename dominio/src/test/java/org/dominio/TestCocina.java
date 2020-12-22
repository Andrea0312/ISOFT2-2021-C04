package org.dominio;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCocina {

	static Cocina c;
	static ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	static ArrayList<Ingrediente> ingredientes1 = new ArrayList<Ingrediente>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Ingrediente i1 = new Ingrediente(1, 5, 1, "Patata");
		Ingrediente i2 = new Ingrediente(2, 20, 2, "Lechuga");
		ingredientes.add(i1);
		ingredientes.add(i2);
		c = new Cocina(1, 1, 1, ingredientes);
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
	public final void testSetIdCocina() {
		assertEquals(1, c.getIdCocina());
		c.setIdCocina(5);
	}

	@Test
	public final void testGetIdCocina() {
		assertEquals(5, c.getIdCocina());
	}

	@Test
	public final void testSetIdAlmacen() {
		c.setIdAlmacen(5);
		assertEquals(5, c.getIdAlmacen());
	}

	@Test
	public final void testGetIdAlmacen() {
		assertEquals(1, c.getIdAlmacen());
	}

	@Test
	public final void testSetIdRestaurante() {
		c.setIdRestaurante(5);
		assertEquals(5, c.getIdRestaurante());
	}

	@Test
	public final void testGetIdRestaurante() {
		assertEquals(1, c.getIdRestaurante());
	}

	@Test
	public final void testSetIngredientes() {
		c.setIngredientes(ingredientes1);
		assertEquals(ingredientes1, c.getIngredientes());
	}

	@Test
	public final void testGetIngredientes() {
		assertEquals(ingredientes, c.getIngredientes());
	}
}
