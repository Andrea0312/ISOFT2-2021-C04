package org.persistencia_M1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.dominio.Restaurante;


public class RestauranteDAO {
	public static void SelectTodosRestaurantes(ArrayList<Restaurante> restaurantes) throws SQLException {
        ResultSet result = Agente.Select("SELECT * FROM C04dbservice.restaurante");
        int id = -1;
        String ciudad = "";
        String direccion = "";
        //PROBAR

        try {
        	while(result.next()) {
				id = result.getInt("ID_Restaurante");
				ciudad = result.getString("ciudad");
				direccion = result.getString("direccion");
				Restaurante rAux= new Restaurante(id, ciudad, direccion);
				restaurantes.add(rAux);
        	}

		} catch (SQLException e) {
			e.printStackTrace();
		}
        
    }
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
}
