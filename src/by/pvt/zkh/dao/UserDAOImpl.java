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
import by.pvt.zkh.entity.User;

public class UserDAOImpl implements UserDAO {
	private static final Logger logger = LogManager.getLogger(OrderDAOImpl.class);
	public static final String SQL_QUERY_GET_USER = "SELECT * FROM users WHERE login=?";
	public static final String SQL_QUERY_GET_ALL_USER = "SELECT * FROM users;";
	public static final String SQL_QUERY_ADD_NEW_USER = "INSERT INTO users (`login`, `password`, `role`, `email`, `phone`) VALUES (?,?,?,?,?);";
	private static final int USER_ROLE = 1;

	public User getUserByLogin(String login) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = new ConnectionPool().getConnect();
			preparedStatement = connection.prepareStatement(SQL_QUERY_GET_USER);
			preparedStatement.setString(1, login);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return new User.Builder().id(resultSet.getInt("id")).login(resultSet.getString("login"))
						.password(resultSet.getString("password")).role(resultSet.getInt("role"))
						.email(resultSet.getString("email")).phone(resultSet.getString("phone")).build();
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
		return null;
	}

	@Override
	public List<User> getUserList() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<User> resultList = new ArrayList<User>();
		User user = null;

		try {
			connection = new ConnectionPool().getConnect();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SQL_QUERY_GET_ALL_USER);
			while (resultSet.next()) {
				user = new User();
				user.setId(Integer.parseInt(resultSet.getString("id")));
				user.setLogin(resultSet.getString("login"));
				user.setRole(Integer.parseInt(resultSet.getString("role")));
				user.setEmail(resultSet.getString("email"));
				user.setPhone(resultSet.getString("phone"));
				resultList.add(user);
			}
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
		return resultList;
	}

	@Override
	public Boolean registerNewUser(User user) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = new ConnectionPool().getConnect();
			ps = connection.prepareStatement(SQL_QUERY_ADD_NEW_USER);
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			ps.setInt(3, USER_ROLE);
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhone());
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
		return true;
	}
}
