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
			//traigo todos los transportes
			List<Transporte> list = tABM.traerTransporte();
			//los mando a la vista
			System.out.println(list);
			//el usuario selecciona uno
			int idTransporte = 1;
			//lo traigo con sus lineas
			Transporte transporte = tABM.traerTransporte(idTransporte);
			//mando las lineas a la vista
			System.out.println(transporte.getLineas());
			//el usuario selecciona una
			int idLinea = 1;
			//la traigo con sus estaciones y ramales
			Linea linea = f.getLineaABM().traerLinea(idLinea);
			//si tiene, mando los ramales a la vista
			if(linea.getRamales().size() > 0) {
				System.out.println(linea.getRamales());
				//el usuario selecciona un ramal
				int idRamal = 1;
				//lo traigo con sus estaciones
				Ramal ramal = f.getRamalABM().traerRamal(idRamal);
				//mando las estaciones a la vista
				
				if(ramal.getRamalEstaciones().size() > 0)
				{
					System.out.println(ramal.getRamalEstaciones());
					//el usuario selecciona una estacion del ramal
					int idEstacionRamal = 1;
					//traigo la estacion con sus ramales para posibles combinaciones
					Estacion estacionRamal = f.getEstacionABM().traerEstacion(idEstacionRamal);
					//fin	
				}
			}
			else { //si no tienem mando las estaciones a la vista
				System.out.println(linea.getEstaciones());
				//el usuario secciona una estacion de la linea
				int idEstacionLinea = 1;
				//traigo la estacion con sus ramales para posibles combinaciones
				Estacion estacionLinea = f.getEstacionABM().traerEstacion(idEstacionLinea);
				//fin
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
	}

}
