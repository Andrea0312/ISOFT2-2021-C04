package isoft_c04.cd2.Persistencia_GestionComanda;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import isoft_c04.cd2.Dominio_GestionComanda.*;

public class BebidaDAO {

	public ArrayList<Bebida> obtenerBebida() {
		// TODO - implement BebidaDAO.obtenerBebida
		
		ArrayList<Bebida> bebidas = new ArrayList<Bebida>();
		/*
		 * FUNCIONA!!
		 * */
		ResultSet result = Agente.consultaBD("SELECT A.ID_Bebida, B.precio, A.cantidad, A.ID_Restaurante, B.nombre"
						 				   + "FROM BEBIDA_ALMACEN A, BEBIDA B"
						 				   + "WHERE A.ID_Bebida=B.ID_Bebida;");
		
		try {
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
	public void eliminarUnaBebida(int idRestaurante, int idBebida) {
		// TODO - implement BebidaDAO.eliminarUnaBebida
		
		Statement st = Agente.conectar();
		/*
		 * 
		 * 		FUNCIONA !!
		 * 
		 * */
		try {
			st.executeUpdate("UPDATE BEBIDA_ALMACEN"
						   + "SET  cantidad = cantidad-1 "
						   + "WHERE idRestaurante="+idRestaurante
						   + "AND idBebida="+idBebida+";");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		throw new UnsupportedOperationException();
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