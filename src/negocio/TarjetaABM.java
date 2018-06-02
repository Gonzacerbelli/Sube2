package negocio;

import datos.Movimiento;
import datos.Tarjeta;
import datos.Usuario;
import datos.Viaje;
import java.util.Set;
import dao.TarjetaDao;

public class TarjetaABM {
	TarjetaDao dao = new TarjetaDao();
	
	public int agregar(int numTarjeta, double saldo, Set<Viaje> lstViaje, Usuario usuario, boolean activa,
			Set<Movimiento> lstMovimiento) throws Exception {
		Tarjeta tarjetaAux = dao.traerTarjeta(numTarjeta);
		if (tarjetaAux != null) {
			throw new Exception("Existe una tarjeta con el mismo número.");
		}
		Tarjeta t = new Tarjeta(numTarjeta, saldo, lstViaje, usuario, activa, lstMovimiento);
		return dao.agregar(t);
	}
	
	public int agregar(int numTarjeta, double saldo, boolean activa) throws Exception {
//		Tarjeta tarjetaAux = dao.traerTarjeta(numTarjeta);
//		if (tarjetaAux != null) {
//			throw new Exception("Existe una tarjeta con el mismo número.");
//		}
		Tarjeta t = new Tarjeta(numTarjeta, saldo, activa);
		return dao.agregar(t);
	}
	
	public void modificar(Tarjeta t) throws Exception {
		Tarjeta tarjetaAux = dao.traerTarjeta(t.getNumTarjeta());
		if (tarjetaAux != null) {
			dao.actualizar(tarjetaAux);
		} else {
			throw new Exception("No existe una tarjeta con ese número.");
		}
	}

	public void eliminar(int numTarjeta) throws Exception {
		Tarjeta t = dao.traerTarjeta(numTarjeta);
		if(t == null) {
			throw new Exception("La tarjeta no existe.");
		}
		dao.eliminar(t);
	}
	
	public Tarjeta traerTarjeta(int numTarjeta) throws Exception {
		Tarjeta t = dao.traerTarjeta(numTarjeta);
		if (t == null) {
			throw new Exception("La tarjeta no existe en la base de datos.");
		}
		return t;
	}
	
	public Tarjeta traerTarjeta(Usuario usuario) throws Exception {
		Tarjeta t = dao.traerTarjeta(usuario);
		if (t == null) {
			throw new Exception("La tarjeta no existe en la base de datos.");
		}
		return t;
	}
}
