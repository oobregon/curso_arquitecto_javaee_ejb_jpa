package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoClientes;
import daos.DaoTemas;
import daos.DaoTemasImpl;
import model.Cliente;



@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	
	@EJB
	DaoClientes daoEjb;
	@EJB
	DaoTemas daoTemas;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		boolean resultado=false;
		String usuario = request.getParameter("user");
		String contra = request.getParameter("pwd");
		if(daoEjb.autenticar(usuario,contra)){			
			request.setAttribute("temas", daoTemas.obtenerTemas());
			Cliente clienteLogado = daoEjb.obtenerCliente(usuario,contra);			
			request.getSession().setAttribute("clienteLogado",clienteLogado);
            resultado=true;            
		}
		else{
			request.setAttribute("mensaje", "Usuario no registrado");			
		}       
        request.setAttribute("resultado",resultado);
	}	
}
