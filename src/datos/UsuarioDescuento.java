package datos;

import java.util.GregorianCalendar;

public class UsuarioDescuento {
	
	private int idRelacion;
	private Usuario usuario;
	private Descuento descuento;
	private GregorianCalendar fechaAsignado;
	private boolean activo;
	
	public UsuarioDescuento() { }

	public int getIdRelacion() {
		return idRelacion;
	}

	public void setIdRelacion(int idRelacion) {
		this.idRelacion = idRelacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Descuento getDescuento() {
		return descuento;
	}

	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}
	
	
	
	public GregorianCalendar getFechaAsignado() {
		return fechaAsignado;
	}

	public void setFechaAsignado(GregorianCalendar fechaAsignado) {
		this.fechaAsignado = fechaAsignado;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public double aplicarDescuento(double monto) {
		if(activo) {
			return descuento.aplicarDescuento(monto);
		}
		return monto;
	}

	@Override
	public String toString() {
		return "UsuarioDescuento [idRelacion=" + idRelacion + ", usuario=" + usuario + ", descuento=" + descuento
				+ ", fechaAsignado=" + fechaAsignado + ", activo=" + activo + "]";
	}
	
	
	
	
}
