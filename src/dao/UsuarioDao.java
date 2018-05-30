package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import datos.Usuario;

public class UsuarioDao {
	private static Session session;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
	}
	
	public Usuario traerUsuario(int dni) throws HibernateException {
		Usuario objeto = null;
		try {
			iniciaOperacion();
			objeto = (Usuario) session.createQuery("from Usuario u where u.dni=" + dni).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
}
