package test;

import datos.Usuario;
import datos.UsuarioBeneficio;
import datos.Viaje;
import datos.Beneficio;
import datos.Estacion;
import datos.Ramal;
import datos.Tarjeta;
import datos.Usuario;
import datos.Movimiento;

import negocio.UsuarioABM;
import negocio.EstacionABM;
import negocio.RamalABM;
import negocio.TarjetaABM;
import negocio.UsuarioABM;
import negocio.ViajeABM;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;



public class TestAsignarTarjeta {

	public static void main(String[] args) {

		try 
		{
			UsuarioABM usuarioABM = new UsuarioABM();
			TarjetaABM tarjetaABM = new TarjetaABM();
			Usuario usuario = usuarioABM.traerUsuario(39281276);
			Tarjeta tarjeta = tarjetaABM.traerTarjetaPorNum(1234);
			usuarioABM.asignarTarjeta(tarjeta, usuario);
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
