package servlets;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.DaoLibros;
import mensajeria.ProcesaCompra;
import model.Cliente;
import model.Libro;
import model.Venta;

/**
 * Servlet implementation class ComprasAction
 */
@WebServlet("/ComprasAction")
public class ComprasAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ProcesaCompra compraEjb;
	@EJB
	DaoLibros libroEjb;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		int idLibro = Integer.parseInt(request.getParameter("idLibro"));
		Cliente clienteLogado = (Cliente)sesion.getAttribute("clienteLogado");
		Libro libro = libroEjb.obtenerLibro(idLibro);				
		Venta venta = new Venta(0,new Date(),clienteLogado,libro);
		compraEjb.procesarCompra(venta);	
	}
}
