package com.znczCxtc.entity;

public class CheLiang {

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
