package test;

import datos.Usuario;
import datos.Viaje;
import datos.Tarjeta;
import datos.Movimiento;

import negocio.UsuarioABM;
import negocio.TarjetaABM;
import negocio.ViajeABM;

import java.util.Set;



public class TestAgregarTarjeta {

	public static void main(String[] args) {

		try 
		{
			TarjetaABM tABM = new TarjetaABM();
			int ultimoId = tABM.agregar(1239);
			System.out.println("Agregar tarjeta --" + ultimoId);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println(e);
		}
		
		
		
		
		

	}

}
