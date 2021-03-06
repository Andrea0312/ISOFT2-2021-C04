package org.interfaz;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.dominio.CamareroBarra;
import org.dominio.CamareroMesa;
import org.dominio.JefeSala;
import org.dominio.Mesa;
import org.dominio.Restaurante;
import org.persistencia_M1.CamareroBarraDAO;
import org.persistencia_M1.CamareroMesaDAO;
import org.persistencia_M1.JefeSalaDAO;
import org.persistencia_M1.MesaDAO;
import org.persistencia_M1.RestauranteDAO;
import org.persistencia_M5.EstadisticasDAO;

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
	private Restaurante restauranteElegido;
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

		JLabel lblSeleccioneElEstado = new JLabel("Seleccione el estado:");

		final JLabel labelEstado = new JLabel("");
		JButton btnAceptar = new JButton("Aceptar");

		JTextArea textArea = new JTextArea();
		textArea.setText(MesaDAO.CadenaMesas(mesas));
		textArea.setEditable(false);

		JLabel lblListadoDeMesas = new JLabel("Listado de mesas:");

		textFieldIDMesa = new JTextField();
		textFieldIDMesa.setColumns(10);

		JLabel lblIdMesa = new JLabel("ID Mesa:");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idMesa = textFieldIDMesa.getText();
				int idM = Integer.parseInt(idMesa);

				try {
					System.out.println(idM);
					Mesa mesa = MesaDAO.SelectMesaPorID(idM);
					mesa.cambiarEstadoMesa();
					MesaDAO.UpdateMesaEstado(mesa);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				labelEstado.setText("Estado actualizado correctamente");
			}
		});
		
		JButton btnEnviarEstadisticas = new JButton("Enviar estadisticas");
		btnEnviarEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					restauranteElegido = EstadisticasDAO.SelectRestaurantePorID(2);
					double tiempoNota = restauranteElegido.getTiempoEntregaNota();
					double tiempoLibre = restauranteElegido.getTiempoMesaLire();
					double tiempoPreparacion = restauranteElegido.getTiempoPrepComida();
					double tiempoComandas = restauranteElegido.getTiempoTomaComandas();
					
					EstadisticasDAO.enviarEstadistica(2, tiempoNota, tiempoLibre, tiempoPreparacion, tiempoComandas);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSeleccioneElEstado)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(labelEstado)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textArea)
										.addComponent(lblListadoDeMesas, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))))))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(textFieldIDMesa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIdMesa, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(236, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnEnviarEstadisticas)
								.addContainerGap())
							.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addComponent(btnAceptar)
								.addGap(75)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSeleccioneElEstado)
						.addComponent(lblIdMesa))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldIDMesa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblListadoDeMesas)
					.addGap(13)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addComponent(labelEstado)
					.addGap(49))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(79)
					.addComponent(btnAceptar)
					.addGap(18)
					.addComponent(btnEnviarEstadisticas)
					.addContainerGap(228, Short.MAX_VALUE))
		);
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
