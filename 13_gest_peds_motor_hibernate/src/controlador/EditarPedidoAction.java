package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoPedidos;
import model.Pedido;

/**
 * Servlet implementation class EditarPedidoAction
 */
@WebServlet("/EditarPedidoAction")
public class EditarPedidoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	DaoPedidos daoEjb;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idPedido = Integer.parseInt(request.getParameter("idPedido"));
		Pedido pedido = daoEjb.damePedido(idPedido);
		request.setAttribute("pedido",pedido);
	}
}
