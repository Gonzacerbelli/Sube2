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
		Tarjeta t = new Tarjeta(numTarjeta);
		return dao.agregar(t);
	}
	
	public int agregar(int numTarjeta) throws Exception {
//		Tarjeta tarjetaAux = dao.traerTarjeta(numTarjeta);
//		if (tarjetaAux != null) {
//			throw new Exception("Existe una tarjeta con el mismo número.");
//		}
		Tarjeta t = new Tarjeta(numTarjeta);
		return dao.agregar(t);
	}
	
	public void modificar(Tarjeta t) throws Exception {
		Tarjeta tarjetaAux = dao.traerTarjetaPorNum(t.getNumTarjeta());
		if (tarjetaAux != null) {
			dao.actualizar(t);
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
	
	public Tarjeta traerTarjeta(int idTarjeta) throws Exception {
		Tarjeta t = dao.traerTarjeta(idTarjeta);
		if (t == null) {
			throw new Exception("La tarjeta no existe en la base de datos.");
		}
		return t;
	}
	
	public Tarjeta traerTarjetaPorNum(int numTarjeta) throws Exception {
		Tarjeta t = dao.traerTarjetaPorNum(numTarjeta);
		if (t == null) {
			throw new Exception("La tarjeta no existe en la base de datos.");
		}
		return t;
	}
	
	
	public Tarjeta traerTarjetaActiva(Usuario usuario) throws Exception {
		Tarjeta t = dao.traerTarjetaActiva(usuario);
		if (t == null) {
			throw new Exception("La tarjeta no existe en la base de datos.");
		}
		return t;
	}
	
	public void recargarTarjeta(int idTarjeta, double monto) throws Exception {
		Tarjeta t = dao.traerTarjeta(idTarjeta);
		if (t == null) {
			throw new Exception("La tarjeta no existe en la base de datos.");
		}
		if(t.getSaldo() + monto < 0) {
			throw new Exception("La carga debe saldar lo negativo");	
		}
		t.setSaldo(t.getSaldo() + monto);
		modificar(t);
	}
}
