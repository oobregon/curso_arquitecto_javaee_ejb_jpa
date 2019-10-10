package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.DaoClientes;
import daos.DaoVentas;
import model.Cliente;
import model.Venta;

/**
 * Servlet implementation class VentasAction
 */
@WebServlet("/VentasAction")
public class VentasAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	DaoVentas daoEjb;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		Cliente clienteLogado = (Cliente)sesion.getAttribute("clienteLogado");		
		int idCliente = clienteLogado.getIdCliente();		
		List<Venta> ventas = daoEjb.obtenerVentasCliente(idCliente);
		request.setAttribute("ventas",ventas);		
		/*
		if(ventas.size() > 0) {
			request.setAttribute("resultado","ok");			
			request.setAttribute("ventas",ventas);
			
		} else {
			request.setAttribute("resultado","ko");
		}*/
	}
}
