package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Estacion;
import datos.Linea;
import datos.Ramal;

public class EstacionDao {
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
	
	public int agregar(Estacion objeto) {
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

	public void actualizar(Estacion objeto) throws HibernateException {
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

	public void eliminar(Estacion objeto) throws HibernateException {
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
	
	public Estacion traerEstacion(int idEstacion) throws HibernateException {
		Estacion objeto = null;
		try {
			iniciaOperacion();
			objeto = (Estacion) session.get(Estacion.class, idEstacion);
			tx.commit();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Estacion traerEstacion(String nombre) throws HibernateException {
		Estacion objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Estacion c where c.nombre = '" + nombre + "'";
			objeto = (Estacion) session.createQuery(hql).uniqueResult();
			tx.commit();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Estacion> traerEstacionesLinea(int idLinea) throws HibernateException {
		List<Estacion> list = null;
		try {
			iniciaOperacion();
			String hql = "from Estacion e inner join fetch e.linea l where l.idLinea = " + idLinea;
			list = (List<Estacion>) session.createQuery(hql).list();
			tx.commit();
		} finally {
			session.close();
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Estacion> traerEstacionesRamal(int idRamal) throws HibernateException {
		List<Estacion> list = null;
		try {
			iniciaOperacion(); 
			String hql = "from ramal_tiene_estacion r_e inner join fetch Estacion e on e.idEstacion = r_e.idEstacion where r_e.idRamal = " + idRamal;
			list = (List<Estacion>) session.createQuery(hql).list();
			tx.commit();
		} finally {
			session.close();
		}
		return list;
	}
	
}
