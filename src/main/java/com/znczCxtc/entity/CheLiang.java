package com.znczCxtc.entity;

public class CheLiang {

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
	
	public static final int GUO_WU_RAN_YOU=1;
	public static final int GUO_WU_RAN_QI=2;
	public static final int GUO_LIU_RAN_YOU=3;
	public static final int GUO_LIU_RAN_QI=4;
	public static final int DIAN_DONG=5;
	
	public static final String GUO_WU_RAN_YOU_TEXT="����ȼ��";
	public static final String GUO_WU_RAN_QI_TEXT="����ȼ��";
	public static final String GUO_LIU_RAN_YOU_TEXT="����ȼ��";
	public static final String GUO_LIU_RAN_QI_TEXT="����ȼ��";
	public static final String DIAN_DONG_TEXT="�綯";
	
	private Integer id;//����id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCph() {
		return cph;
	}
	public void setCph(String cph) {
		this.cph = cph;
	}
	public String getCzxx() {
		return czxx;
	}
	public void setCzxx(String czxx) {
		this.czxx = czxx;
	}
	public Float getPz() {
		return pz;
	}
	public void setPz(Float pz) {
		this.pz = pz;
	}
	public Integer getCllx() {
		return cllx;
	}
	public void setCllx(Integer cllx) {
		this.cllx = cllx;
	}
	public String getPpxh() {
		return ppxh;
	}
	public void setPpxh(String ppxh) {
		this.ppxh = ppxh;
	}
	public String getZp() {
		return zp;
	}
	public void setZp(String zp) {
		this.zp = zp;
	}
	public String getFdjhm() {
		return fdjhm;
	}
	public void setFdjhm(String fdjhm) {
		this.fdjhm = fdjhm;
	}
	public String getClsbdh() {
		return clsbdh;
	}
	public void setClsbdh(String clsbdh) {
		this.clsbdh = clsbdh;
	}
	public String getZcrq() {
		return zcrq;
	}
	public void setZcrq(String zcrq) {
		this.zcrq = zcrq;
	}
	public Integer getPfjd() {
		return pfjd;
	}
	public void setPfjd(Integer pfjd) {
		this.pfjd = pfjd;
	}
	public String getFzrq() {
		return fzrq;
	}
	public void setFzrq(String fzrq) {
		this.fzrq = fzrq;
	}
	public Boolean getSfzy() {
		return sfzy;
	}
	public void setSfzy(Boolean sfzy) {
		this.sfzy = sfzy;
	}
	public Integer getShzt() {
		return shzt;
	}
	public void setShzt(Integer shzt) {
		this.shzt = shzt;
	}
	public Integer getClyslx() {
		return clyslx;
	}
	public void setClyslx(Integer clyslx) {
		this.clyslx = clyslx;
	}
	public String getXsz() {
		return xsz;
	}
	public void setXsz(String xsz) {
		this.xsz = xsz;
	}
	public String getScqd() {
		return scqd;
	}
	public void setScqd(String scqd) {
		this.scqd = scqd;
	}
	public String getPfjdcxjt() {
		return pfjdcxjt;
	}
	public void setPfjdcxjt(String pfjdcxjt) {
		this.pfjdcxjt = pfjdcxjt;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	private String cph;//���ƺ�
	private String czxx;//������Ϣ
	private Float pz;//Ƥ��
	private Integer cllx;//�������ͣ�1.����
	private String ppxh;//Ʒ���ͺ�
	private String zp;//��Ƭ
	private String fdjhm;//����������
	private String clsbdh;//����ʶ�����
	private String zcrq;//ע������
	private Integer pfjd;//�ŷŽ׶Σ�1.����ȼ�� 2.����ȼ�� 3.����ȼ�� 4.����ȼ�� 5.�綯
	private String fzrq;//��֤����
	private Boolean sfzy;//�Ƿ�����
	private Integer shzt;//���״̬��1.����� 2.���ͨ�� 3.�༭��
	private Integer clyslx;//�����������ͣ�1.�ջ����� 2.�������� 3.Σ��Ʒ����
	private String xsz;//��ʻ֤
	private String scqd;//�泵�嵥
	private String pfjdcxjt;//�ŷŽ׶β�ѯ��ͼ
	private String bz;//��ע
}
