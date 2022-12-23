package com.znczCxtc.entity;

public class SiJi {

	/**
	 * 是
	 */
	public static final boolean SHI=true;
	/**
	 * 否
	 */
	public static final boolean FOU=false;

	/**
	 * 是
	 */
	public static final String SHI_TEXT="是";
	/**
	 * 否
	 */
	public static final String FOU_TEXT="否";
	
	/**
	 * 合格
	 */
	public static final boolean HE_GE=true;
	/**
	 * 不合格
	 */
	public static final boolean BU_HE_GE=false;
	
	/**
	 * 合格
	 */
	public static final String HE_GE_TEXT="合格";
	/**
	 * 不合格
	 */
	public static final String BU_HE_GE_TEXT="不合格";
	
	/**
	 * 待审核
	 */
	public static final int DAI_SHEN_HE=1;
	/**
	 * 审核通过
	 */
	public static final int SHEN_HE_TONG_GUO=2;
	/**
	 * 编辑中
	 */
	public static final int BIAN_JI_ZHONG=3;
	
	/**
	 * 待审核
	 */
	public static final String DAI_SHEN_HE_TEXT="待审核";
	/**
	 * 审核通过
	 */
	public static final String SHEN_HE_TONG_GUO_TEXT="审核通过";
	/**
	 * 编辑中
	 */
	public static final String BIAN_JI_ZHONG_TEXT="编辑中";
	
	public static final int DAI_SHEN_HE_SHEET=1;
	public static final int ZONG_HE_CHA_XUN_SHEET=2;
	
	public static final int ZHAO_PIAN=1;
	public static final int ZI_GE_ZHENG_SHU=2;
	public static final int JIA_ZHENG=3;
	
	private Integer id;//司机id
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
	private String xm;//姓名
	private String sjh;//手机号
	private String sfzzp;//身份证照片
	private String sfzh;//身份证号	
	private String zgzs;//资格证书
	private String zgzyxqz;//资格证有效期至
	private String jz;//驾证
	private String jzyxqz;//驾证有效期至
	private Integer shzt;//审核状态 1.编辑中2.待审核3.审核通过
	private Boolean zyzt;//在用状态
	private Integer glyhId;
}
