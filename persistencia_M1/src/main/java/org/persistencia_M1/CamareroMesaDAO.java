package org.persistencia_M1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.dominio.CamareroMesa;
import org.dominio.Restaurante;

public class CamareroMesaDAO {
	public static String CadenaCamarerosMesa(ArrayList<CamareroMesa> camarerosMesa) {
		String cadena="";
		while(!camarerosMesa.isEmpty()) {
			cadena+=camarerosMesa.remove(0).toString()+"\n";
		}
		return cadena;
	}
	
	public static CamareroMesa SelectCamareroMesaPorID(int ID) throws SQLException {
		ResultSet result = Agente.Select("SELECT * FROM C04dbservice.empleado where ID_Empleado = " + ID + " and Tipo = 'CM'");
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
				CamareroMesa camareroMesa = new CamareroMesa(id, restaurante, nombre, apellido, telefono);
				return camareroMesa;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void SelectTodosCamarerosMesa(ArrayList<CamareroMesa> CamarerosMesa) throws SQLException {
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
				CamareroMesa camareroMesa = new CamareroMesa(id, restaurante, nombre, apellido, telefono);
				CamarerosMesa.add(camareroMesa);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
