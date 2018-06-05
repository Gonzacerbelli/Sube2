package datos;

public class Tarifa {
	private int idTarifa;
	private String nombre;
	private int cantEstaciones;
	private double monto;
	private Transporte transporte;
	
	public Tarifa() {}
	
	public Tarifa(String nombre, int cantEstaciones, Transporte transporte, double monto) {
		super();
		this.nombre = nombre;
		this.cantEstaciones = cantEstaciones;
		this.transporte = transporte;
		this.monto = monto;
	}

	public int getCantEstaciones() {
		return cantEstaciones;
	}

	public void setCantEstaciones(int cantEstaciones) {
		this.cantEstaciones = cantEstaciones;
	}

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

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	
	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}
	
}
