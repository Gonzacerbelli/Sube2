package datos;

public class UsuarioRol {
	private int idUsuarioRol;
	private Usuario usuario;
	private Rol rol;
	
	public UsuarioRol() { }

	public UsuarioRol(Usuario usuario, Rol rol) {
		super();
		this.usuario = usuario;
		this.rol = rol;
	}

	public int getIdUsuarioRol() {
		return idUsuarioRol;
	}

	public void setIdUsuarioRol(int idUsuarioRol) {
		this.idUsuarioRol = idUsuarioRol;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
}
