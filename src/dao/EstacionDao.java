package dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Estacion;
import datos.Linea;
import datos.Ramal;
import datos.Estacion;

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
			if(objeto !=null)
			{
				Hibernate.initialize(objeto.getRamales());
			}
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
	public Set<Estacion> traerEstacion(Linea linea) throws HibernateException {
		Set<Estacion> list = null;
		try {
			iniciaOperacion();
			String hql = "from Estacion c where c.idLinea = " + linea.getIdLinea();
			list = (Set<Estacion>) session.createQuery(hql).list();
			tx.commit();
		} finally {
			session.close();
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Set<Estacion> traerEstacion(Ramal ramal) throws HibernateException {
		Set<Estacion> list = null;
		try {
			iniciaOperacion();
			String hql = "from Estacion c select * inner join ramal_tiene_estacion as r_e on r_e.idRamal = " + ramal.getIdRamal();
			list = (Set<Estacion>) session.createQuery(hql).list();
			tx.commit();
		} finally {
			session.close();
		}
		return list;
	}
	
}
