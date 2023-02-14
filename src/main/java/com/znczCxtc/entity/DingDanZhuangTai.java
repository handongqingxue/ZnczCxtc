package com.znczCxtc.entity;

public class DingDanZhuangTai {
	
	//订单状态的标识start
	/**
	 * 待审核状态标识
	 */
	public static final int DAI_SHEN_HE=1;//待审核
	/**
	 * 编辑中状态标识
	 */
	public static final int BIAN_JI_ZHONG=2;//编辑中
	/**
	 * 已下单状态标识
	 */
	public static final int YI_XIA_DAN=3;//已下单
	/**
	 * 排队中状态标识
	 */
	public static final int PAI_DUI_ZHONG=4;//排队中
	/**
	 * 待入厂状态标识
	 */
	public static final int DAI_RU_CHANG=5;//待入厂
	/**
	 * 待检验状态标识
	 */
	public static final int DAI_JIAN_YAN=6;//待检验
	/**
	 * 一检待扫码状态标识
	 */
	public static final int YI_JIAN_DAI_SAO_MA=7;//一检待扫码
	/**
	 * 一检待上磅状态标识
	 */
	public static final int YI_JIAN_DAI_SHANG_BANG=8;//一检待上磅
	/**
	 * 一检中状态标识
	 */
	public static final int YI_JIAN_ZHONG=9;//一检中
	/**
	 * 一检待审核状态标识
	 */
	public static final int YI_JIAN_DAI_SHEN_HE=10;//一检待审核
	/**
	 * 待装卸货状态标识
	 */
	public static final int DAI_ZHUANG_XIE_HUO=11;//待装卸货
	/**
	 * 二检待扫码状态标识
	 */
	public static final int ER_JIAN_DAI_SAO_MA=12;//二检待扫码
	/**
	 * 二检待上磅状态标识
	 */
	public static final int ER_JIAN_DAI_SHANG_BANG=13;//二检待上磅
	/**
	 * 二检中状态标识
	 */
	public static final int ER_JIAN_ZHONG=14;//二检中
	/**
	 * 二检待审核状态标识
	 */
	public static final int ER_JIAN_DAI_SHEN_HE=15;//二检待审核
	/**
	 * 待打印凭证状态标识
	 */
	public static final int DAI_DA_YIN_PING_ZHENG=16;//待打印凭证
	/**
	 * 待离厂状态标识
	 */
	public static final int DAI_LI_CHANG=17;//待离厂
	/**
	 * 已完成状态标识
	 */
	public static final int YI_WAN_CHENG=18;//已完成
	/**
	 * 异常状态标识
	 */
	public static final int YI_CHANG=19;//异常
	/**
	 * 已废弃状态标识
	 */
	public static final int YI_FEI_QI=20;//已废弃
	//订单状态的标识end
	
	//订单状态的名称start
	/**
	 * 待审核状态名称
	 */
	public static final String DAI_SHEN_HE_TEXT="待审核";//1
	/**
	 * 编辑中状态名称
	 */
	public static final String BIAN_JI_ZHONG_TEXT="编辑中";//2
	/**
	 * 已下单状态名称
	 */
	public static final String YI_XIA_DAN_TEXT="已下单";//3
	/**
	 * 排队中状态名称
	 */
	public static final String PAI_DUI_ZHONG_TEXT="排队中";//4
	/**
	 * 待入厂状态名称
	 */
	public static final String DAI_RU_CHANG_TEXT="待入厂";//5
	/**
	 * 待检验状态名称
	 */
	public static final String DAI_JIAN_YAN_TEXT="待检验";//6
	/**
	 * 一检待扫码状态名称
	 */
	public static final String YI_JIAN_DAI_SAO_MA_TEXT="一检待扫码";//7
	/**
	 * 一检待上磅状态名称
	 */
	public static final String YI_JIAN_DAI_SHANG_BANG_TEXT="一检待上磅";//8
	/**
	 * 一检中状态名称
	 */
	public static final String YI_JIAN_ZHONG_TEXT="一检中";//9
	/**
	 * 一检待审核状态名称
	 */
	public static final String YI_JIAN_DAI_SHEN_HE_TEXT="一检待审核";//10
	/**
	 * 待装卸货状态名称
	 */
	public static final String DAI_ZHUANG_XIE_HUO_TEXT="待装卸货";//11
	/**
	 * 二检待扫码状态名称
	 */
	public static final String ER_JIAN_DAI_SAO_MA_TEXT="二检待扫码";//12
	/**
	 * 二检待上磅状态名称
	 */
	public static final String ER_JIAN_DAI_SHANG_BANG_TEXT="二检待上磅";//13
	/**
	 * 二检中状态名称
	 */
	public static final String ER_JIAN_ZHONG_TEXT="二检中";//14
	/**
	 * 二检待审核状态名称
	 */
	public static final String ER_JIAN_DAI_SHEN_HE_TEXT="二检待审核";//15
	/**
	 * 待打印凭证状态名称
	 */
	public static final String DAI_DA_YIN_PING_ZHENG_TEXT="待打印凭证";//16
	/**
	 * 待离厂状态名称
	 */
	public static final String DAI_LI_CHANG_TEXT="待离厂";//17
	/**
	 * 已完成状态名称
	 */
	public static final String YI_WAN_CHENG_TEXT="已完成";//18
	/**
	 * 异常状态名称
	 */
	public static final String YI_CHANG_TEXT="异常";//19
	/**
	 * 已废弃状态名称
	 */
	public static final String YI_FEI_QI_TEXT="已废弃";//20
	//订单状态的名称end
	
	public static final String CHECK_SHANG_BANG_TEXT="上磅";
		
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
	private String mc;
	private Integer px;
}
