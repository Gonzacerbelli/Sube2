package test;

import datos.Usuario;
import datos.UsuarioBeneficio;
import datos.Viaje;
import datos.Beneficio;
import datos.Estacion;
import datos.Ramal;
import datos.Usuario;
import datos.Movimiento;

import negocio.UsuarioABM;
import negocio.EstacionABM;
import negocio.RamalABM;
import negocio.UsuarioABM;
import negocio.ViajeABM;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;



public class TestTraerUsuario {

	public static void main(String[] args) {

		try 
		{
			UsuarioABM UsuarioABM = new UsuarioABM();
			Usuario Usuario = UsuarioABM.traerUsuario(39281276);
			for(UsuarioBeneficio ub : Usuario.getUsuarioBeneficios()) 
			{
				System.out.println(ub.getFechaCobro());
				ub.setFechaCobro((GregorianCalendar)Calendar.getInstance());
			}
			UsuarioABM.modificar(Usuario);
			Usuario = UsuarioABM.traerUsuario(39281276);
			for(UsuarioBeneficio ub : Usuario.getUsuarioBeneficios()) 
			{
				System.out.println(ub.getFechaCobro());	
			}
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
		}
		
	}

}
