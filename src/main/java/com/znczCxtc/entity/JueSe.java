package com.znczCxtc.entity;

public class JueSe {

	private Integer id;//角色id
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
	public Integer getZt() {
		return zt;
	}
	public void setZt(Integer zt) {
		this.zt = zt;
	}
	public String getMs() {
		return ms;
	}
	public void setMs(String ms) {
		this.ms = ms;
	}
	public String getQxIds() {
		return qxIds;
	}
	public void setQxIds(String qxIds) {
		this.qxIds = qxIds;
	}
	private String mc;//名称
	private Integer zt;//状态:1.新增2.正常使用3.废弃4.有误
	private String ms;//描述
	private String qxIds;//直接权限id
}
