package com.znczCxtc.entity;

public class DingDan {
	private Integer id;//订单id（主键）
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDdh() {
		return ddh;
	}
	public void setDdh(String ddh) {
		this.ddh = ddh;
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
	public Integer getDdztId() {
		return ddztId;
	}
	public void setDdztId(Integer ddztId) {
		this.ddztId = ddztId;
	}
	public String getDdztmc() {
		return ddztmc;
	}
	public void setDdztmc(String ddztmc) {
		this.ddztmc = ddztmc;
	}
	public String getJhysrq() {
		return jhysrq;
	}
	public void setJhysrq(String jhysrq) {
		this.jhysrq = jhysrq;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public Float getJszl() {
		return jszl;
	}
	public void setJszl(Float jszl) {
		this.jszl = jszl;
	}
	public Integer getBs() {
		return bs;
	}
	public void setBs(Integer bs) {
		this.bs = bs;
	}
	public Integer getKs() {
		return ks;
	}
	public void setKs(Integer ks) {
		this.ks = ks;
	}
	public Float getDfgbpz() {
		return dfgbpz;
	}
	public void setDfgbpz(Float dfgbpz) {
		this.dfgbpz = dfgbpz;
	}
	public Float getDfgbmz() {
		return dfgbmz;
	}
	public void setDfgbmz(Float dfgbmz) {
		this.dfgbmz = dfgbmz;
	}
	public Float getDfgbjz() {
		return dfgbjz;
	}
	public void setDfgbjz(Float dfgbjz) {
		this.dfgbjz = dfgbjz;
	}
	public String getDfgbzp() {
		return dfgbzp;
	}
	public void setDfgbzp(String dfgbzp) {
		this.dfgbzp = dfgbzp;
	}
	public String getDfgbsj() {
		return dfgbsj;
	}
	public void setDfgbsj(String dfgbsj) {
		this.dfgbsj = dfgbsj;
	}
	public String getEwm() {
		return ewm;
	}
	public void setEwm(String ewm) {
		this.ewm = ewm;
	}
	public Integer getYssId() {
		return yssId;
	}
	public void setYssId(Integer yssId) {
		this.yssId = yssId;
	}
	public String getYssmc() {
		return yssmc;
	}
	public void setYssmc(String yssmc) {
		this.yssmc = yssmc;
	}
	public Integer getWlxxId() {
		return wlxxId;
	}
	public void setWlxxId(Integer wlxxId) {
		this.wlxxId = wlxxId;
	}
	public String getWlmc() {
		return wlmc;
	}
	public void setWlmc(String wlmc) {
		this.wlmc = wlmc;
	}
	public Integer getFhdwId() {
		return fhdwId;
	}
	public void setFhdwId(Integer fhdwId) {
		this.fhdwId = fhdwId;
	}
	public String getFhdwmc() {
		return fhdwmc;
	}
	public void setFhdwmc(String fhdwmc) {
		this.fhdwmc = fhdwmc;
	}
	public Integer getShdwId() {
		return shdwId;
	}
	public void setShdwId(Integer shdwId) {
		this.shdwId = shdwId;
	}
	public String getShdwmc() {
		return shdwmc;
	}
	public void setShdwmc(String shdwmc) {
		this.shdwmc = shdwmc;
	}
	public Integer getCyclId() {
		return cyclId;
	}
	public void setCyclId(Integer cyclId) {
		this.cyclId = cyclId;
	}
	public Integer getCysjId() {
		return cysjId;
	}
	public void setCysjId(Integer cysjId) {
		this.cysjId = cysjId;
	}
	private String ddh;//订单号
	private Integer lxlx;//流向类型
	private Float yzxzl;//预装卸重量
	private Float sjzl;//实际重量
	private Float zlceb;//重量差额比
	private Integer ddztId;//订单状态id
	private String ddztmc;//订单状态名称
	private String jhysrq;//计划运输日期
	private String bz;//备注
	private Float jszl;//实际重量
	private Integer bs;//包数
	private Integer ks;//块数
	private Float dfgbpz;//对方过磅皮重
	private Float dfgbmz;//对方过磅毛重
	private Float dfgbjz;//对方过磅净重
	private String dfgbzp;//对方过磅照片
	private String dfgbsj;//对方过磅时间
	private String ewm;//二维码
	private Integer yssId;//运输商id
	private String yssmc;
	private Integer wlxxId;//物料信息id
	private String wlmc;
	private Integer fhdwId;//发货单位id
	private String fhdwmc;
	private Integer shdwId;//收货单位id
	private String shdwmc;
	private Integer cyclId;//承运车辆id
	private Integer cysjId;//承运司机id
}
