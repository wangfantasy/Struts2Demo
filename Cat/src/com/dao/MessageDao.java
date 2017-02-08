package com.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.domain.Message;
import com.utils.DataSourceUtils;

public class MessageDao {

//	存留言
	public void saveMessage(Message message) throws SQLException {
      	String sql = "insert into message values(null,?,?,?)";
      	QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
      	runner.update(sql,message.getMessagetext(),message.getTno(),message.getUno());
	}
//删除留言
	public void deleteMessage(Integer mid) throws SQLException {
		String sql = "delete from message where mid=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql,mid);
	}
//	查询所有的Message
	public List<Message> findAllMessage() throws SQLException {
		String sql = "select * from message";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<Message>(Message.class));
	}
//	根据外键tno查询tno下所有的留言Message
	public List<Message> findByTno(Integer tno) throws SQLException {
		String sql = "select * from message where tno=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<Message>(Message.class),tno);
	}
	public void addMessage(String mes, Integer tno, Integer uno) throws SQLException {
		String sql = "insert into message values(null,?,?,?)";
      	QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
      	runner.update(sql,mes,tno,uno);
		
	}

}
