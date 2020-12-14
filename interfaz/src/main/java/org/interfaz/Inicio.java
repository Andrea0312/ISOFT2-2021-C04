package org.interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio {

	private JFrame frame;
	static boolean camareroAvisado = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 607, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnJefeDeSala = new JButton("Jefe de sala");
		btnJefeDeSala.setBounds(55, 96, 138, 67);
		frame.getContentPane().add(btnJefeDeSala);
		btnJefeDeSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				POVJefeSala JefSala = new POVJefeSala();
			}
		});
		
		JButton btnCocina = new JButton("Cocina");
		btnCocina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				POVCocina Cocina = new POVCocina();
			}
		});
		btnCocina.setBounds(55, 207, 138, 61);
		frame.getContentPane().add(btnCocina);
		
		JButton btnCamarero = new JButton("Camarero");
		btnCamarero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				POVCamarero cam = new POVCamarero(camareroAvisado);
			}
		});
		btnCamarero.setBounds(323, 97, 138, 65);
		frame.getContentPane().add(btnCamarero);
		
		JLabel lblElijaLaVista = new JLabel("Elija la vista del actor deseado:");
		lblElijaLaVista.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblElijaLaVista.setBounds(179, 27, 237, 16);
		frame.getContentPane().add(lblElijaLaVista);
	}
}