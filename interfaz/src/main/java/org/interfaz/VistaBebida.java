package org.interfaz;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

import org.dominio.*;
import org.persistencia_M1.*;
import org.persistencia_M2.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;

public class VistaBebida extends JPanel {

	/**
	 * Create the panel.
	 */
	public VistaBebida(final Bebida bebida, final int idRestaurante, final Comanda comanda) {
		setMinimumSize(new Dimension(290, 40));
		setMaximumSize(new Dimension(290, 40));
		
		addMouseListener(new ThisMouseListener());
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{89, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel txt_bebida = new JLabel("Bebida: ");
		GridBagConstraints gbc_txt_bebida = new GridBagConstraints();
		gbc_txt_bebida.anchor = GridBagConstraints.EAST;
		gbc_txt_bebida.fill = GridBagConstraints.VERTICAL;
		gbc_txt_bebida.insets = new Insets(0, 0, 0, 5);
		gbc_txt_bebida.gridx = 0;
		gbc_txt_bebida.gridy = 0;
		add(txt_bebida, gbc_txt_bebida);
		
		JLabel nombreBebida = new JLabel(bebida.getNombre());
		GridBagConstraints gbc_nombreBebida = new GridBagConstraints();
		gbc_nombreBebida.anchor = GridBagConstraints.WEST;
		gbc_nombreBebida.insets = new Insets(0, 0, 0, 5);
		gbc_nombreBebida.gridx = 1;
		gbc_nombreBebida.gridy = 0;
		add(nombreBebida, gbc_nombreBebida);
		
		JButton addPlato = new JButton("Añadir");
		addPlato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comanda.getBebidas().add(bebida);
				BebidaDAO.eliminarUnaBebida(idRestaurante, bebida.getIdBebida());
			}
		});
		GridBagConstraints gbc_addPlato = new GridBagConstraints();
		gbc_addPlato.gridx = 2;
		gbc_addPlato.gridy = 0;
		add(addPlato, gbc_addPlato);

	}
	
	Color colorOriginal=getBackground();
	Color colorSeleccionar=new Color(250,250,190);
	
	private class ThisMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			setBackground(colorSeleccionar);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			setBackground(colorOriginal);
		}
	}
}
