package com.znczCxtc.entity;

public class FaHuoDanWei {
	
	private Integer id;//发货单位id 主键
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	public String getBjsj() {
		return bjsj;
	}
	public void setBjsj(String bjsj) {
		this.bjsj = bjsj;
	}
	private String dwmc;//单位名称
	private String bjsj;//编辑时间
}
