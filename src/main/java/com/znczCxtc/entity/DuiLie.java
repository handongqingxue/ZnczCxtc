package com.znczCxtc.entity;

public class DuiLie {

	/**
	 * 在用
	 */
	public static final Integer ZAI_YONG=1;
	/**
	 * 暂停
	 */
	public static final Integer ZAN_TING=2;
	/**
	 * 废弃
	 */
	public static final Integer FEI_QI=3;
	
	private Integer id;//队列id
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
	public String getDm() {
		return dm;
	}
	public void setDm(String dm) {
		this.dm = dm;
	}
	public Integer getJhxs() {
		return jhxs;
	}
	public void setJhxs(Integer jhxs) {
		this.jhxs = jhxs;
	}
	public Integer getJhyz() {
		return jhyz;
	}
	public void setJhyz(Integer jhyz) {
		this.jhyz = jhyz;
	}
	public Integer getZt() {
		return zt;
	}
	public void setZt(Integer zt) {
		this.zt = zt;
	}
	private String mc;//名称
	private String dm;//代码
	private Integer jhxs;//叫号形式
	private Integer jhyz;//叫号阈值
	private Integer zt;//状态  1.在用2.暂停3.废弃
}
