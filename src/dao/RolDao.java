package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.HibernateUtil;
import datos.Tarifa;

public class RolDao {
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
	
	public int agregar(Tarifa objeto) {
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

	public void actualizar(Tarifa objeto) throws HibernateException {
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

	public void eliminar(Tarifa objeto) throws HibernateException {
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
	
	public Tarifa traerTarifa(int idTarifa) throws HibernateException {
		Tarifa objeto = null;
		try {
			iniciaOperacion();
			objeto = (Tarifa) session.get(Tarifa.class, idTarifa);
			tx.commit();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tarifa> traerTarifas(int idTransporte){
		List<Tarifa> list = null;
		try {
			iniciaOperacion();
			String hql = "from Tarifa t inner join fetch t.transporte tr where tr.idTransporte = " + idTransporte ;
			list = (List<Tarifa>) session.createQuery(hql).list();
			tx.commit();
		} finally {
			session.close();
		}
		return list;
	}
}
