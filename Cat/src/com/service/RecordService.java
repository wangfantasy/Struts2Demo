package com.service;

import java.sql.SQLException;

import com.dao.RecordDao;

public class RecordService {
	RecordDao dao=new RecordDao();
	//执行dao层查询记录方法 有则返回真 无则返回假
	public Boolean checkIsVoted(Integer tno,Integer uno) throws SQLException{
		return dao.checkIsVoted(tno,uno);
	}
	public Boolean addRecord(Integer tno,Integer uno) throws SQLException {
		return dao.addRecord(tno, uno);
		
	}
}
