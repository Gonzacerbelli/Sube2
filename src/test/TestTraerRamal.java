package test;

import datos.Usuario;
import datos.Viaje;
import datos.Estacion;
import datos.Ramal;
import datos.Movimiento;

import negocio.UsuarioABM;
import negocio.EstacionABM;
import negocio.RamalABM;
import negocio.ViajeABM;

import java.util.Iterator;
import java.util.List;
import java.util.Set;



public class TestTraerRamal {

	public static void main(String[] args) {

		try 
		{
			RamalABM tABM = new RamalABM();
			Ramal Ramal = tABM.traerRamal(1);
			System.out.println(Ramal.toString());
			System.out.println(Ramal.getEstaciones());
//			Iterator it = Ramal.getEstaciones().iterator();
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
			System.out.println(e);
		}
		
	}

}
