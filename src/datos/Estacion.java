package datos;

import java.util.Set;

public class Estacion {
	private int idEstacion;
	private String nombre;
	private Linea linea;
	private int nroEstacion;
	private Set<Ramal> ramales;
	public Estacion() {}
	
	public int getNroEstacion() {
		return nroEstacion;
	}

	public void setNroEstacion(int nroEstacion) {
		this.nroEstacion = nroEstacion;
	}

	public Set<Ramal> getRamales() {
		return ramales;
	}

	public void setRamales(Set<Ramal> ramales) {
		this.ramales = ramales;
	}

	public Estacion(String nombre) {
		this.nombre = nombre;
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

	public Linea getLinea() {
		return linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}

	@Override
	public String toString() {
		return "Estacion [idEstacion=" + idEstacion + ", nombre=" + nombre + "]";
	}

	
	
}
