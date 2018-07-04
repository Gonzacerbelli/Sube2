package dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.RamalEstacion;

public class RamalEstacionDao {
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
	
	public int agregar(RamalEstacion objeto) {
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

	public void actualizar(RamalEstacion objeto) throws HibernateException {
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

	public void eliminar(RamalEstacion objeto) throws HibernateException {
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
	
	public RamalEstacion traerRamalEstacion(int idRamalEstacion) throws HibernateException {
		RamalEstacion objeto = null;
		try {
			iniciaOperacion();
			objeto = (RamalEstacion) session.get(RamalEstacion.class, idRamalEstacion);
			tx.commit();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public RamalEstacion traerRamalEstacion(int idRamal, int idEstacion) throws HibernateException {
		RamalEstacion objeto = null;
		try {
			iniciaOperacion();
			String hql = "from RamalEstacion c where c.ramal.idRamal = " + idRamal + " and  c.estacion.idEstacion = " + idEstacion;
			objeto = (RamalEstacion) session.createQuery(hql).uniqueResult();
			if(objeto != null) {
				Hibernate.initialize(objeto.getEstacion());
				Hibernate.initialize(objeto.getRamal());
			}
			tx.commit();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<RamalEstacion> traerRamalEstacion() throws HibernateException {
		List<RamalEstacion> list = null;
		try {
			iniciaOperacion();
			String hql = "from RamalEstacion";
			list = (List<RamalEstacion>) session.createQuery(hql).list();
			tx.commit();
		} finally {
			session.close();
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<RamalEstacion> traerRamalEstaciones(int idRamal) throws HibernateException {
		List<RamalEstacion> list = null;
		try {
			iniciaOperacion();
			String hql = "from RamalEstacion ub where ub.ramal.idRamal = " + idRamal;
			list = (List<RamalEstacion>) session.createQuery(hql).list();
			tx.commit();
		} finally {
			session.close();
		}
		return list;
	}
	
	
}
