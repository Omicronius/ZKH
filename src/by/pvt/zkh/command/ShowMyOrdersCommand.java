package by.pvt.zkh.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import by.pvt.zkh.dao.OrderDAO;
import by.pvt.zkh.dao.OrderDAOImpl;
import by.pvt.zkh.resource.ConfigurationManager;

public class ShowMyOrdersCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.user");
		OrderDAO orderDAO = new OrderDAOImpl();
		HttpSession hs = request.getSession();
		request.setAttribute("orderList", orderDAO.getOrdersByUserId((Integer) hs.getAttribute("uid")));
		return page;
	}
}
