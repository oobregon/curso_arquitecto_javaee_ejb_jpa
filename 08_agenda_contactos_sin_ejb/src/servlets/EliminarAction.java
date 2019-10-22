package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.DaoContactos;

/**
 * Servlet implementation class Eliminar
 */
@WebServlet("/EliminarAction")
public class EliminarAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre=request.getParameter("nombre");
		
		DaoContactos dcontactos=new DaoContactos();
		dcontactos.eliminarContacto(nombre);
		//request.getRequestDispatcher("menu.html").forward(request, response);
	}

}
