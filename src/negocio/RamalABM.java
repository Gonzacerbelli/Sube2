package negocio;

import datos.Ramal;
import datos.Linea;
import datos.Movimiento;
import datos.Ramal;
import datos.Transporte;
import datos.Usuario;
import datos.Viaje;

import java.util.List;
import java.util.Set;
import dao.RamalDao;

public class RamalABM {
	RamalDao dao = new RamalDao();
	
	public int agregar(String nombre, Linea linea) throws Exception {
		Ramal RamalAux = dao.traerRamal(nombre);
		if (RamalAux != null) {
			throw new Exception("Existe un Ramal con el mismo nombre.");
		}
		Ramal t = new Ramal(nombre, linea);
		return dao.agregar(t);
	}
	
	public void modificar(Ramal t) throws Exception {
		Ramal RamalAux = dao.traerRamal(t.getIdRamal());
		if (RamalAux != null) {
			dao.actualizar(RamalAux);
		} else {
			throw new Exception("No existe un Ramal con ese id.");
		}
	}

	public void eliminar(int idRamal) throws Exception {
		Ramal t = dao.traerRamal(idRamal);
		if(t == null) {
			throw new Exception("El Ramal no existe.");
		}
		dao.eliminar(t);
	}
	
	public Ramal traerRamal(int idRamal) throws Exception {
		Ramal t = dao.traerRamal(idRamal);
		if (t == null) {
			throw new Exception("El Ramal no existe en la base de datos.");
		}
		return t;
	}
	
	public Ramal traerRamal(String nombre) throws Exception {
		Ramal t = dao.traerRamal(nombre);
		if (t == null) {
			throw new Exception("El Ramal no existe en la base de datos.");
		}
		return t;
	}
	
//	public List<Ramal> traerRamal() throws Exception {
//		List<Ramal> list = dao.traerRamal();
//		if (list == null) {
//			throw new Exception("La Ramal no existe en la base de datos.");
//		}
//		return list;
//	}
//	
	
}
