package isoft_c04.cd2.Dominio_GestionComanda;


public class Empleado {

	private int idEmpleado;
	private Restaurante idRestaurante;
	private String nombre;
	private String apellido;
	private int telefono;

	/**
	 * 
	 * @param idEmpleado
	 * @param restaurante
	 * @param nombre
	 * @param apellido
	 * @param telefono
	 */
	public Empleado(int idEmpleado, Restaurante restaurante, String nombre, String apellido, int telefono) {
		// TODO - implement Empleado.Empleado
		throw new UnsupportedOperationException();
	}

	public int getIdEmpleado() {
		return this.idEmpleado;
	}

	/**
	 * 
	 * @param idEmpleado
	 */
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Restaurante getRestaurante() {
		// TODO - implement Empleado.getRestaurante
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param restaurante
	 */
	public void setRestaurante(Restaurante restaurante) {
		// TODO - implement Empleado.setRestaurante
		throw new UnsupportedOperationException();
	}

	public String getNombre() {
		return this.nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	/**
	 * 
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getTelefono() {
		return this.telefono;
	}

	/**
	 * 
	 * @param telefono
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String toString() {
		// TODO - implement Empleado.toString
		throw new UnsupportedOperationException();
	}

}