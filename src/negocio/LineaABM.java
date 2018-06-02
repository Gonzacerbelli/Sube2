package negocio;

import datos.Linea;
import datos.Movimiento;
import datos.Linea;
import datos.Transporte;
import datos.Usuario;
import datos.Viaje;

import java.util.List;
import java.util.Set;
import dao.LineaDao;

public class LineaABM {
	LineaDao dao = new LineaDao();
	
	public int agregar(String nombre, Transporte transporte) throws Exception {
		Linea LineaAux = dao.traerLinea(nombre);
		if (LineaAux != null) {
			throw new Exception("Existe un Linea con el mismo nombre.");
		}
		Linea t = new Linea(nombre, transporte);
		return dao.agregar(t);
	}
	
	public void modificar(Linea t) throws Exception {
		Linea LineaAux = dao.traerLinea(t.getIdLinea());
		if (LineaAux != null) {
			dao.actualizar(LineaAux);
		} else {
			throw new Exception("No existe un Linea con ese id.");
		}
	}

	public void eliminar(int idLinea) throws Exception {
		Linea t = dao.traerLinea(idLinea);
		if(t == null) {
			throw new Exception("El Linea no existe.");
		}
		dao.eliminar(t);
	}
	
	public Linea traerLinea(int idLinea) throws Exception {
		Linea t = dao.traerLinea(idLinea);
		if (t == null) {
			throw new Exception("El Linea no existe en la base de datos.");
		}
		return t;
	}
	
	public Linea traerLinea(String nombre) throws Exception {
		Linea t = dao.traerLinea(nombre);
		if (t == null) {
			throw new Exception("El Linea no existe en la base de datos.");
		}
		return t;
	}
	
	public List<Linea> traerLinea() throws Exception {
		List<Linea> list = dao.traerLinea();
		if (list == null) {
			throw new Exception("La Linea no existe en la base de datos.");
		}
		return list;
	}
	
	
}
