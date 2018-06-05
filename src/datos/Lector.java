package datos;

import java.util.GregorianCalendar;

public class Lector {
	private int idLector;
	private int numTarjeta;
	private Transporte transporte;
	private Linea linea;
	private Ramal ramal;
	private Estacion estacion;
	private Tarifa tarifa;
	private GregorianCalendar fechaHora;
	private String msjPantalla;
	
	public Lector(int numTarjeta, Transporte transporte, Linea linea, Ramal ramal, Estacion estacion, Tarifa tarifa,
			GregorianCalendar fechaHora, String msjPantalla) {
		super();
		this.numTarjeta = numTarjeta;
		this.transporte = transporte;
		this.linea = linea;
		this.ramal = ramal;
		this.estacion = estacion;
		this.tarifa = tarifa;
		this.fechaHora = fechaHora;
		this.msjPantalla = msjPantalla;
	}

	public int getIdLector() {
		return idLector;
	}

	public void setIdLector(int idLector) {
		this.idLector = idLector;
	}

	public int getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(int numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	public Linea getLinea() {
		return linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}

	public Ramal getRamal() {
		return ramal;
	}

	public void setRamal(Ramal ramal) {
		this.ramal = ramal;
	}

	public Estacion getEstacion() {
		return estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	public GregorianCalendar getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getMsjPantalla() {
		return msjPantalla;
	}

	public void setMsjPantalla(String msjPantalla) {
		this.msjPantalla = msjPantalla;
	}
	
	
	
}
