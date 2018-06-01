package datos;

import java.util.GregorianCalendar;

public class Movimiento {
	private int idMovimiento;
	private Tarjeta tarjeta;
	private Boleto boleto;
	private double valor;
	private GregorianCalendar fechaHora;
	private String tipo;
	private String detalle;
	
	public Movimiento() {}

	public Movimiento(Tarjeta tarjeta, Boleto boleto, double valor, GregorianCalendar fechaHora, String tipo,
			String detalle) {
		super();
		this.tarjeta = tarjeta;
		this.boleto = boleto;
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

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Boleto getBoleto() {
		return boleto;
	}

	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
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

	@Override
	public String toString() {
		return "Movimiento [idMovimiento=" + idMovimiento + ", tarjeta=" + tarjeta + ", boleto=" + boleto + ", valor="
				+ valor + ", fechaHora=" + fechaHora + ", tipo=" + tipo + ", detalle=" + detalle + "]";
	}

	
	
	
}
