package isoft_c04.cd2.Presentacion_GestionComanda;


import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

import isoft_c04.cd2.Dominio_GestionComanda.Plato;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class vistaPlato extends JPanel {

	/**
	 * Create the panel.
	 */
	public vistaPlato(Plato plato) {
		
		addMouseListener(new ThisMouseListener());
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{64, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel txt_plato = new JLabel("Plato: ");
		GridBagConstraints gbc_txt_plato = new GridBagConstraints();
		gbc_txt_plato.anchor = GridBagConstraints.EAST;
		gbc_txt_plato.fill = GridBagConstraints.VERTICAL;
		gbc_txt_plato.insets = new Insets(0, 0, 0, 5);
		gbc_txt_plato.gridx = 0;
		gbc_txt_plato.gridy = 0;
		add(txt_plato, gbc_txt_plato);
		
		JLabel nombrePlato = new JLabel(plato.getNombre());
		GridBagConstraints gbc_nombrePlato = new GridBagConstraints();
		gbc_nombrePlato.insets = new Insets(0, 0, 0, 5);
		gbc_nombrePlato.gridx = 1;
		gbc_nombrePlato.gridy = 0;
		add(nombrePlato, gbc_nombrePlato);
		
		JButton addPlato = new JButton("Añadir");
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
