package org.persistencia_M2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.dominio.*;
import org.persistencia_M1.*;


public class IngredienteDAO {

	public static ArrayList<Ingrediente> obtenerIngredientes(int idRestaurante, int idPlato) {
		// TODO - implement IngredienteDAO.obtenerIngredientes
				
		Ingrediente ingrediente;
		ArrayList<Ingrediente> ingredientesPlato = new ArrayList<Ingrediente>();
		ResultSet ingredientesRestauranteN;
		
		try {
			
			ingredientesRestauranteN = Agente.Select("select i.ID_Ingrediente, a.cantidad, a.ID_Restaurante, i.nombre "
					 								   + "from ingrediente i, ingrediente_almacen a, plato_ingrediente p "
					 								   + "where a.ID_Ingrediente = i.ID_Ingrediente "
					 								   + "and i.ID_Ingrediente = p.ID_Ingrediente "
					 								   + "and a.ID_restaurante ="+ (idRestaurante+1)
					 								   + " and p.id_plato = "+ (idPlato+1)
					 								   + " order by ID_Restaurante, ID_Ingrediente;");
			
			while (ingredientesRestauranteN.next()) {
				ingrediente = new Ingrediente(ingredientesRestauranteN.getInt(1)
											 ,ingredientesRestauranteN.getInt(2)
											 ,idRestaurante
											 ,ingredientesRestauranteN.getString(3));
				ingredientesPlato.add(ingrediente);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ingredientesPlato;
		
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