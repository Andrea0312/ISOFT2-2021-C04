package CDU1.CDU1.Dominio;

import java.sql.SQLException;
import java.util.ArrayList;

import CDU1.CDU1.Persistencia.Agente;

public class Principal {

	public static ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();

	public static void main(String[] args) {
		Agente.conectar();
		try {
			Agente.SelectRestaurantes(restaurantes);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
