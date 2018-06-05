package datos;

import java.util.*;


public class Tarjeta {
	private int idTarjeta;
	private int numTarjeta;
	private double saldo;
	private Usuario usuario;
	private boolean activa;
	private Set<Viaje> lstViaje;
	private Set<Movimiento> lstMovimiento;
	
	public Tarjeta() {}

	public Tarjeta(int numTarjeta) {
		super();
		this.numTarjeta = numTarjeta;
		this.activa = true;
		this.saldo = 0;
		this.lstMovimiento = new HashSet<Movimiento>();
		this.lstViaje = new HashSet<Viaje>();
		this.usuario = null;
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
	
	public Viaje getUltimoViaje()
	{
		Viaje viaje = null;
		if(lstViaje != null && lstViaje.size() > 1)
		{
			Iterator<Viaje> it = lstViaje.iterator();
			while(it.hasNext())
			{
				it.next();
			}
		}
		return viaje;
	}
	
	public void cobrarBoleto(float monto) throws Exception
	{
		if(this.saldo - monto < -20)
		{
			throw new Exception("Saldo insuficiente");
		}
		setSaldo(getSaldo() - monto);
	}
	
	public void agregarMovimiento(Movimiento movimiento) {
		this.lstMovimiento.add(movimiento);
	}

	@Override
	public String toString() {
		return "Tarjeta [idTarjeta=" + idTarjeta + ", numTarjeta=" + numTarjeta + ", saldo=" + saldo + ", usuario="+ usuario.toString() + ", activa=" + activa + "]";
	}
	
}
