package com.znczCxtc.util;

import javax.servlet.http.HttpServletRequest;

import com.znczCxtc.entity.*;

public class Constant {

	/**
	 * 工控机模块类名
	 */
	public static final String GKJ_MODULE_NAME="gkj";
	/**
	 * 登录、注销模块类名
	 */
	public static final String MAIN_MODULE_NAME="main";
	/**
	 * 订单管理模块类名
	 */
	public static final String DDGL_MODULE_NAME="ddgl";
	/**
	 * 车辆管理模块类名
	 */
	public static final String CLGL_MODULE_NAME="clgl";
	/**
	 * 单位管理模块类名
	 */
	public static final String DWGL_MODULE_NAME="dwgl";
	/**
	 * 排队管理模块类名
	 */
	public static final String PDGL_MODULE_NAME="pdgl";
	/**
	 * 司机管理模块类名
	 */
	public static final String SJGL_MODULE_NAME="sjgl";
	/**
	 * 物资管理模块类名
	 */
	public static final String WZGL_MODULE_NAME="wzgl";
	/**
	 * 过磅管理模块类名
	 */
	public static final String GBGL_MODULE_NAME="gbgl";

	//地点标识start
	public static final int WEI_GUO_BANG=0;
	public static final int YI_HAO_BANG_FANG=1;
	public static final int ER_HAO_BANG_FANG=2;
	public static final int SAN_HAO_BANG_FANG=3;
	public static final int MEN_GANG=4;

	public static final String WEI_GUO_BANG_TEXT="未过磅";
	public static final String YI_HAO_BANG_FANG_TEXT="一号磅房";
	public static final String ER_HAO_BANG_FANG_TEXT="二号磅房";
	public static final String SAN_HAO_BANG_FANG_TEXT="三号磅房";
	public static final String MEN_GANG_TEXT="门岗";
	//地点标识end
	
	public static final String PUSH_CPH="pushCph";
	public static final String PUSH_SFZH="pushSfzh";
	
	/**
	 * 存放订单状态常量
	 * @param request
	 */
	public static void setDdztInRequest(HttpServletRequest request) {
		
		request.setAttribute("dshDdzt", DingDanZhuangTai.DAI_SHEN_HE);//待审核
		request.setAttribute("bjzDdzt", DingDanZhuangTai.BIAN_JI_ZHONG);//编辑中
		request.setAttribute("yxdDdzt", DingDanZhuangTai.YI_XIA_DAN);//已下单
		request.setAttribute("pdzDdzt", DingDanZhuangTai.PAI_DUI_ZHONG);//排队中
		request.setAttribute("drcDdzt", DingDanZhuangTai.DAI_RU_CHANG);//待入厂
		request.setAttribute("djyDdzt", DingDanZhuangTai.DAI_JIAN_YAN);//待检验
		request.setAttribute("yjdsmDdzt", DingDanZhuangTai.YI_JIAN_DAI_SAO_MA);//一检待扫码
		request.setAttribute("yjdsbDdzt", DingDanZhuangTai.YI_JIAN_DAI_SHANG_BANG);//一检待上磅
		request.setAttribute("yjzDdzt", DingDanZhuangTai.YI_JIAN_ZHONG);//一检中
		request.setAttribute("yjdshDdzt", DingDanZhuangTai.YI_JIAN_DAI_SHEN_HE);//一检待审核
		request.setAttribute("dzxhDdzt", DingDanZhuangTai.DAI_ZHUANG_XIE_HUO);//待装卸货
		request.setAttribute("ejdsmDdzt", DingDanZhuangTai.ER_JIAN_DAI_SAO_MA);//二检待扫码
		request.setAttribute("ejdsbDdzt", DingDanZhuangTai.ER_JIAN_DAI_SHANG_BANG);//二检待上磅
		request.setAttribute("ejzDdzt", DingDanZhuangTai.ER_JIAN_ZHONG);//二检中
		request.setAttribute("ejdshDdzt", DingDanZhuangTai.ER_JIAN_DAI_SHEN_HE);//二检待审核
		request.setAttribute("ddypzDdzt", DingDanZhuangTai.DAI_DA_YIN_PING_ZHENG);//待打印凭证
		request.setAttribute("dlcDdzt", DingDanZhuangTai.DAI_LI_CHANG);//待离厂
		request.setAttribute("ywcDdzt", DingDanZhuangTai.YI_WAN_CHENG);//已完成
		request.setAttribute("ycDdzt", DingDanZhuangTai.YI_CHANG);//异常
		request.setAttribute("yfqDdzt", DingDanZhuangTai.YI_FEI_QI);//已废弃

		request.setAttribute("dshDdztMc", DingDanZhuangTai.DAI_SHEN_HE_TEXT);//待审核
		request.setAttribute("bjzDdztMc", DingDanZhuangTai.BIAN_JI_ZHONG_TEXT);//编辑中
		request.setAttribute("yxdDdztMc", DingDanZhuangTai.YI_XIA_DAN_TEXT);//已下单
		request.setAttribute("pdzDdztMc", DingDanZhuangTai.PAI_DUI_ZHONG_TEXT);//排队中
		request.setAttribute("drcDdztMc", DingDanZhuangTai.DAI_RU_CHANG_TEXT);//待入厂
		request.setAttribute("djyDdztMc", DingDanZhuangTai.DAI_JIAN_YAN_TEXT);//待检验
		request.setAttribute("yjdsmDdztMc", DingDanZhuangTai.YI_JIAN_DAI_SAO_MA_TEXT);//一检待扫码
		request.setAttribute("yjdsbDdztMc", DingDanZhuangTai.YI_JIAN_DAI_SHANG_BANG_TEXT);//一检待上磅
		request.setAttribute("yjzDdztMc", DingDanZhuangTai.YI_JIAN_ZHONG_TEXT);//一检中
		request.setAttribute("yjdshDdztMc", DingDanZhuangTai.YI_JIAN_DAI_SHEN_HE_TEXT);//一检待审核
		request.setAttribute("dzxhDdztMc", DingDanZhuangTai.DAI_ZHUANG_XIE_HUO_TEXT);//待装卸货
		request.setAttribute("ejdsmDdztMc", DingDanZhuangTai.ER_JIAN_DAI_SAO_MA_TEXT);//二检待扫码
		request.setAttribute("ejdsbDdztMc", DingDanZhuangTai.ER_JIAN_DAI_SHANG_BANG_TEXT);//二检待上磅
		request.setAttribute("ejzDdztMc", DingDanZhuangTai.ER_JIAN_ZHONG_TEXT);//二检中
		request.setAttribute("ejdshDdztMc", DingDanZhuangTai.ER_JIAN_DAI_SHEN_HE_TEXT);//二检待审核
		request.setAttribute("ddypzDdztMc", DingDanZhuangTai.DAI_DA_YIN_PING_ZHENG_TEXT);//待打印凭证
		request.setAttribute("dlcDdztMc", DingDanZhuangTai.DAI_LI_CHANG_TEXT);//待离厂
		request.setAttribute("ywcDdztMc", DingDanZhuangTai.YI_WAN_CHENG_TEXT);//已完成
		request.setAttribute("ycDdztMc", DingDanZhuangTai.YI_CHANG_TEXT);//异常
		request.setAttribute("yfqDdztMc", DingDanZhuangTai.YI_FEI_QI_TEXT);//已废弃
		
	}
	
	/**
	 * 存放审核类型常量
	 * @param request
	 */
	public static void setShlxInRequest(HttpServletRequest request) {

		request.setAttribute("xdshShlx", DingDanShenHeJiLu.XIA_DAN_SHEN_HE);
		request.setAttribute("zjshShlx", DingDanShenHeJiLu.ZHI_JIAN_SHEN_HE);
		request.setAttribute("yjshShlx", DingDanShenHeJiLu.YI_JIAN_SHEN_HE);
		request.setAttribute("rkshShlx", DingDanShenHeJiLu.RU_KU_SHEN_HE);
		request.setAttribute("ejshShlx", DingDanShenHeJiLu.ER_JIAN_SHEN_HE);
		
		request.setAttribute("xdshShlxMc", DingDanShenHeJiLu.XIA_DAN_SHEN_HE_TEXT);
		request.setAttribute("zjshShlxMc", DingDanShenHeJiLu.ZHI_JIAN_SHEN_HE_TEXT);
		request.setAttribute("yjshShlxMc", DingDanShenHeJiLu.YI_JIAN_SHEN_HE_TEXT);
		request.setAttribute("rkshShlxMc", DingDanShenHeJiLu.RU_KU_SHEN_HE_TEXT);
		request.setAttribute("ejshShlxMc", DingDanShenHeJiLu.ER_JIAN_SHEN_HE_TEXT);
	}
	
	/**
	 * 存放过磅类型常量
	 * @param request
	 */
	public static void setGblxInRequest(HttpServletRequest request) {

		request.setAttribute("rcgbGblx", GuoBangJiLu.RU_CHANG_GUO_BANG);
		request.setAttribute("ccgbGblx", GuoBangJiLu.CHU_CHANG_GUO_BANG);

		request.setAttribute("rcgbGblxMc", GuoBangJiLu.RU_CHANG_GUO_BANG_TEXT);
		request.setAttribute("ccgbGblxMc", GuoBangJiLu.CHU_CHANG_GUO_BANG_TEXT);
	}
	
	/**
	 * 存放流向类型常量
	 * @param request
	 */
	public static void setLxlxInRequest(HttpServletRequest request) {

		request.setAttribute("syLxlx", DingDan.SONG_YUN);
		request.setAttribute("qyLxlx", DingDan.QU_YUN);
		
		request.setAttribute("syLxlxMc", DingDan.SONG_YUN_TEXT);
		request.setAttribute("qyLxlxMc", DingDan.QU_YUN_TEXT);
	}
	
	public static void setGbztInRequest(HttpServletRequest request) {

		request.setAttribute("zcGbzt", GuoBangJiLu.ZHENG_CHANG);
		request.setAttribute("ycGbzt", GuoBangJiLu.YI_CHANG);
		
		request.setAttribute("zcGbztMc", GuoBangJiLu.ZHENG_CHANG_TEXT);
		request.setAttribute("ycgbztMc", GuoBangJiLu.YI_CHANG_TEXT);
	}
}
