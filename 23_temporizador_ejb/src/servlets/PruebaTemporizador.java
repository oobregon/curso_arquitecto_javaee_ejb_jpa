package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.TemporizadorEjbLocal;

/**
 * Servlet implementation class PruebaTemporizador
 */
@WebServlet("/PruebaTemporizador")
public class PruebaTemporizador extends HttpServlet {
	@EJB
	TemporizadorEjbLocal tp;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		tp.iniciarTemporizador(2000);
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tp.detenerTemporizador();
	}

}
