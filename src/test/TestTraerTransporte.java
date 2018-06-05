package test;

import datos.Usuario;
import datos.Viaje;
import datos.Transporte;
import datos.Estacion;
import datos.Linea;
import datos.Movimiento;
import datos.Ramal;
import negocio.UsuarioABM;
import negocio.Facade;
import negocio.TransporteABM;
import negocio.ViajeABM;

import java.util.List;
import java.util.Set;



public class TestTraerTransporte {

	public static void main(String[] args) {

		try 
		{
			Facade f = new Facade();
			TransporteABM tABM = new TransporteABM();
			Transporte transporte = tABM.traerTransporte("Tren");
			System.out.println(transporte.toString());
			List<Transporte> list = tABM.traerTransporte();
			System.out.println(list);
			Transporte transporte = list.get(0);
			List<Linea> lineas = f.getLineaABM().traerLineas(transporte.getIdTransporte());
			System.out.println(lineas);
			Linea linea = lineas.get(0);
			List<Ramales> ramales = f.getRamalABM().traerRamales(linea.getIdLinea());
			System.out.println(ramales);
			Ramal ramal = ramales.get(0);
			List<Estacion> estaciones = f.getEstacionABM().traerEstaciones(ramal.getIdRamal());
			System.out.println(estaciones);
			Estacion estacion = estaciones.get(0);
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
	}

}
