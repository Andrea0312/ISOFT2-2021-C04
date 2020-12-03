package org.interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

import org.dominio.Mesa;
import org.dominio.CamareroBarra;
import org.dominio.CamareroMesa;
import org.dominio.Restaurante;

import org.persistencia_M1.MesaDAO;
import org.persistencia_M1.CamareroBarraDAO;
import org.persistencia_M1.CamareroMesaDAO;



public class AsignarCamarero {

	private JFrame frame;
	private JTextField MesaIDtextField;
	private JTextField CamareroIDtextField;
	private ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();
	private ArrayList<CamareroMesa> camarerosMesa = new ArrayList<CamareroMesa>();
	private ArrayList<CamareroBarra> camarerosBarra = new ArrayList<CamareroBarra>();
	private ArrayList<Mesa> mesas = new ArrayList<Mesa>();

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { AsignarCamarero window = new
	 * AsignarCamarero();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } } }); }
	 */
	/**
	 * Create the application.
	 */
	public AsignarCamarero() {

		GenerarCamarerosMesa();
		GenerarMesas();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 600, 385);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblListadoDeMesas = new JLabel("Listado de mesas:");
		lblListadoDeMesas.setBounds(10, 34, 104, 16);
		frame.getContentPane().add(lblListadoDeMesas);

		JLabel lblListadoDeCamareros = new JLabel("Listado de camareros:");
		lblListadoDeCamareros.setBounds(168, 34, 128, 16);
		frame.getContentPane().add(lblListadoDeCamareros);

		JLabel lblIdMesa = new JLabel("ID Mesa:");
		lblIdMesa.setBounds(309, 95, 56, 16);

		frame.getContentPane().add(lblIdMesa);

		JLabel lblIdCamarero = new JLabel("ID Camarero:");
		lblIdCamarero.setBounds(309, 141, 78, 16);
		frame.getContentPane().add(lblIdCamarero);

		JTextArea MesastextArea = new JTextArea();
		MesastextArea.setEditable(false);
		MesastextArea.setBounds(10, 73, 104, 161);
		MesastextArea.setText(MesaDAO.CadenaMesas(mesas));
		frame.getContentPane().add(MesastextArea);

		JTextArea CamarerostextArea = new JTextArea();
		CamarerostextArea.setEditable(false);
		CamarerostextArea.setBounds(168, 73, 104, 161);
		CamarerostextArea.setText(CamareroMesaDAO.CadenaCamarerosMesa(camarerosMesa));
		frame.getContentPane().add(CamarerostextArea);

		MesaIDtextField = new JTextField();
		MesaIDtextField.setBounds(389, 92, 116, 22);
		frame.getContentPane().add(MesaIDtextField);
		MesaIDtextField.setColumns(10);

		CamareroIDtextField = new JTextField();
		CamareroIDtextField.setBounds(399, 138, 116, 22);
		frame.getContentPane().add(CamareroIDtextField);
		CamareroIDtextField.setColumns(10);

		final JLabel labelEstado = new JLabel("");
		labelEstado.setBackground(UIManager.getColor("Button.background"));
		labelEstado.setBounds(45, 267, 403, 58);
		frame.getContentPane().add(labelEstado);

		JButton btnAsignar = new JButton("Asignar");
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String idMesa = MesaIDtextField.getText();
				String idCamarero = CamareroIDtextField.getText();
				int idM = Integer.parseInt(idMesa);
				int idC = Integer.parseInt(idCamarero);
				try {
					Mesa mesa = MesaDAO.SelectMesaPorID(idM);
					CamareroMesa camareroMesa =  CamareroMesaDAO.SelectCamareroMesaPorID(idC);
					mesa.setCamareroMesa(camareroMesa);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				MesaDAO.UpdateMesaCamarero(mesas);
				labelEstado.setText("Asignado correctamente"); // if existian ambos IDs, si no habrá q mostrar error
			}
		});
		btnAsignar.setBounds(327, 209, 97, 25);
		frame.getContentPane().add(btnAsignar);

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
}
