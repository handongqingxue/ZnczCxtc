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
	private Integer id;//�ջ���λid
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
	private String dwmc;//��λ����
	private String bjsj;//�༭ʱ��
	private Integer dlId;//����id
}
