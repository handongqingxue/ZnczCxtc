package com.znczCxtc.entity;

public class DuiLie {
	
	public static final int ZI_DONG_JIAO_HAO=1;
	public static final int SHOU_DONG_JIAO_HAO=2;
	
	public static final String ZI_DONG_JIAO_HAO_TEXT="�Զ��к�";
	public static final String SHOU_DONG_JIAO_HAO_TEXT="�ֶ��к�";

	/**
	 * ����
	 */
	public static final int ZAI_YONG=1;
	/**
	 * ��ͣ
	 */
	public static final int ZAN_TING=2;
	/**
	 * ����
	 */
	public static final int FEI_QI=3;

	/**
	 * ����
	 */
	public static final String ZAI_YONG_TEXT="����";
	/**
	 * ��ͣ
	 */
	public static final String ZAN_TING_TEXT="��ͣ";
	/**
	 * ����
	 */
	public static final String FEI_QI_TEXT="����";
	
	private Integer id;//����id
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
	private String mc;//����
	private String dm;//����
	private Integer jhxs;//�к���ʽ
	private Integer jhyz;//�к���ֵ
	private Integer zt;//״̬  1.����2.��ͣ3.����
}
