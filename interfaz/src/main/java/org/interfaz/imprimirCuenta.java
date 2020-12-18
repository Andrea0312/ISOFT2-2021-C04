package org.interfaz;

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JSpinner;

import org.dominio.*;
import org.persistencia_M2.*;
import org.persistencia_M1.*;

import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Font;

public class imprimirCuenta extends JFrame{
	
	static ArrayList<Bebida> bebidas = new ArrayList<Bebida>();
	static ArrayList<Plato> platos = new ArrayList<Plato>();
	static Comanda comanda = new Comanda();
	
	static JPanel panel_lista = new JPanel();
	static JPanel panel_botones = new JPanel();
	static JPanel panel_busqueda = new JPanel();
	
	private int idMesa;
	private JButton selectMesa;
	private JSpinner spinner_idMesa;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					imprimirCuenta frame = new imprimirCuenta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public imprimirCuenta() {
		
		int idRestaurante=0;
		
		setResizable(false);
		setMinimumSize(new Dimension(290, 450));
		getContentPane().setLayout(new CardLayout(0, 0));
		
		cambiarPanelBusqueda listenerAdd = new cambiarPanelBusqueda();
		cambiarPanelComanda listenerComanda = new cambiarPanelComanda();
		
		JPanel anotarComanda = new JPanel();
		anotarComanda.setMaximumSize(new Dimension(290, 32767));
		getContentPane().add(anotarComanda, "anotarComanda");
		anotarComanda.setLayout(null);
		
		spinner_idMesa = new JSpinner();
		spinner_idMesa.setBounds(92, 53, 45, 20);
		anotarComanda.add(spinner_idMesa);
		
		try {
			ResultSet query = Agente.Select("select ID_Restaurante "
						 					  + "from mesa "
						 					  + "where ID_Mesa="+idMesa+";");
			if(query.next()){
				idRestaurante = query.getInt(1);
			}
			comanda.setIdRestaurante(idRestaurante);
						
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		
		
		JLabel txt_idMesa = new JLabel("Mesa nº:");
		txt_idMesa.setBounds(31, 56, 51, 14);
		anotarComanda.add(txt_idMesa);
		
		selectMesa = new JButton("Seleccionar Mesa");
		selectMesa.setFont(new Font("Tahoma", Font.PLAIN, 9));
		selectMesa.setBounds(147, 52, 115, 23);
		anotarComanda.add(selectMesa);
		selectMesa.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				idMesa = (int) spinner_idMesa.getValue();
				comanda.setIdMesa(idMesa);
				
				((CardLayout) getContentPane().getLayout()).show(getContentPane(), "panel_busqueda");
				panel_lista.removeAll();
				ArrayList<String[]> pedidos = new ArrayList<String[]>();
				
				pedidos = ComandaDAO.imprimirCuenta(idMesa);
				
				for(String[] s : pedidos) {
					panel_lista.add(new VistaCuenta(s[0],s[1]));
					panel_lista.revalidate();	
				}
				
			}
		});
		
		
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

		panel_busqueda.add(scroll_lista, BorderLayout.CENTER);
		
	}
	
	private static void mostrarBebidas(int idRestaurante) {
		
		bebidas=BebidaDAO.obtenerBebida(idRestaurante);
		comanda.setBebidas(bebidas);
		for(Bebida be : bebidas) {		
			panel_lista.add( new VistaBebida(be, idRestaurante, comanda));
			panel_lista.revalidate();
		}
	}
	
	private class cambiarPanelComanda implements ActionListener {
		
		public void actionPerformed(ActionEvent arg0) {
			((CardLayout) getContentPane().getLayout()).show(getContentPane(), "anotarComanda");
		}
	}
	
	private class cambiarPanelBusqueda implements ActionListener {
		
		public void actionPerformed(ActionEvent arg0) {
			((CardLayout) getContentPane().getLayout()).show(getContentPane(), "panel_busqueda");
			panel_lista.removeAll();
			ArrayList<String[]> pedidos = new ArrayList<String[]>();
			
			pedidos = ComandaDAO.imprimirCuenta(idMesa);
			
			for(String[] s : pedidos) {
				panel_lista.add(new VistaCuenta(s[0],s[1]));
				panel_lista.revalidate();	
			}
			
		}
	}
	
	private static void mostrarPlatos(int idRestaurante, int tipoPlato) {
		
		platos = PlatoDAO.obtenerPlatos(idRestaurante, tipoPlato);
		
		switch(tipoPlato) {
		case 1:
			comanda.setEntrantes(platos);
			break;
		case 2:
			comanda.setPrimerPlato(platos);
			break;
		case 3:
			comanda.setSegundoPlato(platos);
			break;
		case 4:
			comanda.setPostre(platos);
			break;
		}
		
		
		for(Plato pl : platos) {
			System.out.println(pl.toString());
			panel_lista.add(new VistaPlato(pl,idRestaurante,comanda));
			panel_lista.revalidate();	
		}
		
	}
}
