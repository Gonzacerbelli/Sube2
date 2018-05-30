package datos;

public class SeccionTren {
	private int idSeccion;
	private float precio;
	
	public SeccionTren() {}

	public SeccionTren(float precio) {
		super();
		this.precio = precio;
	}

	public int getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(int idSeccion) {
		this.idSeccion = idSeccion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
}
