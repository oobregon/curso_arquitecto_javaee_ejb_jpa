package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		String url="";
		switch(op) {
			case "doGuardar":
				request.getRequestDispatcher("GuardarAction").include(request, response);
				url="menu.html";
				break;
			case "doEliminar":
				request.getRequestDispatcher("EliminarAction").include(request, response);
				url="menu.html";
				break;
			case "doListado":
				request.getRequestDispatcher("ListadoAction").include(request, response);
				url="contactos.jsp";
				break;
			case "doEliminarPorId":
				request.getRequestDispatcher("EliminarPorIdAction").include(request, response);
				url="contactos.jsp";
				break;
			case "toRegistro":
				url="registro.html";
				break;
			case "toNombre":
				url="nombre.html";
				break;
			/*case "toMenu":
				url="menu.html";
				break;*/
			default:
				url="menu.html";
		}
		
		//transferimos el control a la vista definitiva
		request.getRequestDispatcher(url).forward(request, response);
	}

}
