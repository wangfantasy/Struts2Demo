package com.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.domain.User;
import com.utils.DataSourceUtils;

public class UserDao {

//	存入用户信息
	public void saveUser(User user) throws SQLException {
		 String sql="insert into user values(null,?,?,?,?,0)";
		 QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		 runner.update(sql,user.getUsername(),user.getPassword(),user.getSex(),user.getEmail());
		 
	}
//修改用户信息
	public void updateUser(User user) throws SQLException {
          String sql = "updata user set username=?,sex=?,email=? where uid=?";
          QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
          runner.update(sql,user.getUsername(),user.getSex(),user.getEmail());
	}
//	通过username查询user
	public User findByUsername(String username) throws SQLException {
        String sql = "select * from user where username=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanHandler<User>(User.class),username);
	}
//	查询所有用户信息
	public List<User> findAllUser() throws SQLException{
		String sql = "select * from User";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<User>(User.class));
	}
//	根据ID查询用户信息
	public User findById(int uid) throws SQLException {
        String sql = "select * from User where uid=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanHandler<User>(User.class),uid);
	}
	

}
