package org.persistencia_M2;

import java.sql.*;

public class Agente {
	
	private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://172.20.48.70/C04dbservice?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USUARIO = "C04";
    private static final String CLAVE = "@ISoft2.2020#";
    
//    private static final String URL = "jdbc:mysql://localhost/isolab?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//    private static final String USUARIO = "root";
//    private static final String CLAVE = "ISO2c04//2020";

	public static Statement conectar() {
		// TODO - implement Agente.conectar
		Connection conexion = null;
        Statement stmt = null;
        try {
            Class.forName(CONTROLADOR);
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            stmt = conexion.createStatement();	
            //System.out.println("Conexión OK");

        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Error en la conexión");
            e.printStackTrace();
        }
        
        return stmt;
		
	}

	/**
	 * 
	 * @param cadena
	 * @return 
	 */
	public static ResultSet consultaBD(String cadena) {
		// TODO - implement Agente.consultaBD
		Statement stmt= conectar();	
        ResultSet result;
		try {
			result = stmt.executeQuery(cadena);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
        return null;
	}

}