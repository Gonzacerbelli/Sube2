package negocio;

import datos.Beneficio;
import datos.Movimiento;
import datos.UsuarioBeneficio;
import datos.Usuario;
import datos.Viaje;

import java.util.List;
import java.util.Set;
import dao.UsuarioBeneficioDao;

public class UsuarioBeneficioABM {
	UsuarioBeneficioDao dao = new UsuarioBeneficioDao();
	
	public int agregar(Usuario usuario, Beneficio beneficio) throws Exception {
		UsuarioBeneficio t = new UsuarioBeneficio(usuario, beneficio);
		return dao.agregar(t);
	}
	
	public void modificar(UsuarioBeneficio t) throws Exception {
		UsuarioBeneficio UsuarioBeneficioAux = dao.traerUsuarioBeneficio(t.getIdRelacion());
		if (UsuarioBeneficioAux != null) {
			dao.actualizar(UsuarioBeneficioAux);
		} else {
			throw new Exception("No existe un UsuarioBeneficio con ese id.");
		}
	}

	public void eliminar(int idUsuarioBeneficio) throws Exception {
		UsuarioBeneficio t = dao.traerUsuarioBeneficio(idUsuarioBeneficio);
		if(t == null) {
			throw new Exception("El UsuarioBeneficio no existe.");
		}
		dao.eliminar(t);
	}
	
	public UsuarioBeneficio traerUsuarioBeneficio(int idUsuarioBeneficio) throws Exception {
		UsuarioBeneficio t = dao.traerUsuarioBeneficio(idUsuarioBeneficio);
		if (t == null) {
			throw new Exception("El UsuarioBeneficio no existe en la base de datos.");
		}
		return t;
	}
	
	public UsuarioBeneficio traerUsuarioBeneficio(int idUsuario, int idBeneficio) throws Exception {
		UsuarioBeneficio t = dao.traerUsuarioBeneficio(idUsuario, idBeneficio);
		if (t == null) {
			throw new Exception("El UsuarioBeneficio no existe en la base de datos.");
		}
		return t;
	}
	
	public Set<UsuarioBeneficio> traerUsuarioBeneficios(int idUsuario) throws Exception {
		Set<UsuarioBeneficio> t = dao.traerUsuarioBeneficios(idUsuario);
		if (t == null) {
			throw new Exception("El usuario no tiene beneficios");
		}
		return t;
	}
	
	public List<UsuarioBeneficio> traerUsuarioBeneficio() throws Exception {
		List<UsuarioBeneficio> list = dao.traerUsuarioBeneficio();
		if (list == null) {
			throw new Exception("El UsuarioBeneficio no existe en la base de datos.");
		}
		return list;
	}
	
}
