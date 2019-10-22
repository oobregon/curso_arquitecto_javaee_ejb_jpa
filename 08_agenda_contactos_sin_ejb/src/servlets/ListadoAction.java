package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Contacto;
import modelo.DaoContactos;

/**
 * Servlet implementation class ListadoAction
 */
@WebServlet("/ListadoAction")
public class ListadoAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoContactos dao=new DaoContactos();
		List<Contacto> contactos=dao.recuperarContactos();
		request.setAttribute("contactos", contactos);
	}

}
