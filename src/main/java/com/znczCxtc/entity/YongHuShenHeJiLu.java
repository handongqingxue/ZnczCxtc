package com.znczCxtc.entity;

public class YongHuShenHeJiLu {

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
	public Integer getYhId() {
		return yhId;
	}
	public void setYhId(Integer yhId) {
		this.yhId = yhId;
	}
	public String getYhm() {
		return yhm;
	}
	public void setYhm(String yhm) {
		this.yhm = yhm;
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
	private Integer yhId;
	private String yhm;
	private String shsj;//审核时间
	private Boolean shjg;//审核结果
	private Integer shrId;//审核人id
	private String shrYhm;//审核人账号
	private String bz;//备注
}
