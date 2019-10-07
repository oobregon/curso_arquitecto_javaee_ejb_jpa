package controlador;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoPedidos;
import model.Pedido;

/**
 * Servlet implementation class PedidosAction
 */
@WebServlet("/PedidosAction")
public class PedidosAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	DaoPedidos daoEjb;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Pedido> pedidos = daoEjb.damePedidos();
		if(pedidos.size() > 0) {
			request.setAttribute("resultado","ok");			
			request.setAttribute("pedidos",pedidos);			
		} else {
			request.setAttribute("resultado","ko");
		}
	}
}
