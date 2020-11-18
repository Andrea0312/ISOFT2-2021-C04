package CDU1.CDU1.Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JInternalFrame;
import java.awt.Checkbox;
import javax.swing.Box;
import java.awt.Panel;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CambiarEstadoMesa {

	private JFrame frame;
	private JTextField textFieldIDMesa;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CambiarEstadoMesa window = new CambiarEstadoMesa();
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
	public CambiarEstadoMesa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);

		frame.setBounds(100, 100, 559, 410);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JComboBox comboBoxEstados = new JComboBox();
		comboBoxEstados.setModel(new DefaultComboBoxModel(new String[] {"Libre", "Reservada", "Ocupada", "Pidiendo", "En espera de comida", "Servidos", "Esperando la cuenta", "Pagando", "En preparacion"}));
		
		JLabel lblSeleccioneElEstado = new JLabel("Seleccione el estado:");
		
		final JLabel labelEstado = new JLabel("");
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelEstado.setText("Estado actualizado correctamente");
			}
		});
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		
		JLabel lblListadoDeMesas = new JLabel("Listado de mesas:");
		
		textFieldIDMesa = new JTextField();
		textFieldIDMesa.setColumns(10);
		
		JLabel lblIdMesa = new JLabel("ID Mesa:");
		
	
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(319, Short.MAX_VALUE)
					.addComponent(btnAceptar)
					.addGap(75))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSeleccioneElEstado)
								.addComponent(comboBoxEstados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(labelEstado)
									.addGap(99))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblListadoDeMesas, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
										.addComponent(textArea))))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textFieldIDMesa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIdMesa, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(208, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSeleccioneElEstado)
						.addComponent(lblIdMesa))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxEstados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldIDMesa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblListadoDeMesas)
					.addGap(13)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addComponent(labelEstado)
					.addGap(49))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(79)
					.addComponent(btnAceptar)
					.addContainerGap(164, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	
	

}
}
