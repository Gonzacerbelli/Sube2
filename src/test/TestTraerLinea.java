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



public class TestTraerLinea {

	public static void main(String[] args) {

		try 
		{
			LineaABM tABM = new LineaABM();
			Linea linea = tABM.traerLinea("Roca");
			System.out.println(linea.toString());
			System.out.println(linea.getEstaciones());
			System.out.println(linea.getRamales());
			Iterator it = linea.getEstaciones().iterator();
			Estacion e = (Estacion) it.next();
			EstacionABM eABM = new EstacionABM();
			e = eABM.traerEstacion(e.getIdEstacion());
			System.out.println("Estacion " + e.toString());
			System.out.println("Esta en ramales " + e.getEstacionRamales());
//			List<Linea> list = tABM.traerLinea();
//			System.out.println(list);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println(e);
		}
		
	}

}
