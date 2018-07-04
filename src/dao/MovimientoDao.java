package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONException;
import org.json.JSONObject;

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
	public List<Movimiento> traerMovimientos(int idTarjeta, String desdeStr, String hastaStr, String tipo) throws HibernateException {
		List<Movimiento> list = null;
		try {
			iniciaOperacion();
			
			String fechaDesde = "";
			String fechaHasta = "";
			
			if(desdeStr == null || desdeStr == "") {
				fechaDesde = "2018-01-01 00:00:00";
			}else {
				fechaDesde = desdeStr+" 00:00:00";
			}
			
			if(hastaStr == null || hastaStr == "") {
				fechaHasta = "2018-12-31 23:59:59";
			}else {
				fechaHasta = hastaStr+" 23:59:59";
			}
			
			String hql = "from Movimiento m where m.tarjeta.idTarjeta = " + idTarjeta + " and m.fechaHora >= '" + fechaDesde + "' and m.fechaHora <= '" + fechaHasta + "'";
			list = (List<Movimiento>) session.createQuery(hql).list();
			tx.commit();
		} finally {
			session.close();
		}
		return list;
	}
	
	public int traerCantidad(String medio, int idTarjeta, String desdeStr, String hastaStr, String tipo) throws HibernateException {
		int count = 0;
		try {
			iniciaOperacion();

			String fechaDesde = "";
			String fechaHasta = "";
			
			if(desdeStr == null || desdeStr == "") {
				fechaDesde = "2018-01-01 00:00:00";
			}else {
				fechaDesde = desdeStr+" 00:00:00";
			}
			
			if(hastaStr == null || hastaStr == "") {
				fechaHasta = "2018-12-31 23:59:59";
			}else {
				fechaHasta = hastaStr+" 23:59:59";
			}
			
			count = ((Long)session.createQuery("select count(*) from Movimiento m where m.medio LIKE '"+medio+"%' and m.tarjeta.idTarjeta = " + idTarjeta + " and m.fechaHora >= '" + fechaDesde + "' and m.fechaHora <= '" + fechaHasta + "'").uniqueResult()).intValue();
			tx.commit();
		} finally {
			session.close();
		}
		return count;
	}
	
	public JSONObject traerCantidadMedio(int idTarjeta, String desdeStr, String hastaStr) throws HibernateException, JSONException {
		List<String> list = null;
		JSONObject obj = new JSONObject();
		try {
			iniciaOperacion();
			
			String fechaDesde = "";
			String fechaHasta = "";
			
			if(desdeStr == null || desdeStr == "") {
				fechaDesde = "2018-01-01 00:00:00";
			}else {
				fechaDesde = desdeStr+" 00:00:00";
			}
			
			if(hastaStr == null || hastaStr == "") {
				fechaHasta = "2018-12-31 23:59:59";
			}else {
				fechaHasta = hastaStr+" 23:59:59";
			}
			
			String hql = "select distinct(medio) from Movimiento m where m.tarjeta.idTarjeta = " + idTarjeta + " and  m.fechaHora >= '" + fechaDesde + "' and m.fechaHora <= '" + fechaHasta + "'";
			list = (List<String>) session.createQuery(hql).list();
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i) != "" || list.get(i) != null) {
					int count = ((Long)session.createQuery("select count(*) from Movimiento m where m.medio LIKE '%"+list.get(i)+"%' and m.tarjeta.idTarjeta = " + idTarjeta + " and  m.fechaHora >= '" + fechaDesde + "' and m.fechaHora <= '" + fechaHasta + "'").uniqueResult()).intValue();
					String[] claves = list.get(i).split(",");
					obj.put(claves[i], count);
				}
			}
			obj.put("status", "ok");
			
			
			tx.commit();
		} finally {
			session.close();
		}
		return obj;
	}
	
	public List<String> traerTipoMovimiento(int idTarjeta, String desdeStr, String hastaStr) throws HibernateException {
		List<String> list = null;
		try {
			iniciaOperacion();
			
			String fechaDesde = "";
			String fechaHasta = "";
			
			if(desdeStr == null || desdeStr == "") {
				fechaDesde = "2018-01-01 00:00:00";
			}else {
				fechaDesde = desdeStr+" 00:00:00";
			}
			
			if(hastaStr == null || hastaStr == "") {
				fechaHasta = "2018-12-31 23:59:59";
			}else {
				fechaHasta = hastaStr+" 23:59:59";
			}
			
			String hql = "select distinct(tipo) from Movimiento m where m.tarjeta.idTarjeta = " + idTarjeta + " and  m.fechaHora >= '" + fechaDesde + "' and m.fechaHora <= '" + fechaHasta + "'";
			list = (List<String>) session.createQuery(hql).list();
			
			tx.commit();
		} finally {
			session.close();
		}
		return list;
	}
	
}
