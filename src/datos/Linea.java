package datos;

import java.util.Set;

public class Linea {
	private int idLinea;
	private String nombre;
	private Transporte transporte;
	private Set<Estacion> estaciones;
	private Set<Ramal> ramales;
	
	public Linea() {}

	public Linea(String nombre, Transporte transporte) {
		super();
		this.nombre = nombre;
		this.transporte = transporte;
	}
	
	public Linea(String nombre) {
		super();
		this.nombre = nombre;
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

	@Override
	public String toString() {
		return "Linea [idLinea=" + idLinea + ", nombre=" + nombre + "]";
	}
	
	

	public Set<Estacion> getEstaciones() {
		return estaciones;
	}

	public void setEstaciones(Set<Estacion> estaciones) {
		this.estaciones = estaciones;
	}

	public Set<Ramal> getRamales() {
		return ramales;
	}

	public void setRamales(Set<Ramal> ramales) {
		this.ramales = ramales;
	}
	
}
