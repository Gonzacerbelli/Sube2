package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Transporte;

public class TransporteDao {
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
	
	public int agregar(Transporte objeto) {
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

	public void actualizar(Transporte objeto) throws HibernateException {
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

	public void eliminar(Transporte objeto) throws HibernateException {
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
	
	public Transporte traerTransporte(int idTransporte) throws HibernateException {
		Transporte objeto = null;
		try {
			iniciaOperacion();
			objeto = (Transporte) session.get(Transporte.class, idTransporte);
			if(objeto != null)
			{
				Hibernate.initialize(objeto.getLineas());
			}
			tx.commit();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Transporte traerTransporte(String nombre) throws HibernateException {
		Transporte objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Transporte c where c.nombre = '" + nombre + "'";
			objeto = (Transporte) session.createQuery(hql).uniqueResult();
			if(objeto != null)
			{
				Hibernate.initialize(objeto.getLineas());
			}
			tx.commit();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Transporte> traerTransporte() throws HibernateException {
		List<Transporte> list = null;
		try {
			iniciaOperacion();
			String hql = "from Transporte";
			list = (List<Transporte>) session.createQuery(hql).list();
			tx.commit();
		} finally {
			session.close();
		}
		return list;
	}
}
