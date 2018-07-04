package negocio;

import datos.Rol;
import datos.Movimiento;
import datos.UsuarioRol;
import datos.Usuario;
import datos.Viaje;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import dao.UsuarioRolDao;

public class UsuarioRolABM {
	UsuarioRolDao dao = new UsuarioRolDao();
	
	public int agregar(Usuario usuario, Rol Rol) throws Exception {
		UsuarioRol t = new UsuarioRol(usuario, Rol);
		return dao.agregar(t);
	}
	
	public void modificar(UsuarioRol t) throws Exception {
		UsuarioRol UsuarioRolAux = dao.traerUsuarioRol(t.getIdUsuarioRol());
		if (UsuarioRolAux != null) {
			dao.actualizar(UsuarioRolAux);
		} else {
			throw new Exception("No existe un UsuarioRol con ese id.");
		}
	}

	public void eliminar(int idUsuarioRol) throws Exception {
		UsuarioRol t = dao.traerUsuarioRol(idUsuarioRol);
		if(t == null) {
			throw new Exception("El UsuarioRol no existe.");
		}
		dao.eliminar(t);
	}
	
	public UsuarioRol traerUsuarioRol(int idUsuarioRol) throws Exception {
		UsuarioRol t = dao.traerUsuarioRol(idUsuarioRol);
		if (t == null) {
			throw new Exception("El UsuarioRol no existe en la base de datos.");
		}
		return t;
	}
	
	public UsuarioRol traerUsuarioRol(int idUsuario, int idRol) throws Exception {
		UsuarioRol t = dao.traerUsuarioRol(idUsuario, idRol);
		if (t == null) {
			throw new Exception("El UsuarioRol no existe en la base de datos.");
		}
		return t;
	}
	
	public List<UsuarioRol> traerRoles(int idUsuario) throws Exception {
		List<UsuarioRol> t = dao.traerUsuarioRoles(idUsuario);
		if (t == null) {
			return new ArrayList<UsuarioRol>();
		}
		return t;
	}
	
	public List<UsuarioRol> traerUsuarioRol() throws Exception {
		List<UsuarioRol> list = dao.traerUsuarioRol();
		if (list == null) {
			throw new Exception("El UsuarioRol no existe en la base de datos.");
		}
		return list;
	}
	
}
