package isoft_c04.cd2.Persistencia_GestionComanda;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import isoft_c04.cd2.Dominio_GestionComanda.*;

public class PlatoDAO {

	public ArrayList<Plato> obtenerPlatos() {
		// TODO - implement PlatoDAO.obtenerPlatos
		
		ArrayList<Plato> todosPlatos = new ArrayList<Plato>();
		ArrayList<Ingrediente[]> todosIngredientes = new ArrayList<Ingrediente[]>();
		
		todosIngredientes = IngredienteDAO.obtenerIngredientes();
		
		/*
		 * 
		 * 		PROBAR LA CONSULTA !!
		 * 
		 * */
		
		//ResultSet result = Agente.consultaBD("SELECT ALL "
		//		 						   + "FROM INGREDIENTE_ALMACEN;");

		/*
		 * 
		 * 		PROBAR LA CONSULTA !!
		 * 
		 * */
		//ResultSet result = Agente.consultaBD("SELECT ALL FROM isolab.PLATOS;");
		
		try {
			ResultSet result = Agente.consultaBD("SELECT ALL FROM isolab.PLATOS;");
			while (result.next()) {
				Plato pl = new Plato(result.getInt("idPlato")
									,result.getDouble("precio")
									,buscarIngredientes(todosIngredientes,result.getInt("idPlato"))
									,result.getString("nombre"));
				todosPlatos.add(pl);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return todosPlatos;
		
	}

	
	private ArrayList<Ingrediente> buscarIngredientes(ArrayList<Ingrediente[]> todosIngredientes, int idPlato) {
		// TODO Auto-generated method stub
		
		ArrayList<Ingrediente> ingtes = new ArrayList<Ingrediente>();
		/*
		 * 
		 * 		FUNCIONA !!
		 * 
		 * */
		ResultSet result = Agente.consultaBD("SELECT ID_Ingrediente "
										   + "FROM PLATO_INGREDIENTE "
										   + "WHERE ID_Plato="+idPlato+");");
//		try {
//			while (result.next()) {
//				ingtes.add(todosIngredientes.get(result.getInt("idIngrediente")));
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		return ingtes;
	}

	/**
	 * 
	 * @param idRestaurante
	 * @param idPlato
	 */
	public void eliminarUnPlatoRestaurante(int idRestaurante, int idPlato) {
		// TODO - implement PlatoDAO.eliminarUnPlatoRestaurante
		Statement st = Agente.conectar();
		/*
		 * 
		 * 		FUNCIONA !!
		 * 
		 * */
		try {
			st.executeUpdate("UPDATE INGREDIENTE_ALMACEN"
						   + "SET  cantidad = cantidad-1 "
						   + "WHERE ID_Restaurante="+idRestaurante
						   + "AND ID_Ingrediente = (SELECT ID_Ingrediente"
							 					+ "FROM PLATO_INGREDIENTE"
							 					+ "WHERE ID_Plato="+idPlato+");");			
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