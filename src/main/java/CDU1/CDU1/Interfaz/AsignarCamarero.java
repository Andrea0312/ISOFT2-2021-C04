package CDU1.CDU1.Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

import CDU1.CDU1.Dominio.CamareroBarra;
import CDU1.CDU1.Dominio.CamareroMesa;
import CDU1.CDU1.Dominio.Empleado;
import CDU1.CDU1.Dominio.JefeSala;
import CDU1.CDU1.Dominio.Mesa;
import CDU1.CDU1.Dominio.Restaurante;
import CDU1.CDU1.Persistencia.Agente;
import CDU1.CDU1.Persistencia.EmpleadoDAO;
import CDU1.CDU1.Persistencia.MesaDAO;
import CDU1.CDU1.Persistencia.RestauranteDAO;

public class AsignarCamarero {

	private JFrame frame;
	private JTextField MesaIDtextField;
	private JTextField CamareroIDtextField;
	private ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();
	private ArrayList<CamareroMesa> camarerosMesa = new ArrayList<CamareroMesa>();
	private ArrayList<CamareroBarra> camarerosBarra = new ArrayList<CamareroBarra>();
	private ArrayList<JefeSala> jefesMesa = new ArrayList<JefeSala>();
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
		
		GenerarListas();
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
		CamarerostextArea.setText(EmpleadoDAO.CadenaCamarerosMesa(camarerosMesa));
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
					Empleado empleadoAux = EmpleadoDAO.SelectEmpleadoPorID(idC);
					CamareroMesa camareroMesa = new CamareroMesa(empleadoAux.getID(), empleadoAux.getRestaurante(), empleadoAux.getNombre(), empleadoAux.getApellido(), empleadoAux.getTelefono(), mesa);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				//FALTA ACTUALIZAR LA MESA EN LA BASE DE DATOS
				labelEstado.setText("Asignado correctamente"); // if existian ambos IDs, si no habrá q mostrar error
			}
		});
		btnAsignar.setBounds(327, 209, 97, 25);
		frame.getContentPane().add(btnAsignar);

	}
	
	public void GenerarListas() {
		try {
			RestauranteDAO.SelectTodosRestaurantes(restaurantes);
			EmpleadoDAO.SelectTodosEmpleados(camarerosBarra, camarerosMesa, jefesMesa);
			MesaDAO.SelectTodasMesas(mesas);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
