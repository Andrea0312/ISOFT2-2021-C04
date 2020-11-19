package CDU1.CDU1.Persistencia;
import java.sql.*;
import java.util.ArrayList;

import CDU1.CDU1.Dominio.*;


public class Agente {

    private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://148.3.109.70:3306/isolab?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USUARIO = "pablovelasco";
    private static final String CLAVE = "ISO2c04//2020";
 
    
    public static Statement Conectar()  {
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
        Statement stmt= Conectar();	
        ResultSet result = stmt.executeQuery(cadena);		
        return result;
    }
    
    public static ResultSet Update(String cadena) throws SQLException {
        Statement stmt= Conectar();	
        ResultSet result = stmt.executeQuery(cadena);		
        return result;
    }
}