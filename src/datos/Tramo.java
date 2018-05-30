package datos;

public class Tramo {
	Estacion estacionInicial;
	Estacion estacionFinal;
	SeccionTren seccion;
	
	public Tramo() {}

	public Tramo(Estacion estacionInicial, Estacion estacionFinal, SeccionTren seccion) {
		super();
		this.estacionInicial = estacionInicial;
		this.estacionFinal = estacionFinal;
		this.seccion = seccion;
	}

	public Estacion getEstacionInicial() {
		return estacionInicial;
	}

	public void setEstacionInicial(Estacion estacionInicial) {
		this.estacionInicial = estacionInicial;
	}

	public Estacion getEstacionFinal() {
		return estacionFinal;
	}

	public void setEstacionFinal(Estacion estacionFinal) {
		this.estacionFinal = estacionFinal;
	}

	public SeccionTren getSeccion() {
		return seccion;
	}

	public void setSeccion(SeccionTren seccion) {
		this.seccion = seccion;
	}
	
	
}
