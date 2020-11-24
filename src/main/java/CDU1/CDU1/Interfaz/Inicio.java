package CDU1.CDU1.Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCambiarEstadoMesa = new JButton("Cambiar estado mesa (camarero)");
		btnCambiarEstadoMesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CambiarEstadoMesa window = new CambiarEstadoMesa();
			}
		});
		btnCambiarEstadoMesa.setBounds(22, 190, 227, 54);
		frame.getContentPane().add(btnCambiarEstadoMesa);
		
		JButton btnAsignarCamareroA = new JButton("Asignar camarero a mesa \r\n(Jefe de sala)");
		btnAsignarCamareroA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AsignarCamarero asignarCam = new AsignarCamarero();
			}
		});
		btnAsignarCamareroA.setBounds(22, 85, 263, 54);
		frame.getContentPane().add(btnAsignarCamareroA);
	}
}
