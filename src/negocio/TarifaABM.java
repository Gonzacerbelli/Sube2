package negocio;

import dao.TarifaDao;
import datos.Tarifa;
import datos.Transporte;
import java.util.List;

public class TarifaABM {
	TarifaDao dao = new TarifaDao();
	
	public int agregar(String nombre, int cantEstaciones, Transporte transporte, double monto) {
		Tarifa Tarifa = new Tarifa(nombre, cantEstaciones, transporte, monto);
		return dao.agregar(Tarifa);
	}
	
	public void modificar(Tarifa b) throws Exception {
		Tarifa Tarifa = dao.traerTarifa(b.getIdTarifa());
		if(Tarifa != null) {
			dao.actualizar(Tarifa);
		} else {
			throw new Exception("El Tarifa no existe.");
		}
	}
	
	public void eliminar(int idTarifa) throws Exception {
		Tarifa b = dao.traerTarifa(idTarifa);
		if(b == null) {
			throw new Exception("La Tarifa no existe.");
		}
		dao.eliminar(b);
	}
	
	public Tarifa traerTarifa(int idTarifa) throws Exception {
		Tarifa b = dao.traerTarifa(idTarifa);
		if (b == null) {
			throw new Exception("La Tarifa no existe.");
		}
		return b;
	}
	
	public List<Tarifa> traerTarifa(Transporte transporte) throws Exception {
		List<Tarifa> b = dao.traerTarifas(transporte.getIdTransporte());
		if (b == null) {
			throw new Exception("No existen tarifas para el transporte.");
		}
		return b;
	}
	
	public List<Tarifa> traerTarifas(int idTransporte) throws Exception {
		List<Tarifa> b = dao.traerTarifas(idTransporte);
		if (b == null) {
			throw new Exception("No existen tarifas para el transporte.");
		}
		return b;
	}
	
}
