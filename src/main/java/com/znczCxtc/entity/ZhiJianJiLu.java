package com.znczCxtc.entity;

public class ZhiJianJiLu {

	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getJg() {
		return jg;
	}
	public void setJg(Boolean jg) {
		this.jg = jg;
	}
	public String getBjsj() {
		return bjsj;
	}
	public void setBjsj(String bjsj) {
		this.bjsj = bjsj;
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
	public String getCph() {
		return cph;
	}
	public void setCph(String cph) {
		this.cph = cph;
	}
	private Boolean jg;//结果 true.合格 false.不合格
	private String bjsj;//编辑时间
	private Long ddId;//关联订单编码
	private String ddh;//订单号
	private String ddztMc;//订单状态名称
	private String cph;//车牌号
}
