package com.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;


import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private User user=new User();
	
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	private Map<String, Object> session=null;
	

	public Map<String, Object> getSession() {
		return session;
	}




	public String checkUser() throws Exception {
		
		UserService us=new UserService();
		session=ActionContext.getContext().getSession();
		User getuser=null;
	
		//执行service层的检查方法
		getuser=us.findByUsername(user.getUsername());
		
		//如果查询结果不为空  将UID PERMIT USERNAME传入session
		if(getuser!=null){
			
			
			session.put("USER_ID", getuser.getUid());
			session.put("USER_NAME", getuser.getUsername());
			session.put("PERMIT", getuser.getPermit());
			
			 return "SUCCESS";
		}else{
			 return "DEFEAT";
		}	
	
	}
	
	public String register(){
		return null;
		
	}
	

	
}
