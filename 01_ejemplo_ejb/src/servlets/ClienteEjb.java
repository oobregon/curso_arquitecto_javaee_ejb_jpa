package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.SaludoEjbLocal;

/**
 * Servlet implementation class ClienteEjb
 */
@WebServlet("/ClienteEjb")
public class ClienteEjb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@EJB
	SaludoEjbLocal miEjb;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String resultado = miEjb.obtenerSaludo("Oscar");
		PrintWriter salida = response.getWriter();
		salida.println(resultado);
	}
}
