package CDU1.CDU1.Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import CDU1.CDU1.Dominio.CamareroMesa;
import CDU1.CDU1.Dominio.Mesa;
import CDU1.CDU1.Dominio.Restaurante;

public class MesaDAO {
	public static void SelectTodasMesas(ArrayList<Mesa> mesas) throws SQLException {
		ResultSet result = Agente.Select("SELECT * FROM isolab.mesa");
		int id = -1;
		int idRestaurante = -1;
		Restaurante restaurante = null;
		int idCamareroMesa = -1;
		CamareroMesa CamareroMesa = null;
		int tamano = -1;
		int estado = -1;
		String estadoAux = "";
		Mesa mAux = null;

		try {
			while (result.next()) {
				id = result.getInt("ID_Mesa");
				idRestaurante = result.getInt("ID_Restaurante");
				restaurante = RestauranteDAO.SelectRestaurantePorID(idRestaurante);
				idCamareroMesa = result.getInt("ID_Empleado");
				CamareroMesa = CamareroMesaDAO.SelectCamareroMesaPorID(idCamareroMesa);
				tamano = result.getInt("Tamaño");
				estadoAux = result.getString("Estado");

				switch (estadoAux) {
				case "L":
					estado = 0;
					break;
				case "R":
					estado = 1;
					break;
				case "O":
					estado = 2;
					break;
				case "PI":
					estado = 3;
					break;
				case "ECO":
					estado = 4;
					break;
				case "S":
					estado = 5;
					break;
				case "ECU":
					estado = 6;
					break;
				case "PA":
					estado = 7;
					break;
				case "EP":
					estado = 8;
					break;
				default:
					estado = -1;
					break;
				}
				mAux = new Mesa(id, restaurante, CamareroMesa, tamano, estado);
				mesas.add(mAux);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static String CadenaMesas(ArrayList<Mesa> mesas) {
		String cadena = "";
		for(int i = 0; i<mesas.size(); i++){
			cadena += mesas.get(i).toString();
		}
		return cadena;
	}

	public static Mesa SelectMesaPorIDEmpleado(int ID_Empleado) throws SQLException {
		ResultSet result = Agente.Select("SELECT * FROM isolab.mesa where ID_Restaurante = " + ID_Empleado);
		int id = -1;
		int idRestaurante = -1;
		Restaurante restaurante = null;
		int idCamareroMesa = -1;
		CamareroMesa CamareroMesa = null;
		int tamano = -1;
		int estado = -1;
		Mesa mAux = null;

		try {
			while (result.next()) {
				id = result.getInt("ID_Mesa");
				idRestaurante = result.getInt("ID_Restaurante");
				restaurante = RestauranteDAO.SelectRestaurantePorID(idRestaurante);
				idCamareroMesa = result.getInt("ID_Empleado");
				CamareroMesa = (CamareroMesa) CamareroMesaDAO.SelectCamareroMesaPorID(idCamareroMesa);
				tamano = result.getInt("Tamaño");
				estado = result.getInt("Estado");
				mAux = new Mesa(id, restaurante, CamareroMesa, tamano, estado);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mAux;
	}

	public static Mesa SelectMesaPorID(int ID) throws SQLException {
		ResultSet result = Agente.Select("SELECT * FROM isolab.mesa where ID_Restaurante = " + ID);
		int id = ID;
		int idRestaurante = -1;
		Restaurante restaurante = null;
		int idCamareroMesa = -1;
		CamareroMesa CamareroMesa = null;
		int tamano = -1;
		int estado = -1;
		Mesa mAux = null;

		try {
			while (result.next()) {
				idRestaurante = result.getInt("ID_Restaurante");
				restaurante = RestauranteDAO.SelectRestaurantePorID(idRestaurante);
				idCamareroMesa = result.getInt("ID_Empleado");
				CamareroMesa = (CamareroMesa) CamareroMesaDAO.SelectCamareroMesaPorID(idCamareroMesa);
				tamano = result.getInt("Tamaño");
				estado = result.getInt("Estado");
				mAux = new Mesa(id, restaurante, CamareroMesa, tamano, estado);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mAux;
	}

	public static void UpdateMesaCamarero(ArrayList<Mesa> mesas) {
		while (!mesas.isEmpty()) {
			Mesa mesa = mesas.remove(0);
			try {
				ResultSet result = Agente.Update("UPDATE isolab.mesa SET ID_Empleado= '" + mesa.getCamareroMesa().getID()
						+ "' where ID_Mesa= '" + mesa + "'");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void UpdateMesaEstado(ArrayList<Mesa> mesas) {
		while (!mesas.isEmpty()) {
			Mesa mesa = mesas.remove(0);

			try {
				ResultSet result = Agente.Update(
						"UPDATE isolab.mesa SET Estado= '" + mesa.getEstadoMesa() + "' where ID_Mesa= '" + mesa + "'");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static int ObtenerEstado(String cadenaEstado) {
		switch (cadenaEstado) {
		case "Libre":
			return 0;
		case "Reservada":
			return 1;
		case "Ocupada":
			return 2;
		case "Pidiendo":
			return 3;
		case "En espera de comida":
			return 4;
		case "Servidos":
			return 5;
		case "Esperando la cuenta":
			return 6;
		case "Pagando":
			return 7;
		case "En preparacion":
			return 8;
		default:
			return -1;
		}
	}

}
