package test;

import datos.Usuario;
import datos.Viaje;
import datos.Linea;
import datos.Movimiento;
import datos.Transporte;
import negocio.UsuarioABM;
import negocio.LineaABM;
import negocio.TransporteABM;
import negocio.ViajeABM;

import java.util.Set;



public class TestAgregarLinea {

	public static void main(String[] args) {

		try 
		{
			TransporteABM tABM = new TransporteABM();
			Transporte transporte = tABM.traerTransporte("Tren");
			LineaABM lABM = new LineaABM();
			int ultimoId = lABM.agregar("Sarmiento",transporte);
			System.out.println("Agregar Linea --" + ultimoId);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println(e);
		}
		
		
		
		
		

	}

}
