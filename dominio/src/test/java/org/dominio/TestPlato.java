package org.dominio;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPlato {

	static Plato p;
	static ArrayList<Ingrediente> ingredientes;
	static Ingrediente i1;
	static Ingrediente i2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		i1 = new Ingrediente (1, 3, 1, "Champiñon");
		ingredientes.add(i1);
		i2 = new Ingrediente (2, 1, 2, "Queso");
		ingredientes.add(i2);
		p = new Plato(1, 10.5, ingredientes, "Pizza", 3);
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
	public final void testGetIdPlato() {
		assertEquals(3, p.getIdPlato());
	}

	@Test
	public final void testSetIdPlato() {
		assertEquals(1, p.getIdPlato());
		p.setIdPlato(3);
	}

	@Test
	public final void testGetIngredientes() {
		assertEquals(ingredientes, p.getIngredientes());
	}

	@Test
	public final void testGetNombre() {
		assertEquals("Tiras", p.getNombre());
	}
	
	@Test
	public final void testSetNombre() {
		assertEquals("Pizza", p.getNombre());
		p.setNombre("Tiras");
	}

}
