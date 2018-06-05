package datos;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class UsuarioBeneficio {
	private int idRelacion;
	private Usuario usuario;
	private Beneficio beneficio;
	private boolean activo;
	private GregorianCalendar fechaCobro;
	private GregorianCalendar fechaAsignado;
	
	public UsuarioBeneficio() { }

	public UsuarioBeneficio(Usuario usuario, Beneficio beneficio) {
		this.usuario = usuario;
		this.beneficio = beneficio;
		this.activo = true;
		this.fechaCobro = null;
		this.fechaAsignado = (GregorianCalendar)Calendar.getInstance();
	}

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

	public Beneficio getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public GregorianCalendar getFechaCobro() {
		return fechaCobro;
	}

	public void setFechaCobro(GregorianCalendar fechaCobro) {
		this.fechaCobro = fechaCobro;
	}

	public GregorianCalendar getFechaAsignado() {
		return fechaAsignado;
	}

	public void setFechaAsignado(GregorianCalendar fechaAsignado) {
		this.fechaAsignado = fechaAsignado;
	}
	
	

	@Override
	public String toString() {
		return "UsuarioBeneficio [idRelacion=" + idRelacion + ", usuario=" + usuario.getApellido() + ", beneficio=" + beneficio.getNombre()
				+ ", activo=" + activo + ", fechaCobro=" + fechaCobro + ", fechaAsignado=" + fechaAsignado + "]";
	}
	
	
}
