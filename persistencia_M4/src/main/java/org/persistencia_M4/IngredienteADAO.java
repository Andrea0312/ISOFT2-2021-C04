package org.persistencia_M4;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.dominio.Ingrediente;
import org.persistencia_M1.Agente;

public class IngredienteADAO {
	
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
	

	public static void aprovisionarIngredientes(int idRestaurante, int idIngrediente) {

		//Según la previsión hemos un mínimo de 30 unidades por ingrediente diario

		Statement st = Agente.Conectar();

		try {
			st.executeUpdate("UPDATE ingrediente_almacen"
					+ "SET  cantidad = 30"
					+ "WHERE ID_Restaurante="+idRestaurante
					+ " AND ID_Ingrediente="+idIngrediente+";");

		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public static void eactualizarIngredietentes(int idRestaurante, int idIngrediente) {
		// TODO - implement BebidaDAO.eliminarUnaBebida
		
		Statement st = Agente.Conectar();
		/*
		 * 
		 * 		FUNCIONA !!
		 * 
		 * */
		try {
			st.executeUpdate("UPDATE ingrediente_almacen "
						   + "SET  cantidad = cantidad-1 "
						   + "WHERE ID_Restaurante="+idRestaurante
						   + " AND ID_Ingrediente="+idIngrediente+";");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
}