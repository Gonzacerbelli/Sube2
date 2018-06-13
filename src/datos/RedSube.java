package datos;

public class RedSube {
	private int idRedSube;
	private double porcentaje;
	private int cantidadBoletos;
	private String descripcion;
	
	public RedSube() { }
	
	public RedSube(double porcentaje, int cantidadBoletos, String descripcion) {
		super();
		this.porcentaje = porcentaje;
		this.cantidadBoletos = cantidadBoletos;
		this.descripcion = descripcion;
	}

	public int getIdRedSube() {
		return idRedSube;
	}

	public void setIdRedSube(int idRedSube) {
		this.idRedSube = idRedSube;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public int getCantidadBoletos() {
		return cantidadBoletos;
	}

	public void setCantidadBoletos(int cantidadBoletos) {
		this.cantidadBoletos = cantidadBoletos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public double aplicarDescuento(double monto) {
		return monto * ((100.0 - porcentaje) / 100);
	}
	
}

