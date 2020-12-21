package org.interfaz;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class POVJefeSala {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
/*
 * public static void main(String[] args) { EventQueue.invokeLater(new
 * Runnable() { public void run() { try { POVJefeSala window = new
 * POVJefeSala(); window.frame.setVisible(true); } catch (Exception e) {
 * e.printStackTrace(); } } }); }
 */
	/**
	 * Create the application.
	 */
	public POVJefeSala() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 523, 335);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAsignarCamarero = new JButton("Asignar camarero a mesa");
		btnAsignarCamarero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AsignarCamarero();
			}
		});
		btnAsignarCamarero.setBounds(23, 92, 186, 57);
		frame.getContentPane().add(btnAsignarCamarero);
		
		JButton btnReservarMesa = new JButton("Reservar mesas");
		btnReservarMesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservarMesa reservarMesa = new ReservarMesa();
				reservarMesa.setVisible(true);
			}
		});
		btnReservarMesa.setBounds(23, 200, 186, 57);
		frame.getContentPane().add(btnReservarMesa);
	}

}