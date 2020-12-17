package isoft_c04.cd2.Persistencia_GestionComanda;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import isoft_c04.cd2.Dominio_GestionComanda.*;

public class BebidaDAO {

	public static ArrayList<Bebida> obtenerBebida(int idRestaurante) {
		// TODO - implement BebidaDAO.obtenerBebida
		
		ArrayList<Bebida> bebidas = new ArrayList<Bebida>();
		/*
		 * FUNCIONA!!
		 * */
		
		
		try {
			
			ResultSet result = Agente.consultaBD("SELECT A.ID_Bebida, B.precio, A.cantidad, A.ID_Restaurante, B.nombre "
	 				   						   + "FROM bebida_almacen A, bebida B "
	 				   						   + "WHERE A.ID_Bebida=B.ID_Bebida "
	 				   						   + "AND A.ID_Restaurante="+idRestaurante+";");
			
			while (result.next()) {
				Bebida b = new Bebida(result.getInt("ID_Bebida")
									 ,result.getDouble("precio")
									 ,result.getInt("cantidad")
									 ,result.getInt("ID_Restaurante")
									 ,result.getString("nombre"));
				bebidas.add(b);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bebidas;
		
	}

	/**
	 * 
	 * @param idRestaurante
	 * @param idBebida
	 */
	public static void eliminarUnaBebida(int idRestaurante, int idBebida) {
		// TODO - implement BebidaDAO.eliminarUnaBebida
		
		Statement st = Agente.conectar();
		/*
		 * 
		 * 		FUNCIONA !!
		 * 
		 * */
		try {
			st.executeUpdate("UPDATE BEBIDA_ALMACEN "
						   + "SET  cantidad = cantidad-1 "
						   + "WHERE ID_Restaurante="+idRestaurante
						   + " AND ID_Bebida="+idBebida+";");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

	/**
	 * 
	 * @param idRestaurante
	 * @param idBebida
	 */
	public boolean validarBebidaRestaurante(int idRestaurante, int idBebida) {
		// TODO - implement BebidaDAO.validarBebidaRestaurante
		throw new UnsupportedOperationException();
	}

}