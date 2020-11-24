package CDU1.CDU1.Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import CDU1.CDU1.Dominio.CamareroBarra;
import CDU1.CDU1.Dominio.Restaurante;

public class CamareroBarraDAO {
	public static String CadenaCamarerosBarra(ArrayList<CamareroBarra> camarerosBarra) {
		String cadena = "";
		while (!camarerosBarra.isEmpty()) {
			cadena += camarerosBarra.remove(0).toString() + "\n";
		}
		return cadena;
	}

	public static CamareroBarra SelectCamareroBarraPorID(int ID) throws SQLException {
		ResultSet result = Agente.Select("SELECT * FROM isolab.empleado where ID_Empleado = " + ID + " and Tipo = 'CB'");
		int id = -1;
		int idRestaurante = -1;
		Restaurante restaurante = null;
		String nombre = "";
		String apellido = "";
		String telefono = "";

		try {
			if (result.next()) {
				id = result.getInt("ID_Empleado");
				idRestaurante = result.getInt("ID_Restaurante");
				restaurante = RestauranteDAO.SelectRestaurantePorID(idRestaurante);
				nombre = result.getString("nombre");
				apellido = result.getString("apellido");
				telefono = result.getString("telefono");
				CamareroBarra camareroBarra = new CamareroBarra(id, restaurante, nombre, apellido, telefono);
				return camareroBarra;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void SelectTodosCamarerosBarra(ArrayList<CamareroBarra> CamarerosBarra) throws SQLException {
		ResultSet result = Agente.Select("SELECT * FROM isolab.empleado where Tipo = 'CB'");
		int id = -1;
		int idRestaurante = -1;
		Restaurante restaurante = null;
		String nombre = "";
		String apellido = "";
		String telefono = "";

		try {
			while (result.next()) {
				id = result.getInt("ID_Empleado");
				idRestaurante = result.getInt("ID_Restaurante");
				restaurante = RestauranteDAO.SelectRestaurantePorID(idRestaurante);
				nombre = result.getString("nombre");
				apellido = result.getString("apellido");
				telefono = result.getString("telefono");
				CamareroBarra camareroBarra = new CamareroBarra(id, restaurante, nombre, apellido, telefono);
				CamarerosBarra.add(camareroBarra);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}