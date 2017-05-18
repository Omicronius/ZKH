package by.pvt.zkh.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import by.pvt.zkh.dao.OrderDAO;
import by.pvt.zkh.dao.OrderDAOImpl;
import by.pvt.zkh.entity.Order;
import by.pvt.zkh.resource.ConfigurationManager;

public class CreateOrderCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.user");
		HttpSession hs = request.getSession();
		OrderDAO orderDAO = new OrderDAOImpl();
		String workType = request.getParameter("worktype");
		String description = request.getParameter("description");
		int uid = Integer.parseInt(hs.getAttribute("uid").toString());
		Order order = new Order();
		order.setUid(uid);
		order.setWorkType(workType);
		order.setDetails(description);
		orderDAO.createOrder(order);
		return page;
	}
}
