package negocio;

import dao.BeneficioDao;
import datos.Beneficio;
import datos.Estacion;
import datos.Linea;
import datos.Ramal;
import datos.Beneficio;
import datos.Viaje;
import datos.Transporte;
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
	
	
}
