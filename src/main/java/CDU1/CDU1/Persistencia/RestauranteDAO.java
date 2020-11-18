package CDU1.CDU1.Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import CDU1.CDU1.Dominio.Restaurante;

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
				Restaurante rAux= new Restaurante(id, nombre, ciudad);
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
				rAux= new Restaurante(id, nombre, ciudad);
        	}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rAux;
	}
}
