package datos;

public class Ramal {
	private int idRamal;
	private String nombre;
	private Linea linea;
	
	public Ramal() {}

	public Ramal(String nombre, Linea linea) {
		super();
		this.nombre = nombre;
		this.linea = linea;
	}

	public int getIdRamal() {
		return idRamal;
	}

	public void setIdRamal(int idRamal) {
		this.idRamal = idRamal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Linea getLinea() {
		return linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}
	
	
}
