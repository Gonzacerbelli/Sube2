package test;

import datos.Usuario;
import datos.Viaje;
import datos.Estacion;
import datos.Ramal;
import datos.Tarjeta;
import datos.Transporte;
import datos.Movimiento;

import negocio.UsuarioABM;
import negocio.EstacionABM;
import negocio.Facade;
import negocio.RamalABM;
import negocio.TarjetaABM;
import negocio.ViajeABM;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;



public class TestTraerTarjeta {

	public static void main(String[] args) {

		try 
		{
			Facade f = new Facade();
			
			List<Transporte> transportes = f.getTransporteABM().traerTransporte();
			JSONArray array = new JSONArray();
			array.put(transportes);
			System.out.println(array);
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
