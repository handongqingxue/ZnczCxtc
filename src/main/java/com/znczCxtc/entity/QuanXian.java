package com.znczCxtc.entity;

public class QuanXian {

	/**
	 * ��Ӷ���
	 */
	public static final int TIAN_JIA_DING_DAN=1;
	/**
	 * �޸Ķ���
	 */
	public static final int XIU_GAI_DING_DAN=2;
	/**
	 * ɾ������
	 */
	public static final int SHAN_CHU_DING_DAN=3;
	/**
	 * ��ѯ����
	 */
	public static final int CHA_XUN_DING_DAN=4;
	/**
	 * �µ����
	 */
	public static final int XIA_DAN_SHEN_HE=5;
	/**
	 * �ʼ����
	 */
	public static final int ZHI_JIAN_SHEN_HE=6;
	/**
	 * һ�����
	 */
	public static final int YI_JIAN_SHEN_HE=7;
	/**
	 * �������
	 */
	public static final int ER_JIAN_SHEN_HE=8;
	/**
	 * װж�����
	 */
	public static final int ZHUANG_XIE_HUO_SHEN_HE=9;
	/**
	 * ɾ��������¼
	 */
	public static final int SHAN_CHU_GUO_BANG_JI_LU=10;
	/**
	 * ɾ��������¼
	 */
	public static final int SHAN_CHU_BANG_DAN_JI_LU=11;
	/**
	 * ����״̬��ѯ
	 */
	public static final int DING_DAN_ZHUANG_TAI_CHA_XUN=28;
	/**
	 * ��ѯ������¼
	 */
	public static final int CHA_XUN_BANG_DAN_JI_LU=29;
	/**
	 * ��ѯ������¼
	 */
	public static final int CHA_XUN_GUO_BANG_JI_LU=30;
	/**
	 * ��ѯ��������
	 */
	public static final int CHA_XUN_WU_ZI_LEI_XING=31;
	/**
	 * ��ѯ����
	 */
	public static final int CHA_XUN_WU_ZI=32;
	/**
	 * ��ѯ������
	 */
	public static final int CHA_XUN_YUN_SHU_SHANG=33;
	/**
	 * ��ѯ������λ
	 */
	public static final int CHA_XUN_FA_HUO_DAN_WEI=34;
	/**
	 * ��ѯ�ջ���λ
	 */
	public static final int CHA_XUN_SHOU_HUO_DAN_WEI=35;
	/**
	 * ��ѯ�ֿ�
	 */
	public static final int CHA_XUN_CANG_KU=36;
	
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
