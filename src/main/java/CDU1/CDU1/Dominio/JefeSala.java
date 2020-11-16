package CDU1.CDU1.Dominio;

public class JefeSala extends Empleado{

		public JefeSala(int iD, int restauranteID, String nombre, String apellido, String telefono) {
		super(iD, restauranteID, nombre, apellido, telefono);
		}
		
		public void ReservarMesa(Mesa m) {
			m.setEstadoMesa(1);
		}
		public void AsignarCamareroMesa(Mesa m, CamareroMesa c) {
			//If mesa est� libre???
			c.setMesa(m);
		}
} 
