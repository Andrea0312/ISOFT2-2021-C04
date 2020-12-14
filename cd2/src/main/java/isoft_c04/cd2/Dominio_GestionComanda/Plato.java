package isoft_c04.cd2.Dominio_GestionComanda;

import java.util.ArrayList;

public class Plato {

	private int idPlato;
	private double precio;
	private ArrayList<Ingrediente> ingredientes;
	private String nombre;
	private int tipo;

	/**
	 * 
	 * @param idPlato
	 * @param precio
	 * @param ingredientes
	 * @param nombre
	 */
	

	public Plato(int idPlato, double precio, ArrayList<Ingrediente> ingredientes, String nombre, int tipo) {
		super();
		this.idPlato = idPlato;
		this.precio = precio;
		this.ingredientes = ingredientes;
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	
	
	public int getTipo() {
		return tipo;
	}



	public void setTipo(int tipo) {
		this.tipo = tipo;
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

	@Override
	public String toString() {
		return "Plato [idPlato=" + idPlato + ", precio=" + precio + ", ingredientes=" + ingredientes + ", nombre="
				+ nombre + "]";
	}

}