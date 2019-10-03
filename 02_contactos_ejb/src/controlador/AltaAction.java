package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoContactos;
import model.Contacto;

/**
 * Servlet implementation class Alta
 */
@WebServlet("/AltaAction")

// Con la siguiente nomenclatura hacemos que este mismo servlet atienda a varias urls
// @WebServlet(urlPatterns = {"/AltaAction","/Alta"})


public class AltaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	DaoContactos daoEjb;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		int edad = Integer.parseInt(request.getParameter("edad"));		 
		Contacto contacto = new Contacto(nombre,email,edad);
		daoEjb.altaContactoParametrizado(contacto);		
	}
}
