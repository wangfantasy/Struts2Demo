package com.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.domain.Record;
import com.utils.DataSourceUtils;

public class RecordDao {
	
	
	//查询记录 有则返回真 无则返回假
	public Boolean checkIsVoted(Integer tno, Integer uno) throws SQLException {
		Record record=null;
		String sql ="select * from record  where tno=? and uno=?";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		
		record=runner.query(sql,new BeanHandler<Record>(Record.class),tno,uno);
		if(record==null){
			System.out.println("RecordDao:"+false);
			return false;
		}else{
			System.out.println("RecordDao:"+true);
			return true;
			
		}
		
	}

	public Boolean addRecord(Integer tno,Integer uno) throws SQLException {
		// TODO Auto-generated method stub
		 String sql="insert into record values(null,?,?)";
		 QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		 Integer isDone=runner.update(sql,tno,uno);
		 if(isDone!=0){
			 return true;
		 }else{
			 return false;
		 }
	}

}
