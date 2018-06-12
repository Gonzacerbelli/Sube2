package test;

import datos.Usuario;
import datos.Viaje;
import datos.Estacion;
import datos.Linea;
import datos.Movimiento;

import negocio.UsuarioABM;
import negocio.EstacionABM;
import negocio.LineaABM;
import negocio.ViajeABM;

import java.util.Iterator;
import java.util.List;
import java.util.Set;



public class TestTraerEstacion {

	public static void main(String[] args) {

		try 
		{
			LineaABM tABM = new LineaABM();
			Linea linea = tABM.traerLinea(1);
			System.out.println(linea.toString());
			System.out.println(linea.getEstaciones().toString());
			List<Linea> list = tABM.traerLinea();
			System.out.println(list);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println(e);
		}
		
	}

}
