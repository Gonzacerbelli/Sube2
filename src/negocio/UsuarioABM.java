package negocio;

import java.util.List;

import dao.UsuarioDao;
import datos.Tarjeta;
import datos.Usuario;
import datos.Usuario;

public class UsuarioABM {
	
	UsuarioDao dao = new UsuarioDao();
		
	public int agregar(String nombre, String apellido, int dni, String pass, String email) {
		Usuario Usuario = new Usuario(nombre, apellido, dni, pass, email);
		return dao.agregar(Usuario);
	}
	
	public void modificar(Usuario b) throws Exception {
		Usuario Usuario = dao.traerUsuario(b.getDni());
		if(Usuario != null) {
			dao.actualizar(b);
		} else {
			throw new Exception("El Usuario no existe.");
		}
	}
	
	public void eliminar(int idUsuario) throws Exception {
		Usuario b = dao.traerUsuario(idUsuario);
		if(b == null) {
			throw new Exception("El Usuario no existe.");
		}
		dao.eliminar(b);
	}
	
	public Usuario traerUsuario(int dni) throws Exception {
		Usuario u = dao.traerUsuario(dni);
		if (u == null) {
			throw new Exception("El usuario no existe.");
		}
		return u;
	}
	
	
	
	
}
