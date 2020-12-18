package org.persistencia_M2;

import java.sql.*;
import java.util.ArrayList;

import org.dominio.*;
import org.persistencia_M1.*;

public class ComandaDAO {

	/**
	 * 
	 * @param comanda
	 */
	public static void addComanda(Comanda comanda) {
		// TODO - implement ComandaDAO.addComanda
		
		ArrayList<Plato> totalPlatos = new ArrayList<Plato>();
		Statement st = Agente.Conectar();	
		
		if(comanda.getEntrantes()!=null)totalPlatos.addAll(comanda.getEntrantes());
		if(comanda.getPrimerPlato()!=null)totalPlatos.addAll(comanda.getPrimerPlato());
		if(comanda.getSegundoPlato()!=null)totalPlatos.addAll(comanda.getSegundoPlato());
		if(comanda.getPostre()!=null)totalPlatos.addAll(comanda.getPostre());
		
		
		try {
			st.executeUpdate("insert into comanda (ID_Mesa, precio) "
						   + "values ("+comanda.getIdMesa()+","+calcularPrecio(comanda.getIdComanda())+");");
			// HAY QUE PONER EN EL 1 EL NUMERO DE MESA
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Plato pl : totalPlatos) {
			
			try {
				st.executeUpdate("INSERT INTO comanda_plato (ID_Comanda, ID_Plato) "
						       + "VALUES ("+comanda.getIdComanda()+","+pl.getIdPlato()+");");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(comanda.getBebidas()!=null) {
			for(Bebida be : comanda.getBebidas()) {
				
				try {
					st.executeUpdate("INSERT INTO comanda_bebida (ID_Comanda, ID_Bebida) "
								   + "VALUES ("+comanda.getIdComanda()+","+be.getIdBebida()+");");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		
		
		
	}
	
	public static void crearComanda(int idMesa) {
		
		Statement st = Agente.Conectar();		
		try {
			st.executeUpdate("insert into comanda (ID_Mesa) "
						   + "values ("+idMesa+");");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<String[]> imprimirCuenta(int idMesa) {
		// TODO - implement ComandaDAO.imprimirCuenta
		
		ResultSet query;
		int idComanda = 0;
		ArrayList<String[]> pedidos = new ArrayList<String[]>();
		
		try {
			
			query = Agente.Select("select max(ID_Comanda)\r\n"
								+ "from comanda\r\n"
								+ "where ID_Mesa = "+idMesa+";");

			
			if(query.next())idComanda=query.getInt("max(ID_Comanda)");
		
			query = Agente.Select("select c.ID_Plato, p.nombre, p.precio\r\n"
								+ "from plato p, comanda_plato c\r\n"
								+ "where c.ID_Plato = p.ID_Plato\r\n"
								+ "and c.ID_Comanda = "+idComanda+";");
			
			while(query.next()) {
				String[] plato = new String[2];
				plato[0] = query.getString("nombre");
				plato[1] = String.valueOf(query.getInt("precio"));
				pedidos.add(plato);
			}
			
			query = Agente.Select("select c.ID_Bebida, b.nombre, b.precio\r\n"
								+ "from bebida b, comanda_bebida c\r\n"
								+ "where c.ID_Bebida = b.ID_Bebida\r\n"
								+ "and c.ID_Comanda = "+idComanda+";");
			
			while(query.next()) {
				String[] plato = new String[2];
				plato[0] = query.getString("nombre");
				plato[1] = String.valueOf(query.getInt("precio"));
				pedidos.add(plato);
			}
			
			return pedidos;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;	
		
	}

	public static double calcularPrecio(int idComanda) {
		
		double precio=0;
		ResultSet query;
			
			try {
				query = Agente.Select("SELECT SUM(precio) "
									+ "FROM bebida "
									+ "WHERE ID_Bebida IN (SELECT ID_Bebida "
														+ "FROM comanda_bebida "
														+ "WHERE ID_Comanda="+idComanda+");");
				
				if(query.next())precio+=query.getInt("SUM(precio)");
				
				query = Agente.Select("SELECT SUM(precio) "
							        + "FROM plato "
							        + "WHERE ID_Plato IN (SELECT ID_Plato "
							            			   + "FROM comanda_plato "
							            			   + "WHERE ID_Comanda="+idComanda+");");
				
				if(query.next())precio+=query.getInt("SUM(precio)");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return precio;
		
	}
	
}