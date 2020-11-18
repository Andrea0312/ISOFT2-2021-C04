package CDU1.CDU1.Interfaz;

import java.sql.SQLException;
import java.util.ArrayList;

import CDU1.CDU1.Dominio.Restaurante;
import CDU1.CDU1.Persistencia.RestauranteDAO;

public class Pruebas {

	public static void main(String[] args) {
		ArrayList<Restaurante> r = new ArrayList<Restaurante>();
		Restaurante res = null;
		try {
			RestauranteDAO.SelectTodosRestaurantes(r);
			res =RestauranteDAO.SelectRestaurantePorID(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(!r.isEmpty()) {
			System.out.println(r.remove(0));
		}
		System.out.println(res);
	}

}
