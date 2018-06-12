package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.MovimientoDao;
import datos.Movimiento;
import datos.Tarjeta;

public class MovimientoABM {
	
	MovimientoDao dao = new MovimientoDao();
	
	
	public int agregar(String tipo, Tarjeta tarjeta, double valor, GregorianCalendar fechaHora, String detalle, String medio) throws Exception {
		Movimiento t = new Movimiento(tipo, tarjeta, valor, fechaHora, detalle, medio);
		return dao.agregar(t);
	}
	
	public void modificar(Movimiento t) throws Exception {
		Movimiento MovimientoAux = dao.traerMovimiento(t.getIdMovimiento());
		if (MovimientoAux != null) {
			dao.actualizar(MovimientoAux);
		} else {
			throw new Exception("No existe un Movimiento con ese id.");
		}
	}

	public void eliminar(int idMovimiento) throws Exception {
		Movimiento t = dao.traerMovimiento(idMovimiento);
		if(t == null) {
			throw new Exception("El Movimiento no existe.");
		}
		dao.eliminar(t);
	}
	
	public Movimiento traerMovimiento(int idMovimiento) throws Exception {
		Movimiento t = dao.traerMovimiento(idMovimiento);
		if (t == null) {
			throw new Exception("El Movimiento no existe en la base de datos.");
		}
		return t;
	}
	
	public List<Movimiento> traerMovimientos(int idTarjeta) throws Exception {
		List<Movimiento> list = dao.traerMovimientos(idTarjeta);
		if (list == null) {
			throw new Exception("La tarjeta no tiene Movimientos.");
		}
		return list;
	}
	
//	public List<Movimiento> traerMovimiento() throws Exception {
//		List<Movimiento> list = dao.traerMovimiento();
//		if (list == null) {
//			throw new Exception("La Movimiento no existe en la base de datos.");
//		}
//		return list;
//	}
}
