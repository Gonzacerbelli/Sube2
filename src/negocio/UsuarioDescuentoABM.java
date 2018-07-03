package negocio;

import datos.Descuento;
import datos.Movimiento;
import datos.UsuarioDescuento;
import datos.Usuario;
import datos.Viaje;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import dao.UsuarioDescuentoDao;

public class UsuarioDescuentoABM {
	UsuarioDescuentoDao dao = new UsuarioDescuentoDao();
	
	public int agregar(Usuario usuario, Descuento descuento, GregorianCalendar fechaAsignado, boolean activo) throws Exception {
		UsuarioDescuento t = new UsuarioDescuento(usuario, descuento, fechaAsignado, activo);
		return dao.agregar(t);
	}
	
	public void modificar(UsuarioDescuento t) throws Exception {
		UsuarioDescuento UsuarioDescuentoAux = dao.traerUsuarioDescuento(t.getIdRelacion());
		if (UsuarioDescuentoAux != null) {
			dao.actualizar(UsuarioDescuentoAux);
		} else {
			throw new Exception("No existe un UsuarioDescuento con ese id.");
		}
	}

	public void eliminar(int idUsuarioDescuento) throws Exception {
		UsuarioDescuento t = dao.traerUsuarioDescuento(idUsuarioDescuento);
		if(t == null) {
			throw new Exception("El UsuarioDescuento no existe.");
		}
		dao.eliminar(t);
	}
	
	public UsuarioDescuento traerUsuarioDescuento(int idUsuarioDescuento) throws Exception {
		UsuarioDescuento t = dao.traerUsuarioDescuento(idUsuarioDescuento);
		if (t == null) {
			throw new Exception("El UsuarioDescuento no existe en la base de datos.");
		}
		return t;
	}
	
	public UsuarioDescuento traerUsuarioDescuento(int idUsuario, int idDescuento) throws Exception {
		UsuarioDescuento t = dao.traerUsuarioDescuento(idUsuario, idDescuento);
		if (t == null) {
			throw new Exception("El UsuarioDescuento no existe en la base de datos.");
		}
		return t;
	}
	
	public List<UsuarioDescuento> traerUsuarioDescuentos(int idUsuario) {
		List<UsuarioDescuento> t = dao.traerUsuarioDescuentos(idUsuario);
		if (t == null) {
			return new ArrayList<UsuarioDescuento>();
		}
		return t;
	}
	
	public List<UsuarioDescuento> traerUsuarioDescuento() throws Exception {
		List<UsuarioDescuento> list = dao.traerUsuarioDescuento();
		if (list == null) {
			throw new Exception("El UsuarioDescuento no existe en la base de datos.");
		}
		return list;
	}
	
}
