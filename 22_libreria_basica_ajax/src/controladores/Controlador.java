package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		String url = "inicio.html";
		switch(op) {
			case "hacerListaLibros":
				request.getRequestDispatcher("ListaLibrosAjaxAction").forward(request, response);
				return;
			case "hacerListaTemas":
				request.getRequestDispatcher("ListaTemasAction").include(request, response);
				url = "temas.jsp";
				break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}	
}
