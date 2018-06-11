package controladores;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch.lambdaj.Lambda;

import org.apache.tomcat.util.file.Matcher;
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
			case "traerTarjeta":
				traerTarjeta(request,response);
			case "traerMovimientos":
				traerMovimientos(request, response);
			}
	}
	
	private void traerTarjeta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		try {
			String numTarjeta = request.getParameter("numTarjeta");
			Tarjeta tarjeta = f.getTarjetaABM().traerTarjetaPorNum(Integer.parseInt(numTarjeta));
			JSONObject obj = new JSONObject();
			obj.put("tarjeta", tarjeta);
			response.getWriter().write(obj.toString());		
		}
		catch(Exception ex) {
			response.getWriter().write(ex.getMessage());
		}
	}
	
	private void traerMovimientos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		try {
			
			String desdeStr = request.getParameter("desde");
			String hastaStr = request.getParameter("hasta");
			String tipo = request.getParameter("tipo");
			String medio = request.getParameter("medio");
			String numTarjeta = request.getParameter("numTarjeta");
			
			Tarjeta tarjeta = f.getTarjetaABM().traerTarjetaPorNum(Integer.parseInt(numTarjeta));
			
			JSONObject obj = new JSONObject();
			
			List<Movimiento> movimientos = f.getMovimientoABM().traerMovimientos(tarjeta.getIdTarjeta());
			
			if(!desdeStr.equals("")) {
				GregorianCalendar desde = Funciones.traerFechaHMyS(desdeStr);
				movimientos.stream().allMatch(mov -> mov.getFechaHora().after(desde));
			}
			if(!hastaStr.equals("")) {
				GregorianCalendar hasta = Funciones.traerFechaHMyS(hastaStr);	
				movimientos.stream().allMatch(mov -> mov.getFechaHora().before(hasta));
			}
			if(!tipo.equals("")) {
				movimientos.stream().allMatch(mov -> mov.getTipo().contains(tipo));
			}
			if(!medio.equals("")) {
				movimientos.stream().allMatch(mov -> mov.getMedio().contains(medio));
			}
			
			obj.put("movimientos", movimientos);
			
			response.getWriter().write(obj.toString());		
		}
		catch(Exception ex) {
			response.getWriter().write(ex.getMessage());
		}
	}
	

}
