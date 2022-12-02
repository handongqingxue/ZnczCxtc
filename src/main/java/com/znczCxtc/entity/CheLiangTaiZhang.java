package com.znczCxtc.entity;

public class CheLiangTaiZhang {
	
	public static final int JIN_CHANG=1;
	public static final int CHU_CHANG=2;
	
	public static final int ZONG_HE_CHA_XUN_SHEET=1;
	public static final int CHANG_NEI_SHEET=2;

	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getJcsj() {
		return jcsj;
	}
	public void setJcsj(String jcsj) {
		this.jcsj = jcsj;
	}
	public String getJczp() {
		return jczp;
	}
	public void setJczp(String jczp) {
		this.jczp = jczp;
	}
	public String getCcsj() {
		return ccsj;
	}
	public void setCcsj(String ccsj) {
		this.ccsj = ccsj;
	}
	public String getCczp() {
		return cczp;
	}
	public void setCczp(String cczp) {
		this.cczp = cczp;
	}
	public Long getDdId() {
		return ddId;
	}
	public void setDdId(Long ddId) {
		this.ddId = ddId;
	}
	public String getDdh() {
		return ddh;
	}
	public void setDdh(String ddh) {
		this.ddh = ddh;
	}
	public String getDdztMc() {
		return ddztMc;
	}
	public void setDdztMc(String ddztMc) {
		this.ddztMc = ddztMc;
	}
	public String getCyclCph() {
		return cyclCph;
	}
	public void setCyclCph(String cyclCph) {
		this.cyclCph = cyclCph;
	}
	public Integer getLxlx() {
		return lxlx;
	}
	public void setLxlx(Integer lxlx) {
		this.lxlx = lxlx;
	}
	private String jcsj;
	private String jczp;
	private String ccsj;
	private String cczp;
	private Long ddId;
	private String ddh;
	private String ddztMc;
	private String cyclCph;
	private Integer lxlx;//流向类型
}
