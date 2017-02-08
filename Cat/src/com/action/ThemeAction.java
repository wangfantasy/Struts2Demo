package com.action;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.domain.ThemeVote;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.service.ThemeService;

public class ThemeAction {
	private ThemeService ts=new ThemeService();
	
	private List<ThemeVote> theme;
	private Map<Integer,String> themes=new HashMap<Integer, String>();;
	public String showTheme(){
		//调用themeservice层查询所有标题
		try {
			//找到所有id
			theme=ts.findAllThemeVote();
			
			for(ThemeVote tv:theme){
				themes.put(tv.getTid(), tv.getThemetext());
			}
			
			
			//压入值栈
			ActionContext.getContext().put("themes", themes);
			return "SUCCESS";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "DEFEAT";
		}
		
		
	}  
	
	
	
}
