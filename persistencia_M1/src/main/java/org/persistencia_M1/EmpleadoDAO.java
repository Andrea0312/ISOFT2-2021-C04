package org.persistencia_M1;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.dominio.CamareroBarra;
import org.dominio.CamareroMesa;
import org.dominio.Empleado;
import org.dominio.JefeSala;
import org.dominio.Restaurante;

public class EmpleadoDAO {
	public static void SelectTodosEmpleados(ArrayList<CamareroBarra> CamarerosBarra, ArrayList<CamareroMesa> CamarerosMesa, ArrayList<JefeSala> JefesSala) throws SQLException {
		ResultSet result = Agente.Select("SELECT * FROM C04dbservice.empleado");
		int id = -1;
		int idRestaurante = -1;
		Restaurante restaurante = null;
		String nombre = "";
		String apellido = "";
		String telefono = "";
		String tipo = "";
 
		try {
			while (result.next()) {
				id = result.getInt("ID_Empleado");
				idRestaurante = result.getInt("ID_Restaurante");
				restaurante = RestauranteDAO.SelectRestaurantePorID(idRestaurante);
				nombre = result.getString("nombre");
				apellido = result.getString("apellido");
				telefono = result.getString("telefono");
				tipo = result.getString("Tipo");
				switch (tipo) {
				case "CM":
					CamareroMesa cmAux = new CamareroMesa(id, restaurante, nombre, apellido, telefono);
					CamarerosMesa.add(cmAux);
					break;
				case "CB":
					CamareroBarra cbAux = new CamareroBarra(id, restaurante, nombre, apellido, telefono);
					CamarerosBarra.add(cbAux);
					break;
				case "JS":
					JefeSala jsAux = new JefeSala(id, restaurante, nombre, apellido, telefono);
					JefesSala.add(jsAux);
					break;
				default:
					Empleado eAux = new Empleado(id, restaurante, nombre, apellido, telefono); //METER UN ARRAYLIST PARA CONTROLAR COCINEROS O MÁS COSAS
					break;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static Empleado SelectEmpleadoPorID(int ID) throws SQLException {
		ResultSet result = Agente.Select("SELECT * FROM C04dbservice.empleado where ID_Empleado = " + ID);
		int id = -1;
		int idRestaurante = -1;
		Restaurante restaurante = null;
		String nombre = "";
		String apellido = "";
		String telefono = "";
		String tipo = "";

		try {
			if (result.next()) {
				id = result.getInt("ID_Empleado");
				idRestaurante = result.getInt("ID_Restaurante");
				restaurante = RestauranteDAO.SelectRestaurantePorID(idRestaurante);
				nombre = result.getString("nombre");
				apellido = result.getString("apellido");
				telefono = result.getString("telefono");
				tipo = result.getString("Tipo");
				switch (tipo) {
				case "cm":
					CamareroMesa cmAux = new CamareroMesa(id, restaurante, nombre, apellido, telefono);
					return cmAux;
				case "cb":
					CamareroBarra cbAux = new CamareroBarra(id, restaurante, nombre, apellido, telefono);
					return cbAux;
				case "js":
					JefeSala jsAux = new JefeSala(id, restaurante, nombre, apellido, telefono);
					return jsAux;
				default:
					Empleado eAux = new Empleado(id, restaurante, nombre, apellido, telefono);
					return eAux;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String CadenaCamarerosMesa(ArrayList<CamareroMesa> camarerosMesa) {
		String cadena="";
		while(!camarerosMesa.isEmpty()) {
			cadena+=camarerosMesa.remove(0).toString()+"\n";
		}
		return cadena;
	}
	
	public static String CadenaCamarerosBarra(ArrayList<CamareroBarra> camarerosBarra) {
		String cadena="";
		while(!camarerosBarra.isEmpty()) {
			cadena+=camarerosBarra.remove(0);
		}
		return cadena;
	}
	
	public static String CadenaJefesSala(ArrayList<CamareroMesa> jefesSala) {
		String cadena="";
		while(!jefesSala.isEmpty()) {
			cadena+=jefesSala.remove(0);
		}
		return cadena;
	}
}
