package com.znczCxtc.entity;

import java.io.Serializable;

public class YongHu {
	
	/**
	 * �����
	 */
	public static final int DAI_SHEN_HE=1;
	/**
	 * ���ͨ��
	 */
	public static final int SHEN_HE_TONG_GUO=2;
	/**
	 * �༭��
	 */
	public static final int BIAN_JI_ZHONG=3;
	
	/**
	 * �����
	 */
	public static final String DAI_SHEN_HE_TEXT="�����";
	/**
	 * ���ͨ��
	 */
	public static final String SHEN_HE_TONG_GUO_TEXT="���ͨ��";
	/**
	 * �༭��
	 */
	public static final String BIAN_JI_ZHONG_TEXT="�༭��";

	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getYhm() {
		return yhm;
	}
	public void setYhm(String yhm) {
		this.yhm = yhm;
	}
	public String getNc() {
		return nc;
	}
	public void setNc(String nc) {
		this.nc = nc;
	}
	public String getTx() {
		return tx;
	}
	public void setTx(String tx) {
		this.tx = tx;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public Integer getShzt() {
		return shzt;
	}
	public void setShzt(Integer shzt) {
		this.shzt = shzt;
	}
	public String getMm() {
		return mm;
	}
	public void setMm(String mm) {
		this.mm = mm;
	}
	public String getCjsj() {
		return cjsj;
	}
	public void setCjsj(String cjsj) {
		this.cjsj = cjsj;
	}
	public String getJs() {
		return js;
	}
	public void setJs(String js) {
		this.js = js;
	}
	public String getJsIds() {
		return jsIds;
	}
	public void setJsIds(String jsIds) {
		this.jsIds = jsIds;
	}
	public String getQxIds() {
		return qxIds;
	}
	public void setQxIds(String qxIds) {
		this.qxIds = qxIds;
	}
	
	//https://blog.csdn.net/qq_43416276/article/details/102981480
	public YongHu() {
		super();
	}
	
	public YongHu(String yhm,String mm) {
		this.yhm=yhm;
		this.mm=mm;
	}
	private String yhm;
	private String nc;
	private String tx;
	private String xm;
	private Integer shzt;//���״̬��1.����� 2.���ͨ�� 3.�༭��
	private String mm;
	private String cjsj;
	private String js;
	private String jsIds;
	private String qxIds;

}
