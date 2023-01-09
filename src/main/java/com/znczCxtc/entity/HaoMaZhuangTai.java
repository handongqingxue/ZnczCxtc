package com.znczCxtc.entity;

public class HaoMaZhuangTai {
	
	/**
	 * 排队中状态标识
	 */
	public static final int PAI_DUI_ZHONG=1;//排队中
	/**
	 * 叫号中状态标识
	 */
	public static final int JIAO_HAO_ZHONG=2;//叫号中
	/**
	 * 已过号状态标识
	 */
	public static final int YI_GUO_HAO=3;//已过号
	/**
	 * 受理中状态标识
	 */
	public static final int SHOU_LI_ZHONG=4;//受理中
	/**
	 * 已完成状态标识
	 */
	public static final int YI_WAN_CHENG=5;//已完成
	/**
	 * 取消状态标识
	 */
	public static final int QU_XIAO=6;//取消

	/**
	 * 排队中状态名称
	 */
	public static final String PAI_DUI_ZHONG_TEXT="排队中";
	/**
	 * 叫号中状态名称
	 */
	public static final String JIAO_HAO_ZHONG_TEXT="叫号中";
	/**
	 * 已过号状态名称
	 */
	public static final String YI_GUO_HAO_TEXT="已过号";
	/**
	 * 受理中状态名称
	 */
	public static final String SHOU_LI_ZHONG_TEXT="受理中";
	/**
	 * 已完成状态名称
	 */
	public static final String YI_WAN_CHENG_TEXT="已完成";
	/**
	 * 取消状态名称
	 */
	public static final String QU_XIAO_TEXT="取消";
			
	private Integer id;//号码状态id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public Integer getPx() {
		return px;
	}
	public void setPx(Integer px) {
		this.px = px;
	}
	private String mc;//名称
	private Integer px;//排序

}
