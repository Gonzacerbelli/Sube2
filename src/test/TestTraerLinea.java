package test;

import datos.Usuario;
import datos.Viaje;
import datos.Estacion;
import datos.Linea;
import datos.Movimiento;
import datos.Ramal;
import datos.Transporte;
import negocio.UsuarioABM;
import negocio.EstacionABM;
import negocio.Facade;
import negocio.LineaABM;
import negocio.ViajeABM;

import java.util.Iterator;
import java.util.List;
import java.util.Set;



public class TestTraerLinea {

	public static void main(String[] args) {

		try 
		{
			Facade f = new Facade();
			LineaABM tABM = new LineaABM();
			Linea linea = tABM.traerLinea("Roca");
			System.out.println("LINEA --> " + linea.toString());
			System.out.println("ID TRANSPORTE --> " + linea.getTransporte().getIdTransporte());
			Transporte transporte = f.getTransporteABM().traerTransporte(linea.getTransporte().getIdTransporte());
			System.out.println("TRANSPORTE --> " + transporte);
			System.out.println("ESTACIONES --> " + linea.getEstaciones());
			System.out.println("RAMALES --> " + linea.getRamales());
			Iterator it = linea.getEstaciones().iterator();
			Estacion e = (Estacion) it.next();
			EstacionABM eABM = new EstacionABM();
			e = eABM.traerEstacion(e.getIdEstacion());
			System.out.println("PRIMER ESTACIONES --> " + e.toString());
			System.out.println("Esta en ramales --> " + e.getEstacionRamales());
			Ramal r = linea.getRamales().iterator().next();
			r = f.getRamalABM().traerRamal(1);
			System.out.println("RAMAL --> " + r);
			System.out.println("ESTACIONES RAMAL --> " + r.getRamalEstaciones());
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
