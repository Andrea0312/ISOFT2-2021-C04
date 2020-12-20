package org.persistencia_M1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.dominio.CamareroMesa;
import org.dominio.Mesa;
import org.dominio.Restaurante;

public class MesaDAO {
	public static void SelectTodasMesas(ArrayList<Mesa> mesas) throws SQLException {
		ResultSet result = Agente.Select("SELECT * FROM C04dbservice.mesa");
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
				idCamareroMesa = result.getInt("ID_Empleado");
				tamano = result.getInt("Tamaño");
				estado = result.getInt("ID_EstadoMesa");
				restaurante = RestauranteDAO.SelectRestaurantePorID(idRestaurante);
				CamareroMesa = CamareroMesaDAO.SelectCamareroMesaPorID(idCamareroMesa);
				mAux = new Mesa(id, restaurante, CamareroMesa, tamano, estado);
				mesas.add(mAux);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static String CadenaMesas(ArrayList<Mesa> mesas) {
		String cadena = "";
		for (int i = 0; i < mesas.size(); i++) {
			cadena += mesas.get(i).toString();
		}
		return cadena;
	}

	public static Mesa SelectMesaPorIDEmpleado(int ID_Empleado) throws SQLException {
		ResultSet result = Agente.Select("SELECT * FROM C04dbservice.mesa where ID_Empleado = " + ID_Empleado);
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
				CamareroMesa = CamareroMesaDAO.SelectCamareroMesaPorID(idCamareroMesa);
				tamano = result.getInt("Tamaño");
				estado = result.getInt("ID_EstadoMesa");
				mAux = new Mesa(id, restaurante, CamareroMesa, tamano, estado);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mAux;
	}

	public static Mesa SelectMesaPorID(int ID) throws SQLException {
		ResultSet result = Agente.Select("SELECT * FROM C04dbservice.mesa where ID_Mesa = " + ID);
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
				estado = result.getInt("ID_EstadoMesa");
				mAux = new Mesa(id, restaurante, CamareroMesa, tamano, estado);
				System.out.println(mAux);
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
				Agente.Update("UPDATE C04dbservice.mesa SET ID_Empleado= '" + mesa.getCamareroMesa().getID()
						+ "' where ID_Mesa= '" + mesa.getID() + "'");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void UpdateMesaEstado(Mesa mesa) {
		try {
			Agente.Update("UPDATE C04dbservice.mesa SET ID_EstadoMesa= '" + mesa.getEstadoMesa() + "' where ID_Mesa= '"
					+ mesa.getID() + "';");
		} catch (SQLException e) {
			e.printStackTrace();
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
