package org.dominio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRestaurante {

	static Restaurante r;
	static Empleado e1;
	static Empleado e2;
	static Empleado[] empleados;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		e1 = new Empleado(1, null, "Fernando", "Torres", "654578756");
		e2 = new Empleado(2, null, "Laura", "Torres", "658558556");
		Empleado[] empleados = { e1, e2 };
		r = new Restaurante(0, "Mafia", "Ciudad Real", empleados, null);
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
		assertEquals(0, r.getID());
	}

	@Test
	public final void testSetID() {
		r.setID(5);
		assertEquals(5, r.getID());
	}

	@Test
	public final void testGetNombre() {
		assertEquals("Ginos", r.getNombre());
	}

	@Test
	public final void testSetNombre() {
		assertEquals("Mafia", r.getNombre());
		r.setNombre("Ginos");
	}

	@Test
	public final void testGetCiudad() {
		assertEquals("Toledo", r.getCiudad());
	}

	@Test
	public final void testSetCiudad() {
		assertEquals("Ciudad Real", r.getCiudad());
		r.setCiudad("Toledo");
	}

	@Test
	public final void testGetEmpleados() {
		r.setEmpleados(empleados);
		assertEquals(empleados, r.getEmpleados());
	}

	@Test
	public final void testSetTiempoTomaComandas() {
		r.setTiempoTomaComandas(5);
		assertEquals(5, r.getTiempoTomaComandas(), 0);
	}

	@Test
	public final void testGetTiempoTomaComandas() {
		assertEquals(0, r.getTiempoTomaComandas(), 0);
	}

	@Test
	public final void testGetTiempoPrepComida() {
		r.setTiempoPrepComida(5);
		assertEquals(5, r.getTiempoPrepComida(), 0);
	}

	@Test
	public final void testSetTiempoPrepComida() {
		assertEquals(0, r.getTiempoPrepComida(), 0);
	}

	@Test
	public final void testGetTiempoEntregaNota() {
		r.setTiempoEntregaNota(5);
		assertEquals(5, r.getTiempoEntregaNota(), 0);
	}

	@Test
	public final void testSetTiempoEntregaNota() {
		assertEquals(0, r.getTiempoEntregaNota(), 0);
	}

	@Test
	public final void testGetTiempoMesaLire() {
		r.setTiempoMesaLire(5);
		assertEquals(5, r.getTiempoMesaLire(), 0);
	}

	@Test
	public final void testSetTiempoMesaLire() {
		assertEquals(0, r.getTiempoMesaLire(), 0);
	}
}
