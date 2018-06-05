package datos;

import datos.Linea;
import datos.Ramal;
import datos.Estacion;

import java.util.GregorianCalendar;

public class Boleto {
	private int idBoleto;
	private GregorianCalendar fechaHora;
	private double precioFinal;
	private Tarifa tarifa;
	private Estacion estacion;
	private Ramal ramal;
	private Linea linea;
	private Transporte transporte;
	private Viaje viaje;
	
	public Boleto() {}

	public Boleto(GregorianCalendar fechaHora, double precioFinal, Tarifa tarifa, Estacion estacion, Ramal ramal,
			Linea linea, Transporte transporte, Viaje viaje) {
		super();
		this.fechaHora = fechaHora;
		this.precioFinal = precioFinal;
		this.tarifa = tarifa;
		this.estacion = estacion;
		this.ramal = ramal;
		this.linea = linea;
		this.transporte = transporte;
		this.viaje = viaje;
	}



	public int getIdBoleto() {
		return idBoleto;
	}

	public void setIdBoleto(int idBoleto) {
		this.idBoleto = idBoleto;
	}

	public GregorianCalendar getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
	}

	public double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = precioFinal;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	public Estacion getEstacion() {
		return estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
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

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	@Override
	public String toString() {
		return "/nBoleto /n ID: " + idBoleto + "/nHORA: " + fechaHora + "/nMonto: " + precioFinal + "/nTransporte: " + linea.getTransporte().getNombre() + "/nLinea: " + linea.getNombre() + "/n";
	}
	
	public String descripcionTren() {
		return this.toString() + "Ramal: " + ramal.getNombre() + "/n Estacion: " + estacion.getNombre() + "/n";
	}
	
	public String descripcionColectivo() {
		return this.toString();
	}

	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}
	
}
