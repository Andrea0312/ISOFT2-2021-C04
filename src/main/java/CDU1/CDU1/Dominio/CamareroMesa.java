package CDU1.CDU1.Dominio;

public class CamareroMesa extends Empleado {
	private Mesa mesa;

	public CamareroMesa(int iD, Restaurante restaurante, String nombre, String apellido, String telefono) {
		super(iD, restaurante, nombre, apellido, telefono);
	}
	
	public CamareroMesa(int iD, Restaurante restaurante, String nombre, String apellido, String telefono, Mesa m) {
		super(iD, restaurante, nombre, apellido, telefono);
		mesa = m;
	}
	public void CambiarEstadoMesa(int estado) {
		mesa.setEstadoMesa(estado);
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa m) {
		mesa = m;
	}

}
