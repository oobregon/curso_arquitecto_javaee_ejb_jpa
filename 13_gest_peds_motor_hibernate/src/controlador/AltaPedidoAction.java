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
 * Servlet implementation class AltaAction
 */
@WebServlet("/AltaPedidoAction")
public class AltaPedidoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	DaoPedidos daoEjb;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String producto = request.getParameter("producto");
		String categoria = request.getParameter("categoria");
		double precio = Double.parseDouble(request.getParameter("precio"));
		Pedido pedido = new Pedido(0,categoria,precio,producto);
		daoEjb.altaPedido(pedido);
	}
}
