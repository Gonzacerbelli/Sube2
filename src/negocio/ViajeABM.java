package negocio;

import dao.ViajeDao;
import datos.Viaje;
import util.Funciones;
import datos.Boleto;
import datos.Transporte;
import datos.Tarjeta;
import java.util.GregorianCalendar;
import java.util.Set;

public class ViajeABM {
	
	ViajeDao dao = new ViajeDao();
	
	public int agregar(GregorianCalendar fechaHora, Tarjeta tarjeta) {
		Viaje viaje = new Viaje(fechaHora, tarjeta);
		return dao.agregar(viaje);
	}
	
	public void modificar(Viaje v) throws Exception {
		Viaje viaje = dao.traerViaje(v.getIdViaje());
		if(viaje != null) {
			dao.actualizar(v);
		} else {
			throw new Exception("El viaje no existe.");
		}
	}
	
	public void eliminar(int idViaje) throws Exception {
		Viaje v = dao.traerViaje(idViaje);
		if(v == null) {
			throw new Exception("El viaje no existe.");
		}
		dao.eliminar(v);
	}
	
	public Viaje traerViaje(int idViaje) throws Exception {
		Viaje v = dao.traerViaje(idViaje);
		if (v == null) {
			throw new Exception("El Viaje no existe.");
		}
		return v;
	}
	
	public Viaje viajeCorrespondiente(Tarjeta tarjeta, GregorianCalendar fechaHora) {
		Viaje ultimo = tarjeta.getUltimoViaje();
		if(ultimo == null || ultimo.getCantBoletos() >= 6 || Funciones.diferenciaHoras(ultimo.getFechaHora(), fechaHora) > 2) {
			return new Viaje(fechaHora, tarjeta);
		}
		return ultimo;
	}

}
