package com.znczCxtc.entity;

public class FaHuoDanWei {
	
	private Integer id;//单位id 主键
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public String getBjsj() {
		return bjsj;
	}
	public void setBjsj(String bjsj) {
		this.bjsj = bjsj;
	}
	private String mc;//名称
	private String bjsj;//编辑时间
}
