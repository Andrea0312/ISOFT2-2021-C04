package CDU1.CDU1.Persistencia;
import java.sql.*;
import java.util.ArrayList;

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
    
    public static void SelectRestaurantes(ArrayList<Restaurante> restaurantes) throws SQLException {
        Connection conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
        Statement stmt = conexion.createStatement();	
        int id = -1;
        String ciudad = "";
        String nombre = "";
        //PROBAR

        try {
        	ResultSet result = stmt.executeQuery("SELECT * FROM isolab.restaurante;");			
        	while(result.next()) {
				id = result.getInt("ID_Restaurante");
				ciudad = result.getString("ciudad");
				nombre = result.getString("nombre");
				Restaurante rAux= new Restaurante(id, nombre, ciudad);
				restaurantes.add(rAux);
        	}

		} catch (SQLException e) {
			e.printStackTrace();
		}
        
    }
//	-----------------------PROBAR Y HACER LO DEL TIPO------------------------------
    public static void SelectEmpleados(ArrayList<Empleado> empleados) throws SQLException {
        Connection conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
        Statement stmt = conexion.createStatement();	
        int id = -1;
        int idRestaurante = -1;
        Restaurante restaurante = null;
        String nombre = "";
        String apellido = "";
        String telefono = "";

        try {
        	ResultSet result = stmt.executeQuery("SELECT * FROM isolab.empleado;");			
        	while(result.next()) {
        		id = result.getInt("ID_Empleado");
        		idRestaurante = result.getInt("ID_Restaurante");
//---------------CREAR MÉTODO PARA ENCONTRAR EN LA BBDD UN RESTAURANTE POR SU ID----------------------------
        		ResultSet resultRestaurante = stmt.executeQuery("SELECT * FROM isolab.restaurante WHERE (ID_Restaurante = "+id+")");
        		restaurante = new Restaurante(idRestaurante, resultRestaurante.getString("ciudad"), resultRestaurante.getString("nombre")); 
        		nombre = result.getString("nombre");
        		apellido = result.getString("apellido");
        		telefono = result.getString("telefono");
        		Empleado eAux = new Empleado(id, restaurante, nombre, apellido, telefono);
        		empleados.add(eAux);
        	}

		} catch (SQLException e) {
			e.printStackTrace();
		}
        
    }
//	-----------------------PROBAR------------------------------

    public static void SelectMesa(ArrayList<Mesa> mesas) throws SQLException {
        Connection conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
        Statement stmt = conexion.createStatement();	
        int id = -1;
        int idRestaurante = -1;
        Restaurante restaurante = null;
        int n_Comensales = -1;
        int estadoMesa = -1;

        try {
        	ResultSet result = stmt.executeQuery("SELECT * FROM isolab.mesa;");			
        	while(result.next()) {
        		id = result.getInt("ID_Empleado");
        		idRestaurante = result.getInt("ID_Restaurante");
//---------------CREAR MÉTODO PARA ENCONTRAR EN LA BBDD UN RESTAURANTE POR SU ID----------------------------
        		ResultSet resultRestaurante = stmt.executeQuery("SELECT * FROM isolab.restaurante WHERE (ID_Restaurante = "+id+")");
        		restaurante = new Restaurante(idRestaurante, resultRestaurante.getString("ciudad"), resultRestaurante.getString("nombre")); 
        		n_Comensales = result.getInt("n_Comensales");
        		estadoMesa = result.getInt("estadoMesa");
        		Mesa mesaAux = new Mesa(id, restaurante, n_Comensales, estadoMesa);
        		mesas.add(mesaAux);
        	}

		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

}