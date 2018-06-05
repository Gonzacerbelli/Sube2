package datos;

import java.util.Set;

public class Estacion {
	private int idEstacion;
	private String nombre;
	private int nroEstacion;
	private Linea linea;
	private Set<RamalEstacion> estacionRamales;
	
	public Estacion() {}

	public Estacion(String nombre) {
		this.nombre = nombre;
	}
	
	public int getNroEstacion() {
		return nroEstacion;
	}

	public void setNroEstacion(int nroEstacion) {
		this.nroEstacion = nroEstacion;
	}

	public Set<RamalEstacion> getEstacionRamales() {
		return estacionRamales;
	}

	public void setEstacionRamales(Set<RamalEstacion> estacionRamales) {
		this.estacionRamales = estacionRamales;
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
