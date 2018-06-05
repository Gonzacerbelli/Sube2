package datos;

public class Descuento {
	
	private int idDescuento;
	private String nombre;
	private double porcentaje;
	
	public Descuento() { }

	public int getIdDescuento() {
		return idDescuento;
	}

	public void setIdDescuento(int idDescuento) {
		this.idDescuento = idDescuento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public float aplicarDescuento(float monto) {
		return (float) ((monto/100.0) * porcentaje); 
	}
	
}
