package servicios;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Future;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.Calculo;

/**
 * Servlet implementation class ProbandoEjbAsinc
 */
@WebServlet("/ProbandoEjbAsinc")
public class ProbandoEjbAsinc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	Calculo calcEjb;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter salida = response.getWriter();
		try {
			Future<Integer> respFutura = calcEjb.sumaNumeros(50);
			salida.println("<html><body>");
			// Mientras la respuesta no esté preparada, pues esperamos
			while( !respFutura.isDone() ) { 
				System.out.println("Esperando respuesta");
			}
			int respuesta = respFutura.get();
			salida.println("<h1>La respuesta futura es " + respuesta + "</h1>");
			salida.println("</body></html>");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
