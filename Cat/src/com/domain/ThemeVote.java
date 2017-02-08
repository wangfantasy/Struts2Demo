package com.domain;

public class ThemeVote {
	private Integer tid;
	private String themetext;
	private Integer sum;
	
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getThemetext() {
		return themetext;
	}
	public void setThemetext(String themetext) {
		this.themetext = themetext;
	}
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "ThemeVote [tid=" + tid + ", themetext=" + themetext + ", sum="
				+ sum + "]";
	}
	
	
	
	
	
	
}
