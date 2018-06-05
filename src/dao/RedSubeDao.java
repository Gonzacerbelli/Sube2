package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.HibernateUtil;
import datos.RedSube;
import datos.RedSube;
import datos.RedSube;

public class RedSubeDao {
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
	
	public int agregar(RedSube objeto) {
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

	public void actualizar(RedSube objeto) throws HibernateException {
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

	public void eliminar(RedSube objeto) throws HibernateException {
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
	
	public RedSube traerRedSube(int idRedSube) throws HibernateException {
		RedSube objeto = null;
		try {
			iniciaOperacion();
			objeto = (RedSube) session.get(RedSube.class, idRedSube);
			tx.commit();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public RedSube traerRedSubeCorrespondiente(int cantidadBoletos) throws HibernateException {
		RedSube objeto = null;
		try {
			iniciaOperacion();
			String hql = "from RedSube c where c.cantidadBoletos = " + cantidadBoletos;
			objeto = (RedSube) session.createQuery(hql).uniqueResult();
			tx.commit();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<RedSube> traerRedSubes(){
		List<RedSube> list = null;
		try {
			iniciaOperacion();
			String hql = "from RedSube";
			list = (List<RedSube>) session.createQuery(hql).list();
			tx.commit();
		} finally {
			session.close();
		}
		return list;
	}
}
