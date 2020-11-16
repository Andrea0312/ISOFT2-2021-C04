package CDU1.CDU1.Interfaz;

import java.sql.SQLException;

import CDU1.CDU1.Persistencia.Agente;

public class Principal {

	public static void main(String[] args) {
		Agente.conectar();
		try {
			Agente.Select();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
