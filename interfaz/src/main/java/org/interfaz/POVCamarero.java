package org.interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class POVCamarero {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					POVCamarero window = new POVCamarero();
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
	public POVCamarero(boolean camareroAvisado) {
		initialize(camareroAvisado);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(boolean camareroAvisado) {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 596, 449);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCambiarEstadoMesa = new JButton("Cambiar estado mesa");
		btnCambiarEstadoMesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CambiarEstadoMesa window = new CambiarEstadoMesa();
			}
		});
		btnCambiarEstadoMesa.setBounds(23, 99, 183, 50);
		frame.getContentPane().add(btnCambiarEstadoMesa);
		
		JLabel iconAlarma = new JLabel("");
		
		iconAlarma.setEnabled(false);
		iconAlarma.setIcon(new ImageIcon(POVCamarero.class.getResource("/org/interfaz/alarma.png")));
		iconAlarma.setBounds(433, 0, 133, 128);
		frame.getContentPane().add(iconAlarma);
		if(camareroAvisado) {
			iconAlarma.setEnabled(true);
		}
		JLabel lblAvisoDeCocina = new JLabel("Aviso de cocina");
		lblAvisoDeCocina.setBounds(455, 133, 98, 16);
		frame.getContentPane().add(lblAvisoDeCocina);
	}

}
