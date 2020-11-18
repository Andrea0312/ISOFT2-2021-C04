package CDU1.CDU1.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import CDU1.CDU1.Dominio.CamareroBarra;
import CDU1.CDU1.Dominio.CamareroMesa;
import CDU1.CDU1.Dominio.Empleado;
import CDU1.CDU1.Dominio.JefeSala;
import CDU1.CDU1.Dominio.Mesa;
import CDU1.CDU1.Dominio.Restaurante;

public class EmpleadoDAO {
	public static void SelectTodosEmpleados(ArrayList<CamareroBarra> CamarerosBarra, ArrayList<CamareroMesa> CamarerosMesa, ArrayList<JefeSala> JefesSala) throws SQLException {
		ResultSet result = Agente.Select("SELECT * FROM isolab.empleado");
		int id = -1;
		int idRestaurante = -1;
		Restaurante restaurante = null;
		String nombre = "";
		String apellido = "";
		String telefono = "";
		String tipo = "";
		Mesa mesa = null;

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
				case "cm":
					mesa = MesaDAO.SelectMesaPorIDEmpleado(id);
					CamareroMesa cmAux = new CamareroMesa(id, restaurante, nombre, apellido, telefono, mesa);
					CamarerosMesa.add(cmAux);
					break;
				case "cb":
					CamareroBarra cbAux = new CamareroBarra(id, restaurante, nombre, apellido, telefono);
					CamarerosBarra.add(cbAux);
					break;
				case "js":
					JefeSala jsAux = new JefeSala(id, restaurante, nombre, apellido, telefono);
					JefesSala.add(jsAux);
					break;
//COCINEROS???
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static Empleado SelectEmpleadoPorID(int ID) throws SQLException {
		ResultSet result = Agente.Select("SELECT * FROM isolab.empleado where ID_Empleado = " + ID);
		int id = -1;
		int idRestaurante = -1;
		Restaurante restaurante = null;
		String nombre = "";
		String apellido = "";
		String telefono = "";
		String tipo = "";
		Mesa mesa = null;

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
					mesa = MesaDAO.SelectMesaPorIDEmpleado(id);
					CamareroMesa cmAux = new CamareroMesa(id, restaurante, nombre, apellido, telefono, mesa);
					return cmAux;
				case "cb":
					CamareroBarra cbAux = new CamareroBarra(id, restaurante, nombre, apellido, telefono);
					return cbAux;
				case "js":
					JefeSala jsAux = new JefeSala(id, restaurante, nombre, apellido, telefono);
					return jsAux;
//COCINEROS???
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
			cadena+=camarerosMesa.remove(0);
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
