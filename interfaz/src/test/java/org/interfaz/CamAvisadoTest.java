/**
 * 
 */
package org.interfaz;

import static org.junit.Assert.*;

import java.awt.Component;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Alberto
 *
 */
public class CamAvisadoTest {

	private final CamAvisado ca = new CamAvisado();
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link java.awt.Dialog#setVisible(boolean)}.
	 */
	@Test
	public void testSetVisible() {
		assertEquals(true,ca.isVisible());
	}

	@Test
	public void testJLabel() {
		for(Component c : ca.getContentPane().getComponents()) {
			if (c instanceof JLabel) {
				assertEquals("Los camareros han sido avisados satisfactoriamente",((JLabel) c).getText());
			}
		}
	}

	@Test
	public void testJButton() {
		for(Component c : ca.getContentPane().getComponents()) {
			if (c instanceof JButton) {
				assertEquals("OK",((JButton) c).getText());
			}
		}
	}
	
}
