package isoft_c04.cd2.Persistencia_GestionComanda;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import isoft_c04.cd2.Dominio_GestionComanda.*;

public class PlatoDAO {

	public static ArrayList<Plato> obtenerPlatos(int idRestaurante, int tipoPlato) {
		// TODO - implement PlatoDAO.obtenerPlatos

		ArrayList<Plato> platos = new ArrayList<Plato>();
		ArrayList<Ingrediente> ingredientes;
		ResultSet queryPlatos;

		/*
		 * select i.ID_Ingrediente, a.cantidad, i.nombre from ingrediente i,
		 * ingrediente_almacen a, plato_ingrediente p where a.ID_Ingrediente =
		 * i.ID_Ingrediente and i.ID_Ingrediente = p.ID_Ingrediente and a.ID_restaurante
		 * = 1 and p.id_plato = 1 order by ID_Restaurante, ID_Ingrediente;
		 */

		try {

			queryPlatos = Agente.consultaBD("select ID_Plato, precio, nombre, tipoPlato "
										  + "from plato "
										  + "where tipoPlato="+tipoPlato+";");
			
			System.out.println("consulta");

			while (queryPlatos.next()) {
				
				ingredientes = buscarIngredientes(idRestaurante,queryPlatos.getInt("ID_Plato"));

				Plato p = new Plato(queryPlatos.getInt("ID_Plato"), 
							        queryPlatos.getDouble("precio"),
							        ingredientes,
							        queryPlatos.getString("nombre"),
							        queryPlatos.getInt("tipoPlato"));

				platos.add(p);
			}

			return platos;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	private static ArrayList<Ingrediente> buscarIngredientes(int idRestaurante, int idPlato) {
		// TODO Auto-generated method stub

		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		
		try {
			
			ResultSet queryIngredientes = Agente.consultaBD("select i.ID_Ingrediente, a.cantidad, i.nombre\r\n"
					  									  + "from ingrediente i, ingrediente_almacen a, plato_ingrediente p\r\n"
					  									  + "where a.ID_Ingrediente = i.ID_Ingrediente\r\n"
					  									  + "and i.ID_Ingrediente = p.ID_Ingrediente\r\n" 
					  									  + "and a.ID_restaurante = "+idRestaurante+"\r\n"
					  									  + "and p.id_plato = "+idPlato+";");
			
			while (queryIngredientes.next()) {

				Ingrediente i = new Ingrediente(queryIngredientes.getInt("ID_Ingrediente"),
												queryIngredientes.getInt("cantidad"),
												idRestaurante,
												queryIngredientes.getString("nombre"));
				ingredientes.add(i);
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ingredientes;
	}

	/**
	 * 
	 * @param idRestaurante
	 * @param idPlato
	 */
	public static void eliminarUnPlatoRestaurante(int idRestaurante, int idPlato) {
		// TODO - implement PlatoDAO.eliminarUnPlatoRestaurante
		Statement st = Agente.conectar();
		/*
		 * 
		 * FUNCIONA !!
		 * 
		 */
		try {
			st.executeUpdate("UPDATE INGREDIENTE_ALMACEN " + "SET  cantidad = cantidad-1 " + "WHERE ID_Restaurante="
					+ idRestaurante + " AND ID_Ingrediente IN (SELECT ID_Ingrediente " + "FROM PLATO_INGREDIENTE "
					+ "WHERE ID_Plato=" + idPlato + ");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param idRestaurante
	 * @param idPlato
	 */
	public int disponibilidadPlatoRestaurante(int idRestaurante, int idPlato) {
		// TODO - implement PlatoDAO.disponibilidadPlatoRestaurante
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idRestaurante
	 * @param idPlato
	 */
	public boolean validarPlatoRestaurante(int idRestaurante, int idPlato) {
		// TODO - implement PlatoDAO.validarPlatoRestaurante
		throw new UnsupportedOperationException();
	}

}