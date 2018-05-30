package datos;

public class Seccion {

	private int idSeccion;
	private int nroSeccion;
	private double precio;
	private Transporte transporte;
	
	public Seccion() {}

	public Seccion(int nroSeccion, double precio, Transporte transporte) {
		super();
		this.nroSeccion = nroSeccion;
		this.precio = precio;
		this.transporte = transporte;
	}

	public int getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(int idSeccion) {
		this.idSeccion = idSeccion;
	}

	public int getNroSeccion() {
		return nroSeccion;
	}

	public void setNroSeccion(int nroSeccion) {
		this.nroSeccion = nroSeccion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	
	
	
}
