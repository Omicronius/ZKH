package by.pvt.zkh.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.pvt.zkh.dao.OrderDAO;
import by.pvt.zkh.dao.OrderDAOImpl;
import by.pvt.zkh.resource.ConfigurationManager;

public class DeleteOrderCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.user");
		int orderId = Integer.parseInt(request.getParameter("oid"));
		OrderDAO dao = new OrderDAOImpl();
		dao.deleteOrderById(orderId);
		HttpSession hs = request.getSession();
		request.setAttribute("orderList", dao.getOrdersByUserId((Integer) hs.getAttribute("uid")));
		return page;
	}

}
