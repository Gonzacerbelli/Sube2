package test;

import datos.Usuario;
import datos.Viaje;
import datos.Transporte;
import datos.Movimiento;

import negocio.UsuarioABM;
import negocio.TransporteABM;
import negocio.ViajeABM;

import java.util.Set;



public class TestAgregarTransporte {

	public static void main(String[] args) {

		try 
		{
			TransporteABM tABM = new TransporteABM();
			int ultimoId = tABM.agregar("Tren");
			System.out.println("Agregar Transporte --" + ultimoId);

			ultimoId = tABM.agregar("Subte");
			System.out.println("Agregar Transporte --" + ultimoId);

			ultimoId = tABM.agregar("Colectivo");
			System.out.println("Agregar Transporte --" + ultimoId);
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
	}

}
