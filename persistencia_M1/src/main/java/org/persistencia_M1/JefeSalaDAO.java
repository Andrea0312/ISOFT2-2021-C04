package org.persistencia_M1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.dominio.JefeSala;
import org.dominio.Restaurante;

public class JefeSalaDAO {
	public static String CadenaJefesMesa(ArrayList<JefeSala> jefesSala) {
		String cadena="";
		while(!jefesSala.isEmpty()) {
			cadena+=jefesSala.remove(0).toString()+"\n";
		}
		return cadena;
	}
	public static JefeSala SelectJefeSalaPorID(int ID) throws SQLException {
		ResultSet result = Agente.Select("SELECT * FROM C04dbservice.empleado where ID_Empleado = " + ID + " and Tipo = 'JS'");
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
				JefeSala jefeSala= new JefeSala(id, restaurante, nombre, apellido, telefono);
				return jefeSala;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void SelectTodosJefesSala(ArrayList<JefeSala> JefesSala) throws SQLException {
		ResultSet result = Agente.Select("SELECT * FROM C04dbservice.empleado where Tipo = 'CM'");
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
				JefeSala jefeSala = new JefeSala(id, restaurante, nombre, apellido, telefono);
				JefesSala.add(jefeSala);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
