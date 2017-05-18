package by.pvt.zkh.command;

import javax.servlet.http.HttpServletRequest;
import by.pvt.zkh.dao.UserDAO;
import by.pvt.zkh.dao.UserDAOImpl;
import by.pvt.zkh.resource.ConfigurationManager;

public class ShowUsersCommand implements ActionCommand{

	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager. getProperty("path.page.main");
		UserDAO userDAO = new UserDAOImpl();
		request.setAttribute("userList", userDAO.getUserList());
		return page;
	}

}
