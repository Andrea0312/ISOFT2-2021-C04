package isoft_c04.cd2.Persistencia_GestionComanda;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import isoft_c04.cd2.Dominio_GestionComanda.Ingrediente;

public class IngredienteDAO {

	public static ArrayList<Ingrediente[]> obtenerIngredientes() {
		// TODO - implement IngredienteDAO.obtenerIngredientes
		
		ArrayList<Ingrediente[]> todosIngredientes = new ArrayList<Ingrediente[]>();
		Ingrediente[] ingredientes;
		
		
		int contador=0;

		try {
			int numIngr = Agente.consultaBD("select max(ID_Ingrediente) from ingrediente;").getInt(0);
			int numRest = Agente.consultaBD("SELECT max(ID_Restaurante) from restaurante;").getInt(0);
			for(int i = 0; i < numRest; i++) {
				ingredientes = new Ingrediente[numIngr];
				/*
				 * 
				 * 		FUNCIONA !!
				 * 
				 * */
				ResultSet result = Agente.consultaBD("SELECT A.ID_Ingrediente, A.cantidad, A.ID_Restaurante, I.nombre"
												   + "FROM INGREDIENTE I, INGREDIENTE_ALMACEN A"
												   + "WHERE A.ID_Ingrediente = I.ID_Ingrediente"
												   + "AND ID_Restaurante="+numRest
												   + "ORDER BY ID_Restaurante, ID_Ingrediente;");
				while (result.next()) {
					
					Ingrediente ingrediente = new Ingrediente(result.getInt("idIngrediente")
													 ,result.getInt("cantidad")
													 ,result.getInt("idRestaurante")
													 ,result.getString("nombre"));
					ingredientes[contador] = ingrediente;
					contador++;
				}
				contador=0;
				todosIngredientes.add(ingredientes);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return todosIngredientes;
		
	}

	/**
	 * 
	 * @param idRestaurante
	 * @param idIngrediente
	 */
	public void eliminarIngredienteRestaurante(int idRestaurante, int idIngrediente) {
		// TODO - implement IngredienteDAO.eliminarIngredienteRestaurante
		throw new UnsupportedOperationException();
	}

}