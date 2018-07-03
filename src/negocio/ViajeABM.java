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
	Facade f = new Facade();
	
	public int agregar(GregorianCalendar fechaHora, Tarjeta tarjeta) {
		Viaje viaje = new Viaje(fechaHora, tarjeta);
		viaje.setCantBoletos(1);
		return dao.agregar(viaje);
	}
	
	public int agregar(Viaje viaje) {
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
	
	public Viaje traerViaje(int idViaje) {
		Viaje v = dao.traerViaje(idViaje);
//		if (v == null) {
//			throw new Exception("El Viaje no existe.");
//		}
		return v;
	}
	
	public Viaje viajeCorrespondiente(Viaje ultimoViaje, Transporte transporte, GregorianCalendar fechaHora) throws Exception {
		Viaje resultado = null;
		if(ultimoViaje != null) {
			Boleto ultimoBoleto = f.getBoletoABM().traerBoleto(ultimoViaje.getUltimoBoleto().getIdBoleto());
			//si el ultimo boleto no esta cerrado y el transporte actual es el mismo, entonces sigue estando en el mismo viaje
			if (ultimoBoleto != null) {
				if(ultimoViaje.getCantBoletos() <= 5 && Funciones.diferenciaHoras(fechaHora, ultimoBoleto.getFechaHora()) <= 2) {
					resultado = ultimoViaje;
				}
			}
		}
		return resultado;
	}
	
	public Viaje traerUltimoViaje(Tarjeta tarjeta) {
		Viaje resultado = null;
		resultado = tarjeta.getUltimoViaje();
		if(resultado != null)
		{
			resultado = traerViaje(resultado.getIdViaje());
		}
		return resultado;
	}
	
	public boolean sigueEnViaje(Viaje viaje, GregorianCalendar fechaHora, Transporte transporte) {
		boolean sigueEnViaje = false;
		if(viaje != null)
		{
			if(viaje.getUltimoBoleto() != null)
			{
				Boleto ultimoBoleto = f.getBoletoABM().traerBoleto(viaje.getUltimoBoleto().getIdBoleto());	
				//si el ultimo boleto no esta cerrado y el transporte actual es el mismo, entonces sigue estando en el mismo viaje
				if(viaje.getCantBoletos() <= 5 && Funciones.diferenciaHoras(fechaHora, ultimoBoleto.getFechaHora()) <= 2) 
				{
					sigueEnViaje = true;
				}
			}
			
		}
		return sigueEnViaje;
	}
}
