package controladores;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.jws.WebMethod;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch.lambdaj.Lambda;

import org.apache.tomcat.util.file.Matcher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;

import datos.Estacion;
import datos.Linea;
import datos.Movimiento;
import datos.Ramal;
import datos.RamalEstacion;
import datos.Tarifa;
import datos.Tarjeta;
import datos.Transporte;
import datos.Usuario;
import negocio.Facade;
import util.Funciones;

public class ControladorMovimientos extends HttpServlet {
	
	private Facade f = new Facade();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException
	{
		procesarPeticion(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException
	{
		procesarPeticion(request, response);
	}
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{	
		switch((String)request.getParameter("accion")) 
		{
			case "traerTarjetas":
			{
				traerTarjetas(request,response);
				break;
			}
			case "traerMovimientos":
			{
				traerMovimientos(request, response);
				break;
			}
			case "traerSaldoFecha":
			{
				traerSaldoFecha(request, response);
				break;
			}
			case "traerTarjetaActiva":
			{
				traerTarjetaActiva(request, response);
				break;
			}
			case "traerCantidadTransporte":
			{
				traerCantidadTransporte(request, response);
				break;
			}
			case "traerCantidadMedios":
			{
				traerCantidadMedios(request, response);
				break;
			}
			case "traerSelects":
			{
				traerSelects(request, response);
				break;
			}
		}
	
	}
	
	private void traerTarjetas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		JSONObject obj = new JSONObject();
		try {
			System.out.println(request.getSession().getAttribute("dniUsuarioLogueado"));
			int dni = (int)request.getSession().getAttribute("dniUsuarioLogueado");
			Usuario usuario = f.getUsuarioABM().traerUsuario(dni);
			Set<Tarjeta> tarjetas = usuario.getTarjetas();
			List<Integer> numTarjetas = new ArrayList<Integer>();
			tarjetas.forEach(t -> numTarjetas.add(t.getNumTarjeta()));
			obj.put("tarjetas", numTarjetas);
			obj.put("status", "ok");
			response.getWriter().write(obj.toString());		
		}
		catch(Exception ex) {
			try {
				obj.put("status", "error");
				obj.put("mensaje", ex.getMessage());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			response.getWriter().write(obj.toString());
		}
	}
	
	private void traerTarjetaActiva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		JSONObject obj = new JSONObject();
		try {
			System.out.println(request.getSession().getAttribute("dniUsuarioLogueado"));
			int dni = (int)request.getSession().getAttribute("dniUsuarioLogueado");
			Usuario usuario = f.getUsuarioABM().traerUsuario(dni);
			Tarjeta tarjetaActiva = f.getTarjetaABM().traerTarjetaActiva(usuario);
			obj.put("tarjetas", tarjetaActiva.getNumTarjeta());
			obj.put("status", "ok");
			response.getWriter().write(obj.toString());		
		}
		catch(Exception ex) {
			try {
				obj.put("status", "error");
				obj.put("mensaje", ex.getMessage());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			response.getWriter().write(obj.toString());
		}
	}
	
	private void traerMovimientos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		JSONObject obj = new JSONObject();
		JSONArray array = new JSONArray();
		try {
			
			String desdeStr = request.getParameter("fechaDesde");
			String hastaStr = request.getParameter("fechaHasta");
			String tipo = request.getParameter("tipo");
			String numTarjeta = request.getParameter("numTarjeta");
			
			Tarjeta tarjeta = f.getTarjetaABM().traerTarjetaPorNum(Integer.parseInt(numTarjeta));
			
			List<Movimiento> movimientos = f.getMovimientoABM().traerMovimientos(tarjeta.getIdTarjeta(), desdeStr, hastaStr, tipo);
			
			obj.put("movimientos", movimientos);
			obj.put("status", "ok");
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(obj.toString());		
		}
		catch(Exception ex) {
			
			try {
				obj.put("status", "error");
				obj.put("error", "No hay movimientos");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
			}
			response.getWriter().write(obj.toString());
		}
	}
	
	private void traerCantidadTransporte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		JSONObject obj = new JSONObject();
		try {
			
			String desdeStr = request.getParameter("fechaDesde");
			String hastaStr = request.getParameter("fechaHasta");
			String tipo = request.getParameter("tipo");
			String medio = request.getParameter("medio");
			String numTarjeta = request.getParameter("numTarjeta");
			
			Tarjeta tarjeta = f.getTarjetaABM().traerTarjetaPorNum(Integer.parseInt(numTarjeta));
			
			int cTren = f.getMovimientoABM().traerCantidad("Tren",tarjeta.getIdTarjeta(),desdeStr,hastaStr,tipo);
			int cColectivo = f.getMovimientoABM().traerCantidad("Colectivo",tarjeta.getIdTarjeta(),desdeStr,hastaStr,tipo);
			int cSubte = f.getMovimientoABM().traerCantidad("Subte",tarjeta.getIdTarjeta(),desdeStr,hastaStr,tipo);

			obj.put("tren", cTren);
			obj.put("subte", cSubte);
			obj.put("colectivo", cColectivo);
			obj.put("status", "ok");
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(obj.toString());		
		}
		catch(Exception ex) {
			
			try {
				obj.put("status", "error");
				obj.put("error", "No hay movimientos");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
			}
			response.getWriter().write(obj.toString());
		}
	}
	
	private void traerCantidadMedios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		JSONObject obj = new JSONObject();
		try {

			String desdeStr = request.getParameter("fechaDesde");
			String hastaStr = request.getParameter("fechaHasta");
			String numTarjeta = request.getParameter("numTarjeta");
			
			Tarjeta tarjeta = f.getTarjetaABM().traerTarjetaPorNum(Integer.parseInt(numTarjeta));
			
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(f.getMovimientoABM().traerCantidadMedio(tarjeta.getIdTarjeta(),desdeStr,hastaStr).toString());
		}
		catch(Exception ex) {
			
			try {
				obj.put("status", "error");
				obj.put("error", "No hay movimientos");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
			}
			response.getWriter().write(obj.toString());
		}
	}
	
	
private void traerSaldoFecha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		JSONObject obj = new JSONObject();
		
		try {
			
			String numTarjeta = request.getParameter("numTarjeta");
			
			Tarjeta tarjeta = f.getTarjetaABM().traerTarjetaPorNum(Integer.parseInt(numTarjeta));
			
			GregorianCalendar fechaHora = (GregorianCalendar) Calendar.getInstance();
			
			String fechaHoraStr = Funciones.traerFechaCorta(fechaHora);
			
			obj.put("saldo", tarjeta.getSaldo());
			obj.put("fechaHora", fechaHoraStr);
			obj.put("status", "ok");
			response.getWriter().write(obj.toString());		
		}
		catch(Exception ex) {
			
			try {
				obj.put("status", "error");
				obj.put("error", "No se encontro la tarjeta.");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
			}
			response.getWriter().write(obj.toString());
		}
	}

	private void traerSelects(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		JSONObject obj = new JSONObject();
		
		try {
			
			String desdeStr = request.getParameter("fechaDesde");
			String hastaStr = request.getParameter("fechaHasta");
			String numTarjeta = request.getParameter("numTarjeta");
			
			Tarjeta tarjeta = f.getTarjetaABM().traerTarjetaPorNum(Integer.parseInt(numTarjeta));
			
			List<String> lista = f.getMovimientoABM().traerTipoMovimiento(tarjeta.getIdTarjeta(), desdeStr, hastaStr);
			JSONObject array = new JSONObject();
			
			array.put("tipoMovimientos", lista);
			array.put("status", "ok");
			response.getWriter().write(array.toString());	
			
		}
		catch(Exception ex) {
			
			try {
				obj.put("status", "error");
				obj.put("error", "No se encontro la tarjeta.");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
			}
			response.getWriter().write(obj.toString());
		}
	}
	

}
