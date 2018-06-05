package datos;

public class RedSube {
	private int idRedSube;
	private double procentaje;
	private int cantidadBoletos;
	private String descripcion;
	
	public RedSube(double procentaje, int cantidadBoletos, String descripcion) {
		super();
		this.procentaje = procentaje;
		this.cantidadBoletos = cantidadBoletos;
		this.descripcion = descripcion;
	}

	public int getIdRedSube() {
		return idRedSube;
	}

	public void setIdRedSube(int idRedSube) {
		this.idRedSube = idRedSube;
	}

	public double getProcentaje() {
		return procentaje;
	}

	public void setProcentaje(double procentaje) {
		this.procentaje = procentaje;
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
	
}
