package datos;

import java.util.*;

public class Usuario {
	private int idUsuario;
	private String nombre;
	private String apellido;
	private int dni;
	private String pass;
	private String email;
	private String permiso;
	private Set<Tarjeta> tarjetas;
	private Set<UsuarioDescuento> usuarioDescuentos;
	private Set<UsuarioBeneficio> usuarioBeneficios;
	private Set<UsuarioRol> usuarioRoles;
	
	public Usuario() {}
	
	public Usuario(String nombre, String apellido, int dni, String pass, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.pass = pass;
		this.email = email;
	}



	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPermiso() {
		return permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}

	public Set<UsuarioDescuento> getUsuarioDescuentos() {
		return usuarioDescuentos;
	}

	public void setUsuarioDescuentos(Set<UsuarioDescuento> usuarioDescuentos) {
		this.usuarioDescuentos = usuarioDescuentos;
	}
	
	public Set<UsuarioBeneficio> getUsuarioBeneficios() {
		return usuarioBeneficios;
	}

	public void setUsuarioBeneficios(Set<UsuarioBeneficio> usuarioBeneficios) {
		this.usuarioBeneficios = usuarioBeneficios;
	}

	public Set<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(Set<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}

	
	
	public Set<UsuarioRol> getUsuarioRoles() {
		return usuarioRoles;
	}



	public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
		this.usuarioRoles = usuarioRoles;
	}



	public double aplicarDescuentos(double monto ) {
		for(UsuarioDescuento usuarioDescuento: usuarioDescuentos)
		{
			monto = usuarioDescuento.aplicarDescuento(monto);
		}
		return monto;
	}
	
	public void agregarDescuento(UsuarioDescuento usuarioDescuento) throws Exception
	{
		if(usuarioDescuentos.contains(usuarioDescuento))
		{
			throw new Exception("El descuento ya había sido asignado.");
		}
		usuarioDescuentos.add(usuarioDescuento);
	}
	
	public void agregarBeneficio(UsuarioBeneficio usuarioBeneficio) throws Exception
	{
		if(usuarioBeneficios.contains(usuarioBeneficio))
		{
			throw new Exception("El Beneficio ya había sido asignado.");
		}
		usuarioBeneficios.add(usuarioBeneficio);
	}
	
	public void asignarTarjeta(Tarjeta tarjeta) {
		tarjetas.add(tarjeta);
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", pass=" + pass + ", email=" + email + ", usuarioDescuentos="
				+ usuarioDescuentos + ", usuarioBeneficios=" + usuarioBeneficios + "]";
	}
	
	
	
	
	
	
}
