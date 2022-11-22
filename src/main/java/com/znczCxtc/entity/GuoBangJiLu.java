package com.znczCxtc.entity;

public class GuoBangJiLu {
	
	public static final Integer ZHENG_CHANG=1;
	public static final Integer YI_CHANG=2;
	
	/**
	 * 入厂过磅标识
	 */
	public static final Integer RU_CHANG_GUO_BANG=1;
	/**
	 * 出厂过磅标识
	 */
	public static final Integer CHU_CHANG_GUO_BANG=2;
	
	/**
	 * 入厂过磅名称
	 */
	public static final String RU_CHANG_GUO_BANG_TEXT="入厂过磅";
	/**
	 * 出厂过磅名称
	 */
	public static final String CHU_CHANG_GUO_BANG_TEXT="出厂过磅";

	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Float getGbzl() {
		return gbzl;
	}
	public void setGbzl(Float gbzl) {
		this.gbzl = gbzl;
	}
	public String getZp1() {
		return zp1;
	}
	public void setZp1(String zp1) {
		this.zp1 = zp1;
	}
	public String getZp2() {
		return zp2;
	}
	public void setZp2(String zp2) {
		this.zp2 = zp2;
	}
	public String getZp3() {
		return zp3;
	}
	public void setZp3(String zp3) {
		this.zp3 = zp3;
	}
	public Integer getGbzt() {
		return gbzt;
	}
	public void setGbzt(Integer gbzt) {
		this.gbzt = gbzt;
	}
	public String getGbsj() {
		return gbsj;
	}
	public void setGbsj(String gbsj) {
		this.gbsj = gbsj;
	}
	public Integer getGblx() {
		return gblx;
	}
	public void setGblx(Integer gblx) {
		this.gblx = gblx;
	}
	public String getGblxName() {
		return gblxName;
	}
	public void setGblxName(String gblxName) {
		this.gblxName = gblxName;
	}
	public Integer getDdId() {
		return ddId;
	}
	public void setDdId(Integer ddId) {
		this.ddId = ddId;
	}
	public String getDdh() {
		return ddh;
	}
	public void setDdh(String ddh) {
		this.ddh = ddh;
	}
	public String getCysjXm() {
		return cysjXm;
	}
	public void setCysjXm(String cysjXm) {
		this.cysjXm = cysjXm;
	}
	public String getCyclCph() {
		return cyclCph;
	}
	public void setCyclCph(String cyclCph) {
		this.cyclCph = cyclCph;
	}
	public String getCysjSfzh() {
		return cysjSfzh;
	}
	public void setCysjSfzh(String cysjSfzh) {
		this.cysjSfzh = cysjSfzh;
	}
	public Integer getLxlx() {
		return lxlx;
	}
	public void setLxlx(Integer lxlx) {
		this.lxlx = lxlx;
	}
	public String getYssMc() {
		return yssMc;
	}
	public void setYssMc(String yssMc) {
		this.yssMc = yssMc;
	}
	public String getFhdwMc() {
		return fhdwMc;
	}
	public void setFhdwMc(String fhdwMc) {
		this.fhdwMc = fhdwMc;
	}
	public String getShdwMc() {
		return shdwMc;
	}
	public void setShdwMc(String shdwMc) {
		this.shdwMc = shdwMc;
	}
	private Float gbzl;
	private String zp1;
	private String zp2;
	private String zp3;
	private Integer gbzt;
	private String gbsj;
	private Integer gblx;
	private String gblxName;
	private Integer ddId;
	private String ddh;
	private String cysjXm;
	private String cyclCph;
	private String cysjSfzh;
	private Integer lxlx;//流向类型
	private String yssMc;
	private String fhdwMc;
	private String shdwMc;
}
