package negocio;

import java.util.List;

import dao.UsuarioDao;
import datos.Usuario;

public class UsuarioABM {
	UsuarioDao dao = new UsuarioDao();
		
	public Usuario traerUsuario(int dni) throws Exception {
		Usuario u = dao.traerUsuario(dni);
		if (u == null) {
			throw new Exception("El usuario no existe.");
		}
		return u;
	}
}
