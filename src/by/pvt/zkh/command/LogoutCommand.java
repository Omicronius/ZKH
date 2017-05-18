package by.pvt.zkh.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import by.pvt.zkh.filter.ClientType;
import by.pvt.zkh.resource.ConfigurationManager;


public class LogoutCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.index");
		String locale = (String) request.getSession().getAttribute("locale");
		request.getSession().invalidate();
		HttpSession hs = request.getSession();
		hs.setAttribute("locale", locale);
		hs.setAttribute("userType", ClientType.GUEST);
		return page;
	}
}