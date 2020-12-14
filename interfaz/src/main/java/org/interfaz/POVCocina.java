package org.interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class POVCocina {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					POVCocina window = new POVCocina();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
	 */
	public POVCocina() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAvisarCamarero = new JButton("Avisar camarero");
		btnAvisarCamarero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio.camareroAvisado=true;
				CamAvisado aviso = new CamAvisado();
			}
		});
		btnAvisarCamarero.setBounds(12, 82, 153, 44);
		frame.getContentPane().add(btnAvisarCamarero);
	}

}
