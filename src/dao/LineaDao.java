package dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Estacion;
import datos.Linea;
import datos.Linea;
import datos.Linea;

public class LineaDao {
	
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
	
	public int agregar(Linea objeto) {
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

	public void actualizar(Linea objeto) throws HibernateException {
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

	public void eliminar(Linea objeto) throws HibernateException {
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
	
	public Linea traerLinea(int idLinea) throws HibernateException {
		Linea objeto = null;
		try {
			iniciaOperacion();
			objeto = (Linea) session.get(Linea.class, idLinea);
			tx.commit();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Linea traerLinea(String nombre) throws HibernateException {
		Linea objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Linea c where c.nombre = '" + nombre + "'";
			objeto = (Linea) session.createQuery(hql).uniqueResult();
			if(objeto != null)
			{
				Hibernate.initialize(objeto.getEstaciones());
				Hibernate.initialize(objeto.getRamales());
			}
			tx.commit();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Linea> traerLinea() throws HibernateException {
		List<Linea> list = null;
		try {
			iniciaOperacion();
			String hql = "from Linea";
			list = (List<Linea>) session.createQuery(hql).list();
			if(list != null)
			{
				for(Linea trans : list) {
					Hibernate.initialize(trans.getEstaciones());
					Hibernate.initialize(trans.getRamales());
				}
//				Iterator it =  (Iterator) list.iterator();
//				while(it.hasNext())
//				{
//					Hibernate.initialize(list.get(it.next()).getLineas());
//				}
			}
			tx.commit();
		} finally {
			session.close();
		}
		return list;
	}
	

}
