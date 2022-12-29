package com.znczCxtc.entity;

public class QuanXian {

	/**
	 * 添加订单
	 */
	public static final int TIAN_JIA_DING_DAN=1;
	/**
	 * 修改订单
	 */
	public static final int XIU_GAI_DING_DAN=2;
	/**
	 * 删除订单
	 */
	public static final int SHAN_CHU_DING_DAN=3;
	/**
	 * 查询订单
	 */
	public static final int CHA_XUN_DING_DAN=4;
	/**
	 * 下单审核
	 */
	public static final int XIA_DAN_SHEN_HE=5;
	/**
	 * 质检审核
	 */
	public static final int ZHI_JIAN_SHEN_HE=6;
	/**
	 * 一检审核
	 */
	public static final int YI_JIAN_SHEN_HE=7;
	/**
	 * 二检审核
	 */
	public static final int ER_JIAN_SHEN_HE=8;
	/**
	 * 装卸货审核
	 */
	public static final int ZHUANG_XIE_HUO_SHEN_HE=9;
	/**
	 * 删除过磅记录
	 */
	public static final int SHAN_CHU_GUO_BANG_JI_LU=10;
	/**
	 * 删除磅单记录
	 */
	public static final int SHAN_CHU_BANG_DAN_JI_LU=11;
	/**
	 * 订单状态查询
	 */
	public static final int DING_DAN_ZHUANG_TAI_CHA_XUN=28;
	/**
	 * 查询磅单记录
	 */
	public static final int CHA_XUN_BANG_DAN_JI_LU=29;
	/**
	 * 查询过磅记录
	 */
	public static final int CHA_XUN_GUO_BANG_JI_LU=30;
	/**
	 * 查询物资类型
	 */
	public static final int CHA_XUN_WU_ZI_LEI_XING=31;
	/**
	 * 查询物资
	 */
	public static final int CHA_XUN_WU_ZI=32;
	/**
	 * 查询运输商
	 */
	public static final int CHA_XUN_YUN_SHU_SHANG=33;
	/**
	 * 查询发货单位
	 */
	public static final int CHA_XUN_FA_HUO_DAN_WEI=34;
	/**
	 * 查询收货单位
	 */
	public static final int CHA_XUN_SHOU_HUO_DAN_WEI=35;
	/**
	 * 查询仓库
	 */
	public static final int CHA_XUN_CANG_KU=36;
	/**
	 * 添加车辆
	 */
	public static final int TIAN_JIA_CHE_LIANG=37;
	/**
	 * 修改车辆
	 */
	public static final int XIU_GAI_CHE_LIANG=38;
	/**
	 * 删除车辆
	 */
	public static final int SHAN_CHU_CHE_LIANG=39;
	/**
	 * 查询车辆
	 */
	public static final int CHA_XUN_CHE_LIANG=40;
	/**
	 * 审核车辆
	 */
	public static final int SHEN_HE_CHE_LIANG=41;
	/**
	 * 查询车辆台账
	 */
	public static final int CHA_XUN_CHE_LIANG_TAI_ZHANG=42;
	/**
	 * 查询车辆审核记录
	 */
	public static final int CHA_XUN_CHE_LIANG_SHEN_HE_JI_LU=43;
	/**
	 * 添加司机
	 */
	public static final int TIAN_JIA_SI_JI=44;
	/**
	 * 修改司机
	 */
	public static final int XIU_GAI_SI_JI=45;
	/**
	 * 删除司机
	 */
	public static final int SHAN_CHU_SI_JI=46;
	/**
	 * 查询司机
	 */
	public static final int CHA_XUN_SI_JI=47;
	/**
	 * 审核司机
	 */
	public static final int SHEN_HE_SI_JI=48;
	/**
	 * 查询司机审核记录
	 */
	public static final int CHA_XUN_SI_JI_SHEN_HE_JI_LU=49;
	/**
	 * 查询排队号码
	 */
	public static final int CHA_XUN_PAI_DUI_HAO_MA=50;
	/**
	 * 删除排队号码
	 */
	public static final int SHAN_CHU_PAI_DUI_HAO_MA=51;
	/**
	 * 添加队列
	 */
	public static final int TIAN_JIA_DUI_LIE=52;
	/**
	 * 修改队列
	 */
	public static final int XIU_GAI_DUI_LIE=53;
	/**
	 * 删除队列
	 */
	public static final int SHAN_CHU_DUI_LIE=54;
	/**
	 * 查询队列
	 */
	public static final int CHA_XUN_DUI_LIE=55;
	/**
	 * 查询用户
	 */
	public static final int CHA_XUN_YONG_HU=56;
	/**
	 * 修改用户
	 */
	public static final int XIU_GAI_YONG_HU=57;
	/**
	 * 审核用户
	 */
	public static final int SHEN_HE_YONG_HU=58;
	/**
	 * 查询用户审核记录
	 */
	public static final int CHA_XUN_YONG_HU_SHEN_HE_JI_LU=59;
	/**
	 * 添加角色
	 */
	public static final int TIAN_JIA_JUE_SE=60;
	/**
	 * 修改角色
	 */
	public static final int XIU_GAI_JUE_SE=61;
	/**
	 * 删除角色
	 */
	public static final int SHAN_CHU_JUE_SE=62;
	/**
	 * 查询角色
	 */
	public static final int CHA_XUN_JUE_SE=63;
	
	private Integer id;
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
	public String getMs() {
		return ms;
	}
	public void setMs(String ms) {
		this.ms = ms;
	}
	private String mc;
	private Integer px;
	private String ms;
}
