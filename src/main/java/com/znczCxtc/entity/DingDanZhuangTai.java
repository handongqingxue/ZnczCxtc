package com.znczCxtc.entity;

public class DingDanZhuangTai {
	
	//����״̬�ı�ʶstart
	public static final int DAI_SHEN_HE=1;//�����
	public static final int BIAN_JI_ZHONG=2;//�༭��
	public static final int YI_XIA_DAN=3;//���µ�
	public static final int PAI_DUI_ZHONG=4;//�Ŷ���
	public static final int DAI_RU_CHANG=5;//���볧
	public static final int DAI_JIAN_YAN=6;//������
	public static final int YI_JIAN_DAI_SAO_MA=7;//һ���ɨ��
	public static final int YI_JIAN_DAI_SHANG_BANG=8;//һ����ϰ�
	public static final int YI_JIAN_ZHONG=9;//һ����
	public static final int YI_JIAN_DAI_SHEN_HE=10;//һ������
	public static final int DAI_ZHUANG_XIE_HUO=11;//��װж��
	public static final int ER_JIAN_DAI_SAO_MA=12;//�����ɨ��
	public static final int ER_JIAN_DAI_SHANG_BANG=13;//������ϰ�
	public static final int ER_JIAN_ZHONG=14;//������
	public static final int ER_JIAN_DAI_SHEN_HE=15;//��������
	public static final int DAI_DA_YIN_PING_ZHENG=16;//����ӡƾ֤
	public static final int DAI_LI_CHANG=17;//���볧
	public static final int YI_WAN_CHENG=18;//�����
	public static final int YI_CHANG=19;//�쳣
	public static final int YI_FEI_QI=20;//�ѷ���
	//����״̬�ı�ʶend
	
	//����״̬������start
	public static final String DAI_SHEN_HE_TEXT="�����";//1
	public static final String BIAN_JI_ZHONG_TEXT="�༭��";//2
	public static final String YI_XIA_DAN_TEXT="���µ�";//3
	public static final String PAI_DUI_ZHONG_TEXT="�Ŷ���";//4
	public static final String DAI_RU_CHANG_TEXT="���볧";//5
	public static final String DAI_JIAN_YAN_TEXT="������";//6
	public static final String YI_JIAN_DAI_SAO_MA_TEXT="һ���ɨ��";//7
	public static final String YI_JIAN_DAI_SHANG_BANG_TEXT="һ����ϰ�";//8
	public static final String YI_JIAN_ZHONG_TEXT="һ����";//9
	public static final String YI_JIAN_DAI_SHEN_HE_TEXT="һ������";//10
	public static final String DAI_ZHUANG_XIE_HUO_TEXT="��װж��";//11
	public static final String ER_JIAN_DAI_SAO_MA_TEXT="�����ɨ��";//12
	public static final String ER_JIAN_DAI_SHANG_BANG_TEXT="������ϰ�";//13
	public static final String ER_JIAN_ZHONG_TEXT="������";//14
	public static final String ER_JIAN_DAI_SHEN_HE_TEXT="��������";//15
	public static final String DAI_DA_YIN_PING_ZHENG_TEXT="����ӡƾ֤";//16
	public static final String DAI_LI_CHANG_TEXT="���볧";//17
	public static final String YI_WAN_CHENG_TEXT="�����";//18
	public static final String YI_CHANG_TEXT="�쳣";//19
	public static final String YI_FEI_QI_TEXT="�ѷ���";//20
	//����״̬������end
		
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
