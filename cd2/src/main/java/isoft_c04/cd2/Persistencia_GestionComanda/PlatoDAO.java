package isoft_c04.cd2.Persistencia_GestionComanda;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import isoft_c04.cd2.Dominio_GestionComanda.*;

public class PlatoDAO {

	public static ArrayList<Plato[]> obtenerPlatos() {
		// TODO - implement PlatoDAO.obtenerPlatos
		
		ArrayList<Plato[]> totalPlatos = new ArrayList<Plato[]>();
		Plato platoAux = null;
		ArrayList<Ingrediente> ingredientesPlato;
		int numRestaurantes=0;
		int numPlatos=0;
		int idPlatoAux=0;
		ResultSet queryAux;

		try {
			
			queryAux = Agente.consultaBD("select count(ID_Restaurante) "
					  + "from restaurante;");
			
			if(queryAux.next()){
				numRestaurantes = queryAux.getInt(1);
			}
			
			queryAux = Agente.consultaBD("select count(ID_Plato) "
  					+ "from plato;");
			
			if(queryAux.next()){
				numPlatos = queryAux.getInt(1);
			}
			
			for (int idRestaurante = 0; idRestaurante < numRestaurantes; idRestaurante++) {
				
				Plato[] platos = new Plato[numPlatos];
								
				for(int idPlato = 0; idPlato < numPlatos; idPlato++) {
					
					idPlatoAux= idPlato+1;
					queryAux = Agente.consultaBD("select id_plato, precio, nombre "
												 + "from plato "
												 + "where id_plato = "+ (idPlatoAux) +" ;");
					
					ingredientesPlato = IngredienteDAO.obtenerIngredientes(idRestaurante, idPlato);
					
					if(queryAux.next()){
						platoAux = new Plato(queryAux.getInt(1),queryAux.getDouble(2),ingredientesPlato,queryAux.getString(3));
						
					}
					
					platos[idPlato]= platoAux;
					
				}
				
				totalPlatos.add(platos);
				
			}
			
			return totalPlatos;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
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
	public static void eliminarUnPlatoRestaurante(int idRestaurante, int idPlato) {
		// TODO - implement PlatoDAO.eliminarUnPlatoRestaurante
		Statement st = Agente.conectar();
		/*
		 * 
		 * 		FUNCIONA !!
		 * 
		 * */
		try {
			st.executeUpdate("UPDATE INGREDIENTE_ALMACEN "
						   + "SET  cantidad = cantidad-1 "
						   + "WHERE ID_Restaurante="+idRestaurante
						   + " AND ID_Ingrediente IN (SELECT ID_Ingrediente "
							 					+ "FROM PLATO_INGREDIENTE "
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