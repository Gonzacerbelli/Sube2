package datos;

public class Subte extends Transporte {
	private int idSubte;
	private String estacion;
	private String linea;
	private int interno;

	public Subte(float precio, String estacion, String linea, int interno) {
		super(precio);
		this.estacion = estacion;
		this.linea = linea;
		this.interno = interno;
	}

	public int getIdSubte() {
		return idSubte;
	}

	public void setIdSubte(int idSubte) {
		this.idSubte = idSubte;
	}

	public String getEstacion() {
		return estacion;
	}

	public void setEstacion(String estacion) {
		this.estacion = estacion;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public int getInterno() {
		return interno;
	}

	public void setInterno(int interno) {
		this.interno = interno;
	}
	
	
}
