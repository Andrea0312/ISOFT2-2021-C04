package org.persistencia_M4;

import java.sql.SQLException;
import java.sql.Statement;

import org.persistencia_M1.Agente;

public class BebidaADAO {

	public static void aprovisionarBebidas(int idRestaurante, int idBebida) {

		//Según la previsión hemos un mínimo de 40 unidades por bebida diarias
		
		Statement st = Agente.Conectar();

		try {
			st.executeUpdate("UPDATE bebida_almacen "
						   + "SET  cantidad = 40"
						   + "WHERE ID_Restaurante="+idRestaurante
						   + " AND ID_Bebida="+idBebida+";");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		
	}
}
