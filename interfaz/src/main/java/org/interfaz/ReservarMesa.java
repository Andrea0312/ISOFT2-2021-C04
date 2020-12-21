package org.interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.persistencia_M1.MesaDAO;
import org.dominio.Mesa;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class ReservarMesa extends JFrame {

	private JPanel contentPane;
	private JTextField textMesasID;
	private JLabel lblMesasID = new JLabel();
	private JTextArea textMesas = new JTextArea();
	private JLabel lblEstado = new JLabel();
	private ArrayList<Mesa> mesas = new ArrayList<Mesa>();

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ReservarMesa frame = new
	 * ReservarMesa(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public ReservarMesa() {
		GenerarMesas();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 782, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMesas = new JLabel("Mesas Disponibles:");
		lblMesas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMesas.setBounds(10, 10, 250, 50);
		contentPane.add(lblMesas);

		textMesasID = new JTextField();
		textMesasID.setBounds(400, 70, 358, 30);
		contentPane.add(textMesasID);
		textMesasID.setColumns(10);

		lblMesasID.setText("Introduzca el id de la mesa a reservar");
		lblMesasID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMesasID.setBounds(400, 10, 358, 50);
		contentPane.add(lblMesasID);

		textMesas.setBounds(10, 70, 351, 281);
		contentPane.add(textMesas);

		lblEstado.setBounds(10, 350, 351, 40);
		contentPane.add(lblEstado);

		JButton btnReservarMesa = new JButton("Reservar Mesa");
		btnReservarMesa.setBounds(380, 310, 358, 70);
		contentPane.add(btnReservarMesa);
		new JLabel("ID Mesa:");
		textMesas.setText(MesaDAO.CadenaMesas(mesas));
		textMesas.setEditable(false);
		btnReservarMesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idMesa = textMesasID.getText();
				try {
					int idM = Integer.parseInt(idMesa);
					if (idM > 0) {
						reservar(idM);
					} else {
						lblEstado.setText("Introduzca un valor positivo");
					}
				} catch (final NumberFormatException e1) {
					lblEstado.setText("Introduzca un valor numerico");
				}
			}
		});
	}

	public void GenerarMesas() {
		try {
			MesaDAO.SelectMesasDisponibles(mesas);
		} catch (SQLException e1) {
			lblEstado.setText("No se han podido obtener las mesas de la base de datos correctamente.");
		}
	}

	public void reservar(int idM) {
		try {
			Mesa mesa = MesaDAO.SelectMesaPorID(idM);
			mesa.reservarMesa();
			MesaDAO.UpdateMesaEstado(mesa);
			textMesas.setText("");
			mesas.clear();
			GenerarMesas();
			textMesas.setText(MesaDAO.CadenaMesas(mesas));
			lblEstado.setText("Estado actualizado correctamente");
		} catch (NullPointerException e) {
			lblEstado.setText("Mesa no disponible");
		} catch (SQLException e1) {
			e1.printStackTrace();
			lblEstado.setText("Ocurrió un error al actualizar el estado");
		}
	}
}
