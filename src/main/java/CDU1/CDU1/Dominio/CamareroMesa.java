package CDU1.CDU1.Dominio;

public class CamareroMesa extends Camarero {
	private Mesa mesa;

	public CamareroMesa(int iD, int restauranteID, String nombre, String apellido, String telefono) {
		super(iD, restauranteID, nombre, apellido, telefono);
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
