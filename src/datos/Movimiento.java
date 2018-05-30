package datos;

import java.util.GregorianCalendar;

public class Movimiento {
	private int idMovimiento;
	private Transporte transporte;
	private float valor;
	private GregorianCalendar fechaHora;
	private String tipo;
	private String detalle;
	
	public Movimiento() {}

	public Movimiento(Transporte transporte, float valor, GregorianCalendar fechaHora, String tipo, String detalle) {
		super();
		this.transporte = transporte;
		this.valor = valor;
		this.fechaHora = fechaHora;
		this.tipo = tipo;
		this.detalle = detalle;
	}

	public int getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public GregorianCalendar getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	
}
