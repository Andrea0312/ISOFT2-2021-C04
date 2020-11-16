package CDU1.CDU1;

public class Restaurante {
	private int ID;
	private String Nombre;
	private String Ciudad;
	private double tiempoTomaComandas;
	private double tiempoPrepComida;
	private double tiempoEntregaNota;
	private double tiempoMesaLire;
	private Empleado[] empleados;

	public Restaurante(int iD, String nombre, String ciudad, Empleado[] empleados, Mesa[] mesas) {
		ID = iD;
		Nombre = nombre;
		Ciudad = ciudad;
		this.empleados = empleados;
		this.mesas = mesas;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public double getTiempoTomaComandas() {
		return tiempoTomaComandas;
	}

	public void setTiempoTomaComandas(double tiempoTomaComandas) {
		this.tiempoTomaComandas = tiempoTomaComandas;
	}

	public double getTiempoPrepComida() {
		return tiempoPrepComida;
	}

	public void setTiempoPrepComida(double tiempoPrepComida) {
		this.tiempoPrepComida = tiempoPrepComida;
	}

	public double getTiempoEntregaNota() {
		return tiempoEntregaNota;
	}

	public void setTiempoEntregaNota(double tiempoEntregaNota) {
		this.tiempoEntregaNota = tiempoEntregaNota;
	}

	public double getTiempoMesaLire() {
		return tiempoMesaLire;
	}

	public void setTiempoMesaLire(double tiempoMesaLire) {
		this.tiempoMesaLire = tiempoMesaLire;
	}

	public Empleado[] getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Empleado[] empleados) {
		this.empleados = empleados;
	}

	public Mesa[] getMesas() {
		return mesas;
	}

	public void setMesas(Mesa[] mesas) {
		this.mesas = mesas;
	}

	private Mesa[] mesas;

}
