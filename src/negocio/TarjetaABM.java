package negocio;

import datos.Boleto;
import datos.Estacion;
import datos.Linea;
import datos.Movimiento;
import datos.Ramal;
import datos.RedSube;
import datos.Tarifa;
import datos.Tarjeta;
import datos.Transporte;
import datos.Usuario;
import datos.Viaje;

import java.util.GregorianCalendar;
import java.util.Set;
import dao.TarjetaDao;

public class TarjetaABM {
	TarjetaDao dao = new TarjetaDao();
	Facade f = new Facade();
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
	
	public Boleto viajar(Tarjeta tarjeta, Usuario usuario, GregorianCalendar fechaHora, Tarifa tarifa, Estacion estacion, Ramal ramal, Linea linea, Transporte transporte) throws Exception {
		Viaje viaje = f.getViajeABM().traerUltimoViaje(tarjeta);
		if(viaje == null || !f.getViajeABM().sigueEnViaje(viaje, fechaHora, transporte))
		{
			viaje = new Viaje(fechaHora, tarjeta);
			tarjeta.agregarViaje(viaje);
		}
//		Usuario usuario = null;
//		if(tarjeta.getUsuario() != null)
//		{
//			usuario = f.getUsuarioABM().traerUsuario(tarjeta.getUsuario().getDni());
//		}
		RedSube redSube = f.getRedSubeABM().traerRedSubeCorrespondiente(viaje.getCantBoletos());
//		Boleto ultimoBoleto = viaje.getUltimoBoleto();
////		if(ultimoBoleto != null && f.getBoletoABM().estaCerrandoViajeEnTren(ultimoBoleto, transporte)) 
////		{
////			double aDevolver = f.getBoletoABM().montoCorrespondienteADevolver(ultimoBoleto, estacion, ramal);
////			tarifa.setMonto(aDevolver);
////			redSube = f.getRedSubeABM().traerRedSubeCorrespondiente(viaje.getCantBoletos()-1);
////		}
		Boleto boleto = f.getBoletoABM().generarBoleto(fechaHora, tarifa, estacion, ramal, linea, transporte, viaje, usuario, redSube);
		f.getBoletoABM().cobrarBoleto(boleto, tarjeta);
		f.getMovimientoABM().agregar(boleto, tarjeta, redSube);
		f.getTarjetaABM().modificar(tarjeta);
		viaje.agregarBoleto(boleto);
		try {
			Viaje aux = f.getViajeABM().traerViaje(viaje.getIdViaje());	
			f.getViajeABM().modificar(viaje);
		}
		catch (Exception ex){
			f.getViajeABM().agregar(viaje);
		}
		return boleto;
	}
}
