package datos;

public class RamalEstacion {
	private int idRelacion;
	private Ramal ramal;
	private Estacion estacion;
	private int nroEstacion;
	
	public RamalEstacion() {}

	public RamalEstacion(Ramal ramal, Estacion estacion, int nroEstacion) {
		super();
		this.ramal = ramal;
		this.estacion = estacion;
		this.nroEstacion = nroEstacion;
	}



	public int getIdRelacion() {
		return idRelacion;
	}

	public void setIdRelacion(int idRelacion) {
		this.idRelacion = idRelacion;
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

	public int getNroEstacion() {
		return nroEstacion;
	}

	public void setNroEstacion(int nroEstacion) {
		this.nroEstacion = nroEstacion;
	}

	@Override
	public String toString() {
		return "RamalEstacion [idRelacion=" + idRelacion + ", ramal=" + ramal + ", estacion=" + estacion
				+ ", nroEstacion=" + nroEstacion + "]";
	}
	
	
}
