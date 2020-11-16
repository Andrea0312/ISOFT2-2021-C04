package CDU1.CDU1;

public class Mesa {

	private int ID;
	private int RestauranteID;
	private int n_Comensales;
	private int estadoMesa;

	public Mesa(int iD, int restauranteID, int n_Comensales, int estadoMesa) {

		ID = iD;
		RestauranteID = restauranteID;
		this.n_Comensales = n_Comensales;
		this.estadoMesa = estadoMesa;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getRestauranteID() {
		return RestauranteID;
	}

	public void setRestauranteID(int restauranteID) {
		RestauranteID = restauranteID;
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
