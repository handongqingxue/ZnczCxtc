package com.znczCxtc.entity;

public class CheLiangShenHeJiLu {
	
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
	public Integer getClId() {
		return clId;
	}
	public void setClId(Integer clId) {
		this.clId = clId;
	}
	public String getClCph() {
		return clCph;
	}
	public void setClCph(String clCph) {
		this.clCph = clCph;
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
	private Integer clId;
	private String clCph;//���ƺ�
	private String shsj;//���ʱ��
	private Boolean shjg;//��˽��
	private Integer shrId;//�����id
	private String shrYhm;//������˺�
	private String bz;//��ע
}
