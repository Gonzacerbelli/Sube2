package datos;

import java.util.*;

public class Tarjeta {
	private int idTarjeta;
	private int numTarjeta;
	private double saldo;
	private Set<Viaje> lstViaje;
	private Usuario usuario;
	private boolean activa;
	private Set<Movimiento> lstMovimiento;
	
	public Tarjeta() {}

	public Tarjeta(int numTarjeta, double saldo, Set<Viaje> lstViaje, Usuario usuario, boolean activa,
			Set<Movimiento> lstMovimiento) {
		super();
		this.numTarjeta = numTarjeta;
		this.saldo = saldo;
		this.lstViaje = lstViaje;
		this.usuario = usuario;
		this.activa = activa;
		this.lstMovimiento = lstMovimiento;
	}

	public int getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public int getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(int numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Set<Viaje> getLstViaje() {
		return lstViaje;
	}

	public void setLstViaje(Set<Viaje> lstViaje) {
		this.lstViaje = lstViaje;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public Set<Movimiento> getLstMovimiento() {
		return lstMovimiento;
	}

	public void setLstMovimiento(Set<Movimiento> lstMovimiento) {
		this.lstMovimiento = lstMovimiento;
	}

	
	
	
}
