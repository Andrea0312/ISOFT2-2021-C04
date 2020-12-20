package org.persistencia_M1;

import java.sql.*;

public class Agente {

	private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://172.20.48.70/C04dbservice?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USUARIO = "C04";
	private static final String CLAVE = "@ISoft2.2020#";

	public static Statement Conectar() {
		Connection conexion = null;
		Statement stmt = null;
		try {
			Class.forName(CONTROLADOR);
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			stmt = conexion.createStatement();
			System.out.println("Conexión OK");

		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();

		} catch (SQLException e) {
			System.out.println("Error en la conexión");
			e.printStackTrace();
		}

		return stmt;
	}

	public static ResultSet Select(String cadena) throws SQLException {
		Statement stmt = Conectar();
		ResultSet result = stmt.executeQuery(cadena);
		return result;
	}

	public static PreparedStatement Update(String cadena) throws SQLException {
		Connection conexion = null;
		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
		PreparedStatement preparedStmt = conexion.prepareStatement(cadena);
		preparedStmt.executeUpdate();
		return preparedStmt;
	}
}