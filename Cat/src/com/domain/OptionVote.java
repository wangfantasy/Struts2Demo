package com.domain;

public class OptionVote {
      private Integer oid;
      private String optiontext;
      private Integer num;
      private Integer tno;
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	
	public String getOptiontext() {
		return optiontext;
	}
	public void setOptiontext(String optiontext) {
		this.optiontext = optiontext;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	public Integer getTno() {
		return tno;
	}
	public void setTno(Integer tno) {
		this.tno = tno;
	}
	@Override
	public String toString() {
		return "OptionsVote [oid=" + oid + ", optiontext=" + optiontext + ", num=" + num + ", tno=" + tno + "]";
	}
      
	 
}
