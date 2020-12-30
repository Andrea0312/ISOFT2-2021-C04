package org.persistencia_M5;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.dominio.Restaurante;
import org.persistencia_M1.Agente;

public class EstadisticasDAO {
	
	public static Restaurante SelectRestaurantePorID(int ID) throws SQLException {
		ResultSet result = Agente.Select("SELECT * FROM C04dbservice.restaurante where ID_Restaurante = "+ID);
        int id = -1;
        String ciudad = "";
        String direccion = "";
        Restaurante rAux = null;

        try {
        	if(result.next()) {
				id = result.getInt("ID_Restaurante");
				ciudad = result.getString("ciudad");
				direccion = result.getString("direccion");
				rAux= new Restaurante(id, ciudad, direccion);
        	}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rAux;
	}
	
	public static void enviarEstadistica(int idRestaurante, double tiempoNota, double tiempoLibre, double tiempoPreparacion, double tiempoComandas) {

		Statement st = Agente.Conectar();

		try {
			st.executeUpdate("UPDATE estadisticas_restaurante"
					+ "SET  tiempoNota="+tiempoNota
					+ "SET tiempoLibre="+tiempoLibre
					+ "SET tiempoPreparacion="+tiempoPreparacion
					+ "SET tiempoComandas="+tiempoComandas
					+ "WHERE ID_Restaurante="+idRestaurante+";");

		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
