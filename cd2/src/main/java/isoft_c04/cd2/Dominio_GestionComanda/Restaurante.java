package isoft_c04.cd2.Dominio_GestionComanda;


import java.util.ArrayList;


public class Restaurante {

	private int idRestaurante;
	private String ciudad;
	private String direccion;
	private double tiempoTomaComandas;
	private double tiempoPrepComida;
	private double tiempoEntregaNota;
	private double tiempoMesaLibre;
	private ArrayList<Empleado> empleados;

	//private ArrayList<Mesa> mesas;
	
	/**
	 * 
	 * @param idRestaurante
	 * @param ciudad
	 * @param direccion
	 * @param empleados
	 */
	public Restaurante(int idRestaurante, String ciudad, String direccion, ArrayList<Empleado> empleados) {
		// TODO - implement Restaurante.Restaurante
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idRestaurante
	 * @param ciudad
	 * @param direccion
	 */
	public Restaurante(int idRestaurante, String ciudad, String direccion) {
		// TODO - implement Restaurante.Restaurante
		throw new UnsupportedOperationException();
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

	public String getCiudad() {
		return this.ciudad;
	}

	/**
	 * 
	 * @param ciudad
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return this.direccion;
	}

	/**
	 * 
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getTiempoTomaComandas() {
		return this.tiempoTomaComandas;
	}

	/**
	 * 
	 * @param tiempoTomaComandas
	 */
	public void setTiempoTomaComandas(double tiempoTomaComandas) {
		this.tiempoTomaComandas = tiempoTomaComandas;
	}

	public double getTiempoPrepComida() {
		return this.tiempoPrepComida;
	}

	/**
	 * 
	 * @param tiempoPrepComida
	 */
	public void setTiempoPrepComida(double tiempoPrepComida) {
		this.tiempoPrepComida = tiempoPrepComida;
	}

	public double getTiempoEntregaNota() {
		return this.tiempoEntregaNota;
	}

	/**
	 * 
	 * @param tiempoEntregaNota
	 */
	public void setTiempoEntregaNota(double tiempoEntregaNota) {
		this.tiempoEntregaNota = tiempoEntregaNota;
	}

	public ArrayList<Empleado> getEmpleados() {
		return this.empleados;
	}

	/**
	 * 
	 * @param empleados
	 */
	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}

//	public ArrayList<Mesa> getMesas() {
//	return this.mesas;
//}
//
///**
// * 
// * @param mesas
// */
//public void setMesas(ArrayList<Mesa> mesas) {
//	this.mesas = mesas;
//}

	public String toString() {
		// TODO - implement Restaurante.toString
		throw new UnsupportedOperationException();
	}

}