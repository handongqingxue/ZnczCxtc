package com.znczCxtc.entity;

public class SiJi {

	/**
	 * ��
	 */
	public static final Integer SHI=1;
	/**
	 * ��
	 */
	public static final Integer FOU=0;
	
	/**
	 * �����
	 */
	public static final Integer DAI_SHEN_HE=1;
	/**
	 * ���ͨ��
	 */
	public static final Integer SHEN_HE_TONG_GUO=2;
	/**
	 * �༭��
	 */
	public static final Integer BIAN_JI_ZHONG=3;
	private Integer id;//˾��id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getSjh() {
		return sjh;
	}
	public void setSjh(String sjh) {
		this.sjh = sjh;
	}
	public String getSfzzp() {
		return sfzzp;
	}
	public void setSfzzp(String sfzzp) {
		this.sfzzp = sfzzp;
	}
	public String getSfzh() {
		return sfzh;
	}
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	public String getZgzs() {
		return zgzs;
	}
	public void setZgzs(String zgzs) {
		this.zgzs = zgzs;
	}
	public String getZgzyxqz() {
		return zgzyxqz;
	}
	public void setZgzyxqz(String zgzyxqz) {
		this.zgzyxqz = zgzyxqz;
	}
	public String getJz() {
		return jz;
	}
	public void setJz(String jz) {
		this.jz = jz;
	}
	public String getJzyxqz() {
		return jzyxqz;
	}
	public void setJzyxqz(String jzyxqz) {
		this.jzyxqz = jzyxqz;
	}
	public Integer getShzt() {
		return shzt;
	}
	public void setShzt(Integer shzt) {
		this.shzt = shzt;
	}
	public Boolean getZyzt() {
		return zyzt;
	}
	public void setZyzt(Boolean zyzt) {
		this.zyzt = zyzt;
	}
	public Integer getGlyhId() {
		return glyhId;
	}
	public void setGlyhId(Integer glyhId) {
		this.glyhId = glyhId;
	}
	private String xm;//����
	private String sjh;//�ֻ���
	private String sfzzp;//���֤��Ƭ
	private String sfzh;//���֤��	
	private String zgzs;//�ʸ�֤��
	private String zgzyxqz;//�ʸ�֤��Ч����
	private String jz;//��֤
	private String jzyxqz;//��֤��Ч����
	private Integer shzt;//���״̬ 1.�༭��2.�����3.���ͨ��
	private Boolean zyzt;//����״̬
	private Integer glyhId;
}
