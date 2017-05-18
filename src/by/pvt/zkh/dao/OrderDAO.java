package by.pvt.zkh.dao;

import java.util.List;

import by.pvt.zkh.entity.Order;

public interface OrderDAO {
	Order getOrderById (int id);
	List <Order> getOrdersByUserId(int userId);
	void createOrder(Order order);
	void deleteOrderById(int orderId);
	List <Order> getAllOrders();
}
