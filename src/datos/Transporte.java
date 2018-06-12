package datos;

import java.util.Set;

public class Transporte {
	
	private int idTransporte;
	private String nombre;
	private Set<Linea> lineas;

	public Transporte() {
	}
	public Transporte(String nombre) {
		this.nombre = nombre;
	}
	public int getIdTransporte() {
		return idTransporte;
	}
	public void setIdTransporte(int idTransporte) {
		this.idTransporte = idTransporte;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Set<Linea> getLineas() {
		return lineas;
	}
	public void setLineas(Set<Linea> lineas) {
		this.lineas = lineas;
	}
	@Override
	public String toString() {
		return "Transporte [idTransporte=" + idTransporte + ", nombre=" + nombre + "]";
	}
	
}