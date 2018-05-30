package datos;

public class Linea {
	private int idLinea;
	private String nombre;
	private Transporte transporte;
	
	public Linea() {}

	public Linea(String nombre, Transporte transporte) {
		super();
		this.nombre = nombre;
		this.transporte = transporte;
	}

	public int getIdLinea() {
		return idLinea;
	}

	public void setIdLinea(int idLinea) {
		this.idLinea = idLinea;
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
	
	

}
