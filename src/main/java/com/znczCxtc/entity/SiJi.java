package com.znczCxtc.entity;

public class SiJi {

	/**
	 * ��
	 */
	public static final boolean SHI=true;
	/**
	 * ��
	 */
	public static final boolean FOU=false;

	/**
	 * ��
	 */
	public static final String SHI_TEXT="��";
	/**
	 * ��
	 */
	public static final String FOU_TEXT="��";
	
	/**
	 * �ϸ�
	 */
	public static final boolean HE_GE=true;
	/**
	 * ���ϸ�
	 */
	public static final boolean BU_HE_GE=false;
	
	/**
	 * �ϸ�
	 */
	public static final String HE_GE_TEXT="�ϸ�";
	/**
	 * ���ϸ�
	 */
	public static final String BU_HE_GE_TEXT="���ϸ�";
	
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
	
	public static final int DAI_SHEN_HE_SHEET=1;
	public static final int ZONG_HE_CHA_XUN_SHEET=2;
	
	public static final int ZHAO_PIAN=1;
	public static final int ZI_GE_ZHENG_SHU=2;
	public static final int JIA_ZHENG=3;
	
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
