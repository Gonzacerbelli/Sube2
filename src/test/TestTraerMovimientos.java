package test;

import datos.Usuario;
import datos.Viaje;
import datos.Estacion;
import datos.Linea;
import datos.Movimiento;
import datos.Tarjeta;
import negocio.UsuarioABM;
import negocio.EstacionABM;
import negocio.Facade;
import negocio.LineaABM;
import negocio.ViajeABM;

import java.lang.reflect.Array;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class TestTraerMovimientos {

	public static void main(String[] args) {

		try 
		{
			Facade f = new Facade();
			Movimiento m = f.getMovimientoABM().traerMovimiento(1);
			Tarjeta t = f.getTarjetaABM().traerTarjeta(16);
			System.out.println(t.getLstMovimiento());
			GregorianCalendar desde = new GregorianCalendar(2005,05,10);
			List<Movimiento> movs = t.getLstMovimiento().stream().filter(mov -> mov.getFechaHora().after(desde)).collect(Collectors.toList());
			System.out.println(movs.toString());
			Set<Viaje> viajes = t.getLstViaje();
			System.out.println(viajes.toString());
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println(e);
		}
		
	}

}
