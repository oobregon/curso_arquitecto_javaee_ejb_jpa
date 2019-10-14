package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import daos.DaoLibros;
import model.Libro;

/**
 * Servlet implementation class ListaLibrosAjaxAction
 */
@WebServlet("/ListaLibrosAjaxAction")
public class ListaLibrosAjaxAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	DaoLibros librosEjb;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idTema = Integer.parseInt(request.getParameter("idTema"));
		List<Libro> libros = idTema==0?librosEjb.obtenerLibros():librosEjb.obtenerLibros(idTema);
		// INcluir try con recursos.
		PrintWriter salida = response.getWriter();
		response.setContentType("text/plain");
		salida.println(convertirAJson(libros));		
	}
	
	private String convertirAJson(List<Libro> libros) {
		JSONArray array=new JSONArray();
		for(Libro lib:libros) {
			JSONObject obj=new JSONObject();
			obj.put("titulo", lib.getTitulo());
			obj.put("autor", lib.getAutor());
			obj.put("precio", lib.getPrecio());
			obj.put("paginas", lib.getPaginas());
			array.add(obj);
		}
		// La recomendaci�n es que se env�e una cadena en lugar de un objeto o un array
		// Si devolvi�ramos un objeto json tendr�amos que cambiar la sentencia response.setContentType("text/plain") y a�adir
		// otro MIME que ser�a response.setContentType("text/objetJSON");
		return array.toJSONString();
	}
}
