package negocio;

import dao.ViajeDao;
import datos.Viaje;
import datos.Boleto;
import datos.Transporte;
import datos.Tarjeta;
import java.util.GregorianCalendar;
import java.util.Set;

public class ViajeABM {
	
	ViajeDao dao = new ViajeDao();
	
	public int agregar(GregorianCalendar fechaHora, int cantidadDeBoletos, Set<Boleto> lstBoleto, Tarjeta tarjeta) {
		Viaje viaje = new Viaje(fechaHora, cantidadDeBoletos, lstBoleto, tarjeta);
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
	
	public Viaje traerBoleto(int idViaje) throws Exception {
		Viaje v = dao.traerViaje(idViaje);
		if (v == null) {
			throw new Exception("El boleto no existe.");
		}
		return v;
	}

}
