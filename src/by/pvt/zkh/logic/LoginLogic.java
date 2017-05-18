package by.pvt.zkh.logic;

import by.pvt.zkh.dao.UserDAO;
import by.pvt.zkh.dao.UserDAOImpl;
import by.pvt.zkh.entity.User;

public class LoginLogic {

	public static boolean checkAdminLogin(String enterLogin, String enterPass) {
		UserDAO userDao = new UserDAOImpl();
		User user = userDao.getUserByLogin(enterLogin);
		if (user == null) return false;
		return user.getLogin().equals(enterLogin) && user.getPassword().equals(enterPass) && user.getRole() == 2;
	}

	public static boolean checkUserLogin(String enterLogin, String enterPass) {
		UserDAO userDao = new UserDAOImpl();
		User user = userDao.getUserByLogin(enterLogin);
		if (user == null) return false;
		return user.getLogin().equals(enterLogin) && user.getPassword().equals(enterPass);
	}
}