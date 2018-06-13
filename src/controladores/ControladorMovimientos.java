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
		}
	
	}
	
	private void traerTarjetas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		JSONObject obj = new JSONObject();
		try {
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
	
	private void traerMovimientos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		JSONObject obj = new JSONObject();
		JSONArray array = new JSONArray();
		try {
			
			String desdeStr = request.getParameter("fechaDesde");
			String hastaStr = request.getParameter("fechaHasta");
			String tipo = request.getParameter("tipo");
			String medio = request.getParameter("medio");
			String numTarjeta = request.getParameter("numTarjeta");
			
			Tarjeta tarjeta = f.getTarjetaABM().traerTarjetaPorNum(Integer.parseInt(numTarjeta));
			
			List<Movimiento> movimientos = f.getMovimientoABM().traerMovimientos(tarjeta.getIdTarjeta());
			
			
			if(desdeStr != null) {
				GregorianCalendar desde = Funciones.parse("dd-MM-aaaa", desdeStr);
				movimientos = movimientos.stream().filter(mov -> mov.getFechaHora().after(desde)).collect(Collectors.toList());
			}
			if(hastaStr!= null) {
				GregorianCalendar hasta = Funciones.parse("dd-MM-aaaa", hastaStr);
				movimientos = movimientos.stream().filter(mov -> mov.getFechaHora().before(hasta)).collect(Collectors.toList());
			}
			if(tipo != null) {
				movimientos = movimientos.stream().filter(mov -> mov.getTipo().contains(tipo)).collect(Collectors.toList());
			}
			if(medio != null) {
				movimientos = movimientos.stream().filter(mov -> mov.getMedio().contains(medio)).collect(Collectors.toList());
			}
			List<String> fechaHoras = new ArrayList<>();
			List<String> tipos = new ArrayList<>();
			List<String> detalles = new ArrayList<>();
			List<String> medios = new ArrayList<>();
			List<String> valores = new ArrayList<>();
			for(Movimiento mov : movimientos) {
				fechaHoras.add(Funciones.traerFechaCortaHora(mov.getFechaHora()));
				tipos.add(mov.getTipo());
				detalles.add(mov.getDetalle());
				medios.add(mov.getMedio());
				valores.add(mov.getValor() + "");
			}
			obj.put("fechaHoras", fechaHoras);
			obj.put("tipos", tipos);
			obj.put("detalles", detalles);
			obj.put("medios", medios);
			obj.put("valores", valores);
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
	

}
