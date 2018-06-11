package controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import datos.Estacion;
import datos.Linea;
import datos.Ramal;
import datos.RamalEstacion;
import datos.Tarifa;
import datos.Transporte;
import datos.Usuario;
import negocio.Facade;

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
		
		String dni = request.getParameter("dni");
		
		String pass = request.getParameter("pass");
		
		Usuario usuario = null;
		
		String msjError = "";
		
		try 
		{
			usuario = f.getUsuarioABM().traerUsuario(Integer.parseInt(dni));	
		}
		catch(Exception ex)
		{
			msjError = "El DNI no se encuentra registrado en el sistema.";
			response.sendError(1, msjError);
		}
		
		if(usuario.getPass().equals(pass))
		{
			HttpSession session = request.getSession();
			session.setAttribute("dni", usuario.getDni());
			session.setAttribute("nombre", usuario.getNombre());
			session.setAttribute("apellido", usuario.getApellido());
		}
		else
		{
			msjError = "Contraseņa incorrecta";
			response.sendError(2, msjError);
		}
		
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
	}
	
	@SuppressWarnings("unused")
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
