package dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.UsuarioBeneficio;

public class UsuarioBeneficioDao {
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
	
	public int agregar(UsuarioBeneficio objeto) {
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

	public void actualizar(UsuarioBeneficio objeto) throws HibernateException {
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

	public void eliminar(UsuarioBeneficio objeto) throws HibernateException {
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
	
	public UsuarioBeneficio traerUsuarioBeneficio(int idUsuarioBeneficio) throws HibernateException {
		UsuarioBeneficio objeto = null;
		try {
			iniciaOperacion();
			objeto = (UsuarioBeneficio) session.get(UsuarioBeneficio.class, idUsuarioBeneficio);
			tx.commit();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public UsuarioBeneficio traerUsuarioBeneficio(int idUsuario, int idBeneficio) throws HibernateException {
		UsuarioBeneficio objeto = null;
		try {
			iniciaOperacion();
			String hql = "from usuario_tiene_beneficio c where c.idUsuario = " + idUsuario + " and  c.idBeneficio = " + idBeneficio;
			objeto = (UsuarioBeneficio) session.createQuery(hql).uniqueResult();
			tx.commit();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<UsuarioBeneficio> traerUsuarioBeneficio() throws HibernateException {
		List<UsuarioBeneficio> list = null;
		try {
			iniciaOperacion();
			String hql = "from usuario_tiene_beneficio";
			list = (List<UsuarioBeneficio>) session.createQuery(hql).list();
			tx.commit();
		} finally {
			session.close();
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Set<UsuarioBeneficio> traerUsuarioBeneficios(int idUsuario) throws HibernateException {
		Set<UsuarioBeneficio> list = null;
		try {
			iniciaOperacion();
			String hql = "from usuario_tiene_beneficio ub where ub.idUsuario = " + idUsuario;
			list = (Set<UsuarioBeneficio>) session.createQuery(hql).list();
			tx.commit();
		} finally {
			session.close();
		}
		return list;
	}
}
