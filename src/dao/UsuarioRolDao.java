package dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.UsuarioRol;

public class UsuarioRolDao {
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
	
	public int agregar(UsuarioRol objeto) {
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

	public void actualizar(UsuarioRol objeto) throws HibernateException {
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

	public void eliminar(UsuarioRol objeto) throws HibernateException {
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
	
	public UsuarioRol traerUsuarioRol(int idUsuarioRol) throws HibernateException {
		UsuarioRol objeto = null;
		try {
			iniciaOperacion();
			objeto = (UsuarioRol) session.get(UsuarioRol.class, idUsuarioRol);
			tx.commit();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public UsuarioRol traerUsuarioRol(int idUsuario, int idRol) throws HibernateException {
		UsuarioRol objeto = null;
		try {
			iniciaOperacion();
			String hql = "from usuario_tiene_rol c where c.usuario.idUsuario = " + idUsuario + " and  c.rol.idRol = " + idRol;
			objeto = (UsuarioRol) session.createQuery(hql).uniqueResult();
			tx.commit();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<UsuarioRol> traerUsuarioRol() throws HibernateException {
		List<UsuarioRol> list = null;
		try {
			iniciaOperacion();
			String hql = "from usuario_tiene_rol";
			list = (List<UsuarioRol>) session.createQuery(hql).list();
			tx.commit();
		} finally {
			session.close();
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<UsuarioRol> traerUsuarioRoles(int idUsuario) throws HibernateException {
		List<UsuarioRol> list = null;
		try {
			iniciaOperacion();
			String hql = "from UsuarioRol ub where ub.usuario.idUsuario = " + idUsuario;
			list = (List<UsuarioRol>) session.createQuery(hql).list();
			tx.commit();
		} finally {
			session.close();
		}
		return list;
	}
}
