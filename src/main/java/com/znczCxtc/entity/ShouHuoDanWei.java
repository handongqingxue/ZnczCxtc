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
	private Integer id;//收货单位id
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
	public Integer getDlId() {
		return dlId;
	}
	public void setDlId(Integer dlId) {
		this.dlId = dlId;
	}
	private String dwmc;//单位名称
	private String bjsj;//编辑时间
	private Integer dlId;//队列id
}
