package datos;

import java.util.Set;

public class Ramal {
	private int idRamal;
	private String nombre;
	private Linea linea;
	private Set<RamalEstacion> ramalEstaciones;
	
	public Ramal() {}

	public Ramal(String nombre, Linea linea) {
		super();
		this.nombre = nombre;
		this.linea = linea;
	}

	public Set<RamalEstacion> getRamalEstaciones() {
		return ramalEstaciones;
	}

	public void setRamalEstaciones(Set<RamalEstacion> ramalEstaciones) {
		this.ramalEstaciones = ramalEstaciones;
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

	@Override
	public String toString() {
		return "Ramal [idRamal=" + idRamal + ", nombre=" + nombre + "]";
	}
	
	
}
