package datos;

import datos.Linea;
import datos.Ramal;
import datos.Estacion;

import java.util.GregorianCalendar;

public class Boleto {
	private int idBoleto;
	private Transporte transporte;
	private GregorianCalendar fechaHora;
	private boolean cerrado;
	private double precioFinal;
	private Viaje viaje;
	private Linea linea;
	private Ramal ramal;
	private Estacion estacion;
	
	public Boleto() {}
	
	public Boleto(Transporte transporte, GregorianCalendar fechaHora, boolean cerrado, double precioFinal, Viaje viaje,
			Linea linea, Ramal ramal, Estacion estacion) {
		super();
		this.transporte = transporte;
		this.fechaHora = fechaHora;
		this.cerrado = cerrado;
		this.precioFinal = precioFinal;
		this.viaje = viaje;
		this.linea = linea;
		this.ramal = ramal;
		this.estacion = estacion;
	}

	public int getIdBoleto() {
		return idBoleto;
	}

	public void setIdBoleto(int idBoleto) {
		this.idBoleto = idBoleto;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	public GregorianCalendar getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
	}

	public boolean isCerrado() {
		return cerrado;
	}

	public void setCerrado(boolean cerrado) {
		this.cerrado = cerrado;
	}

	public double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = precioFinal;
	}

	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

	public Linea getLinea() {
		return linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}

	public Ramal getRamal() {
		return ramal;
	}

	public void setRamal(Ramal ramal) {
		this.ramal = ramal;
	}

	public Estacion getEstacion() {
		return estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

	@Override
	public String toString() {
		return "Boleto [idBoleto=" + idBoleto + ", transporte=" + transporte + ", fechaHora=" + fechaHora + ", cerrado="
				+ cerrado + ", precioFinal=" + precioFinal + ", viaje=" + viaje + ", linea=" + linea + ", ramal="
				+ ramal + ", estacion=" + estacion + "]";
	}
	
	
	
	
	
	
	
	
}
