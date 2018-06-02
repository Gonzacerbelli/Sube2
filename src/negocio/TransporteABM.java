package negocio;

import datos.Movimiento;
import datos.Transporte;
import datos.Usuario;
import datos.Viaje;

import java.util.List;
import java.util.Set;
import dao.TransporteDao;

public class TransporteABM {
	TransporteDao dao = new TransporteDao();
	
	public int agregar(String nombre) throws Exception {
		Transporte TransporteAux = dao.traerTransporte(nombre);
		if (TransporteAux != null) {
			throw new Exception("Existe un Transporte con el mismo nombre.");
		}
		Transporte t = new Transporte(nombre);
		return dao.agregar(t);
	}
	
	public void modificar(Transporte t) throws Exception {
		Transporte TransporteAux = dao.traerTransporte(t.getIdTransporte());
		if (TransporteAux != null) {
			dao.actualizar(TransporteAux);
		} else {
			throw new Exception("No existe un Transporte con ese id.");
		}
	}

	public void eliminar(int idTransporte) throws Exception {
		Transporte t = dao.traerTransporte(idTransporte);
		if(t == null) {
			throw new Exception("El Transporte no existe.");
		}
		dao.eliminar(t);
	}
	
	public Transporte traerTransporte(int idTransporte) throws Exception {
		Transporte t = dao.traerTransporte(idTransporte);
		if (t == null) {
			throw new Exception("El Transporte no existe en la base de datos.");
		}
		return t;
	}
	
	public Transporte traerTransporte(String nombre) throws Exception {
		Transporte t = dao.traerTransporte(nombre);
		if (t == null) {
			throw new Exception("El Transporte no existe en la base de datos.");
		}
		return t;
	}
	
	public List<Transporte> traerTransporte() throws Exception {
		List<Transporte> list = dao.traerTransporte();
		if (list == null) {
			throw new Exception("El Transporte no existe en la base de datos.");
		}
		return list;
	}
	
}
