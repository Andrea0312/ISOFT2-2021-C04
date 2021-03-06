package org.dominio;

public class Ingrediente {

	private int IdIngrediente;
	private int cantidad;
	private int idRestaurante;
	private String nombre;

	/**
	 * 
	 * @param idIngrediente
	 * @param cantidad
	 * @param idRestaurante
	 * @param nombre
	 */
	
	public Ingrediente(int idIngrediente, int cantidad, int idRestaurante, String nombre) {
		super();
		IdIngrediente = idIngrediente;
		this.cantidad = cantidad;
		this.idRestaurante = idRestaurante;
		this.nombre = nombre;
	}

	public Ingrediente(int idIngrediente, String nombre) {
		super();
		IdIngrediente = idIngrediente;
		this.nombre = nombre;
	}



	public int getIdIngrediente() {
		// TODO - implement Ingrediente.getIdIngrediente
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param IdIngrediente
	 */
	public void setIdIngrediente(int IdIngrediente) {
		// TODO - implement Ingrediente.setIdIngrediente
		throw new UnsupportedOperationException();
	}

	public int getCantidad() {
		return this.cantidad;
	}

	/**
	 * 
	 * @param cantidad
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getIdRestaurante() {
		return this.idRestaurante;
	}

	/**
	 * 
	 * @param idRestaurante
	 */
	public void setIdRestaurante(int idRestaurante) {
		this.idRestaurante = idRestaurante;
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

	@Override
	public String toString() {
		return "Ingrediente [IdIngrediente=" + IdIngrediente + ", cantidad=" + cantidad + ", idRestaurante="
				+ idRestaurante + ", nombre=" + nombre + "]";
	}
		

}