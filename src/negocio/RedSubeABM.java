package negocio;

import dao.RedSubeDao;
import datos.RedSube;
import datos.Estacion;
import datos.Linea;
import datos.Ramal;
import datos.RedSube;
import datos.Tarifa;
import datos.Viaje;
import datos.Transporte;
import datos.Usuario;

import java.util.GregorianCalendar;

public class RedSubeABM {
	RedSubeDao dao = new RedSubeDao();
		
	public RedSube traerRedSube(int idRedSube) throws Exception {
		RedSube b = dao.traerRedSube(idRedSube);
		if (b == null) {
			throw new Exception("El RedSube no existe.");
		}
		return b;
	}
	
	public RedSube traerRedSubeCorrespondiente(int cantidadBoletos) throws Exception {
		RedSube b = dao.traerRedSubeCorrespondiente(cantidadBoletos);

		return b;
	}
	
}
