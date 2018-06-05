package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Ramal;
import datos.Linea;

public class RamalDao {
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
	
	public int agregar(Ramal objeto) {
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

	public void actualizar(Ramal objeto) throws HibernateException {
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

	public void eliminar(Ramal objeto) throws HibernateException {
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
	
	public Ramal traerRamal(int idRamal) throws HibernateException {
		Ramal objeto = null;
		try {
			iniciaOperacion();
			objeto = (Ramal) session.get(Ramal.class, idRamal);
			if(objeto!=null)
			{
				Hibernate.initialize(objeto.getRamalEstaciones());
			}
			tx.commit();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Ramal traerRamal(String nombre) throws HibernateException {
		Ramal objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Ramal c where c.nombre = '" + nombre + "'";
			objeto = (Ramal) session.createQuery(hql).uniqueResult();
			if(objeto != null)
			{
				Hibernate.initialize(objeto.getRamalEstaciones());
			}
			tx.commit();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Ramal> traerRamales(Linea linea) throws HibernateException {
		List<Ramal> list = null;
		try {
			iniciaOperacion();
			String hql = "from Ramal c where c.idLinea = " + linea.getIdLinea();
			list = (List<Ramal>) session.createQuery(hql).list();
			tx.commit();
		} finally {
			session.close();
		}
		return list;
	}
}
