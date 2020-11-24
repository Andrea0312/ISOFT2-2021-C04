package CDU1.CDU1.Interfaz;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import CDU1.CDU1.Dominio.CamareroBarra;
import CDU1.CDU1.Dominio.CamareroMesa;
import CDU1.CDU1.Dominio.JefeSala;
import CDU1.CDU1.Dominio.Mesa;
import CDU1.CDU1.Dominio.Restaurante;
import CDU1.CDU1.Persistencia.CamareroBarraDAO;
import CDU1.CDU1.Persistencia.CamareroMesaDAO;
import CDU1.CDU1.Persistencia.JefeSalaDAO;
import CDU1.CDU1.Persistencia.MesaDAO;
import CDU1.CDU1.Persistencia.RestauranteDAO;


import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CambiarEstadoMesa {

	private JFrame frame;
	private JTextField textFieldIDMesa;
	private JTextField MesaIDtextField;
	private ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();
	private ArrayList<CamareroMesa> camarerosMesa = new ArrayList<CamareroMesa>();
	private ArrayList<CamareroBarra> camarerosBarra = new ArrayList<CamareroBarra>();
	private ArrayList<JefeSala> jefesSala = new ArrayList<JefeSala>();
	private ArrayList<Mesa> mesas = new ArrayList<Mesa>();

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { CambiarEstadoMesa window = new
	 * CambiarEstadoMesa(); window.frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	/**
	 * Create the application.
	 */
	public CambiarEstadoMesa() {
		GenerarRestaurantes();
		GenerarMesas();
		GenerarCamarerosMesa();
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

		final JComboBox comboBoxEstados = new JComboBox();
		comboBoxEstados.setModel(new DefaultComboBoxModel(new String[] { "Libre", "Reservada", "Ocupada", "Pidiendo",
				"En espera de comida", "Servidos", "Esperando la cuenta", "Pagando", "En preparacion" }));

		JLabel lblSeleccioneElEstado = new JLabel("Seleccione el estado:");

		final JLabel labelEstado = new JLabel("");
		JButton btnAceptar = new JButton("Aceptar");

		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idMesa = MesaIDtextField.getText();
				int idM = Integer.parseInt(idMesa);
				String estadoCadena = (String) comboBoxEstados.getSelectedItem().toString(); // COMPROBAR SI EL FINAL
																								// ESTÁ BIEN
				int estado = MesaDAO.ObtenerEstado(estadoCadena);
				try {
					Mesa mesa = MesaDAO.SelectMesaPorID(idM);
					mesa.setEstadoMesa(estado);
					// ACTUALIZAR EN LA BBDD
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				labelEstado.setText("Estado actualizado correctamente");
			}
		});

		JTextArea textArea = new JTextArea();
		textArea.setText(MesaDAO.CadenaMesas(mesas));
		textArea.setEditable(false);

		JLabel lblListadoDeMesas = new JLabel("Listado de mesas:");

		textFieldIDMesa = new JTextField();
		textFieldIDMesa.setColumns(10);

		JLabel lblIdMesa = new JLabel("ID Mesa:");

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(319, Short.MAX_VALUE)
						.addComponent(btnAceptar).addGap(75))
				.addGroup(Alignment.LEADING,
						groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(
										Alignment.LEADING,
										groupLayout.createSequentialGroup().addGap(29)
												.addGroup(groupLayout
														.createParallelGroup(Alignment.LEADING)
														.addComponent(lblSeleccioneElEstado)
														.addComponent(comboBoxEstados, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup().addGap(18)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addGroup(groupLayout
																.createSequentialGroup().addComponent(labelEstado)
																.addGap(99))
														.addGroup(Alignment.LEADING,
																groupLayout.createSequentialGroup().addGap(10)
																		.addGroup(groupLayout
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(lblListadoDeMesas,
																						GroupLayout.PREFERRED_SIZE, 122,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(textArea))))))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(textFieldIDMesa, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblIdMesa, GroupLayout.PREFERRED_SIZE, 122,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap(208, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(25)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSeleccioneElEstado).addComponent(lblIdMesa))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxEstados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldIDMesa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18).addComponent(lblListadoDeMesas).addGap(13)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE).addComponent(labelEstado)
						.addGap(49))
				.addGroup(groupLayout.createSequentialGroup().addGap(79).addComponent(btnAceptar).addContainerGap(164,
						Short.MAX_VALUE)));
		frame.getContentPane().setLayout(groupLayout);

	}

	public void GenerarRestaurantes() {
		try {
			RestauranteDAO.SelectTodosRestaurantes(restaurantes);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	public void GenerarMesas() {
		try {
			MesaDAO.SelectTodasMesas(mesas);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	public void GenerarCamarerosBarra() {
		try {
			CamareroBarraDAO.SelectTodosCamarerosBarra(camarerosBarra);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	public void GenerarCamarerosMesa() {
		try {
			CamareroMesaDAO.SelectTodosCamarerosMesa(camarerosMesa);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	public void GenerarJefesSala() {
		try {
			JefeSalaDAO.SelectTodosJefesSala(jefesSala);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
