package datos;

public class Tren extends Transporte {
	private int idTren;
	private Tramo tramo;
	private int interno;

	public Tren(float precio, Tramo tramo, int interno) {
		super(precio);
		this.tramo = tramo;
		this.interno = interno;
	}

	public int getIdTren() {
		return idTren;
	}

	public void setIdTren(int idTren) {
		this.idTren = idTren;
	}

	public Tramo getTramo() {
		return tramo;
	}

	public void setTramo(Tramo tramo) {
		this.tramo = tramo;
	}

	public int getInterno() {
		return interno;
	}

	public void setInterno(int interno) {
		this.interno = interno;
	}
	
	
}
