package isoft_c04.cd2.Persistencia_GestionComanda;

import java.sql.*;
import java.util.ArrayList;

import isoft_c04.cd2.Dominio_GestionComanda.*;

public class ComandaDAO {

	/**
	 * 
	 * @param comanda
	 */
	public static void addComanda(Comanda comanda) {
		// TODO - implement ComandaDAO.addComanda
		
		ArrayList<Plato> totalPlatos = new ArrayList<Plato>();
		Statement st = Agente.conectar();	
		
		if(comanda.getEntrantes()!=null)totalPlatos.addAll(comanda.getEntrantes());
		if(comanda.getPrimerPlato()!=null)totalPlatos.addAll(comanda.getPrimerPlato());
		if(comanda.getSegundoPlato()!=null)totalPlatos.addAll(comanda.getSegundoPlato());
		if(comanda.getPostre()!=null)totalPlatos.addAll(comanda.getPostre());
		
		
		try {
			st.executeUpdate("insert into comanda (ID_Mesa, precio) "
						   + "values ("+1+","+calcularPrecio(comanda.getIdComanda())+");");
			// HAY QUE PONER EN EL 1 EL NUMERO DE MESA
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Plato pl : totalPlatos) {
			
			try {
				st.executeUpdate("INSERT INTO COMANDA_PLATO (ID_Comanda, ID_Plato) "
						       + "VALUES ("+comanda.getIdComanda()+","+pl.getIdPlato()+");");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(comanda.getBebidas()!=null) {
			for(Bebida be : comanda.getBebidas()) {
				
				try {
					st.executeUpdate("INSERT INTO COMANDA_BEBIDA (ID_Comanda, ID_Bebida) "
								   + "VALUES ("+comanda.getIdComanda()+","+be.getIdBebida()+");");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		
		
		
	}
	
	public static void crearComanda(int idMesa) {
		
		Statement st = Agente.conectar();		
		try {
			st.executeUpdate("insert into comanda (ID_Mesa) "
						   + "values ("+idMesa+");");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void imprimirCuenta(int idMesa) {
		// TODO - implement ComandaDAO.imprimirCuenta
		
		ResultSet query;
		int idComanda = 0;
		
		try {
			
			query = Agente.consultaBD("select max(ID_Comanda)\r\n"
					+ "from comanda\r\n"
					+ "where ID_Mesa = "+idMesa+";");

			
			if(query.next())idComanda=query.getInt("max(ID_Comanda)");
		
			query = Agente.consultaBD("select c.ID_Plato, p.nombre, p.precio\r\n"
									+ "from plato p, comanda_plato c\r\n"
									+ "where c.ID_Plato = p.ID_plato\r\n"
									+ "and p.tipoPlato=1"
									+ "and c.ID_Comanda = "+idComanda+";");
			
			System.out.println(" --- ENTRANTES ---");
			
			while(query.next()) {
				System.out.println(query.getInt("ID_Plato")+" - "+query.getString("nombre")+"\t\t"+query.getDouble("precio"));
			}
			
			query = Agente.consultaBD("select c.ID_Plato, p.nombre, p.precio\r\n"
									+ "from plato p, comanda_plato c\r\n"
									+ "where c.ID_Plato = p.ID_plato\r\n"
									+ "and p.tipoPlato=2"
									+ "and c.ID_Comanda = "+idComanda+";");
	
			System.out.println(" --- PRIMER PLATO ---");
			
			while(query.next()) {
				System.out.println(query.getInt("ID_Plato")+" - "+query.getString("nombre")+"\t\t"+query.getDouble("precio"));
			}
			
			query = Agente.consultaBD("select c.ID_Plato, p.nombre, p.precio\r\n"
									+ "from plato p, comanda_plato c\r\n"
									+ "where c.ID_Plato = p.ID_plato\r\n"
									+ "and p.tipoPlato=3"
									+ "and c.ID_Comanda = "+idComanda+";");
			
			System.out.println(" --- SEGUNDO PLATO ---");
			
			while(query.next()) {
				System.out.println(query.getInt("ID_Plato")+" - "+query.getString("nombre")+"\t\t"+query.getDouble("precio"));
			}
			
			query = Agente.consultaBD("select c.ID_Plato, p.nombre, p.precio\r\n"
									+ "from plato p, comanda_plato c\r\n"
									+ "where c.ID_Plato = p.ID_plato\r\n"
									+ "and p.tipoPlato=4"
									+ "and c.ID_Comanda = "+idComanda+";");
			
			
			while(query.next()) {
				System.out.println(query.getInt("ID_Plato")+" - "+query.getString("nombre")+"\t\t"+query.getDouble("precio"));
			}
			
			System.out.println(" --- BEBIDAS ---");
			
			query = Agente.consultaBD("select c.ID_Bebida, p.nombre, p.precio\r\n"
									+ "from bebida b, comanda_bebida c\r\n"
									+ "where c.ID_Bebida = p.ID_Bebida\r\n"
									+ "and c.ID_Comanda = "+idComanda+";");
			
			while(query.next()) {
				System.out.println(query.getInt("ID_Bebida")+" - "+query.getString("nombre")+"\t\t"+query.getDouble("precio"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		throw new UnsupportedOperationException();
		
	}

	public static double calcularPrecio(int idComanda) {
		
		double precio=0;
		ResultSet query;
			
			try {
				query = Agente.consultaBD("SELECT SUM(precio) "
										+ "FROM BEBIDA "
										+ "WHERE ID_Bebida IN (SELECT ID_Bebida "
															+ "FROM COMANDA_BEBIDA "
															+ "WHERE ID_Comanda="+idComanda+");");
				
				if(query.next())precio+=query.getInt("SUM(precio)");
				
				query = Agente.consultaBD("SELECT SUM(precio) "
							            + "FROM PLATO "
							            + "WHERE ID_Plato IN (SELECT ID_Plato "
							            				   + "FROM COMANDA_PLATO "
							           					   + "WHERE ID_Comanda="+idComanda+");");
				
				if(query.next())precio+=query.getInt("SUM(precio)");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return precio;
		
	}
	
}