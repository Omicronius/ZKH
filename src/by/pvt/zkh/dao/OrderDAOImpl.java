package by.pvt.zkh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import by.pvt.zkh.connectionpool.ConnectionPool;
import by.pvt.zkh.entity.Order;

public class OrderDAOImpl implements OrderDAO {
	private static final Logger logger = LogManager.getLogger(OrderDAOImpl.class);
	public static final String SQL_QUERY_GET_ORDER = "SELECT * FROM orders WHERE id=?";
	public static final String SQL_QUERY_GET_ORDERS_BY_ID = "SELECT * FROM orders WHERE user_id=?";
	private static final String SQL_QUERY_CREATE_ORDER = "INSERT INTO orders (`work_type`, `details`, `user_id`) values(?,?,?);";
	private static final String SQL_QUERY_DELETE_ORDER_BY_ID = "DELETE FROM orders WHERE id=?;";
	public static final String SQL_QUERY_GET_ALL_ORDERS = "SELECT * FROM orders";

	@Override
	public Order getOrderById(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = new ConnectionPool().getConnect();
			preparedStatement = connection.prepareStatement(SQL_QUERY_GET_ORDER);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return new Order(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
						resultSet.getString(4));
			}
		} catch (SQLException e) {
			logger.error("SQL exception occurred during searching the order");
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				logger.error("SQL exception occurred during searching the order");
			}
		}
		return null;
	}

	@Override
	public List<Order> getOrdersByUserId(int userId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Order> orderList = new ArrayList<>();

		try {
			connection = new ConnectionPool().getConnect();
			preparedStatement = connection.prepareStatement(SQL_QUERY_GET_ORDERS_BY_ID);
			preparedStatement.setInt(1, userId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Order order = new Order();
				order.setId(resultSet.getInt("id"));
				order.setDetails(resultSet.getString("details"));
				order.setWorkType(resultSet.getString("work_type"));
				orderList.add(order);
			}
		} catch (SQLException e) {
			logger.error("SQL exception occurred during add client");
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				logger.error("SQL exception occurred during add client");
			}
		}
		return orderList;
	}

	@Override
	public void createOrder(Order order) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = new ConnectionPool().getConnect();
			ps = connection.prepareStatement(SQL_QUERY_CREATE_ORDER);
			ps.setString(1, order.getWorkType());
			ps.setString(2, order.getDetails());
			ps.setInt(3, order.getUid());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQL exception occurred during add client");
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				logger.error("SQL exception occurred during add client");
			}
		}
	}

	@Override
	public void deleteOrderById(int orderId) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = new ConnectionPool().getConnect();
			ps = connection.prepareStatement(SQL_QUERY_DELETE_ORDER_BY_ID);
			ps.setInt(1, orderId);
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQL exception occurred during add client");
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				logger.error("SQL exception occurred during add client");
			}
		}
	}

	@Override
	public List <Order> getAllOrders() {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList <Order> list = new ArrayList <>();
		try {
			connection = new ConnectionPool().getConnect();
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL_QUERY_GET_ALL_ORDERS);
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt(1));
				order.setWorkType(rs.getString(2));
				order.setDetails(rs.getString(3));
				order.setUid(rs.getInt(4));
				list.add(order);
			}
			return list;
		} catch (SQLException e) {
			logger.error("SQL exception occurred during add client");
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				logger.error("SQL exception occurred during add client");
			}
		}
		return null;
		
	}
}
