package datos;

import java.util.GregorianCalendar;

public class Boleto {
	private int idBoleto;
	private Transporte transporte;
	private GregorianCalendar fechaHora;
	private boolean cerrado;
	private float precioFinal;
	private float descuento;
	private Viaje viaje;
	
	public Boleto() {}

	public Boleto(Transporte transporte, GregorianCalendar fechaHora, boolean cerrado, float precioFinal, float descuento, Viaje viaje) {
		super();
		this.transporte = transporte;
		this.fechaHora = fechaHora;
		this.cerrado = cerrado;
		this.precioFinal = precioFinal;
		this.descuento = descuento;
		this.viaje = viaje;
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

	public float getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(float precioFinal) {
		this.precioFinal = precioFinal;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}
	
	
	
	
	
	
}
