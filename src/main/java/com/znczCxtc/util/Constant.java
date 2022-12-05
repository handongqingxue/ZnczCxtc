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
	/**
	 * 系统管理模块类名
	 */
	public static final String XTGL_MODULE_NAME="xtgl";
	/**
	 * 导出excel模块类名
	 */
	public static final String EXPORT_EXCEL_MODULE_NAME="exportExcel";

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

	public static final String PUSH_EWM="pushEwm";
	public static final String PUSH_CPH="pushCph";
	public static final String PUSH_SFZH="pushSfzh";
	
	public static final int DANG_QIAN_YE=1;
	public static final int SUO_YOU_YE=2;
	
	public static final String DANG_QIAN_YE_TEXT="当前页";
	public static final String SUO_YOU_YE_TEXT="所有页";
	
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
	
	/**
	 * 存放过磅记录过磅状态常量
	 * @param request
	 */
	public static void setGbjlGbztInRequest(HttpServletRequest request) {

		request.setAttribute("zcGbzt", GuoBangJiLu.ZHENG_CHANG);
		request.setAttribute("ycGbzt", GuoBangJiLu.YI_CHANG);
		
		request.setAttribute("zcGbztMc", GuoBangJiLu.ZHENG_CHANG_TEXT);
		request.setAttribute("ycgbztMc", GuoBangJiLu.YI_CHANG_TEXT);
	}
	
	/**
	 * 存放订单审核结果常量
	 * @param request
	 */
	public static void setDdShjgInRequest(HttpServletRequest request) {

		request.setAttribute("hgShjg", DingDanShenHeJiLu.HE_GE);
		request.setAttribute("bhgShjg", DingDanShenHeJiLu.BU_HE_GE);
		
		request.setAttribute("hgShjgMc", DingDanShenHeJiLu.HE_GE_TEXT);
		request.setAttribute("bhgShjgMc", DingDanShenHeJiLu.BU_HE_GE_TEXT);
	}
	
	/**
	 * 存放司机审核结果常量
	 * @param request
	 */
	public static void setSjShjgInRequest(HttpServletRequest request) {

		request.setAttribute("hgShjg", SiJiShenHeJiLu.HE_GE);
		request.setAttribute("bhgShjg", SiJiShenHeJiLu.BU_HE_GE);
		
		request.setAttribute("hgShjgMc", SiJiShenHeJiLu.HE_GE_TEXT);
		request.setAttribute("bhgShjgMc", SiJiShenHeJiLu.BU_HE_GE_TEXT);
	}
	
	/**
	 * 存放车辆审核结果常量
	 * @param request
	 */
	public static void setClShjgInRequest(HttpServletRequest request) {

		request.setAttribute("hgShjg", CheLiangShenHeJiLu.HE_GE);
		request.setAttribute("bhgShjg", CheLiangShenHeJiLu.BU_HE_GE);
		
		request.setAttribute("hgShjgMc", CheLiangShenHeJiLu.HE_GE_TEXT);
		request.setAttribute("bhgShjgMc", CheLiangShenHeJiLu.BU_HE_GE_TEXT);
	}
	
	/**
	 * 存放车辆排放阶段常量
	 * @param request
	 */
	public static void setClPfjdInRequest(HttpServletRequest request) {

		request.setAttribute("gwryPfjd", CheLiang.GUO_WU_RAN_YOU);
		request.setAttribute("gwrqPfjd", CheLiang.GUO_WU_RAN_QI);
		request.setAttribute("glryPfjd", CheLiang.GUO_LIU_RAN_YOU);
		request.setAttribute("glrqPfjd", CheLiang.GUO_LIU_RAN_QI);
		request.setAttribute("ddPfjd", CheLiang.DIAN_DONG);
		
		request.setAttribute("gwryPfjdMc", CheLiang.GUO_WU_RAN_YOU_TEXT);
		request.setAttribute("gwrqPfjdMc", CheLiang.GUO_WU_RAN_QI_TEXT);
		request.setAttribute("glryPfjdMc", CheLiang.GUO_LIU_RAN_YOU_TEXT);
		request.setAttribute("glrqPfjdMc", CheLiang.GUO_LIU_RAN_QI_TEXT);
		request.setAttribute("ddPfjdMc", CheLiang.DIAN_DONG_TEXT);
	}
	
	/**
	 * 存放订单过磅状态常量
	 * @param request
	 */
	public static void setDdGbztInRequest(HttpServletRequest request) {
		
		request.setAttribute("dsbGbzt", DingDan.DAI_SHANG_BANG);
		request.setAttribute("sbzGbzt", DingDan.SHANG_BANG_ZHONG);
		request.setAttribute("dczGbzt", DingDan.DAI_CHENG_ZHONG);
		request.setAttribute("czzGbzt", DingDan.CHENG_ZHONG_ZHONG);
		request.setAttribute("dxbGbzt", DingDan.DAI_XIA_BANG);
		request.setAttribute("xbzGbzt", DingDan.XIA_BANG_ZHONG);
		request.setAttribute("ywcGbzt", DingDan.YI_WAN_CHENG);
		
		request.setAttribute("dsbGbztMc", DingDan.DAI_SHANG_BANG_TEXT);
		request.setAttribute("sbzGbztMc", DingDan.SHANG_BANG_ZHONG_TEXT);
		request.setAttribute("dczGbztMc", DingDan.DAI_CHENG_ZHONG_TEXT);
		request.setAttribute("czzGbztMc", DingDan.CHENG_ZHONG_ZHONG_TEXT);
		request.setAttribute("dxbGbztMc", DingDan.DAI_XIA_BANG_TEXT);
		request.setAttribute("xbzGbztMc", DingDan.XIA_BANG_ZHONG_TEXT);
		request.setAttribute("ywcGbztMc", DingDan.YI_WAN_CHENG_TEXT);
	}
	
	/**
	 * 存放号码分类常量
	 * @param request
	 */
	public static void setHmFlInRequest(HttpServletRequest request) {
		
		request.setAttribute("ptFl", HaoMa.PU_TONG);
		request.setAttribute("qtFl", HaoMa.QI_TA);

		request.setAttribute("ptFlMc", HaoMa.PU_TONG_TEXT);
		request.setAttribute("qtFlMc", HaoMa.QI_TA_TEXT);
	}
	
	/**
	 * 存放地点常量
	 * @param request
	 */
	public static void setPlaceInRequest(HttpServletRequest request) {

		request.setAttribute("wgb", Constant.WEI_GUO_BANG);
		request.setAttribute("yhbf", Constant.YI_HAO_BANG_FANG);
		request.setAttribute("ehbf", Constant.ER_HAO_BANG_FANG);
		request.setAttribute("shbf", Constant.SAN_HAO_BANG_FANG);
		request.setAttribute("mg", Constant.MEN_GANG);

		request.setAttribute("wgbMc", Constant.WEI_GUO_BANG_TEXT);
		request.setAttribute("yhbfMc", Constant.YI_HAO_BANG_FANG_TEXT);
		request.setAttribute("ehbfMc", Constant.ER_HAO_BANG_FANG_TEXT);
		request.setAttribute("shbfMc", Constant.SAN_HAO_BANG_FANG_TEXT);
		request.setAttribute("mgMc", Constant.MEN_GANG_TEXT);
	}
	
	/**
	 * 存放推送类型常量
	 * @param request
	 */
	public static void setPushInRequest(HttpServletRequest request) {

		request.setAttribute("pushSfzh", Constant.PUSH_SFZH);
		request.setAttribute("pushCph", Constant.PUSH_CPH);
		request.setAttribute("pushEwm", Constant.PUSH_EWM);
	}
	
	/**
	 * 队列叫号形式常量
	 * @param request
	 */
	public static void setDLJhxsInRequest(HttpServletRequest request) {

		request.setAttribute("zdjhJhxs", DuiLie.ZI_DONG_JIAO_HAO);
		request.setAttribute("sdjhJhxs", DuiLie.SHOU_DONG_JIAO_HAO);
		
		request.setAttribute("zdjhJhxsMc", DuiLie.ZI_DONG_JIAO_HAO_TEXT);
		request.setAttribute("sdjhJhxsMc", DuiLie.SHOU_DONG_JIAO_HAO_TEXT);
	}
	
	/**
	 * 存放队列状态常量
	 * @param request
	 */
	public static void setDLZtInRequest(HttpServletRequest request) {
		
		request.setAttribute("zyZt", DuiLie.ZAI_YONG);
		request.setAttribute("ztZt", DuiLie.ZAN_TING);
		request.setAttribute("fqZt", DuiLie.FEI_QI);
		
		request.setAttribute("zyZtMc", DuiLie.ZAI_YONG_TEXT);
		request.setAttribute("ztZtMc", DuiLie.ZAN_TING_TEXT);
		request.setAttribute("fqZtMc", DuiLie.FEI_QI_TEXT);
	}
	
	/**
	 * 存放司机审核状态常量
	 * @param request
	 */
	public static void setSjShztInRequest(HttpServletRequest request) {
		
		request.setAttribute("dshShzt", SiJi.DAI_SHEN_HE);
		request.setAttribute("shtgShzt", SiJi.SHEN_HE_TONG_GUO);
		request.setAttribute("bjzShzt", SiJi.BIAN_JI_ZHONG);
		
		request.setAttribute("dshShztMc", SiJi.DAI_SHEN_HE_TEXT);
		request.setAttribute("shtgShztMc", SiJi.SHEN_HE_TONG_GUO_TEXT);
		request.setAttribute("bjzShztMc", SiJi.BIAN_JI_ZHONG_TEXT);
	}
	
	/**
	 * 存放车辆审核状态常量
	 * @param request
	 */
	public static void setClShztInRequest(HttpServletRequest request) {
		
		request.setAttribute("dshShzt", CheLiang.DAI_SHEN_HE);
		request.setAttribute("shtgShzt", CheLiang.SHEN_HE_TONG_GUO);
		request.setAttribute("bjzShzt", CheLiang.BIAN_JI_ZHONG);
		
		request.setAttribute("dshShztMc", CheLiang.DAI_SHEN_HE_TEXT);
		request.setAttribute("shtgShztMc", CheLiang.SHEN_HE_TONG_GUO_TEXT);
		request.setAttribute("bjzShztMc", CheLiang.BIAN_JI_ZHONG_TEXT);
	}
	
	/**
	 * 存放司机在用状态常量
	 * @param request
	 */
	public static void setSjZyztInRequest(HttpServletRequest request) {

		request.setAttribute("shiZyzt", SiJi.SHI);
		request.setAttribute("fouZyzt", SiJi.FOU);
		
		request.setAttribute("shiZyztMc", SiJi.SHI_TEXT);
		request.setAttribute("fouZyztMc", SiJi.FOU_TEXT);
	}
	
	/**
	 * 存放车辆是否在用常量
	 * @param request
	 */
	public static void setClSfzyInRequest(HttpServletRequest request) {

		request.setAttribute("shiSfzy", CheLiang.SHI);
		request.setAttribute("fouSfzy", CheLiang.FOU);
		
		request.setAttribute("shiSfzyMc", CheLiang.SHI_TEXT);
		request.setAttribute("fouSfzyMc", CheLiang.FOU_TEXT);
	}
	
	/**
	 * 存放导出范围常量
	 * @param request
	 */
	public static void setDcfwInRequest(HttpServletRequest request) {

		request.setAttribute("dqyDcfw", DANG_QIAN_YE);
		request.setAttribute("syyDcfw", SUO_YOU_YE);
		
		request.setAttribute("dqyDcfwMc", DANG_QIAN_YE_TEXT);
		request.setAttribute("syyDcfwMc", SUO_YOU_YE_TEXT);
	}
	
	/**
	 * 根据流向类型id获取流向类型名称
	 * @param lxlxId
	 * @return
	 */
	public static String getLxlxMcById(int lxlxId) {
		String lxlxMc=null;
		switch (lxlxId) {
		case DingDan.SONG_YUN:
			lxlxMc=DingDan.SONG_YUN_TEXT;
			break;
		case DingDan.QU_YUN:
			lxlxMc=DingDan.QU_YUN_TEXT;
			break;
		}
		return lxlxMc;
	}

	/**
	 * 根据订单过磅状态id获取过磅状态名称
	 * @param gbztId
	 * @return
	 */
	public static String getDdGbztMcById(int gbztId){
		String gbztMc=null;
		switch (gbztId) {
		case DingDan.DAI_SHANG_BANG:
			gbztMc=DingDan.DAI_SHANG_BANG_TEXT;//待上磅
			break;
		case DingDan.SHANG_BANG_ZHONG:
			gbztMc=DingDan.SHANG_BANG_ZHONG_TEXT;//上磅中
			break;
		case DingDan.DAI_CHENG_ZHONG:
			gbztMc=DingDan.DAI_CHENG_ZHONG_TEXT;//待称重
			break;
		case DingDan.CHENG_ZHONG_ZHONG:
			gbztMc=DingDan.CHENG_ZHONG_ZHONG_TEXT;//称重中
			break;
		case DingDan.DAI_XIA_BANG:
			gbztMc=DingDan.DAI_XIA_BANG_TEXT;//待下磅
			break;
		case DingDan.XIA_BANG_ZHONG:
			gbztMc=DingDan.XIA_BANG_ZHONG_TEXT;//下磅中
			break;
		case DingDan.YI_WAN_CHENG:
			gbztMc=DingDan.YI_WAN_CHENG_TEXT;//已完成
			break;
		}
		return gbztMc;
	}

	/**
	 * 根据磅房号获取磅房名称
	 * @param bfh
	 * @return
	 */
	public static String getBfMcByBfh(int bfh){
		String bfMc=null;
		switch (bfh) {
		case Constant.WEI_GUO_BANG:
			bfMc=Constant.WEI_GUO_BANG_TEXT;
			break;
		case Constant.YI_HAO_BANG_FANG:
			bfMc=Constant.YI_HAO_BANG_FANG_TEXT;
			break;
		case Constant.ER_HAO_BANG_FANG:
			bfMc=Constant.ER_HAO_BANG_FANG_TEXT;
			break;
		case Constant.SAN_HAO_BANG_FANG:
			bfMc=Constant.SAN_HAO_BANG_FANG_TEXT;
			break;
		}
		return bfMc;
	}

	/**
	 * 根据审核类型id获取审核类型名称
	 * @param shlxId
	 * @return
	 */
	public static String getDdShlxMcById(int shlxId){
		String shlxMc=null;
		switch (shlxId) {
		case DingDanShenHeJiLu.XIA_DAN_SHEN_HE:
			shlxMc=DingDanShenHeJiLu.XIA_DAN_SHEN_HE_TEXT;//下单审核
			break;
		case DingDanShenHeJiLu.ZHI_JIAN_SHEN_HE:
			shlxMc=DingDanShenHeJiLu.ZHI_JIAN_SHEN_HE_TEXT;//质检审核
			break;
		case DingDanShenHeJiLu.YI_JIAN_SHEN_HE:
			shlxMc=DingDanShenHeJiLu.YI_JIAN_SHEN_HE_TEXT;//一检审核
			break;
		case DingDanShenHeJiLu.RU_KU_SHEN_HE:
			shlxMc=DingDanShenHeJiLu.RU_KU_SHEN_HE_TEXT;//入库审核
			break;
		case DingDanShenHeJiLu.ER_JIAN_SHEN_HE:
			shlxMc=DingDanShenHeJiLu.ER_JIAN_SHEN_HE_TEXT;//二检审核
			break;
		}
		return shlxMc;
	}
	
	/**
	 * 根据订单审核标识，判断审核是否合格
	 * @param shjg
	 * @return
	 */
	public static String getDdShjgMcByJg(boolean shjg){
		String shjgMc=null;
		if(DingDanShenHeJiLu.HE_GE)
			shjgMc=DingDanShenHeJiLu.HE_GE_TEXT;//合格
		else
			shjgMc=DingDanShenHeJiLu.BU_HE_GE_TEXT;//不合格
		return shjgMc;
	}

	/**
	 * 根据过磅记录过磅状态id获取过磅状态名称
	 * @param gbztId
	 * @return
	 */
	public static String getGbjlGbztMcById(int gbztId){
		String gbztMc=null;
		switch (gbztId) {
		case GuoBangJiLu.ZHENG_CHANG:
			gbztMc=GuoBangJiLu.ZHENG_CHANG_TEXT;//正常
			break;
		case GuoBangJiLu.YI_CHANG:
			gbztMc=GuoBangJiLu.YI_CHANG_TEXT;//异常
			break;
		}
		return gbztMc;
	}
	
	/**
	 * 根据排放阶段id获取排放阶段名称
	 * @param pfjdId
	 * @return
	 */
	public static String getPfjdMcById(int pfjdId){
		String pfjdMc=null;
		switch (pfjdId) {
		case CheLiang.GUO_WU_RAN_YOU:
			pfjdMc=CheLiang.GUO_WU_RAN_YOU_TEXT;//国五燃油
			break;
		case CheLiang.GUO_WU_RAN_QI:
			pfjdMc=CheLiang.GUO_WU_RAN_QI_TEXT;//国五燃气
			break;
		case CheLiang.GUO_LIU_RAN_YOU:
			pfjdMc=CheLiang.GUO_LIU_RAN_YOU_TEXT;//国六燃油
			break;
		case CheLiang.GUO_LIU_RAN_QI:
			pfjdMc=CheLiang.GUO_LIU_RAN_QI_TEXT;//国六燃气
			break;
		case CheLiang.DIAN_DONG:
			pfjdMc=CheLiang.DIAN_DONG_TEXT;//电动
			break;
		}
		return pfjdMc;
	}
	
	/**
	 * 根据审核状态id获取审核状态名称
	 * @param shztId
	 * @return
	 */
	public static String getCLShztMcById(int shztId){
		String shztMc=null;
		switch (shztId) {
		case CheLiang.DAI_SHEN_HE:
			shztMc=CheLiang.DAI_SHEN_HE_TEXT;//待审核
			break;
		case CheLiang.SHEN_HE_TONG_GUO:
			shztMc=CheLiang.SHEN_HE_TONG_GUO_TEXT;//审核通过
			break;
		case CheLiang.BIAN_JI_ZHONG:
			shztMc=CheLiang.BIAN_JI_ZHONG_TEXT;//编辑中
			break;
		}
		return shztMc;
	}
	
	public static String getSJShztMcById(int shztId){
		String shztMc=null;
		switch (shztId) {
		case SiJi.DAI_SHEN_HE:
			shztMc=SiJi.DAI_SHEN_HE_TEXT;//待审核
			break;
		case SiJi.SHEN_HE_TONG_GUO:
			shztMc=SiJi.SHEN_HE_TONG_GUO_TEXT;//审核通过
			break;
		case SiJi.BIAN_JI_ZHONG:
			shztMc=SiJi.BIAN_JI_ZHONG_TEXT;//编辑中
			break;
		}
		return shztMc;
	}
	
	public static String getSJZyztMcById(boolean zyzt) {
		return zyzt==SiJi.SHI?SiJi.SHI_TEXT:SiJi.FOU_TEXT;
	}
	
	public static String getSJShjgMcById(boolean shjg) {
		return shjg==SiJi.HE_GE?SiJi.HE_GE_TEXT:SiJi.BU_HE_GE_TEXT;
	}
	
	public static String getCLSfzyMcById(boolean sfzy) {
		return sfzy==CheLiang.SHI?CheLiang.SHI_TEXT:CheLiang.FOU_TEXT;
	}
	
	public static String getCLShjgMcById(boolean shjg) {
		return shjg==CheLiang.HE_GE?CheLiang.HE_GE_TEXT:CheLiang.BU_HE_GE_TEXT;
	}
	
	public static String getHMFlMcById(int flId) {
		String flMc=null;
		switch (flId) {
		case HaoMa.PU_TONG:
			flMc=HaoMa.PU_TONG_TEXT;//普通
			break;
		case HaoMa.QI_TA:
			flMc=HaoMa.QI_TA_TEXT;//其他
			break;
		}
		return flMc;
	}
	
	public static String getDLJhxsMcById(int jhxsId) {
		String jhxsMc=null;
		switch (jhxsId) {
		case DuiLie.ZI_DONG_JIAO_HAO:
			jhxsMc=DuiLie.ZI_DONG_JIAO_HAO_TEXT;//自动叫号
			break;
		case DuiLie.SHOU_DONG_JIAO_HAO:
			jhxsMc=DuiLie.SHOU_DONG_JIAO_HAO_TEXT;//手动叫号
			break;
		}
		return jhxsMc;
	}
	
	public static String getDLZtMcById(int ztId) {
		String ztMc=null;
		switch (ztId) {
		case DuiLie.ZAI_YONG:
			ztMc=DuiLie.ZAI_YONG_TEXT;//在用
			break;
		case DuiLie.ZAN_TING:
			ztMc=DuiLie.ZAN_TING_TEXT;//暂停
			break;
		case DuiLie.FEI_QI:
			ztMc=DuiLie.FEI_QI_TEXT;//废弃
			break;
		}
		return ztMc;
	}
}
