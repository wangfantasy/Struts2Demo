package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.MessageDao;
import com.domain.Message;

public class MessageService {
    MessageDao dao = new MessageDao();
//	留言的存入
	public void saveMessage(Message message) throws SQLException{
		dao.saveMessage(message);
	}
//	删除留言
	public void deleteMessage(Integer mid) throws SQLException{
		dao.deleteMessage(mid);
	}
//	查询某个Theme下的所有留言
	public List<Message> findAllMessage() throws SQLException{
		return dao.findAllMessage();
	}
	public List<Message> findByTno(Integer tno) throws SQLException {
		return dao.findByTno(tno);
	}
	
	public void addMessage(String mes,Integer tno,Integer uno) throws SQLException{
		dao.addMessage(mes,tno,uno);
	}
}
