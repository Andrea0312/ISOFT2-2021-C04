package org.dominio;

public class Empleado {
	private int ID;
	private Restaurante Restaurante;
	private String Nombre;
	private String Apellido;
	private String Telefono;
	  
	public Empleado(int iD, Restaurante rest, String nombre, String apellido, String telefono) {
		ID = iD;
		Restaurante = rest;
		Nombre = nombre;
		Apellido = apellido;
		Telefono = telefono;
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
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	
	public String toString() {
		return ID+" "+Restaurante.getNombre()+" "+Nombre+" "+Apellido+" "+Telefono;
	}

}
