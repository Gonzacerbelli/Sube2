package test;

import datos.Usuario;
import datos.Viaje;
import datos.Transporte;
import datos.Movimiento;

import negocio.UsuarioABM;
import negocio.TransporteABM;
import negocio.ViajeABM;

import java.util.List;
import java.util.Set;



public class TestTraerTransporte {

	public static void main(String[] args) {

		try 
		{
			TransporteABM tABM = new TransporteABM();
			Transporte transporte = tABM.traerTransporte("Tren");
			System.out.println(transporte.toString());
			List<Transporte> list = tABM.traerTransporte();
			System.out.println(list);
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
	}

}
