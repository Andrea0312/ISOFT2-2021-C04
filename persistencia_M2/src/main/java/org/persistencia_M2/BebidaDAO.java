package org.persistencia_M2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.dominio.Bebida;
import org.persistencia_M1.*;

public class BebidaDAO {

	public static ArrayList<Bebida> obtenerBebida(int idRestaurante) {
		// TODO - implement BebidaDAO.obtenerBebida
		
		ArrayList<Bebida> bebidas = new ArrayList<Bebida>();
		/*
		 * FUNCIONA!!
		 * */
		
		
		try {
			
			ResultSet result = Agente.Select("SELECT A.ID_Bebida, B.precio, A.cantidad, A.ID_Restaurante, B.nombre "
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
		
		Statement st = Agente.Conectar();
		/*
		 * 
		 * 		FUNCIONA !!
		 * 
		 * */
		try {
			st.executeUpdate("UPDATE bebida_almacen "
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