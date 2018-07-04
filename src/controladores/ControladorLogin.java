package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.DeclareRoles;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import datos.Rol;
import datos.Usuario;
import datos.UsuarioRol;
import negocio.Facade;
import sun.net.www.http.HttpClient;

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
				request.getSession().setAttribute("dniUsuarioLogueado", dni);
				request.getSession().setAttribute("usuarioLogueado", usuario);
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().write("True");
			}else {
				response.setContentType("text/html;charset=UTF-8");
	            response.getWriter().write("Contraseña incorrecta.");
			}
			
		} catch (Exception e) {
			response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("Usuario incorrecto.");
            e.printStackTrace();
		}
	}
}
