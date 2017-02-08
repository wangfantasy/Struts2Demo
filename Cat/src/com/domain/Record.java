package com.domain;

public class Record {
	private Integer rid;
	private Integer tno;
	private Integer uno;
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public Integer getTno() {
		return tno;
	}
	public void setTno(Integer tno) {
		this.tno = tno;
	}
	public Integer getUno() {
		return uno;
	}
	public void setUno(Integer uno) {
		this.uno = uno;
	}
	@Override
	public String toString() {
		return "Record [rid=" + rid + ", tno=" + tno + ", uno=" + uno + "]";
	}
	
	
}
