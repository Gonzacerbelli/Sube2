package datos;

public class RedSube {
	private double porcentaje;
	
	public double aplicarDescuento(double monto) {
		return (monto*100)/porcentaje;
	}

}
