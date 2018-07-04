package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.DeclareRoles;
import javax.management.relation.Role;
import javax.management.relation.RoleList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.json.JSONObject;

import datos.Rol;
import datos.Usuario;
import datos.UsuarioRol;
import negocio.Facade;
import sun.net.www.http.HttpClient;

public class ControladorRoles extends HttpServlet {
	
	private Facade f = new Facade();
	

}
