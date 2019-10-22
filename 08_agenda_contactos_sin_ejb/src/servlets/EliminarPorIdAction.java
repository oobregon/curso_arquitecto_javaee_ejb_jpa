package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.DaoContactos;

/**
 * Servlet implementation class EliminarPorIdAction
 */
@WebServlet("/EliminarPorIdAction")
public class EliminarPorIdAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("idContacto"));
		DaoContactos dao=new DaoContactos();
		dao.eliminarContactoPorId(id);
		request.getRequestDispatcher("ListadoAction").include(request, response);
	}

}
