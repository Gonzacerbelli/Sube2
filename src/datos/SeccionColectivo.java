package datos;

public class SeccionColectivo {
	private int idSeccion;
	private float precio;
	
	public SeccionColectivo() {}

	public SeccionColectivo(float precio) {
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
