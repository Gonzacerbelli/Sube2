package datos;

public class Estacion {
	private int idEstacion;
	private String nombre;
	private Ramal ramal;
	private Linea linea;
	
	public Estacion() {}

	public Estacion(String nombre, Ramal ramal, Linea linea) {
		super();
		this.nombre = nombre;
		this.ramal = ramal;
		this.linea = linea;
	}

	public int getIdEstacion() {
		return idEstacion;
	}

	public void setIdEstacion(int idEstacion) {
		this.idEstacion = idEstacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Ramal getRamal() {
		return ramal;
	}

	public void setRamal(Ramal ramal) {
		this.ramal = ramal;
	}

	public Linea getLinea() {
		return linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}

	
}
