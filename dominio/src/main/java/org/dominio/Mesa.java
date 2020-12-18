package org.dominio;

public class Mesa {
 
	private int ID;
	private Restaurante Restaurante;
	private CamareroMesa CamareroMesa;
	private int n_Comensales;
	private int estadoMesa;

	public Mesa(int iD, Restaurante restaurante, CamareroMesa camareroMesa, int n_Comensales, int estadoMesa) {

		ID = iD;
		Restaurante = restaurante;
		CamareroMesa = camareroMesa;
		this.n_Comensales = n_Comensales;
		this.estadoMesa = estadoMesa;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Restaurante getRestaurante() {
		return Restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		Restaurante = restaurante;
	}
	
	public CamareroMesa getCamareroMesa() {
		return CamareroMesa;
	}
	
	public void setCamareroMesa(CamareroMesa camareroMesa) {
		CamareroMesa = camareroMesa;
	}

	public int getN_Comensales() {
		return n_Comensales;
	}

	public void setN_Comensales(int n_Comensales) {
		this.n_Comensales = n_Comensales;
	}

	public int getEstadoMesa() {
		return estadoMesa;
	}
	
	public void setEstadoMesa(int newEstadoMesa) {
		estadoMesa = newEstadoMesa;
	}

	public void cambiarEstadoMesa() {
		if(estadoMesa == 9) {
			estadoMesa = 1;
		}else {
			estadoMesa++;
		}
	}	
	public String toString() {
		return "ID_Mesa: " + ID + ", Estado: " + estadoMesa + "\n";
	}
}
