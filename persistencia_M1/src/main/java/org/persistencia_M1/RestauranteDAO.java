package org.persistencia_M1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.dominio.Restaurante;


public class RestauranteDAO {
	public static void SelectTodosRestaurantes(ArrayList<Restaurante> restaurantes) throws SQLException {
        ResultSet result = Agente.Select("SELECT * FROM isolab.restaurante");
        int id = -1;
        String ciudad = "";
        String nombre = "";
        //PROBAR

        try {
        	while(result.next()) {
				id = result.getInt("ID_Restaurante");
				ciudad = result.getString("ciudad");
				nombre = result.getString("nombre");
				Restaurante rAux= new Restaurante(id, ciudad, nombre);
				restaurantes.add(rAux);
        	}

		} catch (SQLException e) {
			e.printStackTrace();
		}
        
    }
	public static Restaurante SelectRestaurantePorID(int ID) throws SQLException {
		ResultSet result = Agente.Select("SELECT * FROM isolab.restaurante where ID_Restaurante = "+ID);
        int id = -1;
        String ciudad = "";
        String nombre = "";
        Restaurante rAux = null;

        try {
        	if(result.next()) {
				id = result.getInt("ID_Restaurante");
				ciudad = result.getString("ciudad");
				nombre = result.getString("nombre");
				rAux= new Restaurante(id, ciudad, nombre);
        	}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rAux;
	}
}
