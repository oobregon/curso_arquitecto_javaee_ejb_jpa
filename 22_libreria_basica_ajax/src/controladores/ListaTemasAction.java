package controladores;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoTemas;

/**
 * Servlet implementation class ListaTemasAction
 */
@WebServlet("/ListaTemasAction")
public class ListaTemasAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	DaoTemas temasEjb;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("temas",temasEjb.obtenerTemas());
	}

}
