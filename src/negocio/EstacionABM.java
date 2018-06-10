package negocio;

import datos.Estacion;
import datos.Movimiento;
import datos.Ramal;
import datos.Estacion;
import datos.Transporte;
import datos.Usuario;
import datos.Viaje;

import java.util.List;
import java.util.Set;
import dao.EstacionDao;

public class EstacionABM {
	EstacionDao dao = new EstacionDao();
	
	public int agregar(String nombre) throws Exception {
		Estacion EstacionAux = dao.traerEstacion(nombre);
		if (EstacionAux != null) {
			throw new Exception("Existe un Estacion con el mismo nombre.");
		}
		Estacion t = new Estacion(nombre);
		return dao.agregar(t);
	}
	
	public void modificar(Estacion t) throws Exception {
		Estacion EstacionAux = dao.traerEstacion(t.getIdEstacion());
		if (EstacionAux != null) {
			dao.actualizar(EstacionAux);
		} else {
			throw new Exception("No existe un Estacion con ese id.");
		}
	}

	public void eliminar(int idEstacion) throws Exception {
		Estacion t = dao.traerEstacion(idEstacion);
		if(t == null) {
			throw new Exception("El Estacion no existe.");
		}
		dao.eliminar(t);
	}
	
	public Estacion traerEstacion(int idEstacion) throws Exception {
		Estacion t = dao.traerEstacion(idEstacion);
		if (t == null) {
			throw new Exception("El Estacion no existe en la base de datos.");
		}
		return t;
	}
	
	public Estacion traerEstacion(String nombre) throws Exception {
		Estacion t = dao.traerEstacion(nombre);
		if (t == null) {
			throw new Exception("El Estacion no existe en la base de datos.");
		}
		return t;
	}
	
	public List<Estacion> traerEstacionesRamal(int idRamal) throws Exception {
		List<Estacion> list = dao.traerEstacionesRamal(idRamal);
		if (list == null) {
			throw new Exception("La linea no tiene Estacioneses.");
		}
		return list;
	}
	
	public List<Estacion> traerEstacionesLinea(int idLinea) throws Exception {
		List<Estacion> list = dao.traerEstacionesLinea(idLinea);
		if (list == null) {
			throw new Exception("La linea no tiene Estacioneses.");
		}
		return list;
	}
	
//	public List<Estacion> traerEstacion() throws Exception {
//		List<Estacion> list = dao.traerEstacion();
//		if (list == null) {
//			throw new Exception("La Estacion no existe en la base de datos.");
//		}
//		return list;
//	}
	
	
}
