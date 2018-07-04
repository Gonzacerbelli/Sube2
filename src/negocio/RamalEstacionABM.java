package negocio;

import datos.Rol;
import datos.Estacion;
import datos.Movimiento;
import datos.Ramal;
import datos.RamalEstacion;
import datos.Usuario;
import datos.Viaje;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import dao.RamalEstacionDao;

public class RamalEstacionABM {
	RamalEstacionDao dao = new RamalEstacionDao();
	
	public int agregar(Ramal ramal, Estacion estacion, int nroEstacion) throws Exception {
		RamalEstacion t = new RamalEstacion(ramal, estacion, nroEstacion);
		return dao.agregar(t);
	}
	
	public void modificar(RamalEstacion t) throws Exception {
		RamalEstacion RamalEstacionAux = dao.traerRamalEstacion(t.getIdRelacion());
		if (RamalEstacionAux != null) {
			dao.actualizar(RamalEstacionAux);
		} else {
			throw new Exception("No existe un RamalEstacion con ese id.");
		}
	}

	public void eliminar(int idRamalEstacion) throws Exception {
		RamalEstacion t = dao.traerRamalEstacion(idRamalEstacion);
		if(t == null) {
			throw new Exception("El RamalEstacion no existe.");
		}
		dao.eliminar(t);
	}
	
	public RamalEstacion traerRamalEstacion(int idRamalEstacion) throws Exception {
		RamalEstacion t = dao.traerRamalEstacion(idRamalEstacion);
		if (t == null) {
			throw new Exception("El RamalEstacion no existe en la base de datos.");
		}
		return t;
	}
	
	public RamalEstacion traerRamalEstacion(int idRamal, int idEstacion) throws Exception {
		RamalEstacion t = dao.traerRamalEstacion(idRamal, idEstacion);
		if (t == null) {
			throw new Exception("El RamalEstacion no existe en la base de datos.");
		}
		return t;
	}
	
	public List<RamalEstacion> traerRoles(int idUsuario) throws Exception {
		List<RamalEstacion> t = dao.traerRamalEstaciones(idUsuario);
		if (t == null) {
			return new ArrayList<RamalEstacion>();
		}
		return t;
	}
	
	public List<RamalEstacion> traerRamalEstacion() throws Exception {
		List<RamalEstacion> list = dao.traerRamalEstacion();
		if (list == null) {
			throw new Exception("El RamalEstacion no existe en la base de datos.");
		}
		return list;
	}
	
}
