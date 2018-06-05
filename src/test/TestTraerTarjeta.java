package test;

import datos.Usuario;
import datos.Viaje;
import datos.Estacion;
import datos.Ramal;
import datos.Tarjeta;
import datos.Movimiento;

import negocio.UsuarioABM;
import negocio.EstacionABM;
import negocio.RamalABM;
import negocio.TarjetaABM;
import negocio.ViajeABM;

import java.util.Iterator;
import java.util.List;
import java.util.Set;



public class TestTraerTarjeta {

	public static void main(String[] args) {

		try 
		{
			TarjetaABM tarjetaABM = new TarjetaABM();
			Tarjeta tarjeta = tarjetaABM.traerTarjeta(1);
			System.out.println(tarjeta.toString());
//			Iterator it = Ramal.getEstaciones().iterator();
//			Estacion e = (Estacion) it.next();
//			EstacionABM eABM = new EstacionABM();
//			e = eABM.traerEstacion(e.getIdEstacion());
//			System.out.println("Estacion " + e.toString());
//			System.out.println("Esta en ramales " + e.getRamales());
////			List<Ramal> list = tABM.traerRamal();
//			System.out.println(list);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

}
