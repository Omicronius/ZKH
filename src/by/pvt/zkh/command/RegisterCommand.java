package by.pvt.zkh.command;

import javax.servlet.http.HttpServletRequest;
import by.pvt.zkh.dao.UserDAO;
import by.pvt.zkh.dao.UserDAOImpl;
import by.pvt.zkh.entity.User;
import by.pvt.zkh.resource.ConfigurationManager;

public class RegisterCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		UserDAO dao = new UserDAOImpl();
		if (login.length() == 0 || password.length() == 0 || email.length() == 0 || phone.length() == 0
				|| dao.getUserByLogin(login) != null) {
			page = ConfigurationManager.getProperty("path.reg.err");
			return page;
		} else {
			User user = new User.Builder().login(login).password(password).role(1).email(email).phone(phone).build();
			boolean successedRegistraion = dao.registerNewUser(user);
			if (successedRegistraion) {
				page = ConfigurationManager.getProperty("path.page.index");
			} else {
				page = ConfigurationManager.getProperty("path.reg.err");
			}
			return page;
		}
	}
}
