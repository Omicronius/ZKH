package by.pvt.zkh.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.pvt.zkh.dao.UserDAO;
import by.pvt.zkh.dao.UserDAOImpl;
import by.pvt.zkh.filter.ClientType;
import by.pvt.zkh.logic.LoginLogic;
import by.pvt.zkh.resource.ConfigurationManager;
import by.pvt.zkh.resource.MessageManager;

public class LoginCommand implements ActionCommand {
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		UserDAO userDAOImpl = new UserDAOImpl();
		if ((login.length() != 0) && LoginLogic.checkAdminLogin(login, pass)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", login);
			session.setAttribute("userType", ClientType.ADMINISTRATOR);
			session.setAttribute("uid", userDAOImpl.getUserByLogin(login).getId());
			page = ConfigurationManager.getProperty("path.page.main");
			session.setAttribute("currenPage", page);
			
		} else if ((login.length() != 0) && LoginLogic.checkUserLogin(login, pass)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", login);
			session.setAttribute("userType", ClientType.USER);
			session.setAttribute("uid", userDAOImpl.getUserByLogin(login).getId());
			page = ConfigurationManager.getProperty("path.page.user");
			session.setAttribute("currenPage", page);
		} else {
			request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
			request.getSession().setAttribute("userType", ClientType.GUEST);
			page = ConfigurationManager.getProperty("path.page.login");
		}
		return page;
	}
}
