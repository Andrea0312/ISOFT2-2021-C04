package org.dominio;

import java.util.ArrayList;

public class Almacen {
	
	private int idAlmacen;
	private int idRestaurante;
	private ArrayList<Bebida> bebidas;
	private ArrayList<Ingrediente> ingredientes;
	//umbral de cantidad
	
	
	public Almacen(int idAlmacen, int idRestaurante, ArrayList<Bebida> bebidas, ArrayList<Ingrediente> ingredientes) {
		super();
		this.idAlmacen = idAlmacen;
		this.idRestaurante = idRestaurante;
		this.bebidas = bebidas;
		this.ingredientes = ingredientes;
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


	public ArrayList<Bebida> getBebidas() {
		return bebidas;
	}


	public void setBebidas(ArrayList<Bebida> bebidas) {
		this.bebidas = bebidas;
	}


	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}


	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	} 
		
}
