package com.dao;

import java.sql.SQLException;
import java.util.List;

import javax.management.Query;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.domain.ThemeVote;
import com.utils.DataSourceUtils;

public class ThemeDao {
//存入themeVote
	public void saveTheme(ThemeVote themeVote) throws SQLException {
            String sql = "insert into theme_vote values(null,?,0)";
            QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
            runner.update(sql,themeVote.getThemetext());
	}
//根据Themetext查询
	public ThemeVote findByThemeName(String themetext) throws SQLException {
        String sql = " select * from theme_vote where themetext= ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanHandler<ThemeVote>(ThemeVote.class),themetext);
        
	}
//	查询所有ThemeVote 
	public List<ThemeVote> findAllThemeVote() throws SQLException {
		String sql = "select * from theme_vote";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql,new BeanListHandler<ThemeVote>(ThemeVote.class));
	}
//	根据ID查询ThemeVote
	public ThemeVote findById(Integer tid) throws SQLException {
        String sql = "select * from theme_vote where tid=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanHandler<ThemeVote>(ThemeVote.class),tid);
	}
//	根据id删除ThemeVote
	public void deleteThemeVote(Integer tid) throws SQLException {
		String sql = "delete from theme_vote where tid=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql,tid);
	}
//	修改ThemeVote
	public void updateThemeVote(ThemeVote themeVote) throws SQLException{
		String sql ="update theme_vote set themetext=? where tid=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql,themeVote.getThemetext(),themeVote.getTid());
	}
	

}
