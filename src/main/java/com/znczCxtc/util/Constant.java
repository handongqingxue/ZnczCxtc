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
	
	public static final String PUSH_CPH="pushCph";
	public static final String PUSH_SFZH="pushSfzh";
	
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
	
	public static void setGbztInRequest(HttpServletRequest request) {

		request.setAttribute("zcGbzt", GuoBangJiLu.ZHENG_CHANG);
		request.setAttribute("ycGbzt", GuoBangJiLu.YI_CHANG);
		
		request.setAttribute("zcGbztMc", GuoBangJiLu.ZHENG_CHANG_TEXT);
		request.setAttribute("ycgbztMc", GuoBangJiLu.YI_CHANG_TEXT);
	}
}
