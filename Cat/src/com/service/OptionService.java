package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.OptionDao;
import com.domain.OptionVote;

public class OptionService {
    OptionDao dao = new OptionDao();
//    存入optionVote
	public void saveOption(OptionVote optionVote) throws SQLException {
         dao.saveOption(optionVote);   		
	}
//	根据外键tno查询该themeVote下的所有optionVote
	public List<OptionVote> findByTno(Integer tno) throws SQLException{
		return dao.findByTno(tno);
	}
//  根据oid删除OptionVote
	public void deleteOptionVoteById(Integer oid) throws SQLException{
		dao.deleteOptionVoteById(oid);
	}
//	根据optiontext查询OptionVote
	public OptionVote findByOptionText(String optiontext) throws SQLException{
		return dao.findByOptionTest(optiontext);
	}
//	根据id查询OptionVote
	public OptionVote findByOid(Integer oid) throws SQLException{
		return dao.findByOid(oid);
	}
	
	public Integer increaseNumByOid(Integer oid) throws SQLException{
		return dao.increaseNumByOid(oid);
	}
}
