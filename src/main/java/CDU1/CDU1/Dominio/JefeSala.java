package CDU1.CDU1.Dominio;

public class JefeSala extends Empleado{

		public JefeSala(int iD, Restaurante restaurante, String nombre, String apellido, String telefono) {
		super(iD, restaurante, nombre, apellido, telefono);
		}
		
		public void ReservarMesa(Mesa m) {
			m.setEstadoMesa(1);
		}
		public void AsignarCamareroMesa(Mesa m, CamareroMesa c) {
			//If mesa est� libre???
			m.setCamareroMesa(c);
		}
} 
