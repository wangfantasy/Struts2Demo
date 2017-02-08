package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.UserDao;
import com.domain.User;

public class UserService {

	private UserDao dao = new UserDao();
//	存入用户信息
	public void saveUser(User user) throws SQLException {
         dao.saveUser(user);
	}
//	修改用户信息
	public void updateUser(User user) throws SQLException {
         dao.updateUser(user);
	}
//  通过用户名查询User
	public User findByUsername(String username) throws SQLException{
		return dao.findByUsername(username);
	}
//	查询所有用户信息
	public List<User> findAllUser() throws SQLException{
		return dao.findAllUser();
	}
	public User findUserId(int uid) throws SQLException {
		return dao.findById(uid);
	}

}
