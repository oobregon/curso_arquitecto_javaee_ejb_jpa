package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoContactos;
import model.Contacto;

/**
 * Servlet implementation class EliminarAction
 */
@WebServlet("/EliminarAction")
public class EliminarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@EJB
	DaoContactos daoEjb;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		int idContacto = Integer.parseInt(request.getParameter("idContacto"));		 				
		daoEjb.eliminarContacto(idContacto);		
	}
}
