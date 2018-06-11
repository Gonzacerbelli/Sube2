package controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import datos.Tarjeta;
import negocio.Facade;

public class ControladorRecarga extends HttpServlet {
	
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
			case "verificarTarjeta":
				verificarTarjeta(request, response);
			case "recargarTarjeta":
				recargarTarjeta(request, response);
			}
	}
	
	private void verificarTarjeta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
	
	private void recargarTarjeta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jsonResponse = new JSONObject();
		
		try 
		{
			String numTarjeta = request.getParameter("numTarjeta");
			
			String montoStr = request.getParameter("monto");
			
			double monto = Double.parseDouble(montoStr);
			
			Tarjeta tarjeta = f.getTarjetaABM().traerTarjetaPorNum(Integer.parseInt(numTarjeta));
			
			f.getTarjetaABM().recargarTarjeta(tarjeta.getIdTarjeta(), monto);
			
			tarjeta = f.getTarjetaABM().traerTarjetaPorNum(Integer.parseInt(numTarjeta));
			
			jsonResponse.put("tarjeta", tarjeta);
		}
		
		catch(Exception ex) 
		{		
			String error = ex.getMessage();
			
			try 
			{
				jsonResponse.put("error", error);
			} 
			catch (JSONException e) {
				
			}	
		}
		
		response.getWriter().write(jsonResponse.toString());
	}
	
}
