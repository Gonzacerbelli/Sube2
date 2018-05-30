package datos;

public class Colectivo extends Transporte {
	private int idColectivo;
	private int linea;
	private String ramal;
	private int interno;
	private SeccionColectivo seccion;

	public Colectivo(float precio, int linea, String ramal, int interno, SeccionColectivo seccion) {
		super(precio);
		this.linea = linea;
		this.ramal = ramal;
		this.interno = interno;
		this.seccion = seccion;
	}

	public int getIdColectivo() {
		return idColectivo;
	}

	public void setIdColectivo(int idColectivo) {
		this.idColectivo = idColectivo;
	}

	public int getLinea() {
		return linea;
	}

	public void setLinea(int linea) {
		this.linea = linea;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public int getInterno() {
		return interno;
	}

	public void setInterno(int interno) {
		this.interno = interno;
	}

	public SeccionColectivo getSeccion() {
		return seccion;
	}

	public void setSeccion(SeccionColectivo seccion) {
		this.seccion = seccion;
	}
	
	
}
