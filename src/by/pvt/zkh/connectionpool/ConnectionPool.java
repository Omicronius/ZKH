package by.pvt.zkh.connectionpool;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.pvt.zkh.dao.OrderDAOImpl;

public class ConnectionPool {
	private static final Logger logger = LogManager.getLogger(OrderDAOImpl.class);
	
	public Connection getConnect() {
		Connection connection = null;
		try {
			InitialContext initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jndi/zkhdb");
			connection = ds.getConnection();
		} catch (SQLException e) {
			logger.error("SQL exception occurred during UserDAO.getConnect()");
			e.printStackTrace();
		} catch (NamingException e) {
			logger.error("SQL exception occurred during UserDAO.getConnect()");
			e.printStackTrace();
		}

		return connection;
	}
}
