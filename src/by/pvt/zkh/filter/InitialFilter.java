package by.pvt.zkh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.pvt.zkh.resource.ConfigurationManager;

@WebFilter(urlPatterns = { "/index.jsp" })
public class InitialFilter implements Filter {
	
	/**
	 * @author Kos KLimov
	 *
	 *	This filter sets guest status for a new visitor and russian locale as a default.
	 */
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		ClientType type = (ClientType) session.getAttribute("userType");
		if (type == null) {
			session.setAttribute("userType", ClientType.GUEST);
			session.setAttribute("locale", "locale_ru_RU");
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(ConfigurationManager.getProperty("path.page.index"));
			dispatcher.forward(req, resp);
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
