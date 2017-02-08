package com.test;


	import java.sql.SQLException;

	import org.apache.commons.dbutils.QueryRunner;
	import org.apache.commons.dbutils.ResultSetHandler;
	import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import com.domain.Record;
	import com.domain.User;
import com.utils.DataSourceUtils;

public class test1 {
		@Test
		public void testq() throws SQLException{
			Record record=null;
			Integer tid=1;
			Integer uid=98;
			
			String sql ="select * from record  where tid=? and uid=?";
			QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
			System.out.println(record);
			record=runner.query(sql,new BeanHandler<Record>(Record.class),tid,uid);
			System.out.println(record);
			
		}

		
		
}

