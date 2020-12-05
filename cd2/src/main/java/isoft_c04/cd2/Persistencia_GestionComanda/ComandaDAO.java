package isoft_c04.cd2.Persistencia_GestionComanda;

import java.sql.*;
import java.util.ArrayList;

import isoft_c04.cd2.Dominio_GestionComanda.*;

public class ComandaDAO {

	/**
	 * 
	 * @param comanda
	 */
	public void addComanda(Comanda comanda) {
		// TODO - implement ComandaDAO.addComanda
		
		ArrayList<Plato> totalPlatos = new ArrayList<Plato>();
		
		totalPlatos.addAll(comanda.getEntrantes());
		totalPlatos.addAll(comanda.getPrimerPlato());
		totalPlatos.addAll(comanda.getSegundoPlato());
		totalPlatos.addAll(comanda.getPostre());	
		
		Statement st = Agente.conectar();		
		
		for(Plato pl : totalPlatos) {
			
			try {
				st.executeUpdate("INSERT INTO COMANDA_PLATO (idComanda, idBebida) VALUES ("+comanda.getIdComanda()+","
						+pl.getIdPlato()+");");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		for(Bebida be : comanda.getBebidas()) {
			
			try {
				st.executeUpdate("INSERT INTO COMANDA_BEBIDA (idComanda, idBebida) VALUES ("+comanda.getIdComanda()+","
						+be.getIdBebida()+");");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		try {
			st.executeUpdate("UPDATE COMANDA SET precio="+calcularPrecio(comanda.getIdComanda())
								+ "WHERE idComanda="+comanda.getIdComanda()+");");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		throw new UnsupportedOperationException();
	}

	public void imprimirCuenta(Comanda comanda) {
		// TODO - implement ComandaDAO.imprimirCuenta
		
		System.out.println(" --- ENTRANTES ---");
		for(Plato pl : comanda.getEntrantes()) {
			System.out.println(pl.getIdPlato()+" - "+pl.getNombre()+"\t\t"+pl.getPrecio());
		}
		
		System.out.println(" --- PRIMER PLATO ---");
		for(Plato pl : comanda.getPrimerPlato()) {
			System.out.println(pl.getIdPlato()+" - "+pl.getNombre()+"\t\t"+pl.getPrecio());
		}
		
		System.out.println(" --- SEGUNDO PLATO ---");
		for(Plato pl : comanda.getSegundoPlato()) {
			System.out.println(pl.getIdPlato()+" - "+pl.getNombre()+"\t\t"+pl.getPrecio());
		}
		
		System.out.println(" --- POSTRE ---");
		for(Plato pl : comanda.getPostre()) {
			System.out.println(pl.getIdPlato()+" - "+pl.getNombre()+"\t\t"+pl.getPrecio());
		}
		
		System.out.println(" --- BEBIDAS ---");
		for(Bebida be : comanda.getBebidas()) {
			System.out.println(be.getIdBebida()+" - "+be.getNombre()+"\t\t"+be.getPrecio());
		}
		
		throw new UnsupportedOperationException();
		
	}

	public double calcularPrecio(int idComanda) {
		
		double precio=0;
		Statement st = Agente.conectar();		
			
			try {
				precio+=st.executeUpdate("SELECT SUM(precio) FROM BEBIDA WHERE idBebida="
						+ "(SELECT idBebida FROM COMANDA_BEBIDA WHERE idComanda="+idComanda+"));");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				precio+=st.executeUpdate("SELECT SUM(precio) FROM PLATO WHERE idPlato="
						+ "(SELECT idPlato FROM COMANDA_PLATO WHERE idComanda="+idComanda+"));");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return precio;
		
	}
	
}