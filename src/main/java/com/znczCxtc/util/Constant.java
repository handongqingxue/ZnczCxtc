package com.znczCxtc.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.znczCxtc.entity.*;

public class Constant {

	public static final String NO_QX_RETURN_URL="login";
	/**
	 * ���ػ�ģ������
	 */
	public static final String GKJ_MODULE_NAME="gkj";
	/**
	 * С����ģ������
	 */
	public static final String PHONE_MODULE_NAME="phone";
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
	/**
	 * δ������ʶ
	 */
	public static final int WEI_GUO_BANG=0;
	/**
	 * һ�Ű�����ʶ
	 */
	public static final int YI_HAO_BANG_FANG=1;
	/**
	 * ���Ű�����ʶ
	 */
	public static final int ER_HAO_BANG_FANG=2;
	/**
	 * ���Ű�����ʶ
	 */
	public static final int SAN_HAO_BANG_FANG=3;
	/**
	 * �Ÿڱ�ʶ
	 */
	public static final int MEN_GANG=4;

	/**
	 * δ��������
	 */
	public static final String WEI_GUO_BANG_TEXT="δ����";
	/**
	 * һ�Ű�������
	 */
	public static final String YI_HAO_BANG_FANG_TEXT="һ�Ű���";
	/**
	 * ���Ű�������
	 */
	public static final String ER_HAO_BANG_FANG_TEXT="���Ű���";
	/**
	 * ���Ű�������
	 */
	public static final String SAN_HAO_BANG_FANG_TEXT="���Ű���";
	/**
	 * �Ÿ�����
	 */
	public static final String MEN_GANG_TEXT="�Ÿ�";
	//�ص��ʶend

	/**
	 * ���Ͷ�ά��
	 */
	public static final String PUSH_EWM="pushEwm";
	/**
	 * ���ͳ��ƺ�
	 */
	public static final String PUSH_CPH="pushCph";
	/**
	 * �������֤��
	 */
	public static final String PUSH_SFZH="pushSfzh";
	
	/**
	 * ��ǰҳ��ʶ
	 */
	public static final int DANG_QIAN_YE=1;
	/**
	 * ����ҳ��ʶ
	 */
	public static final int SUO_YOU_YE=2;
	
	/**
	 * ��ǰҳ����
	 */
	public static final String DANG_QIAN_YE_TEXT="��ǰҳ";
	/**
	 * ����ҳ����
	 */
	public static final String SUO_YOU_YE_TEXT="����ҳ";
	
	public static final int LXLX=1;
	public static final int DDZT=2;
	public static final int DDGBZT=3;
	public static final int PLACE=4;
	public static final int DDSHLX=5;
	public static final int DDSHJG=6;
	public static final int GBJLGBZT=7;
	public static final int GBLX=8;
	public static final int CLPFJD=9;
	public static final int CLSHZT=10;
	public static final int CLSFZY=11;
	public static final int CLYSLX=12;
	public static final int CLWJLX=13;
	public static final int CLSHJG=14;
	public static final int SJSHZT=15;
	public static final int SJZYZT=16;
	public static final int SJWJLX=17;
	public static final int HMZT=18;
	public static final int HMFL=19;
	public static final int DLZT=20;
	public static final int DLJHXS=21;
	
	/**
	 * ��֤�û��Ƿ�ӵ��Ȩ��
	 * @param checkQxId
	 * @param request
	 * @return
	 */
	public static boolean checkIfExistQx(int checkQxId,HttpServletRequest request) {
		boolean flag=false;
		HttpSession session = request.getSession();
		YongHu yongHu=(YongHu)session.getAttribute("yongHu");
		String yhm = yongHu.getYhm();
		if("admin".equals(yhm)) {
			flag=true;
		}
		else {
			String qxIds = yongHu.getQxIds();
			String[] qxIdArr = qxIds.split(",");
			for (int i = 0; i < qxIdArr.length; i++) {
				String qxId = qxIdArr[i];
				int qxIdInt = Integer.valueOf(qxId);
				if(qxIdInt==checkQxId) {
					flag=true;
					break;
				}
			}
		}
		return flag;
	}
	
	/**
	 * ����û�Ȩ�޳���
	 * @param request
	 */
	public static void setYhQxInRequest(HttpServletRequest request) {

		request.setAttribute("tjddQx", QuanXian.TIAN_JIA_DING_DAN);//1
		request.setAttribute("xgddQx", QuanXian.XIU_GAI_DING_DAN);//2
		request.setAttribute("scddQx", QuanXian.SHAN_CHU_DING_DAN);//3
		request.setAttribute("cxddQx", QuanXian.CHA_XUN_DING_DAN);//4
		request.setAttribute("xdshQx", QuanXian.XIA_DAN_SHEN_HE);//5
		request.setAttribute("zjshQx", QuanXian.ZHI_JIAN_SHEN_HE);//6
		request.setAttribute("yjshQx", QuanXian.YI_JIAN_SHEN_HE);//7
		request.setAttribute("ejshQx", QuanXian.ER_JIAN_SHEN_HE);//8
		request.setAttribute("zxhshQx", QuanXian.ZHUANG_XIE_HUO_SHEN_HE);//9
		request.setAttribute("scgbjlQx", QuanXian.SHAN_CHU_GUO_BANG_JI_LU);//10
		request.setAttribute("scbdjlQx", QuanXian.SHAN_CHU_BANG_DAN_JI_LU);//11
		request.setAttribute("tjwzlxQx", QuanXian.TIAN_JIA_WU_ZI_LEI_XING);//12
		request.setAttribute("xgwzlxQx", QuanXian.XIU_GAI_WU_ZI_LEI_XING);//13
		request.setAttribute("scwzlxQx", QuanXian.SHAN_CHU_WU_ZI_LEI_XING);//14
		request.setAttribute("tjwzQx", QuanXian.TIAN_JIA_WU_ZI);//15
		request.setAttribute("xgwzQx", QuanXian.XIU_GAI_WU_ZI);//16
		request.setAttribute("scwzQx", QuanXian.SHAN_CHU_WU_ZI);//17
		request.setAttribute("tjyssQx", QuanXian.TIAN_JIA_YUN_SHU_SHANG);//18
		request.setAttribute("xgyssQx", QuanXian.XIU_GAI_YUN_SHU_SHANG);//19
		request.setAttribute("scyssQx", QuanXian.SHAN_CHU_YUN_SHU_SHANG);//20
		request.setAttribute("tjfhdwQx", QuanXian.TIAN_JIA_FA_HUO_DAN_WEI);//21
		request.setAttribute("xgfhdwQx", QuanXian.XIU_GAI_FA_HUO_DAN_WEI);//22
		request.setAttribute("scfhdwQx", QuanXian.SHAN_CHU_FA_HUO_DAN_WEI);//23
		request.setAttribute("tjshdwQx", QuanXian.TIAN_JIA_SHOU_HUO_DAN_WEI);//24
		request.setAttribute("xgshdwQx", QuanXian.XIU_GAI_SHOU_HUO_DAN_WEI);//25
		request.setAttribute("scshdwQx", QuanXian.SHAN_CHU_SHOU_HUO_DAN_WEI);//26
		request.setAttribute("tjckQx", QuanXian.TIAN_JIA_CANG_KU);//27
		request.setAttribute("ddztcxQx", QuanXian.DING_DAN_ZHUANG_TAI_CHA_XUN);//28
		request.setAttribute("cxbdjlQx", QuanXian.CHA_XUN_BANG_DAN_JI_LU);//29
		request.setAttribute("cxgbjlQx", QuanXian.CHA_XUN_GUO_BANG_JI_LU);//30
		request.setAttribute("cxwzlxQx", QuanXian.CHA_XUN_WU_ZI_LEI_XING);//31
		request.setAttribute("cxwzQx", QuanXian.CHA_XUN_WU_ZI);//32
		request.setAttribute("cxyssQx", QuanXian.CHA_XUN_YUN_SHU_SHANG);//33
		request.setAttribute("cxfhdwQx", QuanXian.CHA_XUN_FA_HUO_DAN_WEI);//34
		request.setAttribute("cxshdwQx", QuanXian.CHA_XUN_SHOU_HUO_DAN_WEI);//35
		request.setAttribute("cxckQx", QuanXian.CHA_XUN_CANG_KU);//36
		request.setAttribute("tjclQx", QuanXian.TIAN_JIA_CHE_LIANG);//37
		request.setAttribute("xgclQx", QuanXian.XIU_GAI_CHE_LIANG);//38
		request.setAttribute("scclQx", QuanXian.SHAN_CHU_CHE_LIANG);//39
		request.setAttribute("cxclQx", QuanXian.CHA_XUN_CHE_LIANG);//40
		request.setAttribute("shclQx", QuanXian.SHEN_HE_CHE_LIANG);//41
		request.setAttribute("cxcltzQx", QuanXian.CHA_XUN_CHE_LIANG_TAI_ZHANG);//42
		request.setAttribute("cxclshjlQx", QuanXian.CHA_XUN_CHE_LIANG_SHEN_HE_JI_LU);//43
		request.setAttribute("tjsjQx", QuanXian.TIAN_JIA_SI_JI);//44
		request.setAttribute("xgsjQx", QuanXian.XIU_GAI_SI_JI);//45
		request.setAttribute("scsjQx", QuanXian.SHAN_CHU_SI_JI);//46
		request.setAttribute("cxsjQx", QuanXian.CHA_XUN_SI_JI);//47
		request.setAttribute("shsjQx", QuanXian.SHEN_HE_SI_JI);//48
		request.setAttribute("cxsjshjlQx", QuanXian.CHA_XUN_SI_JI_SHEN_HE_JI_LU);//49
		request.setAttribute("cxpdhmQx", QuanXian.CHA_XUN_PAI_DUI_HAO_MA);//50
		request.setAttribute("scpdhmQx", QuanXian.SHAN_CHU_PAI_DUI_HAO_MA);//51
		request.setAttribute("tjdlQx", QuanXian.TIAN_JIA_DUI_LIE);//52
		request.setAttribute("xgdlQx", QuanXian.XIU_GAI_DUI_LIE);//53
		request.setAttribute("scdlQx", QuanXian.SHAN_CHU_DUI_LIE);//54
		request.setAttribute("cxdlQx", QuanXian.CHA_XUN_DUI_LIE);//55
		request.setAttribute("cxyhQx", QuanXian.CHA_XUN_YONG_HU);//56
		request.setAttribute("xgyhQx", QuanXian.XIU_GAI_YONG_HU);//57
		request.setAttribute("shyhQx", QuanXian.SHEN_HE_YONG_HU);//58
		request.setAttribute("cxyhshjlQx", QuanXian.CHA_XUN_YONG_HU_SHEN_HE_JI_LU);//59
		request.setAttribute("tjjsQx", QuanXian.TIAN_JIA_JUE_SE);//60
		request.setAttribute("xgjsQx", QuanXian.XIU_GAI_JUE_SE);//61
		request.setAttribute("scjsQx", QuanXian.SHAN_CHU_JUE_SE);//62
		request.setAttribute("cxjsQx", QuanXian.CHA_XUN_JUE_SE);//63
		request.setAttribute("rgsbsfzQx", QuanXian.REN_GONG_SHI_BIE_SHEN_FEN_ZHENG);//64
		request.setAttribute("rgsbcpQx", QuanXian.REN_GONG_SHI_BIE_CHE_PAI);//65
		request.setAttribute("rgsbewmQx", QuanXian.REN_GONG_SHI_BIE_ER_WEI_MA);//66
		request.setAttribute("ddfwQx", QuanXian.DING_DAN_FU_WEI);//67
		request.setAttribute("bddyQx", QuanXian.BANG_DAN_DA_YIN);//68
		request.setAttribute("cxddshjlQx", QuanXian.CHA_XUN_DING_DAN_SHEN_HE_JI_LU);//69
		request.setAttribute("scddshjlQx", QuanXian.SHAN_CHU_DING_DAN_SHEN_HE_JI_LU);//70
		request.setAttribute("xgckQx", QuanXian.XIU_GAI_CANG_KU);//71
		request.setAttribute("scckQx", QuanXian.SHAN_CHU_CANG_KU);//72
		request.setAttribute("scclshjlQx", QuanXian.SHAN_CHU_CHE_LIANG_SHEN_HE_JI_LU);//73
		request.setAttribute("sccltzQx", QuanXian.SHAN_CHU_CHE_LIANG_TAI_ZHANG);//74
		request.setAttribute("pdhmztcxQx", QuanXian.PAI_DUI_HAO_MA_ZHUANG_TAI_CHA_XUN);//75
		request.setAttribute("scyhshjlQx", QuanXian.SHAN_CHU_YONG_HU_SHEN_HE_JI_LU);//76
		request.setAttribute("qxcxQx", QuanXian.QUAN_XIAN_CHA_XUN);//77
		
	}
	
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
	
	public static Map<String, Object> getDdztMap() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("dshDdzt", DingDanZhuangTai.DAI_SHEN_HE);
		jsonMap.put("bjzDdzt", DingDanZhuangTai.BIAN_JI_ZHONG);
		jsonMap.put("yxdDdzt", DingDanZhuangTai.YI_XIA_DAN);
		jsonMap.put("pdzDdzt", DingDanZhuangTai.PAI_DUI_ZHONG);
		jsonMap.put("drcDdzt", DingDanZhuangTai.DAI_RU_CHANG);
		jsonMap.put("djyDdzt", DingDanZhuangTai.DAI_JIAN_YAN);
		jsonMap.put("yjdsmDdzt", DingDanZhuangTai.YI_JIAN_DAI_SAO_MA);
		jsonMap.put("yjdsbDdzt", DingDanZhuangTai.YI_JIAN_DAI_SHANG_BANG);
		jsonMap.put("yjzDdzt", DingDanZhuangTai.YI_JIAN_ZHONG);
		jsonMap.put("yjdshDdzt", DingDanZhuangTai.YI_JIAN_DAI_SHEN_HE);
		jsonMap.put("dzxhDdzt", DingDanZhuangTai.DAI_ZHUANG_XIE_HUO);
		jsonMap.put("ejdsmDdzt", DingDanZhuangTai.ER_JIAN_DAI_SAO_MA);
		jsonMap.put("ejdsbDdzt", DingDanZhuangTai.ER_JIAN_DAI_SHANG_BANG);
		jsonMap.put("ejzDdzt", DingDanZhuangTai.ER_JIAN_ZHONG);
		jsonMap.put("ejdshDdzt", DingDanZhuangTai.ER_JIAN_DAI_SHEN_HE);
		jsonMap.put("ddypzDdzt", DingDanZhuangTai.DAI_DA_YIN_PING_ZHENG);
		jsonMap.put("dlcDdzt", DingDanZhuangTai.DAI_LI_CHANG);
		jsonMap.put("ywcDdzt", DingDanZhuangTai.YI_WAN_CHENG);
		jsonMap.put("ycDdzt", DingDanZhuangTai.YI_CHANG);
		jsonMap.put("yfqDdzt", DingDanZhuangTai.YI_FEI_QI);
		
		jsonMap.put("dshDdztMc", DingDanZhuangTai.DAI_SHEN_HE_TEXT);
		jsonMap.put("bjzDdztMc", DingDanZhuangTai.BIAN_JI_ZHONG_TEXT);
		jsonMap.put("yxdDdztMc", DingDanZhuangTai.YI_XIA_DAN_TEXT);
		jsonMap.put("pdzDdztMc", DingDanZhuangTai.PAI_DUI_ZHONG_TEXT);
		jsonMap.put("drcDdztMc", DingDanZhuangTai.DAI_RU_CHANG_TEXT);
		jsonMap.put("djyDdztMc", DingDanZhuangTai.DAI_JIAN_YAN_TEXT);
		jsonMap.put("yjdsmDdztMc", DingDanZhuangTai.YI_JIAN_DAI_SAO_MA_TEXT);
		jsonMap.put("yjdsbDdztMc", DingDanZhuangTai.YI_JIAN_DAI_SHANG_BANG_TEXT);
		jsonMap.put("yjzDdztMc", DingDanZhuangTai.YI_JIAN_ZHONG_TEXT);
		jsonMap.put("yjdshDdztMc", DingDanZhuangTai.YI_JIAN_DAI_SHEN_HE_TEXT);
		jsonMap.put("dzxhDdztMc", DingDanZhuangTai.DAI_ZHUANG_XIE_HUO_TEXT);
		jsonMap.put("ejdsmDdztMc", DingDanZhuangTai.ER_JIAN_DAI_SAO_MA);
		jsonMap.put("ejdsbDdztMc", DingDanZhuangTai.ER_JIAN_DAI_SHANG_BANG_TEXT);
		jsonMap.put("ejzDdztMc", DingDanZhuangTai.ER_JIAN_ZHONG_TEXT);
		jsonMap.put("ejdshDdztMc", DingDanZhuangTai.ER_JIAN_DAI_SHEN_HE_TEXT);
		jsonMap.put("ddypzDdztMc", DingDanZhuangTai.DAI_DA_YIN_PING_ZHENG_TEXT);
		jsonMap.put("dlcDdztMc", DingDanZhuangTai.DAI_LI_CHANG_TEXT);
		jsonMap.put("ywcDdztMc", DingDanZhuangTai.YI_WAN_CHENG_TEXT);
		jsonMap.put("ycDdztMc", DingDanZhuangTai.YI_CHANG_TEXT);
		jsonMap.put("yfqDdztMc", DingDanZhuangTai.YI_FEI_QI_TEXT);
		
		return jsonMap;
	}
	
	/**
	 * ���������ͳ���
	 * @param request
	 */
	public static void setDdShlxInRequest(HttpServletRequest request) {

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
	
	public static Map<String, Object> getDdShlxMap() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("xdshShlx", DingDanShenHeJiLu.XIA_DAN_SHEN_HE);
		jsonMap.put("zjshShlx", DingDanShenHeJiLu.ZHI_JIAN_SHEN_HE);
		jsonMap.put("yjshShlx", DingDanShenHeJiLu.YI_JIAN_SHEN_HE);
		jsonMap.put("rkshShlx", DingDanShenHeJiLu.RU_KU_SHEN_HE);
		jsonMap.put("ejshShlx", DingDanShenHeJiLu.ER_JIAN_SHEN_HE);

		jsonMap.put("xdshShlxMc", DingDanShenHeJiLu.XIA_DAN_SHEN_HE_TEXT);
		jsonMap.put("zjshShlxMc", DingDanShenHeJiLu.ZHI_JIAN_SHEN_HE_TEXT);
		jsonMap.put("yjshShlxMc", DingDanShenHeJiLu.YI_JIAN_SHEN_HE_TEXT);
		jsonMap.put("rkshShlxMc", DingDanShenHeJiLu.RU_KU_SHEN_HE_TEXT);
		jsonMap.put("ejshShlxMc", DingDanShenHeJiLu.ER_JIAN_SHEN_HE_TEXT);
		
		return jsonMap;
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
	
	public static Map<String, Object> getGblxMap() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("rcgbGblx", GuoBangJiLu.RU_CHANG_GUO_BANG);
		jsonMap.put("ccgbGblx", GuoBangJiLu.CHU_CHANG_GUO_BANG);
		
		jsonMap.put("rcgbGblxMc", GuoBangJiLu.RU_CHANG_GUO_BANG_TEXT);
		jsonMap.put("ccgbGblxMc", GuoBangJiLu.CHU_CHANG_GUO_BANG_TEXT);
		
		return jsonMap;
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
	
	public static Map<String, Object> getLxlxMap() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("syLxlx", DingDan.SONG_YUN);
		jsonMap.put("qyLxlx", DingDan.QU_YUN);
		
		jsonMap.put("syLxlxMc", DingDan.SONG_YUN_TEXT);
		jsonMap.put("qyLxlxMc", DingDan.QU_YUN_TEXT);
		
		return jsonMap;
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
	
	public static Map<String, Object> getGbjlGbztMap() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("zcGbzt", GuoBangJiLu.ZHENG_CHANG);
		jsonMap.put("ycgbzt", GuoBangJiLu.YI_CHANG);
		
		jsonMap.put("zcGbztMc", GuoBangJiLu.ZHENG_CHANG_TEXT);
		jsonMap.put("ycgbztMc", GuoBangJiLu.YI_CHANG_TEXT);
		
		return jsonMap;
	}
	
	/**
	 * ����û���˽������
	 * @param request
	 */
	public static void setYhShjgInRequest(HttpServletRequest request) {

		request.setAttribute("hgShjg", YongHuShenHeJiLu.HE_GE);
		request.setAttribute("bhgShjg", YongHuShenHeJiLu.BU_HE_GE);
		
		request.setAttribute("hgShjgMc", YongHuShenHeJiLu.HE_GE_TEXT);
		request.setAttribute("bhgShjgMc", YongHuShenHeJiLu.BU_HE_GE_TEXT);
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
	
	public static Map<String, Object> getDdShjgMap() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("hgShjg", DingDanShenHeJiLu.HE_GE);
		jsonMap.put("bhgShjg", DingDanShenHeJiLu.BU_HE_GE);
		
		jsonMap.put("hgShjgMc", DingDanShenHeJiLu.HE_GE_TEXT);
		jsonMap.put("bhgShjgMc", DingDanShenHeJiLu.BU_HE_GE_TEXT);
		
		return jsonMap;
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
	
	public static Map<String, Object> getClShjgMap() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("hgShjg", CheLiangShenHeJiLu.HE_GE);
		jsonMap.put("bhgShjg", CheLiangShenHeJiLu.BU_HE_GE);
		
		jsonMap.put("hgShjgMc", CheLiangShenHeJiLu.HE_GE_TEXT);
		jsonMap.put("bhgShjgMc", CheLiangShenHeJiLu.BU_HE_GE_TEXT);
		
		return jsonMap;
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
	
	public static Map<String, Object> getClPfjdMap() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("gwryPfjd", CheLiang.GUO_WU_RAN_YOU);
		jsonMap.put("gwrqPfjd", CheLiang.GUO_WU_RAN_QI);
		jsonMap.put("glryPfjd", CheLiang.GUO_LIU_RAN_YOU);
		jsonMap.put("glrqPfjd", CheLiang.GUO_LIU_RAN_QI);
		jsonMap.put("ddPfjd", CheLiang.DIAN_DONG);
		
		jsonMap.put("gwryPfjdMc", CheLiang.GUO_WU_RAN_YOU_TEXT);
		jsonMap.put("gwrqPfjdMc", CheLiang.GUO_WU_RAN_QI_TEXT);
		jsonMap.put("glryPfjdMc", CheLiang.GUO_LIU_RAN_YOU_TEXT);
		jsonMap.put("glrqPfjdMc", CheLiang.GUO_LIU_RAN_QI_TEXT);
		jsonMap.put("ddPfjdMc", CheLiang.DIAN_DONG_TEXT);
		
		return jsonMap;
	}
	
	public static void setClYslxInRequest(HttpServletRequest request) {

		request.setAttribute("physYslx", CheLiang.PU_HUO_YUN_SHU);
		request.setAttribute("cnysYslx", CheLiang.CHANG_NEI_YUN_SHU);
		request.setAttribute("whpysYslx", CheLiang.WEI_HUA_PIN_YUN_SHU);
		
		request.setAttribute("physYslxMc", CheLiang.PU_HUO_YUN_SHU_TEXT);
		request.setAttribute("cnysYslxMc", CheLiang.CHANG_NEI_YUN_SHU_TEXT);
		request.setAttribute("whpysYslxMc", CheLiang.WEI_HUA_PIN_YUN_SHU_TEXT);
	}
	
	public static Map<String, Object> getClYslxMap() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("physYslx", CheLiang.PU_HUO_YUN_SHU);
		jsonMap.put("cnysYslx", CheLiang.CHANG_NEI_YUN_SHU);
		jsonMap.put("whpysYslx", CheLiang.WEI_HUA_PIN_YUN_SHU);
		
		jsonMap.put("physYslxMc", CheLiang.PU_HUO_YUN_SHU_TEXT);
		jsonMap.put("cnysYslxMc", CheLiang.CHANG_NEI_YUN_SHU_TEXT);
		jsonMap.put("whpysYslxMc", CheLiang.WEI_HUA_PIN_YUN_SHU_TEXT);
		
		return jsonMap;
	}
	
	public static Map<String, Object> getClWjlxMap() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("zpWjlx", CheLiang.ZHAO_PIAN);
		jsonMap.put("xszWjlx", CheLiang.XING_SHI_ZHENG);
		jsonMap.put("scqdWjlx", CheLiang.SUI_CHE_QING_DAN);
		jsonMap.put("pfjdcxjtWjlx", CheLiang.PAI_FANG_JIE_DUAN_CHA_XUN_JIE_TU);
		
		return jsonMap;
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
	
	public static Map<String, Object> getDdGbztMap() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("dsbGbzt", DingDan.DAI_SHANG_BANG);
		jsonMap.put("sbzGbzt", DingDan.SHANG_BANG_ZHONG);
		jsonMap.put("dczGbzt", DingDan.DAI_CHENG_ZHONG);
		jsonMap.put("czzGbzt", DingDan.CHENG_ZHONG_ZHONG);
		jsonMap.put("dxbGbzt", DingDan.DAI_XIA_BANG);
		jsonMap.put("xbzGbzt", DingDan.XIA_BANG_ZHONG);
		jsonMap.put("ywcGbzt", DingDan.YI_WAN_CHENG);
		
		jsonMap.put("dsbGbztMc", DingDan.DAI_SHANG_BANG_TEXT);
		jsonMap.put("sbzGbztMc", DingDan.SHANG_BANG_ZHONG_TEXT);
		jsonMap.put("dczGbztMc", DingDan.DAI_CHENG_ZHONG_TEXT);
		jsonMap.put("czzGbztMc", DingDan.CHENG_ZHONG_ZHONG_TEXT);
		jsonMap.put("dxbGbztMc", DingDan.DAI_XIA_BANG_TEXT);
		jsonMap.put("xbzGbztMc", DingDan.XIA_BANG_ZHONG_TEXT);
		jsonMap.put("ywcGbztMc", DingDan.YI_WAN_CHENG_TEXT);
		
		return jsonMap;
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
	
	public static Map<String, Object> getHmFlMap() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();

		jsonMap.put("ptFl", HaoMa.PU_TONG);
		jsonMap.put("qtFl", HaoMa.QI_TA);

		jsonMap.put("ptFlMc", HaoMa.PU_TONG_TEXT);
		jsonMap.put("qtFlMc", HaoMa.QI_TA_TEXT);
		
		return jsonMap;
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
	
	public static Map<String, Object> getPlaceMap() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("wgb", Constant.WEI_GUO_BANG);
		jsonMap.put("yhbf", Constant.YI_HAO_BANG_FANG);
		jsonMap.put("ehbf", Constant.ER_HAO_BANG_FANG);
		jsonMap.put("shbf", Constant.SAN_HAO_BANG_FANG);
		jsonMap.put("mg", Constant.MEN_GANG);

		jsonMap.put("wgbMc", Constant.WEI_GUO_BANG_TEXT);
		jsonMap.put("yhbfMc", Constant.YI_HAO_BANG_FANG_TEXT);
		jsonMap.put("ehbfMc", Constant.ER_HAO_BANG_FANG_TEXT);
		jsonMap.put("shbfMc", Constant.SAN_HAO_BANG_FANG_TEXT);
		jsonMap.put("mgMc", Constant.MEN_GANG_TEXT);
		
		return jsonMap;
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
	
	public static Map<String, Object> getDLJhxsMap() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("zdjhJhxs", DuiLie.ZI_DONG_JIAO_HAO);//�Զ��к�
		jsonMap.put("sdjhJhxs", DuiLie.SHOU_DONG_JIAO_HAO);//�ֶ��к�
		
		jsonMap.put("zdjhJhxsMc", DuiLie.ZI_DONG_JIAO_HAO_TEXT);//�Զ��к�
		jsonMap.put("sdjhJhxsMc", DuiLie.SHOU_DONG_JIAO_HAO_TEXT);//�ֶ��к�
		
		return jsonMap;
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
	
	public static Map<String, Object> getDLZtMap() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("zyZt", DuiLie.ZAI_YONG);//����
		jsonMap.put("ztZt", DuiLie.ZAN_TING);//��ͣ
		jsonMap.put("fqZt", DuiLie.FEI_QI);//����
		
		jsonMap.put("zyZtMc", DuiLie.ZAI_YONG_TEXT);//����
		jsonMap.put("ztZtMc", DuiLie.ZAN_TING_TEXT);//��ͣ
		jsonMap.put("fqZtMc", DuiLie.FEI_QI_TEXT);//����
		
		return jsonMap;
	}
	
	/**
	 * ����û����״̬����
	 * @param request
	 */
	public static void setYhShztInRequest(HttpServletRequest request) {
		
		request.setAttribute("dshShzt", YongHu.DAI_SHEN_HE);
		request.setAttribute("shtgShzt", YongHu.SHEN_HE_TONG_GUO);
		request.setAttribute("bjzShzt", YongHu.BIAN_JI_ZHONG);
		
		request.setAttribute("dshShztMc", YongHu.DAI_SHEN_HE_TEXT);
		request.setAttribute("shtgShztMc", YongHu.SHEN_HE_TONG_GUO_TEXT);
		request.setAttribute("bjzShztMc", YongHu.BIAN_JI_ZHONG_TEXT);
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
	
	public static Map<String, Object> getSjShztMap() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("dshShzt", SiJi.DAI_SHEN_HE);
		jsonMap.put("shtgShzt", SiJi.SHEN_HE_TONG_GUO);
		jsonMap.put("bjzShzt", SiJi.BIAN_JI_ZHONG);
		
		jsonMap.put("dshShztMc", SiJi.DAI_SHEN_HE_TEXT);
		jsonMap.put("shtgShztMc", SiJi.SHEN_HE_TONG_GUO_TEXT);
		jsonMap.put("bjzShztMc", SiJi.BIAN_JI_ZHONG_TEXT);
		
		return jsonMap;
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
	
	public static Map<String, Object> getClShztMap() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("dshShzt", CheLiang.DAI_SHEN_HE);
		jsonMap.put("shtgShzt", CheLiang.SHEN_HE_TONG_GUO);
		jsonMap.put("bjzShzt", CheLiang.BIAN_JI_ZHONG);
		
		jsonMap.put("dshShztMc", CheLiang.DAI_SHEN_HE_TEXT);
		jsonMap.put("shtgShztMc", CheLiang.SHEN_HE_TONG_GUO_TEXT);
		jsonMap.put("bjzShztMc", CheLiang.BIAN_JI_ZHONG_TEXT);
		
		return jsonMap;
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
	
	public static Map<String, Object> getSjZyztMap() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("shiZyzt", SiJi.SHI);
		jsonMap.put("fouZyzt", SiJi.FOU);
		
		jsonMap.put("shiZyztMc", SiJi.SHI_TEXT);
		jsonMap.put("fouZyztMc", SiJi.FOU_TEXT);
		
		return jsonMap;
	}
	
	public static Map<String, Object> getSjWjlxMap() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("sfzzpWjlx", SiJi.SHEN_FEN_ZHENG_ZHAO_PIAN);
		jsonMap.put("zgzsWjlx", SiJi.ZI_GE_ZHENG_SHU);
		jsonMap.put("jzWjlx", SiJi.JIA_ZHENG);
		
		return jsonMap;
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
	
	public static Map<String, Object> getClSfzyMap() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("shiSfzy", CheLiang.SHI);
		jsonMap.put("fouSfzy", CheLiang.FOU);
		
		jsonMap.put("shiSfzyMc", CheLiang.SHI_TEXT);
		jsonMap.put("fouSfzyMc", CheLiang.FOU_TEXT);
		
		return jsonMap;
	}
	
	/**
	 * ��Ž�ɫ״̬����
	 * @param request
	 */
	public static void setJsZtInRequest(HttpServletRequest request) {

		request.setAttribute("xzZt", JueSe.XIN_ZENG);
		request.setAttribute("zcsyZt", JueSe.ZHENG_CHANG_SHI_YONG);
		request.setAttribute("fqZt", JueSe.FEI_QI);
		request.setAttribute("ywZt", JueSe.YOU_WU);
		
		request.setAttribute("xzZtMc", JueSe.XIN_ZENG_TEXT);
		request.setAttribute("zcsyZtMc", JueSe.ZHENG_CHANG_SHI_YONG_TEXT);
		request.setAttribute("fqZtMc", JueSe.FEI_QI_TEXT);
		request.setAttribute("ywZtMc", JueSe.YOU_WU_TEXT);
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
	 * ��ź���״̬����
	 * @param request
	 */
	public static void setHmztInRequest(HttpServletRequest request) {
		
		request.setAttribute("pdzHmzt", HaoMaZhuangTai.PAI_DUI_ZHONG);//�Ŷ���
		request.setAttribute("jhzHmzt", HaoMaZhuangTai.JIAO_HAO_ZHONG);//�к���
		request.setAttribute("yghHmzt", HaoMaZhuangTai.YI_GUO_HAO);//�ѹ���
		request.setAttribute("slzHmzt", HaoMaZhuangTai.SHOU_LI_ZHONG);//������
		request.setAttribute("ywcHmzt", HaoMaZhuangTai.YI_WAN_CHENG);//�����
		request.setAttribute("qxHmzt", HaoMaZhuangTai.QU_XIAO);//ȡ��
		
		request.setAttribute("pdzHmztMc", HaoMaZhuangTai.PAI_DUI_ZHONG_TEXT);//�Ŷ���
		request.setAttribute("jhzHmztMc", HaoMaZhuangTai.JIAO_HAO_ZHONG_TEXT);//�к���
		request.setAttribute("yghHmztMc", HaoMaZhuangTai.YI_GUO_HAO_TEXT);//�ѹ���
		request.setAttribute("slzHmztMc", HaoMaZhuangTai.SHOU_LI_ZHONG_TEXT);//������
		request.setAttribute("ywcHmztMc", HaoMaZhuangTai.YI_WAN_CHENG_TEXT);//�����
		request.setAttribute("qxHmztMc", HaoMaZhuangTai.QU_XIAO_TEXT);//ȡ��
	}
	
	public static Map<String, Object> getHmztMap() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("pdzHmzt", HaoMaZhuangTai.PAI_DUI_ZHONG);//�Ŷ���
		jsonMap.put("jhzHmzt", HaoMaZhuangTai.JIAO_HAO_ZHONG);//�к���
		jsonMap.put("yghHmzt", HaoMaZhuangTai.YI_GUO_HAO);//�ѹ���
		jsonMap.put("slzHmzt", HaoMaZhuangTai.SHOU_LI_ZHONG);//������
		jsonMap.put("ywcHmzt", HaoMaZhuangTai.YI_WAN_CHENG);//�����
		jsonMap.put("qxHmzt", HaoMaZhuangTai.QU_XIAO);//ȡ��
		
		jsonMap.put("pdzHmztMc", HaoMaZhuangTai.PAI_DUI_ZHONG_TEXT);//�Ŷ���
		jsonMap.put("jhzHmztMc", HaoMaZhuangTai.JIAO_HAO_ZHONG_TEXT);//�к���
		jsonMap.put("yghHmztMc", HaoMaZhuangTai.YI_GUO_HAO_TEXT);//�ѹ���
		jsonMap.put("slzHmztMc", HaoMaZhuangTai.SHOU_LI_ZHONG_TEXT);//������
		jsonMap.put("ywcHmztMc", HaoMaZhuangTai.YI_WAN_CHENG_TEXT);//�����
		jsonMap.put("qxHmztMc", HaoMaZhuangTai.QU_XIAO_TEXT);//ȡ��
		
		return jsonMap;
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
	 * ���ݳ������״̬id��ȡ���״̬����
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
	
	/**
	 * ����˾�����״̬id��ȡ���״̬����
	 * @param shztId
	 * @return
	 */
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
	
	/**
	 * �����û����״̬id��ȡ���״̬����
	 * @param shztId
	 * @return
	 */
	public static String getYHShztMcById(int shztId){
		String shztMc=null;
		switch (shztId) {
		case YongHu.DAI_SHEN_HE:
			shztMc=YongHu.DAI_SHEN_HE_TEXT;//�����
			break;
		case YongHu.SHEN_HE_TONG_GUO:
			shztMc=YongHu.SHEN_HE_TONG_GUO_TEXT;//���ͨ��
			break;
		case YongHu.BIAN_JI_ZHONG:
			shztMc=YongHu.BIAN_JI_ZHONG_TEXT;//�༭��
			break;
		}
		return shztMc;
	}
	
	/**
	 * ����˾������״̬��ʶ��ȡ����״̬����
	 * @param zyzt
	 * @return
	 */
	public static String getSJZyztMcByIf(boolean zyzt) {
		return zyzt==SiJi.SHI?SiJi.SHI_TEXT:SiJi.FOU_TEXT;
	}
	
	/**
	 * ����˾����˽����ʶ��ȡ��˽������
	 * @param shjg
	 * @return
	 */
	public static String getSJShjgMcByIf(boolean shjg) {
		return shjg==SiJi.HE_GE?SiJi.HE_GE_TEXT:SiJi.BU_HE_GE_TEXT;
	}
	
	/**
	 * ���ݳ����Ƿ����ñ�ʶ��ȡ�Ƿ���������
	 * @param sfzy
	 * @return
	 */
	public static String getCLSfzyMcByIf(boolean sfzy) {
		return sfzy==CheLiang.SHI?CheLiang.SHI_TEXT:CheLiang.FOU_TEXT;
	}
	
	/**
	 * ���ݳ�����˽����ʶ��ȡ��˽������
	 * @param shjg
	 * @return
	 */
	public static String getCLShjgMcByIf(boolean shjg) {
		return shjg==CheLiang.HE_GE?CheLiang.HE_GE_TEXT:CheLiang.BU_HE_GE_TEXT;
	}
	
	/**
	 * ���ݺ�������ʶ��ȡ�����������
	 * @param flId
	 * @return
	 */
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
	
	/**
	 * ���ݶ��нк���ʽ��ʶ��ȡ�к���ʽ����
	 * @param jhxsId
	 * @return
	 */
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
	
	/**
	 * ���ݶ���״̬��ʶ��ȡ����״̬����
	 * @param ztId
	 * @return
	 */
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
