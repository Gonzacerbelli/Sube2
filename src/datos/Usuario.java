package datos;

import java.util.*;

public class Usuario {
	private int idUsuario;
	private String nombre;
	private String apellido;
	private int dni;
	private String pass;
	private String email;
	private boolean tarifaSocial;
	private boolean estudiantil;
	private Set<Tarjeta> lstTarjetas;
	
	public Usuario() {}

	public Usuario(String nombre, String apellido, int dni, String pass, String email, boolean tarifaSocial,
			boolean estudiantil, Set<Tarjeta> lstTarjetas) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.pass = pass;
		this.email = email;
		this.tarifaSocial = tarifaSocial;
		this.estudiantil = estudiantil;
		this.lstTarjetas = lstTarjetas;
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

	public boolean isTarifaSocial() {
		return tarifaSocial;
	}

	public void setTarifaSocial(boolean tarifaSocial) {
		this.tarifaSocial = tarifaSocial;
	}

	public boolean isEstudiantil() {
		return estudiantil;
	}

	public void setEstudiantil(boolean estudiantil) {
		this.estudiantil = estudiantil;
	}

	public Set<Tarjeta> getLstTarjetas() {
		return lstTarjetas;
	}

	public void setLstTarjetas(Set<Tarjeta> lstTarjetas) {
		this.lstTarjetas = lstTarjetas;
	}

	

	
	
	
}
