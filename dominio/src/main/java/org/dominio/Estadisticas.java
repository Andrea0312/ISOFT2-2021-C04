package org.dominio;

public class Estadisticas {
	
	int tmComandas;
	int tmPreparacion;
	int tmNota;
	int tmMesaLibreL;
	
	public Estadisticas(int tmComandas, int tmPreparacion, int tmNota, int tmMesaLibreL) {
		super();
		this.tmComandas = tmComandas;
		this.tmPreparacion = tmPreparacion;
		this.tmNota = tmNota;
		this.tmMesaLibreL = tmMesaLibreL;
	}

	public int getTmComandas() {
		return tmComandas;
	}

	public void setTmComandas(int tmComandas) {
		this.tmComandas = tmComandas;
	}

	public int getTmPreparacion() {
		return tmPreparacion;
	}

	public void setTmPreparacion(int tmPreparacion) {
		this.tmPreparacion = tmPreparacion;
	}

	public int getTmNota() {
		return tmNota;
	}

	public void setTmNota(int tmNota) {
		this.tmNota = tmNota;
	}

	public int getTmMesaLibreL() {
		return tmMesaLibreL;
	}

	public void setTmMesaLibreL(int tmMesaLibreL) {
		this.tmMesaLibreL = tmMesaLibreL;
	}
	
}
