package datos;

import java.util.*;

import util.Funciones;

public class Viaje {
	private int idViaje;
	private GregorianCalendar fechaHora;
	private int cantBoletos;
	private Set<Boleto> lstBoleto = new HashSet<Boleto>();;
	private Tarjeta tarjeta;
	
	public Viaje() {}

	public Viaje(GregorianCalendar fechaHora, Tarjeta tarjeta) {
		super();
		this.fechaHora = fechaHora;
		this.cantBoletos = 0;
		this.lstBoleto = new HashSet<Boleto>();
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

	public int getCantBoletos() {
		return cantBoletos;
	}

	public void setCantBoletos(int cantBoletos) {
		this.cantBoletos = cantBoletos;
	}

	public void agregarBoleto(Boleto boleto) {
		if(!boleto.isCerrado())
		{
			cantBoletos++;	
		}
		this.getLstBoleto().add(boleto);
	}
	
	public Boleto getUltimoBoleto() {
		Boleto boleto = null;
		Iterator<Boleto> it = lstBoleto.iterator();
		while(it.hasNext()) {
			boleto = it.next();
		}
		return boleto;
	}

	@Override
	public String toString() {
		return "Viaje [idViaje=" + idViaje + ", fechaHora=" + Funciones.traerFechaCortaHora(fechaHora) + ", cantBoletos=" + cantBoletos + "]";
	}
	
	
}
