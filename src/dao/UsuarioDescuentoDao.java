package dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.UsuarioDescuento;

public class UsuarioDescuentoDao {
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public int agregar(UsuarioDescuento objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(UsuarioDescuento objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public void eliminar(UsuarioDescuento objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public UsuarioDescuento traerUsuarioDescuento(int idUsuarioDescuento) throws HibernateException {
		UsuarioDescuento objeto = null;
		try {
			iniciaOperacion();
			objeto = (UsuarioDescuento) session.get(UsuarioDescuento.class, idUsuarioDescuento);
			tx.commit();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public UsuarioDescuento traerUsuarioDescuento(int idUsuario, int idDescuento) throws HibernateException {
		UsuarioDescuento objeto = null;
		try {
			iniciaOperacion();
			String hql = "from usuario_tiene_Descuento c where c.idUsuario = " + idUsuario + " and  c.idDescuento = " + idDescuento;
			objeto = (UsuarioDescuento) session.createQuery(hql).uniqueResult();
			tx.commit();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<UsuarioDescuento> traerUsuarioDescuento() throws HibernateException {
		List<UsuarioDescuento> list = null;
		try {
			iniciaOperacion();
			String hql = "from UsuarioDescuento";
			list = (List<UsuarioDescuento>) session.createQuery(hql).list();
			tx.commit();
		} finally {
			session.close();
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<UsuarioDescuento> traerUsuarioDescuentos(int idUsuario) throws HibernateException {
		List<UsuarioDescuento> list = null;
		try {
			iniciaOperacion();
			String hql = "from UsuarioDescuento ud where ud.usuario.idUsuario = " + idUsuario;
			list = (List<UsuarioDescuento>) session.createQuery(hql).list();
			tx.commit();
		} finally {
			session.close();
		}
		return list;
	}
}
