package negocio;

import dao.BoletoDao;
import datos.Boleto;
import datos.Descuento;
import datos.Estacion;
import datos.Linea;
import datos.Ramal;
import datos.RamalEstacion;
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
	
	public Boleto generarBoleto(GregorianCalendar fechaHora, Tarifa tarifa, Estacion estacion, Ramal ramal, Linea linea, Transporte transporte, Viaje viaje, Usuario usuario, RedSube redSube) throws Exception {
		
		double precioFinal = tarifa.getMonto();
		
		Boleto ultimoBoleto = viaje.getUltimoBoleto();
		
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
	
	double montoCorrespondienteADevolver(Boleto ultimoBoleto, Estacion estacionVuelta, Ramal ramalVuelta) throws Exception {
		double aDevolver = 0;
		Tarifa tarifaCobrada = f.getTarifaABM().traerTarifa(ultimoBoleto.getTarifa().getIdTarifa());
		double cobrado = tarifaCobrada.getMonto();
		Ramal ramalIda = ultimoBoleto.getRamal();
		Estacion estacionIda = ultimoBoleto.getEstacion();
		RamalEstacion ramalEstacionIda = f.getRamalEstacionABM().traerRamalEstacion(ramalIda.getIdRamal(), estacionIda.getIdEstacion());
		RamalEstacion ramalEstacionVuelta = f.getRamalEstacionABM().traerRamalEstacion(ramalVuelta.getIdRamal(), estacionVuelta.getIdEstacion());
		int cantEstaciones = calcularCantEstaciones(ramalEstacionIda, ramalEstacionVuelta);
		Tarifa tarifaDefinitiva = f.getTarifaABM().traerTarifaPorCantEst(cantEstaciones, ultimoBoleto.getTransporte().getIdTransporte());
		aDevolver = tarifaDefinitiva.getMonto() - cobrado;
		return aDevolver;
	}

	private int calcularCantEstaciones(RamalEstacion ida, RamalEstacion vuelta) {
		int cantEstaciones = 0;
		if (ida.getRamal().getIdRamal() == vuelta.getRamal().getIdRamal())
		{
			cantEstaciones = ida.getNroEstacion() - vuelta.getNroEstacion();
		}
		if (cantEstaciones < 0) 
			cantEstaciones *= -1;
		return cantEstaciones;
	}

	boolean estaCerrandoViajeEnTren(Boleto ultimoBoleto, Transporte transporte) throws Exception {
		transporte = f.getTransporteABM().traerTransporte(transporte.getIdTransporte());
		Transporte transporteUB = f.getTransporteABM().traerTransporte(ultimoBoleto.getTransporte().getIdTransporte());
		return transporteUB.getNombre().equals("Tren") && ultimoBoleto.getPrecioFinal() >= 0 && transporte.getNombre().equals(transporteUB.getNombre());
		
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
