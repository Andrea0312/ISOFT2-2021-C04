package isoft_c04.cd2.Presentacion_GestionComanda;

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JSpinner;

import isoft_c04.cd2.Dominio_GestionComanda.Bebida;
import isoft_c04.cd2.Dominio_GestionComanda.Mesa;
import isoft_c04.cd2.Dominio_GestionComanda.Plato;
import isoft_c04.cd2.Persistencia_GestionComanda.BebidaDAO;
import isoft_c04.cd2.Persistencia_GestionComanda.PlatoDAO;

import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

public class AnotarComanda extends JFrame{

	
	static ArrayList<Bebida> bebidas = new ArrayList<Bebida>();
	static ArrayList<Plato> platos = new ArrayList<Plato>();
	
	static JPanel panel_lista = new JPanel();
	static JPanel panel_botones = new JPanel();
	static JPanel panel_busqueda = new JPanel();
	
	private JButton addPrimero;
	private JButton addEntrante;
	private JButton addSegundo;
	private JButton addPostre;
	private JButton addBebida;
	private JButton btnAdd;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnotarComanda frame = new AnotarComanda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AnotarComanda() {
		
		setResizable(false);
		setMinimumSize(new Dimension(290, 450));
		getContentPane().setLayout(new CardLayout(0, 0));
		
		cambiarPanelBusqueda listenerAdd = new cambiarPanelBusqueda();
		cambiarPanelComanda listenerComanda = new cambiarPanelComanda();
		
		
		JPanel anotarComanda = new JPanel();
		anotarComanda.setMaximumSize(new Dimension(290, 32767));
		getContentPane().add(anotarComanda, "anotarComanda");
		anotarComanda.setLayout(null);
		
		addEntrante = new JButton("Entrante");
		addEntrante.setBounds(31, 124, 90, 40);
		anotarComanda.add(addEntrante);
		addEntrante.addActionListener(listenerAdd);
		
		addPrimero = new JButton("Primero");
		addPrimero.setBounds(151, 124, 90, 40);
		anotarComanda.add(addPrimero);
		addPrimero.addActionListener(listenerAdd);

		addSegundo = new JButton("Segundo");
		addSegundo.setBounds(31, 175, 90, 40);
		anotarComanda.add(addSegundo);
		addSegundo.addActionListener(listenerAdd);

		addPostre = new JButton("Postre");
		addPostre.setBounds(151, 175, 90, 40);
		anotarComanda.add(addPostre);
		addPostre.addActionListener(listenerAdd);
		
		JButton addComanda = new JButton("Añadir Comanda");
		addComanda.setBounds(75, 318, 130, 50);
		anotarComanda.add(addComanda);
		
		JLabel txt_idMesa = new JLabel("Mesa nº:");
		txt_idMesa.setBounds(92, 56, 46, 14);
		anotarComanda.add(txt_idMesa);
		
		JSpinner idMesa = new JSpinner();
		idMesa.setBounds(137, 53, 45, 20);
		anotarComanda.add(idMesa);
		
		addBebida = new JButton("Bebida");
		addBebida.setBounds(92, 226, 90, 40);
		anotarComanda.add(addBebida);
		addBebida.addActionListener(listenerAdd);
		
		JScrollPane scroll_lista = new JScrollPane();
		scroll_lista.setMaximumSize(new Dimension(290, 32767));
		panel_lista.setMinimumSize(new Dimension(290, 10));
		panel_lista.setMaximumSize(new Dimension(290, 32767));
		
		scroll_lista.add(panel_lista);
		scroll_lista.setViewportView(panel_lista);
		panel_lista.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_busqueda = new JPanel();
		getContentPane().add(panel_busqueda, "panel_busqueda");
		panel_busqueda.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBotones = new JPanel();
		panel_busqueda.add(panelBotones, BorderLayout.SOUTH);
		
		JButton btnVolver = new JButton("Volver");
		panelBotones.add(btnVolver);
		btnVolver.addActionListener(listenerComanda);

		btnAdd = new JButton("Añadir");
		panelBotones.add(btnAdd);
		btnAdd.addActionListener(listenerComanda);

		panel_busqueda.add(scroll_lista, BorderLayout.CENTER);
		
	}
	
	private static void mostrarBebidas(int idRestaurante) {
		
		bebidas=BebidaDAO.obtenerBebida(idRestaurante);
		for(Bebida be : bebidas) {		
			panel_lista.add( new vistaBebida(be));
			panel_lista.revalidate();
		}
	}
	
	private class cambiarPanelComanda implements ActionListener {
		
		public void actionPerformed(ActionEvent arg0) {
			JButton auxBoton = (JButton) arg0.getSource();
			((CardLayout) getContentPane().getLayout()).show(getContentPane(), "anotarComanda");
			if(auxBoton.equals(btnAdd)) {
				
			}
			
		}
	}
	
	private class cambiarPanelBusqueda implements ActionListener {
		
		public void actionPerformed(ActionEvent arg0) {
			JButton auxBoton = (JButton) arg0.getSource();
			((CardLayout) getContentPane().getLayout()).show(getContentPane(), "panel_busqueda");
			panel_lista.removeAll();
			if(auxBoton.equals(addEntrante)) {
				mostrarPlatos(1,1);
			}else if(auxBoton.equals(addPrimero)) {
				mostrarPlatos(1,2);
			}else if(auxBoton.equals(addSegundo)) {
				mostrarPlatos(1,3);
			}else if(auxBoton.equals(addPostre)) {
				mostrarPlatos(1,4);
			}else if(auxBoton.equals(addBebida)) {
				mostrarBebidas(1);
			}
		}
	}
	
	private static void mostrarPlatos(int idRestaurante, int tipoPlato) {
		
		platos = PlatoDAO.obtenerPlatos(idRestaurante, tipoPlato);
		for(Plato pl : platos) {
			System.out.println(pl.toString());
			panel_lista.add(new vistaPlato(pl));
			panel_lista.revalidate();	
		}
	}
}
