package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Estacion;
import datos.Movimiento;

public class MovimientoDao {
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
	
	public int agregar(Movimiento objeto) {
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

	public void actualizar(Movimiento objeto) throws HibernateException {
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

	public void eliminar(Movimiento objeto) throws HibernateException {
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
	

	public Movimiento traerMovimiento(int idMovimiento) throws HibernateException {
		Movimiento objeto = null;
		try {
			iniciaOperacion();
			objeto = (Movimiento) session.get(Movimiento.class, idMovimiento);
			tx.commit();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Movimiento> traerMovimientos(int idTarjeta) throws HibernateException {
		List<Movimiento> list = null;
		try {
			iniciaOperacion();
			String hql = "from Movimiento m where m.idTarjeta = " + idTarjeta;
			list = (List<Movimiento>) session.createQuery(hql).list();
			tx.commit();
		} finally {
			session.close();
		}
		return list;
	}
	
}
