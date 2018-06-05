package test;

import datos.Usuario;
import datos.Viaje;
import datos.Boleto;
import datos.Estacion;
import datos.Linea;
import datos.Movimiento;
import datos.Ramal;
import datos.RedSube;
import datos.Tarifa;
import datos.Tarjeta;
import datos.Transporte;
import negocio.BoletoABM;
import negocio.Facade;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;


public class TestAgregarBoleto {

	public static void main(String[] args) {

		try 
		{
			Facade f = new Facade();
			//estos parametros los manda el usuario a traves del controlador
			int idTransporte = 1;
			int numTarjeta = 1234;
			int idLinea = 1;
			int idTarifa = 1;
			
			Transporte transporte = f.getTransporteABM().traerTransporte(idTransporte);
			Tarjeta tarjeta = f.getTarjetaABM().traerTarjetaPorNum(numTarjeta);
			GregorianCalendar fechaHora = (GregorianCalendar) Calendar.getInstance();
			Viaje viaje = f.getViajeABM().viajeCorrespondiente(tarjeta, fechaHora);
			Linea linea = f.getLineaABM().traerLinea(idLinea);
			Tarifa tarifa = f.getTarifaABM().traerTarifa(idTarifa);
			
			BoletoABM bABM = f.getBoletoABM();
			
			Estacion e = null;
			Ramal r = null;
			Usuario u = null;
			RedSube red = null;
			
			Boleto b = bABM.generarBoleto(fechaHora, tarifa, e, r, linea, transporte, viaje, u, red);
			System.out.println("Generar Boleto --" + b);
			
			bABM.cobrarBoleto(b, tarjeta);
			
			if(viaje.equals(tarjeta.getUltimoViaje())) {
				viaje = f.getViajeABM().traerViaje(viaje.getIdViaje());
				viaje.getLstBoleto().add(b);
			}
			else {
				viaje.agregarBoleto(b);
				tarjeta.getLstViaje().add(viaje);
			}
			
			System.out.println("Cobrar Boleto -->" + b + " " + tarjeta);
			
			f.getTarjetaABM().modificar(tarjeta);

			tarjeta = f.getTarjetaABM().traerTarjetaPorNum(numTarjeta);
			System.out.println("Modificar Tarjeta -->" + tarjeta);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println(e);
		}
		
		
		
		
		

	}

}
