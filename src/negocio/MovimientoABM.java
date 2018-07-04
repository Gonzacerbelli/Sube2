package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import dao.MovimientoDao;
import datos.Boleto;
import datos.Movimiento;
import datos.RedSube;
import datos.Tarjeta;

public class MovimientoABM {
	
	MovimientoDao dao = new MovimientoDao();
	
	
	public int agregar(String tipo, Tarjeta tarjeta, double valor, GregorianCalendar fechaHora, String detalle, String medio) throws Exception {
		Movimiento t = new Movimiento(tipo, tarjeta, valor, fechaHora, detalle, medio);
		return dao.agregar(t);
	}
	public int agregar(Boleto boleto, Tarjeta tarjeta, RedSube redSube) throws Exception {
		String tipo = "Uso Transporte";
		String medio = "";
		String detalle = "";
		if(redSube != null) {
			tipo += " con " + redSube.getDescripcion();
		}
		if(boleto.getEstacion() != null)
		{
			medio = boleto.getEstacion().getNombre();
		}
		Movimiento t = new Movimiento(tipo, tarjeta, boleto.getPrecioFinal(), boleto.getFechaHora(), detalle, medio);
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
	
	public List<Movimiento> traerMovimientos(int idTarjeta, String desdeStr, String hastaStr, String tipo) throws Exception {
		List<Movimiento> list = dao.traerMovimientos(idTarjeta, desdeStr, hastaStr, tipo);
		if (list == null) {
			throw new Exception("La tarjeta no tiene Movimientos.");
		}
		return list;
	}
	
	public int traerCantidad(String medio, int idTarjeta, String desdeStr, String hastaStr, String tipo) throws Exception {
		int cantidad = dao.traerCantidad(medio, idTarjeta,desdeStr,hastaStr,tipo);
		return cantidad;
	}
	
	public JSONObject traerCantidadMedio(int idTarjeta, String desdeStr, String hastaStr) throws Exception, JSONException {
		JSONObject obj = dao.traerCantidadMedio(idTarjeta,desdeStr,hastaStr);
		return obj;
	}
	
	public List<String> traerTipoMovimiento(int idTarjeta, String desdeStr, String hastaStr) throws Exception {
		List<String> list = dao.traerTipoMovimiento(idTarjeta,desdeStr,hastaStr);
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
