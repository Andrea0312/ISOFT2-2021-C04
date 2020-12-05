package isoft_c04.cd2.Dominio_GestionComanda;

import java.util.ArrayList;

public class Plato {

	private int idPlato;
	private double precio;
	private ArrayList<Ingrediente> ingredientes;
	private String nombre;

	/**
	 * 
	 * @param idPlato
	 * @param precio
	 * @param ingredientes
	 * @param nombre
	 */
	public Plato(int idPlato, double precio, ArrayList<Ingrediente> ingredientes, String nombre) {
		// TODO - implement Plato.Plato
		throw new UnsupportedOperationException();
	}

	public int getIdPlato() {
		return this.idPlato;
	}

	/**
	 * 
	 * @param idPlato
	 */
	public void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
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

	public ArrayList<Ingrediente> getIngredientes() {
		return this.ingredientes;
	}

	/**
	 * 
	 * @param ingredientes
	 */
	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
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
		// TODO - implement Plato.toString
		throw new UnsupportedOperationException();
	}

}