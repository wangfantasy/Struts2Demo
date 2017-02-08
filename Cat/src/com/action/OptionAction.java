package com.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.domain.OptionVote;
import com.domain.ThemeVote;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.OptionService;
import com.service.RecordService;
import com.service.ThemeService;

public class OptionAction extends ActionSupport implements ModelDriven<OptionVote>{
    private OptionVote optionVote = new OptionVote();
    
    private String themetext;
	private String optiontext1;
    private String optiontext2;
    private String optiontext3;
    private String optiontext4;
	public String getThemetext() {
  		return themetext;
  	}
  	public void setThemetext(String themetext) {
  		this.themetext = themetext;
  	}

	public String getOptiontext1() {
		return optiontext1;
	}
	public void setOptiontext1(String optiontext1) {
		this.optiontext1 = optiontext1;
	}
	
	public String getOptiontext2() {
		return optiontext2;
	}
	public void setOptiontext2(String optiontext2) {
		this.optiontext2 = optiontext2;
	}
	public String getOptiontext3() {
		return optiontext3;
	}
	public void setOptiontext3(String optiontext3) {
		this.optiontext3 = optiontext3;
	}
	public String getOptiontext4() {
		return optiontext4;
	}
	public void setOptiontext4(String optiontext4) {
		this.optiontext4 = optiontext4;
	}
	public OptionVote getModel() {
		return optionVote;
	}
	
	
	OptionService optionService = new OptionService();
	ThemeService themeService=new ThemeService();
	RecordService recordService=new RecordService();
//	添加option_vote
	public String saveOptions() throws SQLException{
		ThemeService themeService = new ThemeService();
		ThemeVote theme = new ThemeVote();
		theme.setThemetext(themetext);
		themeService.saveTheme(theme);
		theme = themeService.findByThemeText(theme.getThemetext());
		optionVote.setTno(theme.getTid());
		for(int i=1;i<=4;i++){
	    optionVote.setOptiontext("optiontext"+"1");
	    optionService.saveOption(optionVote);
	    
		}
		return "success";
	}
//	根据uno查询所有ThemeVote下的OptionVote
	public String findByUno() throws SQLException{
		Integer tno = 0;
		List<OptionVote> optionVotes = optionService.findByTno(tno);
		return "good";
	}
//	根据oid删除optionVote
	public String deleteOptionVoteById() throws SQLException{
		Integer oid = 0;
		optionService.deleteOptionVoteById(oid);
		return "good";
	}
//展示用户选择的标题的所有的选项（并且通过RecordService检查是否重复投票）
    public String showOptions(){
    	
    	//获取参数tid和uid
    	HttpServletRequest request=ServletActionContext.getRequest();
    	
    	String tid=request.getParameter("tid");
    	Map session=ActionContext.getContext().getSession();
    	Integer uno=(Integer) session.get("USER_ID");
    	Boolean yes=(Boolean) session.get("IsVoted");
    	System.out.println("来来来！"+yes);
    	System.out.println("来来来！搞事情！"+uno);
    	Integer tno=Integer.parseInt(tid);
    	
    	//System.out.println(tno);
    	//调用service层方法
    	try {
    		Boolean getIsVoted=recordService.checkIsVoted(tno, uno);
    		System.out.println("showOption:"+getIsVoted);
    		if(recordService.checkIsVoted(tno, uno)!=true){
	    		 List<OptionVote> option=optionService.findByTno(tno);
	    		 ThemeVote opstheme=themeService.findById(tno);
	    		 
	    		 Map<Integer,String> options=new HashMap<Integer, String>();
	    		 Map<Integer,String> themes=new HashMap<Integer, String>();
	    		 
	    		 themes.put(opstheme.getTid(), opstheme.getThemetext());
			   
	    		 for(OptionVote ov:option){
					options.put(ov.getOid(), ov.getOptiontext());
	    		 }
				 
	    		 ActionContext.getContext().put("options",options);
	    		 ActionContext.getContext().put("themes",themes);
	    		 session.put("IsVoted", false);
	    		 System.out.println("showOptions_IF");
	    		 return "SUCCESS";
    		}else{
    			
    			ThemeVote opstheme=themeService.findById(tno);
    			 Map<Integer,String> themes=new HashMap<Integer, String>();
    			 themes.put(opstheme.getTid(), opstheme.getThemetext());
    			 ActionContext.getContext().put("themes",themes);
    			 session.put("IsVoted", true);
    			 System.out.println("showOptions_ELSE");
    			return "SUCCESS";
    		}
	    		 
    		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return "DEFEAT";
		}
    	
    }
    
    public String doVote() throws SQLException{
    	HttpServletRequest request=ServletActionContext.getRequest();
    	Map session=ActionContext.getContext().getSession();
    			Integer uno=(Integer) session.get("USER_ID");
    			Boolean IsVoted=(Boolean) session.get("IsVoted");
    			System.out.println("doVote:"+IsVoted);
    	String selectedOid=request.getParameter("selectedOid");
    	String selectedTid=request.getParameter("selectedTid");
    	
    	
    	Integer oid=Integer.parseInt(selectedOid);
    	Integer tno=Integer.parseInt(selectedTid);
    	//System.out.println("TID="+tid+"OID="+oid);
    	//调用service层方法
		Integer result=	optionService.increaseNumByOid(oid);
			recordService.addRecord(tno, uno);
			if(result==1){
				List<OptionVote> allresult=optionService.findByTno(tno);
				Map<Integer,List<String>> resdata=new HashMap<Integer, List<String>>();
				for(OptionVote ov:allresult){
					List<String> a=new ArrayList<String>();
					a.add(ov.getOptiontext());
					a.add(ov.getNum().toString());
					
					resdata.put(ov.getOid(), a);
					}
				ActionContext.getContext().put("resdata",resdata);
			}else{
					List<OptionVote> allresult=optionService.findByTno(tno);
					Map<Integer,List<String>> resdata=new HashMap<Integer, List<String>>();
					for(OptionVote ov:allresult){
						List<String> a=new ArrayList<String>();
						a.add(ov.getOptiontext());
						a.add(ov.getNum().toString());
						
						resdata.put(ov.getOid(), a);
					} 
					ActionContext.getContext().put("resdata",resdata);
				}
			
			
			return "SUCCESS";
    	
    	
   
    }
	
	/*public String getResult(){
		HttpServletRequest request=ServletActionContext.getRequest();
    	//String selectedOid=request.getParameter("selectedOid");
    	String selectedTid=request.getParameter("selectedTid");
    	
    	//Integer oid=Integer.parseInt(selectedOid);
    	Integer tid=Integer.parseInt(selectedTid);
			System.out.println(tid);
			try {
				List<OptionVote> results=optionService.findByTno(tid);
				ActionContext.getContext().put("results", results);
			
				return "SUCCESS";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "DEFEAT";
			} 
			return null;
		
		}*/
}
