package CDU1.CDU1.Dominio;

public class Mesa {

	private int ID;
	private Restaurante Restaurante;
	private int n_Comensales;
	private int estadoMesa;

	public Mesa(int iD, Restaurante restaurante, int n_Comensales, int estadoMesa) {

		ID = iD;
		Restaurante = restaurante;
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

	public int getN_Comensales() {
		return n_Comensales;
	}

	public void setN_Comensales(int n_Comensales) {
		this.n_Comensales = n_Comensales;
	}

	public int getEstadoMesa() {
		return estadoMesa;
	}

	public void setEstadoMesa(int estadoMesa) {
		this.estadoMesa = estadoMesa;
	}

}