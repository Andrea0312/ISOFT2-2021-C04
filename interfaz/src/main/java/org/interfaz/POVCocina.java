package org.interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.dominio.Ingrediente;
import org.dominio.Restaurante;
import org.persistencia_M4.IngredienteADAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class POVCocina {

	private JFrame frame;
	private ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();

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
		
		JButton btnActualizarAlmacen = new JButton("Actualizar Almacen");
		btnActualizarAlmacen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int umbralCantidad = 5;
				ingredientes = IngredienteADAO.obtenerIngredientes(1, 3);
				for(int i=0; i<ingredientes.size(); i++ ) {
					if (ingredientes.get(i).getCantidad()<=umbralCantidad)
						IngredienteADAO.aprovisionarIngredientes(1, ingredientes.get(i).getIdIngrediente());
				}
			}
		});
		
		
		
		btnActualizarAlmacen.setBounds(12, 162, 153, 44);
		frame.getContentPane().add(btnActualizarAlmacen);
	}
}
