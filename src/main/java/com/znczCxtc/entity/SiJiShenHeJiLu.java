package com.znczCxtc.entity;

public class SiJiShenHeJiLu {

	/**
	 * �ϸ��ʶ
	 */
	public static final Boolean HE_GE=true;
	/**
	 * ���ϸ��ʶ
	 */
	public static final Boolean BU_HE_GE=false;
	
	/**
	 * �ϸ�����
	 */
	public static final String HE_GE_TEXT="�ϸ�";
	/**
	 * ���ϸ�����
	 */
	public static final String BU_HE_GE_TEXT="���ϸ�";
	
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSjId() {
		return sjId;
	}
	public void setSjId(Integer sjId) {
		this.sjId = sjId;
	}
	public String getSjXm() {
		return sjXm;
	}
	public void setSjXm(String sjXm) {
		this.sjXm = sjXm;
	}
	public String getShsj() {
		return shsj;
	}
	public void setShsj(String shsj) {
		this.shsj = shsj;
	}
	public Boolean getShjg() {
		return shjg;
	}
	public void setShjg(Boolean shjg) {
		this.shjg = shjg;
	}
	public Integer getShrId() {
		return shrId;
	}
	public void setShrId(Integer shrId) {
		this.shrId = shrId;
	}
	public String getShrYhm() {
		return shrYhm;
	}
	public void setShrYhm(String shrYhm) {
		this.shrYhm = shrYhm;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	private Integer sjId;
	private String sjXm;//˾������
	private String shsj;//���ʱ��
	private Boolean shjg;//��˽��
	private Integer shrId;//�����id
	private String shrYhm;//������˺�
	private String bz;//��ע
}
