package datos;

import java.util.*;

public class Viaje {
	private int idViaje;
	private GregorianCalendar fechaHora;
	private Set<Boleto> lstBoleto;
	private Tarjeta tarjeta;
	
	public Viaje() {}

	public Viaje(GregorianCalendar fechaHora, Set<Boleto> lstBoleto, Tarjeta tarjeta) {
		super();
		this.fechaHora = fechaHora;
		this.lstBoleto = lstBoleto;
		this.tarjeta = tarjeta;
	}

	public int getIdViaje() {
		return idViaje;
	}

	public void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
	}

	public GregorianCalendar getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Set<Boleto> getLstBoleto() {
		return lstBoleto;
	}

	public void setLstBoleto(Set<Boleto> lstBoleto) {
		this.lstBoleto = lstBoleto;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	
	
	
}
