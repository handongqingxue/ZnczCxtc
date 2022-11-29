package com.znczCxtc.entity;

public class DingDanShenHeJiLu {
	
	/**
	 * 下单审核标识
	 */
	public static final int XIA_DAN_SHEN_HE=1;
	/**
	 * 质检审核标识
	 */
	public static final int ZHI_JIAN_SHEN_HE=2;
	/**
	 * 一检审核标识
	 */
	public static final int YI_JIAN_SHEN_HE=3;
	/**
	 * 入库审核标识
	 */
	public static final int RU_KU_SHEN_HE=4;
	/**
	 * 二检审核标识
	 */
	public static final int ER_JIAN_SHEN_HE=5;

	/**
	 * 下单审核名称
	 */
	public static final String XIA_DAN_SHEN_HE_TEXT="下单审核";
	/**
	 * 质检审核名称
	 */
	public static final String ZHI_JIAN_SHEN_HE_TEXT="质检审核";
	/**
	 * 一检审核名称
	 */
	public static final String YI_JIAN_SHEN_HE_TEXT="一检审核";
	/**
	 * 入库审核名称
	 */
	public static final String RU_KU_SHEN_HE_TEXT="入库审核";
	/**
	 * 二检审核名称
	 */
	public static final String ER_JIAN_SHEN_HE_TEXT="二检审核";
	
	/**
	 * 合格标识
	 */
	public static final Boolean HE_GE=true;
	/**
	 * 不合格标识
	 */
	public static final Boolean BU_HE_GE=false;
	
	/**
	 * 合格名称
	 */
	public static final String HE_GE_TEXT="合格";
	/**
	 * 不合格名称
	 */
	public static final String BU_HE_GE_TEXT="不合格";

	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getSjSfzh() {
		return sjSfzh;
	}
	public void setSjSfzh(String sjSfzh) {
		this.sjSfzh = sjSfzh;
	}
	public String getSjXm() {
		return sjXm;
	}
	public void setSjXm(String sjXm) {
		this.sjXm = sjXm;
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
	public Float getYzxzl() {
		return yzxzl;
	}
	public void setYzxzl(Float yzxzl) {
		this.yzxzl = yzxzl;
	}
	public Float getSjzl() {
		return sjzl;
	}
	public void setSjzl(Float sjzl) {
		this.sjzl = sjzl;
	}
	public Float getZlceb() {
		return zlceb;
	}
	public void setZlceb(Float zlceb) {
		this.zlceb = zlceb;
	}
	public Integer getWzId() {
		return wzId;
	}
	public void setWzId(Integer wzId) {
		this.wzId = wzId;
	}
	public String getWzMc() {
		return wzMc;
	}
	public void setWzMc(String wzMc) {
		this.wzMc = wzMc;
	}
	public Integer getYssId() {
		return yssId;
	}
	public void setYssId(Integer yssId) {
		this.yssId = yssId;
	}
	public String getYssMc() {
		return yssMc;
	}
	public void setYssMc(String yssMc) {
		this.yssMc = yssMc;
	}
	public Integer getFhdwId() {
		return fhdwId;
	}
	public void setFhdwId(Integer fhdwId) {
		this.fhdwId = fhdwId;
	}
	public String getFhdwMc() {
		return fhdwMc;
	}
	public void setFhdwMc(String fhdwMc) {
		this.fhdwMc = fhdwMc;
	}
	public Integer getShdwId() {
		return shdwId;
	}
	public void setShdwId(Integer shdwId) {
		this.shdwId = shdwId;
	}
	public String getShdwMc() {
		return shdwMc;
	}
	public void setShdwMc(String shdwMc) {
		this.shdwMc = shdwMc;
	}
	public Integer getShlx() {
		return shlx;
	}
	public void setShlx(Integer shlx) {
		this.shlx = shlx;
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
	private Long ddId;
	private String ddh;//订单号
	private String sjSfzh;
	private String sjXm;
	private String cyclCph;
	private Integer lxlx;//流向类型
	private Float yzxzl;//预装卸重量
	private Float sjzl;//实际重量
	private Float zlceb;//重量差额比
	private Integer wzId;
	private String wzMc;
	private Integer yssId;
	private String yssMc;
	private Integer fhdwId;
	private String fhdwMc;
	private Integer shdwId;
	private String shdwMc;
	private Integer shlx;//审核类型 1.下单审核 2.一检审核 3.入库审核 4.二检审核
	private String shsj;//审核时间
	private Boolean shjg;//审核结果
	private Integer shrId;//审核人id
	private String shrYhm;//审核人账号
	private String bz;//备注
}
