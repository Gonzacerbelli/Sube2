package negocio;

import dao.BoletoDao;
import datos.Boleto;
import datos.Estacion;
import datos.Linea;
import datos.Ramal;
import datos.Tarifa;
import datos.Viaje;
import datos.Transporte;
import java.util.GregorianCalendar;

public class BoletoABM {
	BoletoDao dao = new BoletoDao();
	
	public int agregar(Transporte transporte, GregorianCalendar fechaHora, Tarifa tarifa, double precioFinal, Viaje viaje,
			Linea linea, Ramal ramal, Estacion estacion) {
		Boleto boleto = new Boleto(fechaHora, precioFinal, tarifa, estacion, ramal, linea, transporte, viaje);
		return dao.agregar(boleto);
	}
	
	public void modificar(Boleto b) throws Exception {
		Boleto boleto = dao.traerBoleto(b.getIdBoleto());
		if(boleto != null) {
			dao.actualizar(boleto);
		} else {
			throw new Exception("El boleto no existe.");
		}
	}
	
	public void eliminar(int idBoleto) throws Exception {
		Boleto b = dao.traerBoleto(idBoleto);
		if(b == null) {
			throw new Exception("El boleto no existe.");
		}
		dao.eliminar(b);
	}
	
	public Boleto traerBoleto(int idBoleto) throws Exception {
		Boleto b = dao.traerBoleto(idBoleto);
		if (b == null) {
			throw new Exception("El boleto no existe.");
		}
		return b;
	}
	
	
}
