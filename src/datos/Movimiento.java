package datos;

import java.util.GregorianCalendar;
import util.Funciones;

public class Movimiento {
	private int idMovimiento;
	private String tipo;
	private Tarjeta tarjeta;
	private double valor;
	private GregorianCalendar fechaHora;
	private String detalle;
	private String medio;
	private String fechaHoraString;
	
	public Movimiento() {}

	public Movimiento(String tipo, Tarjeta tarjeta, double valor, GregorianCalendar fechaHora, String detalle, String medio) {
		super();
		this.tipo = tipo;
		this.tarjeta = tarjeta;
		this.valor = valor;
		this.fechaHora = fechaHora;
		this.detalle = detalle;
		this.medio = medio;
	}

	public int getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public GregorianCalendar getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
		this.fechaHoraString = Funciones.traerFechaCortaHora(fechaHora);
	}
	
	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMedio() {
		return medio;
	}

	public void setMedio(String medio) {
		this.medio = medio;
	}
	
	public String getFechaHoraString() {
		return fechaHoraString;
	}
	
	public void setFechaHoraString(String fechaHoraString) {
		this.fechaHoraString = fechaHoraString;
	}

	@Override
	public String toString() {
		return "Movimiento [idMovimiento=" + idMovimiento + ", tipo=" + tipo + ", tarjeta=" + tarjeta + ", valor="
				+ valor + ", fechaHora=" + Funciones.traerFechaCortaHora(fechaHora) + ", detalle=" + detalle + ", medio=" + medio + "]";
	}

	
	
}
