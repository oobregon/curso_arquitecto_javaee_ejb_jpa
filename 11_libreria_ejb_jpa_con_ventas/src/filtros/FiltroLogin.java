package filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroLogin
 */
@WebFilter("/FiltroLogin")
public class FiltroLogin implements Filter {

    public FiltroLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String rutaSolicitada = ((HttpServletRequest)request).getServletPath();
		if (rutaSolicitada.equals("/") || rutaSolicitada.equals("/RegistroAction")  
				|| rutaSolicitada.equals("/LoginAction")) {
			chain.doFilter(request, response);
		}			
		
		HttpSession sesion = ((HttpServletRequest)request).getSession();
		if (sesion.getAttribute("clienteLogado") != null) {
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
