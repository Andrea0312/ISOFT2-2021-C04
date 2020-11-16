package CDU1.CDU1;

import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) {
		Conexion.conectar();
		try {
			Conexion.Select();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
