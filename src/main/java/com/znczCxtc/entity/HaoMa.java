package com.znczCxtc.entity;

public class HaoMa {
	
	public static final int PU_TONG=1;
	public static final int QI_TA=2;
	
	public static final String PU_TONG_TEXT="��ͨ";
	public static final String QI_TA_TEXT="����";

	private Long id;//����id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getHm() {
		return hm;
	}
	public void setHm(Integer hm) {
		this.hm = hm;
	}
	public Integer getPdh() {
		return pdh;
	}
	public void setPdh(Integer pdh) {
		this.pdh = pdh;
	}
	public String getPrsj() {
		return prsj;
	}
	public void setPrsj(String prsj) {
		this.prsj = prsj;
	}
	public Integer getHmztId() {
		return hmztId;
	}
	public void setHmztId(Integer hmztId) {
		this.hmztId = hmztId;
	}
	public String getHmztMc() {
		return hmztMc;
	}
	public void setHmztMc(String hmztMc) {
		this.hmztMc = hmztMc;
	}
	public Integer getFl() {
		return fl;
	}
	public void setFl(Integer fl) {
		this.fl = fl;
	}
	public String getKsjhsj() {
		return ksjhsj;
	}
	public void setKsjhsj(String ksjhsj) {
		this.ksjhsj = ksjhsj;
	}
	public Integer getJhcs() {
		return jhcs;
	}
	public void setJhcs(Integer jhcs) {
		this.jhcs = jhcs;
	}
	public Integer getDlId() {
		return dlId;
	}
	public void setDlId(Integer dlId) {
		this.dlId = dlId;
	}
	public String getDlMc() {
		return dlMc;
	}
	public void setDlMc(String dlMc) {
		this.dlMc = dlMc;
	}
	public Integer getDlJhyz() {
		return dlJhyz;
	}
	public void setDlJhyz(Integer dlJhyz) {
		this.dlJhyz = dlJhyz;
	}
	public Long getDdId() {
		return ddId;
	}
	public void setDdId(Long ddId) {
		this.ddId = ddId;
	}
	public String getClCph() {
		return clCph;
	}
	public void setClCph(String clCph) {
		this.clCph = clCph;
	}
	public Integer getSlzsl() {
		return slzsl;
	}
	public void setSlzsl(Integer slzsl) {
		this.slzsl = slzsl;
	}
	private Integer hm;//����
	private Integer pdh;//�ŶӺ�	
	private String prsj;//����ʱ��
	private Integer hmztId;//����״̬ 1.�Ŷ���2.�����3.�ѹ���4.ȡ��5.�к���6.������
	private String hmztMc;//����״̬����
	private Integer fl;//���� 1.��ͨ 2.����
	private String ksjhsj;//��ʼ�к�ʱ��
	private Integer jhcs;
	private Integer dlId;//����id
	private String dlMc;//��������
	private Integer dlJhyz;//���нк���ֵ(�жϳ��ڳ��������Ƿ���������ֵ�����ڵĻ��������Ŷ��еĳ���״̬����ʱ���ı䣬����С��ʱ�Ÿı�)
	private Long ddId;//����id
	private String clCph;
	private Integer slzsl;//����������

}
