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

import datos.Usuario;
import negocio.Facade;

public class ControladorUsuario extends HttpServlet {
	
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
			case "verificarUsuario":
				verificarUsuario(request, response);
			break;
		}
	}
	
	private void verificarUsuario(HttpServletRequest request, HttpServletResponse response) {
		JSONObject array = new JSONObject();
		try {
			
			int dni = (int) request.getSession().getAttribute("dniUsuarioLogueado");
			Usuario usuario = f.getUsuarioABM().traerUsuario(dni);
			
			array.put("permiso", usuario.getPermiso());
			
			response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(array.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
