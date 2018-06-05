package negocio;

import dao.BeneficioDao;
import datos.Beneficio;
import datos.Estacion;
import datos.Linea;
import datos.Movimiento;
import datos.Ramal;
import datos.Tarjeta;
import datos.Beneficio;
import datos.Viaje;
import datos.Terminal;
import datos.Transporte;
import datos.UsuarioBeneficio;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class BeneficioABM {
	BeneficioDao dao = new BeneficioDao();
	
	public int agregar(String nombre, double valor) {
		Beneficio beneficio = new Beneficio(nombre, valor);
		return dao.agregar(beneficio);
	}
	
	public void modificar(Beneficio b) throws Exception {
		Beneficio beneficio = dao.traerBeneficio(b.getIdBeneficio());
		if(beneficio != null) {
			dao.actualizar(b);
		} else {
			throw new Exception("El Beneficio no existe.");
		}
	}
	
	public void eliminar(int idBeneficio) throws Exception {
		Beneficio b = dao.traerBeneficio(idBeneficio);
		if(b == null) {
			throw new Exception("El Beneficio no existe.");
		}
		dao.eliminar(b);
	}
	
	public Beneficio traerBeneficio(int idBeneficio) throws Exception {
		Beneficio b = dao.traerBeneficio(idBeneficio);
		if (b == null) {
			throw new Exception("El Beneficio no existe.");
		}
		return b;
	}
	
	public List<Beneficio> traerBeneficios() throws Exception {
		List<Beneficio> b = dao.traerBeneficios();
		if (b == null) {
			throw new Exception("No existen Beneficios.");
		}
		return b;
	}
	
	public boolean estaParaAplicar(UsuarioBeneficio usuarioBeneficio) {
		if(usuarioBeneficio.isActivo())
		{
			GregorianCalendar aux = (GregorianCalendar) Calendar.getInstance(); 
			aux.add(Calendar.MONTH,-1);
			if(usuarioBeneficio.getFechaCobro().before(aux))
			{
				return true;
			}
		}
		return false;
	}
	
	public void aplicarBeneficios(Tarjeta tarjeta, Terminal terminal) {
		if(tarjeta.getUsuario() == null) {
			return;
		}
		for(UsuarioBeneficio ub : tarjeta.getUsuario().getUsuarioBeneficios())
		{
			if(estaParaAplicar(ub))
			{
				tarjeta.setSaldo(ub.getBeneficio().aplicarBeneficio(tarjeta.getSaldo()));
				GregorianCalendar fechaHora = (GregorianCalendar) Calendar.getInstance();
				ub.setFechaCobro(fechaHora);
				Movimiento movimiento = new Movimiento("Carga Beneficio", tarjeta, ub.getBeneficio().getValor(),  fechaHora, terminal.getUbicacion());
				tarjeta.agregarMovimiento(movimiento);
			}
		}
	}
	
}
