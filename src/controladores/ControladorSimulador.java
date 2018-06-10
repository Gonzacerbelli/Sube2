package controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		switch((String)request.getAttribute("accion")) 
		{
			case "viajar":
				viajar(request,response);
			case "traerTransportes":
				traerTransportes(request, response);
			case "traerLineas":
				traerLineas(request, response);
			case "traerRamales":
				traerRamales(request, response);
			case "traerEstacionesRamal":
				traerEstacionesRamal(request, response);
			case "traerEstacionesLinea":
				traerEstacionesLinea(request, response);
			case "traerTarifas":
				traerTarifas(request, response);

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
			msjError = "Contraseña incorrecta";
			response.sendError(2, msjError);
		}
		
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
	}
	
	@SuppressWarnings("unused")
	private void traerTransportes(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Transporte> transportes = f.getTransporteABM().traerTransporte();
			request.setAttribute("transportes", transportes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void traerLineas(HttpServletRequest request, HttpServletResponse response) {
		try {
			int idTransporte = (int) request.getAttribute("idTransporte");
			List<Linea> lineas = f.getLineaABM().traerLineas(idTransporte);
			request.setAttribute("lineas", lineas);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void traerRamales(HttpServletRequest request, HttpServletResponse response) {
		try {
			int idLinea = (int) request.getAttribute("idLinea");
			List<Ramal> ramales = f.getRamalABM().traerRamales(idLinea);
			request.setAttribute("ramales", ramales);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void traerEstacionesLinea(HttpServletRequest request, HttpServletResponse response) {
		try {
			int idLinea = (int) request.getAttribute("idLinea");
			List<Estacion> estaciones = f.getEstacionABM().traerEstacionesLinea(idLinea);
			request.setAttribute("estaciones", estaciones);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void traerEstacionesRamal(HttpServletRequest request, HttpServletResponse response) {
		try {
			int idRamal = (int) request.getAttribute("idRamal");
			List<Estacion> estaciones = f.getEstacionABM().traerEstacionesRamal(idRamal);
			request.setAttribute("estaciones", estaciones);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void traerTarifas(HttpServletRequest request, HttpServletResponse response) {
		try {
			int idTransporte = (int) request.getAttribute("idTransporte");
			List<Tarifa> tarifas = f.getTarifaABM().traerTarifas(idTransporte);
			request.setAttribute("tarifas", tarifas);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
