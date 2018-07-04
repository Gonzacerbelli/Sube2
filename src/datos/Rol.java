package datos;

public class Rol {
	private int idRol;
	private String descripcion;
	
	public Rol() {	}

	public Rol(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
