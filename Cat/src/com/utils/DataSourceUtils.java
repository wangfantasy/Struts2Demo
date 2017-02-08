package com.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DataSourceUtils {
	private static DataSource dataSource=new ComboPooledDataSource();

	public static DataSource getDataSource() {
		return dataSource;
	}

	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
		
	}
	



}
