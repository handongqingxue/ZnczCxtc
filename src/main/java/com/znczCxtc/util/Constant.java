package com.znczCxtc.util;

import javax.servlet.http.HttpServletRequest;

import com.znczCxtc.entity.*;

public class Constant {

	/**
	 * ���ػ�ģ������
	 */
	public static final String GKJ_MODULE_NAME="gkj";
	/**
	 * ��¼��ע��ģ������
	 */
	public static final String MAIN_MODULE_NAME="main";
	/**
	 * ��������ģ������
	 */
	public static final String DDGL_MODULE_NAME="ddgl";
	/**
	 * ��������ģ������
	 */
	public static final String CLGL_MODULE_NAME="clgl";
	/**
	 * ��λ����ģ������
	 */
	public static final String DWGL_MODULE_NAME="dwgl";
	/**
	 * �Ŷӹ���ģ������
	 */
	public static final String PDGL_MODULE_NAME="pdgl";
	/**
	 * ˾������ģ������
	 */
	public static final String SJGL_MODULE_NAME="sjgl";
	/**
	 * ���ʹ���ģ������
	 */
	public static final String WZGL_MODULE_NAME="wzgl";
	/**
	 * ��������ģ������
	 */
	public static final String GBGL_MODULE_NAME="gbgl";
	/**
	 * ϵͳ����ģ������
	 */
	public static final String XTGL_MODULE_NAME="xtgl";
	/**
	 * ����excelģ������
	 */
	public static final String EXPORT_EXCEL_MODULE_NAME="exportExcel";

	//�ص��ʶstart
	public static final int WEI_GUO_BANG=0;
	public static final int YI_HAO_BANG_FANG=1;
	public static final int ER_HAO_BANG_FANG=2;
	public static final int SAN_HAO_BANG_FANG=3;
	public static final int MEN_GANG=4;

	public static final String WEI_GUO_BANG_TEXT="δ����";
	public static final String YI_HAO_BANG_FANG_TEXT="һ�Ű���";
	public static final String ER_HAO_BANG_FANG_TEXT="���Ű���";
	public static final String SAN_HAO_BANG_FANG_TEXT="���Ű���";
	public static final String MEN_GANG_TEXT="�Ÿ�";
	//�ص��ʶend

	public static final String PUSH_EWM="pushEwm";
	public static final String PUSH_CPH="pushCph";
	public static final String PUSH_SFZH="pushSfzh";
	
	public static final int DANG_QIAN_YE=1;
	public static final int SUO_YOU_YE=2;
	
	public static final String DANG_QIAN_YE_TEXT="��ǰҳ";
	public static final String SUO_YOU_YE_TEXT="����ҳ";
	
	/**
	 * ��Ŷ���״̬����
	 * @param request
	 */
	public static void setDdztInRequest(HttpServletRequest request) {
		
		request.setAttribute("dshDdzt", DingDanZhuangTai.DAI_SHEN_HE);//�����
		request.setAttribute("bjzDdzt", DingDanZhuangTai.BIAN_JI_ZHONG);//�༭��
		request.setAttribute("yxdDdzt", DingDanZhuangTai.YI_XIA_DAN);//���µ�
		request.setAttribute("pdzDdzt", DingDanZhuangTai.PAI_DUI_ZHONG);//�Ŷ���
		request.setAttribute("drcDdzt", DingDanZhuangTai.DAI_RU_CHANG);//���볧
		request.setAttribute("djyDdzt", DingDanZhuangTai.DAI_JIAN_YAN);//������
		request.setAttribute("yjdsmDdzt", DingDanZhuangTai.YI_JIAN_DAI_SAO_MA);//һ���ɨ��
		request.setAttribute("yjdsbDdzt", DingDanZhuangTai.YI_JIAN_DAI_SHANG_BANG);//һ����ϰ�
		request.setAttribute("yjzDdzt", DingDanZhuangTai.YI_JIAN_ZHONG);//һ����
		request.setAttribute("yjdshDdzt", DingDanZhuangTai.YI_JIAN_DAI_SHEN_HE);//һ������
		request.setAttribute("dzxhDdzt", DingDanZhuangTai.DAI_ZHUANG_XIE_HUO);//��װж��
		request.setAttribute("ejdsmDdzt", DingDanZhuangTai.ER_JIAN_DAI_SAO_MA);//�����ɨ��
		request.setAttribute("ejdsbDdzt", DingDanZhuangTai.ER_JIAN_DAI_SHANG_BANG);//������ϰ�
		request.setAttribute("ejzDdzt", DingDanZhuangTai.ER_JIAN_ZHONG);//������
		request.setAttribute("ejdshDdzt", DingDanZhuangTai.ER_JIAN_DAI_SHEN_HE);//��������
		request.setAttribute("ddypzDdzt", DingDanZhuangTai.DAI_DA_YIN_PING_ZHENG);//����ӡƾ֤
		request.setAttribute("dlcDdzt", DingDanZhuangTai.DAI_LI_CHANG);//���볧
		request.setAttribute("ywcDdzt", DingDanZhuangTai.YI_WAN_CHENG);//�����
		request.setAttribute("ycDdzt", DingDanZhuangTai.YI_CHANG);//�쳣
		request.setAttribute("yfqDdzt", DingDanZhuangTai.YI_FEI_QI);//�ѷ���

		request.setAttribute("dshDdztMc", DingDanZhuangTai.DAI_SHEN_HE_TEXT);//�����
		request.setAttribute("bjzDdztMc", DingDanZhuangTai.BIAN_JI_ZHONG_TEXT);//�༭��
		request.setAttribute("yxdDdztMc", DingDanZhuangTai.YI_XIA_DAN_TEXT);//���µ�
		request.setAttribute("pdzDdztMc", DingDanZhuangTai.PAI_DUI_ZHONG_TEXT);//�Ŷ���
		request.setAttribute("drcDdztMc", DingDanZhuangTai.DAI_RU_CHANG_TEXT);//���볧
		request.setAttribute("djyDdztMc", DingDanZhuangTai.DAI_JIAN_YAN_TEXT);//������
		request.setAttribute("yjdsmDdztMc", DingDanZhuangTai.YI_JIAN_DAI_SAO_MA_TEXT);//һ���ɨ��
		request.setAttribute("yjdsbDdztMc", DingDanZhuangTai.YI_JIAN_DAI_SHANG_BANG_TEXT);//һ����ϰ�
		request.setAttribute("yjzDdztMc", DingDanZhuangTai.YI_JIAN_ZHONG_TEXT);//һ����
		request.setAttribute("yjdshDdztMc", DingDanZhuangTai.YI_JIAN_DAI_SHEN_HE_TEXT);//һ������
		request.setAttribute("dzxhDdztMc", DingDanZhuangTai.DAI_ZHUANG_XIE_HUO_TEXT);//��װж��
		request.setAttribute("ejdsmDdztMc", DingDanZhuangTai.ER_JIAN_DAI_SAO_MA_TEXT);//�����ɨ��
		request.setAttribute("ejdsbDdztMc", DingDanZhuangTai.ER_JIAN_DAI_SHANG_BANG_TEXT);//������ϰ�
		request.setAttribute("ejzDdztMc", DingDanZhuangTai.ER_JIAN_ZHONG_TEXT);//������
		request.setAttribute("ejdshDdztMc", DingDanZhuangTai.ER_JIAN_DAI_SHEN_HE_TEXT);//��������
		request.setAttribute("ddypzDdztMc", DingDanZhuangTai.DAI_DA_YIN_PING_ZHENG_TEXT);//����ӡƾ֤
		request.setAttribute("dlcDdztMc", DingDanZhuangTai.DAI_LI_CHANG_TEXT);//���볧
		request.setAttribute("ywcDdztMc", DingDanZhuangTai.YI_WAN_CHENG_TEXT);//�����
		request.setAttribute("ycDdztMc", DingDanZhuangTai.YI_CHANG_TEXT);//�쳣
		request.setAttribute("yfqDdztMc", DingDanZhuangTai.YI_FEI_QI_TEXT);//�ѷ���
		
	}
	
	/**
	 * ���������ͳ���
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
	 * ��Ź������ͳ���
	 * @param request
	 */
	public static void setGblxInRequest(HttpServletRequest request) {

		request.setAttribute("rcgbGblx", GuoBangJiLu.RU_CHANG_GUO_BANG);
		request.setAttribute("ccgbGblx", GuoBangJiLu.CHU_CHANG_GUO_BANG);

		request.setAttribute("rcgbGblxMc", GuoBangJiLu.RU_CHANG_GUO_BANG_TEXT);
		request.setAttribute("ccgbGblxMc", GuoBangJiLu.CHU_CHANG_GUO_BANG_TEXT);
	}
	
	/**
	 * ����������ͳ���
	 * @param request
	 */
	public static void setLxlxInRequest(HttpServletRequest request) {

		request.setAttribute("syLxlx", DingDan.SONG_YUN);
		request.setAttribute("qyLxlx", DingDan.QU_YUN);
		
		request.setAttribute("syLxlxMc", DingDan.SONG_YUN_TEXT);
		request.setAttribute("qyLxlxMc", DingDan.QU_YUN_TEXT);
	}
	
	/**
	 * ��Ź�����¼����״̬����
	 * @param request
	 */
	public static void setGbjlGbztInRequest(HttpServletRequest request) {

		request.setAttribute("zcGbzt", GuoBangJiLu.ZHENG_CHANG);
		request.setAttribute("ycGbzt", GuoBangJiLu.YI_CHANG);
		
		request.setAttribute("zcGbztMc", GuoBangJiLu.ZHENG_CHANG_TEXT);
		request.setAttribute("ycgbztMc", GuoBangJiLu.YI_CHANG_TEXT);
	}
	
	/**
	 * ��Ŷ�����˽������
	 * @param request
	 */
	public static void setDdShjgInRequest(HttpServletRequest request) {

		request.setAttribute("hgShjg", DingDanShenHeJiLu.HE_GE);
		request.setAttribute("bhgShjg", DingDanShenHeJiLu.BU_HE_GE);
		
		request.setAttribute("hgShjgMc", DingDanShenHeJiLu.HE_GE_TEXT);
		request.setAttribute("bhgShjgMc", DingDanShenHeJiLu.BU_HE_GE_TEXT);
	}
	
	/**
	 * ���˾����˽������
	 * @param request
	 */
	public static void setSjShjgInRequest(HttpServletRequest request) {

		request.setAttribute("hgShjg", SiJiShenHeJiLu.HE_GE);
		request.setAttribute("bhgShjg", SiJiShenHeJiLu.BU_HE_GE);
		
		request.setAttribute("hgShjgMc", SiJiShenHeJiLu.HE_GE_TEXT);
		request.setAttribute("bhgShjgMc", SiJiShenHeJiLu.BU_HE_GE_TEXT);
	}
	
	/**
	 * ��ų�����˽������
	 * @param request
	 */
	public static void setClShjgInRequest(HttpServletRequest request) {

		request.setAttribute("hgShjg", CheLiangShenHeJiLu.HE_GE);
		request.setAttribute("bhgShjg", CheLiangShenHeJiLu.BU_HE_GE);
		
		request.setAttribute("hgShjgMc", CheLiangShenHeJiLu.HE_GE_TEXT);
		request.setAttribute("bhgShjgMc", CheLiangShenHeJiLu.BU_HE_GE_TEXT);
	}
	
	/**
	 * ��ų����ŷŽ׶γ���
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
	 * ��Ŷ�������״̬����
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
	 * ��ź�����ೣ��
	 * @param request
	 */
	public static void setHmFlInRequest(HttpServletRequest request) {
		
		request.setAttribute("ptFl", HaoMa.PU_TONG);
		request.setAttribute("qtFl", HaoMa.QI_TA);

		request.setAttribute("ptFlMc", HaoMa.PU_TONG_TEXT);
		request.setAttribute("qtFlMc", HaoMa.QI_TA_TEXT);
	}
	
	/**
	 * ��ŵص㳣��
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
	 * ����������ͳ���
	 * @param request
	 */
	public static void setPushInRequest(HttpServletRequest request) {

		request.setAttribute("pushSfzh", Constant.PUSH_SFZH);
		request.setAttribute("pushCph", Constant.PUSH_CPH);
		request.setAttribute("pushEwm", Constant.PUSH_EWM);
	}
	
	/**
	 * ���нк���ʽ����
	 * @param request
	 */
	public static void setDLJhxsInRequest(HttpServletRequest request) {

		request.setAttribute("zdjhJhxs", DuiLie.ZI_DONG_JIAO_HAO);
		request.setAttribute("sdjhJhxs", DuiLie.SHOU_DONG_JIAO_HAO);
		
		request.setAttribute("zdjhJhxsMc", DuiLie.ZI_DONG_JIAO_HAO_TEXT);
		request.setAttribute("sdjhJhxsMc", DuiLie.SHOU_DONG_JIAO_HAO_TEXT);
	}
	
	/**
	 * ��Ŷ���״̬����
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
	 * ���˾�����״̬����
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
	 * ��ų������״̬����
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
	 * ���˾������״̬����
	 * @param request
	 */
	public static void setSjZyztInRequest(HttpServletRequest request) {

		request.setAttribute("shiZyzt", SiJi.SHI);
		request.setAttribute("fouZyzt", SiJi.FOU);
		
		request.setAttribute("shiZyztMc", SiJi.SHI_TEXT);
		request.setAttribute("fouZyztMc", SiJi.FOU_TEXT);
	}
	
	/**
	 * ��ų����Ƿ����ó���
	 * @param request
	 */
	public static void setClSfzyInRequest(HttpServletRequest request) {

		request.setAttribute("shiSfzy", CheLiang.SHI);
		request.setAttribute("fouSfzy", CheLiang.FOU);
		
		request.setAttribute("shiSfzyMc", CheLiang.SHI_TEXT);
		request.setAttribute("fouSfzyMc", CheLiang.FOU_TEXT);
	}
	
	/**
	 * ��ŵ�����Χ����
	 * @param request
	 */
	public static void setDcfwInRequest(HttpServletRequest request) {

		request.setAttribute("dqyDcfw", DANG_QIAN_YE);
		request.setAttribute("syyDcfw", SUO_YOU_YE);
		
		request.setAttribute("dqyDcfwMc", DANG_QIAN_YE_TEXT);
		request.setAttribute("syyDcfwMc", SUO_YOU_YE_TEXT);
	}
	
	/**
	 * ������������id��ȡ������������
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
	 * ���ݶ�������״̬id��ȡ����״̬����
	 * @param gbztId
	 * @return
	 */
	public static String getDdGbztMcById(int gbztId){
		String gbztMc=null;
		switch (gbztId) {
		case DingDan.DAI_SHANG_BANG:
			gbztMc=DingDan.DAI_SHANG_BANG_TEXT;//���ϰ�
			break;
		case DingDan.SHANG_BANG_ZHONG:
			gbztMc=DingDan.SHANG_BANG_ZHONG_TEXT;//�ϰ���
			break;
		case DingDan.DAI_CHENG_ZHONG:
			gbztMc=DingDan.DAI_CHENG_ZHONG_TEXT;//������
			break;
		case DingDan.CHENG_ZHONG_ZHONG:
			gbztMc=DingDan.CHENG_ZHONG_ZHONG_TEXT;//������
			break;
		case DingDan.DAI_XIA_BANG:
			gbztMc=DingDan.DAI_XIA_BANG_TEXT;//���°�
			break;
		case DingDan.XIA_BANG_ZHONG:
			gbztMc=DingDan.XIA_BANG_ZHONG_TEXT;//�°���
			break;
		case DingDan.YI_WAN_CHENG:
			gbztMc=DingDan.YI_WAN_CHENG_TEXT;//�����
			break;
		}
		return gbztMc;
	}

	/**
	 * ���ݰ����Ż�ȡ��������
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
	 * �����������id��ȡ�����������
	 * @param shlxId
	 * @return
	 */
	public static String getDdShlxMcById(int shlxId){
		String shlxMc=null;
		switch (shlxId) {
		case DingDanShenHeJiLu.XIA_DAN_SHEN_HE:
			shlxMc=DingDanShenHeJiLu.XIA_DAN_SHEN_HE_TEXT;//�µ����
			break;
		case DingDanShenHeJiLu.ZHI_JIAN_SHEN_HE:
			shlxMc=DingDanShenHeJiLu.ZHI_JIAN_SHEN_HE_TEXT;//�ʼ����
			break;
		case DingDanShenHeJiLu.YI_JIAN_SHEN_HE:
			shlxMc=DingDanShenHeJiLu.YI_JIAN_SHEN_HE_TEXT;//һ�����
			break;
		case DingDanShenHeJiLu.RU_KU_SHEN_HE:
			shlxMc=DingDanShenHeJiLu.RU_KU_SHEN_HE_TEXT;//������
			break;
		case DingDanShenHeJiLu.ER_JIAN_SHEN_HE:
			shlxMc=DingDanShenHeJiLu.ER_JIAN_SHEN_HE_TEXT;//�������
			break;
		}
		return shlxMc;
	}
	
	/**
	 * ���ݶ�����˱�ʶ���ж�����Ƿ�ϸ�
	 * @param shjg
	 * @return
	 */
	public static String getDdShjgMcByJg(boolean shjg){
		String shjgMc=null;
		if(DingDanShenHeJiLu.HE_GE)
			shjgMc=DingDanShenHeJiLu.HE_GE_TEXT;//�ϸ�
		else
			shjgMc=DingDanShenHeJiLu.BU_HE_GE_TEXT;//���ϸ�
		return shjgMc;
	}

	/**
	 * ���ݹ�����¼����״̬id��ȡ����״̬����
	 * @param gbztId
	 * @return
	 */
	public static String getGbjlGbztMcById(int gbztId){
		String gbztMc=null;
		switch (gbztId) {
		case GuoBangJiLu.ZHENG_CHANG:
			gbztMc=GuoBangJiLu.ZHENG_CHANG_TEXT;//����
			break;
		case GuoBangJiLu.YI_CHANG:
			gbztMc=GuoBangJiLu.YI_CHANG_TEXT;//�쳣
			break;
		}
		return gbztMc;
	}
	
	/**
	 * �����ŷŽ׶�id��ȡ�ŷŽ׶�����
	 * @param pfjdId
	 * @return
	 */
	public static String getPfjdMcById(int pfjdId){
		String pfjdMc=null;
		switch (pfjdId) {
		case CheLiang.GUO_WU_RAN_YOU:
			pfjdMc=CheLiang.GUO_WU_RAN_YOU_TEXT;//����ȼ��
			break;
		case CheLiang.GUO_WU_RAN_QI:
			pfjdMc=CheLiang.GUO_WU_RAN_QI_TEXT;//����ȼ��
			break;
		case CheLiang.GUO_LIU_RAN_YOU:
			pfjdMc=CheLiang.GUO_LIU_RAN_YOU_TEXT;//����ȼ��
			break;
		case CheLiang.GUO_LIU_RAN_QI:
			pfjdMc=CheLiang.GUO_LIU_RAN_QI_TEXT;//����ȼ��
			break;
		case CheLiang.DIAN_DONG:
			pfjdMc=CheLiang.DIAN_DONG_TEXT;//�綯
			break;
		}
		return pfjdMc;
	}
	
	/**
	 * �������״̬id��ȡ���״̬����
	 * @param shztId
	 * @return
	 */
	public static String getCLShztMcById(int shztId){
		String shztMc=null;
		switch (shztId) {
		case CheLiang.DAI_SHEN_HE:
			shztMc=CheLiang.DAI_SHEN_HE_TEXT;//�����
			break;
		case CheLiang.SHEN_HE_TONG_GUO:
			shztMc=CheLiang.SHEN_HE_TONG_GUO_TEXT;//���ͨ��
			break;
		case CheLiang.BIAN_JI_ZHONG:
			shztMc=CheLiang.BIAN_JI_ZHONG_TEXT;//�༭��
			break;
		}
		return shztMc;
	}
	
	public static String getSJShztMcById(int shztId){
		String shztMc=null;
		switch (shztId) {
		case SiJi.DAI_SHEN_HE:
			shztMc=SiJi.DAI_SHEN_HE_TEXT;//�����
			break;
		case SiJi.SHEN_HE_TONG_GUO:
			shztMc=SiJi.SHEN_HE_TONG_GUO_TEXT;//���ͨ��
			break;
		case SiJi.BIAN_JI_ZHONG:
			shztMc=SiJi.BIAN_JI_ZHONG_TEXT;//�༭��
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
			flMc=HaoMa.PU_TONG_TEXT;//��ͨ
			break;
		case HaoMa.QI_TA:
			flMc=HaoMa.QI_TA_TEXT;//����
			break;
		}
		return flMc;
	}
	
	public static String getDLJhxsMcById(int jhxsId) {
		String jhxsMc=null;
		switch (jhxsId) {
		case DuiLie.ZI_DONG_JIAO_HAO:
			jhxsMc=DuiLie.ZI_DONG_JIAO_HAO_TEXT;//�Զ��к�
			break;
		case DuiLie.SHOU_DONG_JIAO_HAO:
			jhxsMc=DuiLie.SHOU_DONG_JIAO_HAO_TEXT;//�ֶ��к�
			break;
		}
		return jhxsMc;
	}
	
	public static String getDLZtMcById(int ztId) {
		String ztMc=null;
		switch (ztId) {
		case DuiLie.ZAI_YONG:
			ztMc=DuiLie.ZAI_YONG_TEXT;//����
			break;
		case DuiLie.ZAN_TING:
			ztMc=DuiLie.ZAN_TING_TEXT;//��ͣ
			break;
		case DuiLie.FEI_QI:
			ztMc=DuiLie.FEI_QI_TEXT;//����
			break;
		}
		return ztMc;
	}
}
