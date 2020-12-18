package org.interfaz;


import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.BevelBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class VistaCuenta extends JPanel {

	/**
	 * Create the panel.
	 */
	public VistaCuenta(String nombre, String precio) {
		
		addMouseListener(new ThisMouseListener());
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{45, 97, 119, 0, 0};
		gridBagLayout.rowHeights = new int[]{30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel nombrePlato = new JLabel(nombre);
		nombrePlato.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_nombrePlato = new GridBagConstraints();
		gbc_nombrePlato.anchor = GridBagConstraints.WEST;
		gbc_nombrePlato.insets = new Insets(0, 0, 0, 5);
		gbc_nombrePlato.gridx = 1;
		gbc_nombrePlato.gridy = 0;
		add(nombrePlato, gbc_nombrePlato);
		
		JLabel addPlato = new JLabel(precio);
		addPlato.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_addPlato = new GridBagConstraints();
		gbc_addPlato.insets = new Insets(0, 0, 0, 5);
		gbc_addPlato.anchor = GridBagConstraints.EAST;
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
