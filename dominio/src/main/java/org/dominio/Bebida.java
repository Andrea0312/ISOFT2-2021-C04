package org.dominio;

public class Bebida {

	private int idBebida;
	private double precio;
	private int cantidad;
	private int idRestaurante;
	
	private String nombre;

	/**
	 * 
	 * @param idBebida
	 * @param precio
	 * @param cantidad
	 * @param idRestaurante
	 * @param nombre
	 */
	

	public Bebida(int idBebida, double precio, int cantidad, int idRestaurante, String nombre) {
		super();
		this.idBebida = idBebida;
		this.precio = precio;
		this.cantidad = cantidad;
		this.idRestaurante = idRestaurante;
		this.nombre = nombre;
	}

	public int getIdBebida() {
		return this.idBebida;
	}

	/**
	 * 
	 * @param idBebida
	 */
	public void setIdBebida(int idBebida) {
		this.idBebida = idBebida;
	}

	public double getPrecio() {
		return this.precio;
	}

	/**
	 * 
	 * @param precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
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

	public String toString() {
		// TODO - implement Bebida.toString
		throw new UnsupportedOperationException();
	}

}