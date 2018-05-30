package test;

import datos.Usuario;
import datos.Viaje;
import datos.Tarjeta;
import datos.Movimiento;

import negocio.UsuarioABM;
import negocio.TarjetaABM;
import negocio.ViajeABM;

import java.util.Set;



public class Test {

	public static void main(String[] args) {

		//Traer usuario
		
		int dni = 39281276;
		
		UsuarioABM usuarioAbm = new UsuarioABM();
		TarjetaABM tarjetaAbm = new TarjetaABM();
		ViajeABM viajeAbm = new ViajeABM();
		
		try {
			//traigo usuario
			Usuario usuario = usuarioAbm.traerUsuario(dni);
			
			//traigo tarjeta del usuario
			Tarjeta tarjeta = tarjetaAbm.traerTarjeta(123456789);
			
			//si no existe la tarjeta le creo una al usuario
			if(tarjeta == null) {
				tarjetaAbm.agregar(123456789, 15, null, usuario, true, null);
				tarjeta = tarjetaAbm.traerTarjeta(123456789);
			}
			
			//creo un viaje
			
			
			
			
			
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		

	}

}
