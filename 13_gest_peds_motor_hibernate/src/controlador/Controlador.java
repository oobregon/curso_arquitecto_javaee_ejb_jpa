package controlador;

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

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlDestino = "menu.html";
		String op = request.getParameter("op");
		switch(op) {
		case "aFormMenu": 			
			urlDestino = "menu.html";
			break;		
		case "aFormAlta": 			
			urlDestino = "alta.html";
			break;		
		case "hacerAlta": 
			// transferencia de petición de ida y vuelta
			request.getRequestDispatcher("AltaPedidoAction").include(request, response);
			urlDestino = "menu.html";
			break;
		case "hacerListaPedidos": 
			// transferencia de petición de ida y vuelta			
			urlDestino = obtenerUrlListadoPedidos(request, response);
			break;								
		case "hacerEliminar": 
			// transferencia de petición de ida y vuelta
			request.getRequestDispatcher("EliminarPedidoAction").include(request, response);
			urlDestino = obtenerUrlListadoPedidos(request, response);
			break;			
		case "hacerEditar":
			// transferencia de petición de ida y vuelta
			request.getRequestDispatcher("EditarPedidoAction").include(request, response);
			urlDestino = "edicion.jsp";
			break;	
		case "hacerModificar":
			// transferencia de petición de ida y vuelta
			request.getRequestDispatcher("ModificarPedidoAction").include(request, response);
			urlDestino = obtenerUrlListadoPedidos(request, response);
			break;
		}
		request.getRequestDispatcher(urlDestino).forward(request,response);
	}
	
	private String obtenerUrlListadoPedidos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.getRequestDispatcher("PedidosAction").include(request, response);
		String url = ((String)request.getAttribute("resultado")).equals("ok")?"listadoPedidos.jsp":"sinPedidos.html";
		return url;
	}

}
