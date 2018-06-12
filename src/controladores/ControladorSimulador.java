package controladores;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import datos.Boleto;
import datos.Estacion;
import datos.Linea;
import datos.Ramal;
import datos.RamalEstacion;
import datos.RedSube;
import datos.Tarifa;
import datos.Tarjeta;
import datos.Transporte;
import datos.Usuario;
import datos.Viaje;
import negocio.Facade;
import util.Funciones;

public class ControladorSimulador extends HttpServlet {
	
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
			case "viajar":
				viajar(request,response);
			break;
			case "traerTransportes":
				traerTransportes(request, response);
			break;
			case "traerLineas":
				traerLineas(request, response);
			break;
			case "traerRamales":
				traerRamales(request, response);
			break;
			case "traerEstacionesRamal":
				traerEstacionesRamal(request, response);
			break;
			case "traerEstacionesLinea":
				traerEstacionesLinea(request, response);
			break;
			case "traerTarifas":
				traerTarifas(request, response);
			break;

		}
	}
	
	private void viajar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idTransporte = request.getParameter("idTransporte");
		String numTarjeta = request.getParameter("numTarjeta");
		String idLinea = request.getParameter("idLinea");
		String idRamal = request.getParameter("idRamal");
		String idEstacion = request.getParameter("idEstacion");
		String idTarifa = request.getParameter("idTarifa");
		String fechaHoraStr = request.getParameter("fechaHora");
		
		JSONObject array = new JSONObject();
		try {
			Transporte transporte = f.getTransporteABM().traerTransporte(Integer.parseInt(idTransporte));
			Tarjeta tarjeta = f.getTarjetaABM().traerTarjetaPorNum(Integer.parseInt(numTarjeta));
			Linea linea = f.getLineaABM().traerLinea(Integer.parseInt(idLinea));
			Ramal ramal = null;
			if(idRamal != null)
				ramal = f.getRamalABM().traerRamal(Integer.parseInt(idRamal));	
			Estacion estacion = null;
			if(idEstacion != null)
				estacion = f.getEstacionABM().traerEstacion(Integer.parseInt(idEstacion));
			Tarifa tarifa = null;
			if(idTarifa != null)//no debe llegar null
				tarifa = f.getTarifaABM().traerTarifa(Integer.parseInt(idTarifa));
			GregorianCalendar fechaHora = (GregorianCalendar) Calendar.getInstance(); //Funciones.traerFechaHMyS(fechaHoraStr);
			int dni = (int) request.getSession().getAttribute("dniUsuarioLogueado");
			Usuario usuario = f.getUsuarioABM().traerUsuario(dni);
			Viaje viaje = f.getViajeABM().viajeCorrespondiente(tarjeta, transporte, fechaHora);
			RedSube redSube = f.getRedSubeABM().traerRedSubeCorrespondiente(viaje.getCantBoletos());
			Boleto boleto = f.getBoletoABM().generarBoleto(fechaHora, tarifa, estacion, ramal, linea, transporte, viaje, usuario, redSube);
			f.getBoletoABM().cobrarBoleto(boleto, tarjeta);
			f.getTarjetaABM().modificar(tarjeta);
			tarjeta = f.getTarjetaABM().traerTarjetaPorNum(Integer.parseInt(numTarjeta));
			array.put("saldo", tarjeta.getSaldo());
			array.put("mensaje", "Buen viaje!");
			array.put("valorCobrado", boleto.getPrecioFinal());
			array.put("status", "ok");
			response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(array.toString());
		
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				array.put("status", "error");
				array.put("mensaje", e.getMessage());
			} catch (JSONException e1) {
			
			}
			
			e.printStackTrace();
		}
		
	}
	
	private void traerTransportes(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Transporte> transportes = f.getTransporteABM().traerTransporte();
			JSONObject array = new JSONObject();
			array.put("transportes", transportes);
			response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(array.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void traerLineas(HttpServletRequest request, HttpServletResponse response) {
		try {
			int idTransporte = Integer.parseInt(request.getParameter("idTransporte"));
			List<Linea> lineas = f.getLineaABM().traerLineas(idTransporte);
			JSONObject array = new JSONObject();
			array.put("lineas", lineas);
			response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(array.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void traerRamales(HttpServletRequest request, HttpServletResponse response) {
		try {
			int idLinea = Integer.parseInt(request.getParameter("idLinea"));
			List<Ramal> ramales = f.getRamalABM().traerRamales(idLinea);
			JSONObject array = new JSONObject();
			array.put("ramales", ramales);
			response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(array.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void traerEstacionesLinea(HttpServletRequest request, HttpServletResponse response) {
		try {
			int idLinea = Integer.parseInt(request.getParameter("idLinea"));
			List<Estacion> estaciones = f.getEstacionABM().traerEstacionesLinea(idLinea);
			JSONObject array = new JSONObject();
			array.put("estaciones", estaciones);
			response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(array.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void traerEstacionesRamal(HttpServletRequest request, HttpServletResponse response) {
		try {
			int idRamal = Integer.parseInt(request.getParameter("idRamal"));
			List<Estacion> estaciones = f.getEstacionABM().traerEstacionesRamal(idRamal);
			JSONObject array = new JSONObject();
			array.put("estaciones", estaciones);
			response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(array.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void traerTarifas(HttpServletRequest request, HttpServletResponse response) {
		try {
			int idTransporte = Integer.parseInt(request.getParameter("idTransporte"));
			List<Tarifa> tarifas = f.getTarifaABM().traerTarifas(idTransporte);
			JSONObject array = new JSONObject();
			array.put("tarifas", tarifas);
			response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(array.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
