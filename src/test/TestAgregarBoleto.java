package test;

import datos.Usuario;
import datos.Viaje;
import datos.Boleto;
import datos.Linea;
import datos.Movimiento;
import datos.Tarifa;
import datos.Tarjeta;
import datos.Transporte;
import negocio.UsuarioABM;
import negocio.BoletoABM;
import negocio.LineaABM;
import negocio.TarifaABM;
import negocio.TarjetaABM;
import negocio.TransporteABM;
import negocio.ViajeABM;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;



public class TestAgregarBoleto {

	public static void main(String[] args) {

		try 
		{
			TarjetaABM tarjetaABM = new TarjetaABM();
			ViajeABM viajeABM = new ViajeABM();
			UsuarioABM usuarioABM = new UsuarioABM();
			TransporteABM transporteABM = new TransporteABM();
			LineaABM lineaABM = new LineaABM();
			BoletoABM boletoABM = new BoletoABM();
			TarifaABM tarifaABM = new TarifaABM();
			
			//estos parametros los manda el usuario a traves del controlador
			int idTransporte = 1;
			int numTarjeta = 1234;
			int idTarjeta = 1;
			int idLinea = 1;
			int idTarifa = 1;
			double precioFinal = 6.5;
			int idViaje = 1;
			
			Transporte transporte = transporteABM.traerTransporte(idTransporte);
			Tarjeta tarjeta = tarjetaABM.traerTarjeta(idTarjeta);
			Set<Viaje> viajes = tarjeta.getLstViaje();
			GregorianCalendar fechaHora = (GregorianCalendar) Calendar.getInstance();
			viajeABM.agregar(fechaHora, tarjeta);
			Viaje viaje = viajeABM.traerViaje(idViaje);
			Linea linea = lineaABM.traerLinea(idLinea);
			tarifaABM.agregar("Minimo", 1, transporte, 6.5);
			Tarifa tarifa = tarifaABM.traerTarifa(idTarifa);
			
			int ultimoId = boletoABM.agregar(transporte, fechaHora, tarifa, precioFinal, viaje, linea, null, null);
			System.out.println("Agregar Boleto --" + ultimoId);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println(e);
		}
		
		
		
		
		

	}

}
