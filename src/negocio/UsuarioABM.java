package negocio;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import dao.UsuarioDao;
import datos.Tarjeta;
import datos.Usuario;
import datos.UsuarioBeneficio;
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
	
	
	//devuelve false si esta mal la contraseņa, ex si esta mal el dni
	public boolean autenticar(int dni, String pass) {
		try {
			Usuario usuario = dao.traerUsuario(dni);
			return pass.equals(usuario.getPass());
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	public void asignarTarjeta(Tarjeta tarjeta, Usuario usuario) throws Exception {
		
		if(usuario.getTarjetas().contains(tarjeta)) {
			throw new Exception("La tarjeta ya estaba asignada.");
		}
		
		for(Tarjeta t : usuario.getTarjetas()) {
			if(t.isActiva()) {
				throw new Exception("El usuario ya tiene una tarjeta activa.");
			}
		}
		usuario.asignarTarjeta(tarjeta);
		modificar(usuario);
	}
	
	public void aplicarBeneficios(Tarjeta tarjeta) throws Exception {
		try
		{
			Usuario usuario = traerUsuario(tarjeta.getUsuario().getDni());
			
			for(UsuarioBeneficio ub : usuario.getUsuarioBeneficios()) 
			{
				
				tarjeta.setSaldo(tarjeta.getSaldo() + ub.getBeneficio().getValor());
				GregorianCalendar fechaCobro = (GregorianCalendar)Calendar.getInstance();
				ub.setFechaCobro(fechaCobro);
			}	
		}
		catch(Exception ex)
		{
			throw new Exception("No existen recargas pendientes");
		}
	}
	
	
}
