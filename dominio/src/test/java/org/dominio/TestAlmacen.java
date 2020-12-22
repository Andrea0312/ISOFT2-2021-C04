package org.dominio;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestAlmacen {

	static Almacen a;
	static ArrayList<Bebida> bebidas = new ArrayList<Bebida>();
	static ArrayList<Bebida> bebidas1 = new ArrayList<Bebida>();
	static ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	static ArrayList<Ingrediente> ingredientes1 = new ArrayList<Ingrediente>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		a = new Almacen(1, 1, bebidas, ingredientes);
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
	public final void testSetIdAlmacen() {
		a.setIdAlmacen(5);
		assertEquals(5, a.getIdAlmacen());
	}

	@Test
	public final void testGetIdAlmacen() {
		assertEquals(1, a.getIdAlmacen());
	}

	@Test
	public final void testSetIdRestaurante() {
		a.setIdRestaurante(5);
		assertEquals(5, a.getIdRestaurante());
	}

	@Test
	public final void testGetIdRestaurante() {
		assertEquals(1, a.getIdRestaurante());
	}

	@Test
	public final void testSetBebidas() {
		assertEquals(bebidas, a.getBebidas());
		a.setBebidas(bebidas1);
	}

	@Test
	public final void testGetBebidas() {
		assertEquals(bebidas1, a.getBebidas());
	}

	@Test
	public final void testSetIngredientes() {
		assertEquals(ingredientes, a.getIngredientes());
		a.setIngredientes(ingredientes1);
	}

	@Test
	public final void testGetIngredientes() {
		assertEquals(ingredientes1, a.getIngredientes());
	}
}
