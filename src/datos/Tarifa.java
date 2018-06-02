package datos;

public class Tarifa {
	private int idTarifa;
	private String nombre;
	private int cantTransportees;
	private int idTransporte;
	private float monto;
	
	public Tarifa() {}
	


	public int getIdTarifa() {
		return idTarifa;
	}

	public void setIdTarifa(int idTarifa) {
		this.idTarifa = idTarifa;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getCantTransportees() {
		return cantTransportees;
	}



	public void setCantTransportees(int cantTransportees) {
		this.cantTransportees = cantTransportees;
	}



	public int getIdTransporte() {
		return idTransporte;
	}



	public void setIdTransporte(int idTransporte) {
		this.idTransporte = idTransporte;
	}



	public float getMonto() {
		return monto;
	}



	public void setMonto(float monto) {
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "Tarifa [idTarifa=" + idTarifa + ", nombre=" + nombre + ", cantTransportees=" + cantTransportees
				+ ", idTransporte=" + idTransporte + ", monto=" + monto + "]";
	}
	
}
