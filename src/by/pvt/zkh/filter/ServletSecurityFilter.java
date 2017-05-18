package by.pvt.zkh.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "/jsp/main.jsp", "/jsp/user.jsp" })
public class ServletSecurityFilter implements Filter {
	
	/**
	 * @author Kos KLimov
	 *
	 *	This filter impedes access to admin and user area.
	 */
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		((HttpServletResponse) response).sendRedirect("https://fuckoff.com/");  
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
