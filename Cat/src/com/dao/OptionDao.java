package com.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.domain.OptionVote;
import com.utils.DataSourceUtils;

public class OptionDao {

//	存入option——vote，num的值以0存入
	public void saveOption(OptionVote optionVote) throws SQLException {
		String sql = "insert into option_vote values(null,?,0,?)";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql,optionVote.getOptiontext(),optionVote.getTno());
	}
//根据外键tno查询所有OptionVote下所有属于标题id为tno的optionvote选项
	public List<OptionVote> findByTno(Integer tno) throws SQLException {
        String sql="select * from option_vote where tno=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<OptionVote>(OptionVote.class),tno);
	}
//	根据id删除OptionVote
	public void deleteOptionVoteById(Integer oid) throws SQLException {
		String sql = "delete from option_vote where oid=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql,oid);
	}
//	根据OptionTest查询OptionVote
	public OptionVote findByOptionTest(String optiontext) throws SQLException {
        String sql = "select * from option_vote where optiontext=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanHandler<OptionVote>(OptionVote.class),optiontext);
	}
	public OptionVote findByOid(Integer oid) throws SQLException {
		String sql = "select * from option_vote where oid=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanHandler<OptionVote>(OptionVote.class),oid);
	}
//根据oid将OptionVote票数增加	
	public Integer increaseNumByOid(Integer oid) throws SQLException{
		String sql="update option_vote set option_vote.num=option_vote.num+1 where oid=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.update(sql,oid);
		
	}

}
