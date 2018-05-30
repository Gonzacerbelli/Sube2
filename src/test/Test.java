package test;

import datos.Usuario;
import datos.Viaje;
import negocio.UsuarioABM;
import negocio.TarjetaABM;

import java.util.Set;

import datos.Movimiento;
import datos.Tarjeta;

public class Test {

	public static void main(String[] args) {

		//Traer usuario
		
		int dni = 39281276;
		
		UsuarioABM usuarioAbm = new UsuarioABM();
		TarjetaABM tarjetaAbm = new TarjetaABM();
		
		try {
			
			Usuario usuario = usuarioAbm.traerUsuario(dni);
			
			Tarjeta tarjeta = tarjetaAbm.traerTarjeta(123456789);
			
			if(tarjeta == null) {
				tarjetaAbm.agregar(123456789, 15, null, usuario, true, null);
				tarjeta = tarjetaAbm.traerTarjeta(123456789);
			}
			
			
			
			
			
			
			
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		

	}

}
