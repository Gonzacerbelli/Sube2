package datos;

public class Beneficio {
	private int idBeneficio;
	private String nombre;
	private double valor;
	
	public Beneficio() { }
	
	public Beneficio(String nombre, double valor) {
		super();
		this.nombre = nombre;
		this.valor = valor;
	}

	public int getIdBeneficio() {
		return idBeneficio;
	}
	public void setIdBeneficio(int idBeneficio) {
		this.idBeneficio = idBeneficio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double aplicarBeneficio(double saldo) {
		return saldo + valor;
	}

	@Override
	public String toString() {
		return "Beneficio [idBeneficio=" + idBeneficio + ", nombre=" + nombre + ", valor=" + valor + "]";
	}
	
	
	
}
