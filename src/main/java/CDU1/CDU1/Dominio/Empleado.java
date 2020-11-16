package CDU1.CDU1.Dominio;

public class Empleado {
	private int ID;
	private int RestauranteID;
	private String Nombre;
	private String Apellido;
	private String Telefono;
	 
	public Empleado(int iD, int restauranteID, String nombre, String apellido, String telefono) {
		ID = iD;
		RestauranteID = restauranteID;
		Nombre = nombre;
		Apellido = apellido;
		Telefono = telefono;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getRestauranteID() {
		return RestauranteID;
	}
	public void setRestauranteID(int restauranteID) {
		RestauranteID = restauranteID;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	
	
	
}
