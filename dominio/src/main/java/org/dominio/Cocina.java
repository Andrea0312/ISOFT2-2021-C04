package org.dominio;

import java.util.ArrayList;

public class Cocina {
	
	private int idCocina;
	private int idAlmacen;
	private int idRestaurante;
	private ArrayList<Ingrediente> ingredientes;
	
	public Cocina(int idCocina, int idAlmacen, int idRestaurante, ArrayList<Ingrediente> ingredientes) {
		super();
		this.idCocina = idCocina;
		this.idAlmacen = idAlmacen;
		this.idRestaurante = idRestaurante;
		this.ingredientes = ingredientes;
	}

	public int getIdCocina() {
		return idCocina;
	}

	public void setIdCocina(int idCocina) {
		this.idCocina = idCocina;
	}

	public int getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(int idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public int getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(int idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	} 
		
}
