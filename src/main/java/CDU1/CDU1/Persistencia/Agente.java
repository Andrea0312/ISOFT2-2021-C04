package CDU1.CDU1.Persistencia;
import java.sql.*;
import CDU1.CDU1.Dominio.*;


public class Agente {

    private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://148.3.109.70:3306/isolab?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USUARIO = "pablovelasco";
    private static final String CLAVE = "ISO2c04//2020";
 
    
    public static Connection conectar()  {
        Connection conexion = null;
        
        try {
            Class.forName(CONTROLADOR);
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexión OK");

        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Error en la conexión");
            e.printStackTrace();
        }
        
        return conexion;
    }
    
    public static void Select() throws SQLException {
        Connection conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
        Statement stmt = conexion.createStatement();	
        int id = 654654;
        String ciudad = "";
        String nombre = "";
        //PROBAR

        try {
        	ResultSet result = stmt.executeQuery("SELECT * FROM isolab.restaurante;");			
        	while(result.next()) {
				id = result.getInt("ID_Restaurante");
				ciudad = result.getString("ciudad");
				nombre = result.getString("nombre");
				Restaurante restaurante= new Restaurante(id, nombre, ciudad);
				System.out.println(restaurante);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

}