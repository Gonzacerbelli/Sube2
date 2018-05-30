package datos;

public class Transporte {
	
	private int idTransporte;
	private double precio;
	
	public Transporte(double precio) {
		super();
		this.precio = precio;
	}

	public int getIdTransporte() {
		return idTransporte;
	}

	public void setIdTransporte(int idTransporte) {
		this.idTransporte = idTransporte;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
	
	
}