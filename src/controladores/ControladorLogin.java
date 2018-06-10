package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.Usuario;
import negocio.Facade;

public class ControladorLogin extends HttpServlet {
	
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
		if(request.getParameter("action").equals("loguear")) {
			loguear(request, response);
		}
	}
	
	private void loguear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int dni = Integer.parseInt(request.getParameter("dni"));		
			Usuario usuario = f.getUsuarioABM().traerUsuario(dni);
			String pass = request.getParameter("pass");
			
			if(usuario.getPass().equals(pass)) {
				response.setContentType("text/html;charset=UTF-8");
	            response.getWriter().write("True");
			}else {
				response.setContentType("text/html;charset=UTF-8");
	            response.getWriter().write("Contraseña incorrecta.");
			}
			
		} catch (Exception e) {
			response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("Usuario incorrecto.");
		}
	}
}
