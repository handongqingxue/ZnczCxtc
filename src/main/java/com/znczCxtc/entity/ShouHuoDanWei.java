package com.znczCxtc.entity;

public class ShouHuoDanWei {
	
	/**
	 * 有队列常量
	 */
	public static final boolean YOU_DUI_LIE=true;
	/**
	 * 无队列常量
	 */
	public static final boolean WU_DUI_LIE=false;
	private Integer id;//单位id
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
	public Boolean getYwdl() {
		return ywdl;
	}
	public void setYwdl(Boolean ywdl) {
		this.ywdl = ywdl;
	}
	public Integer getDlId() {
		return dlId;
	}
	public void setDlId(Integer dlId) {
		this.dlId = dlId;
	}
	private String mc;//名称
	private String bjsj;//编辑时间
	private Boolean ywdl;
	private Integer dlId;//队列id
}
