package com.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.domain.Message;
import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.MessageService;
import com.service.UserService;

public class MessageAction extends ActionSupport {
	private MessageService messageService=new MessageService();
	private UserService userService=new UserService();
	/*private Map<Integer,List<String>> messages=new HashMap<Integer, List<String>>();

	public Map<Integer, List<String>> getMessages() {
		return messages;
	}
*/
	private List<List<String>> messages=new ArrayList<List<String>>();
	
	public List<List<String>> getMessages() {
		return messages;
	}

	public String showMessage() throws SQLException{
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String tnoo=request.getParameter("tno");
		Integer tno=Integer.parseInt(tnoo);
		List<Message> mm=messageService.findByTno(tno);
		for(Message m : mm){
			//取得uno查询用户名
			int u_no=m.getUno();
			User u=userService.findUserId(u_no);
			//生成集合 好存入messages
			List<String> user_mtext=new ArrayList<String>();
			
			//将信息存入messages
			user_mtext.add(m.getMessagetext());
			user_mtext.add(u.getUsername());
			
			messages.add(user_mtext);
			
		}
		
		
		
		return "SUCCESS";
		
	}

	public String addMessage() throws SQLException{
		HttpServletRequest request=ServletActionContext.getRequest();
		Map session=ActionContext.getContext().getSession();
		Integer uno=(Integer) session.get("USER_ID");
		String mes=request.getParameter("usermessage");
		String ttt=request.getParameter("tno");
		Integer tno=Integer.parseInt(ttt);
		
		System.out.println("Add:"+mes+"--"+tno+"--"+uno);
		//添加留言
		messageService.addMessage(mes, tno, uno);
		//查询留言
		List<Message> mm=messageService.findByTno(tno);
		for(Message m : mm){
			//取得uno查询用户名
			int u_no=m.getUno();
			User u=userService.findUserId(u_no);
			//生成集合 好存入messages
			List<String> user_mtext=new ArrayList<String>();
			
			//将信息存入messages
			user_mtext.add(m.getMessagetext());
			user_mtext.add(u.getUsername());
			
			messages.add(user_mtext);
			
		}
		return "SUCCESS";
		
	}
	
	
	
}
