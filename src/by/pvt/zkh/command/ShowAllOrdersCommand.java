package by.pvt.zkh.command;

import javax.servlet.http.HttpServletRequest;
import by.pvt.zkh.dao.OrderDAO;
import by.pvt.zkh.dao.OrderDAOImpl;
import by.pvt.zkh.resource.ConfigurationManager;

public class ShowAllOrdersCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager. getProperty("path.page.main");
		OrderDAO dao = new OrderDAOImpl();
		request.setAttribute("ordersList", dao.getAllOrders());
		return page;
	}
}
