package com.znczCxtc.entity;

public class ShouHuoDanWei {
	
	/**
	 * �ж��г���
	 */
	public static final boolean YOU_DUI_LIE=true;
	/**
	 * �޶��г���
	 */
	public static final boolean WU_DUI_LIE=false;
	private Integer id;//��λid
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
	private String mc;//����
	private String bjsj;//�༭ʱ��
	private Boolean ywdl;
	private Integer dlId;//����id
}
