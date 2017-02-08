package com.domain;

public class User {
	private Integer uid;
	private Integer permit;
	private String username;
	private String password;
	private String sex;
	private String email;
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getPermit() {
		return permit;
	}
	public void setPermit(Integer permit) {
		this.permit = permit;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", permit=" + permit + ", username="
				+ username + "]";
	}
	
	
	
	
	
	
}
