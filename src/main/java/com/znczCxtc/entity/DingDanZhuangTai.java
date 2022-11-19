package com.znczCxtc.entity;

public class DingDanZhuangTai {
	
	//订单状态的标识start
	public static final int DAI_SHEN_HE=1;//待审核
	public static final int BIAN_JI_ZHONG=2;//编辑中
	public static final int YI_XIA_DAN=3;//已下单
	public static final int PAI_DUI_ZHONG=4;//排队中
	public static final int DAI_RU_CHANG=5;//待入厂
	public static final int DAI_JIAN_YAN=6;//待检验
	public static final int YI_JIAN_DAI_SAO_MA=7;//一检待扫码
	public static final int YI_JIAN_DAI_SHANG_BANG=8;//一检待上磅
	public static final int YI_JIAN_ZHONG=9;//一检中
	public static final int YI_JIAN_DAI_SHEN_HE=10;//一检待审核
	public static final int DAI_ZHUANG_XIE_HUO=11;//待装卸货
	public static final int ER_JIAN_DAI_SAO_MA=12;//二检待扫码
	public static final int ER_JIAN_DAI_SHANG_BANG=13;//二检待上磅
	public static final int ER_JIAN_ZHONG=14;//二检中
	public static final int ER_JIAN_DAI_SHEN_HE=15;//二检待审核
	public static final int DAI_DA_YIN_PING_ZHENG=16;//待打印凭证
	public static final int DAI_LI_CHANG=17;//待离厂
	public static final int YI_WAN_CHENG=18;//已完成
	public static final int YI_CHANG=19;//异常
	public static final int YI_FEI_QI=20;//已废弃
	//订单状态的标识end
	
	//订单状态的名称start
	public static final String DAI_SHEN_HE_TEXT="待审核";//1
	public static final String BIAN_JI_ZHONG_TEXT="编辑中";//2
	public static final String YI_XIA_DAN_TEXT="已下单";//3
	public static final String PAI_DUI_ZHONG_TEXT="排队中";//4
	public static final String DAI_RU_CHANG_TEXT="待入厂";//5
	public static final String DAI_JIAN_YAN_TEXT="待检验";//6
	public static final String YI_JIAN_DAI_SAO_MA_TEXT="一检待扫码";//7
	public static final String YI_JIAN_DAI_SHANG_BANG_TEXT="一检待上磅";//8
	public static final String YI_JIAN_ZHONG_TEXT="一检中";//9
	public static final String YI_JIAN_DAI_SHEN_HE_TEXT="一检待审核";//10
	public static final String DAI_ZHUANG_XIE_HUO_TEXT="待装卸货";//11
	public static final String ER_JIAN_DAI_SAO_MA_TEXT="二检待扫码";//12
	public static final String ER_JIAN_DAI_SHANG_BANG_TEXT="二检待上磅";//13
	public static final String ER_JIAN_ZHONG_TEXT="二检中";//14
	public static final String ER_JIAN_DAI_SHEN_HE_TEXT="二检待审核";//15
	public static final String DAI_DA_YIN_PING_ZHENG_TEXT="待打印凭证";//16
	public static final String DAI_LI_CHANG_TEXT="待离厂";//17
	public static final String YI_WAN_CHENG_TEXT="已完成";//18
	public static final String YI_CHANG_TEXT="异常";//19
	public static final String YI_FEI_QI_TEXT="已废弃";//20
	//订单状态的名称end
		
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
