package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.DaoContactos;

/**
 * Servlet implementation class Guardar
 */
@WebServlet("/GuardarAction")
public class GuardarAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre=request.getParameter("nombre");
		String email=request.getParameter("email");
		int edad=Integer.parseInt(request.getParameter("edad"));
		DaoContactos dcontactos=new DaoContactos();
		dcontactos.guardarContacto(nombre, email, edad);
		//request.getRequestDispatcher("menu.html").forward(request, response);
	}

}
