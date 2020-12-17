package org.dominio;

import java.util.ArrayList;

public class Comanda {

	private int idComanda;
	private int idRestaurante;
	private double precio;
	private ArrayList<Bebida> bebidas;
	private ArrayList<Plato> entrantes;
	private ArrayList<Plato> primerPlato;
	private ArrayList<Plato> segundoPlato;
	private ArrayList<Plato> postre;
	private int idMesa;

	/**
	 * 
	 * @param idComanda
	 * @param idRestaurante
	 * @param precio
	 * @param entrantes
	 * @param primerPlato
	 * @param segundoPlato
	 */
	
	
	
	public Comanda() {
		
	}

	public Comanda(int idRestaurante, ArrayList<Bebida> bebidas,
			ArrayList<Plato> entrantes, ArrayList<Plato> primerPlato, ArrayList<Plato> segundoPlato,
			ArrayList<Plato> postre, int idMesa) {
		super();
		this.idRestaurante = idRestaurante;
		this.bebidas = bebidas;
		this.entrantes = entrantes;
		this.primerPlato = primerPlato;
		this.segundoPlato = segundoPlato;
		this.postre = postre;
		this.idMesa = idMesa;
	}

	public int getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}

	/**
	 * 
	 * @param idComanda
	 */
	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}
	
	public int getIdComanda() {
		return this.idComanda;
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

	public ArrayList<Bebida> getBebidas() {
		return this.bebidas;
	}

	/**
	 * 
	 * @param bebidas
	 */
	public void setBebidas(ArrayList<Bebida> bebidas) {
		this.bebidas = bebidas;
	}

	public ArrayList<Plato> getEntrantes() {
		return this.entrantes;
	}

	/**
	 * 
	 * @param entrantes
	 */
	public void setEntrantes(ArrayList<Plato> entrantes) {
		this.entrantes = entrantes;
	}

	public ArrayList<Plato> getPrimerPlato() {
		return this.primerPlato;
	}

	/**
	 * 
	 * @param primerPlato
	 */
	public void setPrimerPlato(ArrayList<Plato> primerPlato) {
		this.primerPlato = primerPlato;
	}

	public ArrayList<Plato> getSegundoPlato() {
		return this.segundoPlato;
	}

	/**
	 * 
	 * @param segundoPlato
	 */
	public void setSegundoPlato(ArrayList<Plato> segundoPlato) {
		this.segundoPlato = segundoPlato;
	}

	public ArrayList<Plato> getPostre() {
		return this.postre;
	}

	/**
	 * 
	 * @param postre
	 */
	public void setPostre(ArrayList<Plato> postre) {
		this.postre = postre;
	}

	public String toString() {
		// TODO - implement Comanda.toString
		throw new UnsupportedOperationException();
	}

}