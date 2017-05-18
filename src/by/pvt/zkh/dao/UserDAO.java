package by.pvt.zkh.dao;

import java.util.List;
import by.pvt.zkh.entity.User;

public interface UserDAO {
	User getUserByLogin(String login);
	List <User> getUserList();
	Boolean registerNewUser(User user);
}
