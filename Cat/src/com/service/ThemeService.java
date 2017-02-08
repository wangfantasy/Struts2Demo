package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.ThemeDao;
import com.domain.ThemeVote;

public class ThemeService {
    ThemeDao dao = new ThemeDao();
//    存入Themevote
	public void saveTheme(ThemeVote themeVote) throws SQLException {
           dao.saveTheme(themeVote);
	}
//	根据themetext查询ThemeVote
	public ThemeVote findByThemeText(String themetext) throws SQLException {
          return dao.findByThemeName(themetext);		
	}
//	查询所有Vote
	public List<ThemeVote> findAllThemeVote() throws SQLException {
		return dao.findAllThemeVote();
	}
//	根据Id查询 
	public ThemeVote findById(Integer tid) throws SQLException {
		return dao.findById(tid);
	}
//	删除ThemeVote
	public void deleteThemeVote(Integer tid) throws SQLException{
        dao.deleteThemeVote(tid);
	}
//	修改themeVote
	public void updateThemeVote(ThemeVote themeVote) throws SQLException{
		dao.updateThemeVote(themeVote);
	}
	

}
