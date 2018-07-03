package negocio;

import dao.BoletoDao;
import datos.Boleto;
import datos.Descuento;
import datos.Estacion;
import datos.Linea;
import datos.Ramal;
import datos.RedSube;
import datos.Tarifa;
import datos.Tarjeta;
import datos.Viaje;
import datos.Transporte;
import datos.Usuario;
import datos.UsuarioDescuento;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

public class BoletoABM {
	BoletoDao dao = new BoletoDao();
	Facade f = new Facade();
	
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
	
	public Boleto traerBoleto(int idBoleto) {
		Boleto b = dao.traerBoleto(idBoleto);
//		if (b == null) {
//			throw new Exception("El boleto no existe.");
//		}
		return b;
	}
	
	public Boleto generarBoleto(GregorianCalendar fechaHora, Tarifa tarifa, Estacion estacion, Ramal ramal, Linea linea, Transporte transporte, Viaje viaje, Usuario usuario, RedSube redSube) {
		
		double precioFinal = tarifa.getMonto();
		
		if(usuario != null) {
			List<UsuarioDescuento> uDescuentos = f.getUsuarioDescuentoABM().traerUsuarioDescuentos(usuario.getIdUsuario());
			for(UsuarioDescuento ud: uDescuentos)
			{
				precioFinal = ud.getDescuento().aplicarDescuento(precioFinal);		
			}
		}
		
		if(redSube != null) {
			precioFinal = redSube.aplicarDescuento(precioFinal);
		}
		
		Boleto b = new Boleto(fechaHora, precioFinal, tarifa, estacion, ramal, linea, transporte, viaje);
		
		return b;
	}
	
	public void cobrarBoleto(Boleto boleto, Tarjeta tarjeta) throws Exception {
		double saldo = tarjeta.getSaldo();
		if(saldo - boleto.getPrecioFinal() < -20) {
			saldo += boleto.getPrecioFinal();
			throw new Exception("Saldo Insuficiente: " + tarjeta.getSaldo());
		}
		tarjeta.setSaldo(tarjeta.getSaldo() - boleto.getPrecioFinal());
	}
	
}
