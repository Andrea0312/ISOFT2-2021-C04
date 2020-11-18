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
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class AsignarCamarero {

	private JFrame frame;
	private JTextField MesaIDtextField;
	private JTextField CamareroIDtextField;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AsignarCamarero window = new AsignarCamarero();
					
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
	public AsignarCamarero() {
		
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
		frame.getContentPane().add(MesastextArea);
		
		JTextArea CamarerostextArea = new JTextArea();
		CamarerostextArea.setEditable(false);
		CamarerostextArea.setBounds(168, 73, 104, 161);
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
				String idCamarero= CamareroIDtextField.getText();
				//setear mesa a ocupada 
				labelEstado.setText("Asignado correctamente"); //if existian ambos IDs, si no habrá q mostrar error
			}
		});
		btnAsignar.setBounds(327, 209, 97, 25);
		frame.getContentPane().add(btnAsignar);
		

	}
}
