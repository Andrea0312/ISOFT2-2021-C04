package org.dominio;

public class JefeSala extends Empleado{

		public JefeSala(int iD, Restaurante restaurante, String nombre, String apellido, String telefono) {
		super(iD, restaurante, nombre, apellido, telefono);
		}
		public void AsignarCamareroMesa(Mesa m, CamareroMesa c) {
			//If mesa est� libre???
			m.setCamareroMesa(c);
		}
} 
