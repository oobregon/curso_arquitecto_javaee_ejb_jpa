package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoPedidos;

/**
 * Servlet implementation class EliminarPedidoAction
 */
@WebServlet("/EliminarPedidoAction")
public class EliminarPedidoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	DaoPedidos daoEjb;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idPedido = Integer.parseInt(request.getParameter("idPedido"));
		daoEjb.eliminarPedido(idPedido);
	}
}
