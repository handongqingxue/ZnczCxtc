package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.*;

public interface DingDanService {

	int queryForInt(String ddh, Integer ddztId, String ddztMc, String cyclCph, String jhysrq, String yssMc, String wzMc, 
			String fhdwMc, String shdwMc, String cysjXm, String cysjSfzh, String jcsjs, String jcsje, String ccsjs, String ccsje);

	List<DingDan> queryList(String ddh, Integer ddztId, String ddztMc, String cyclCph, String jhysrq, String yssMc, String wzMc, 
			String fhdwMc, String shdwMc, String cysjXm, String cysjSfzh, String jcsjs, String jcsje, String ccsjs, String ccsje, 
			int page, int rows, String sort, String order);

	DingDan selectById(String id);

	int add(DingDan dd);

	int deleteByIds(String ids);

	int edit(DingDan dd);

	int editByZt(DingDan dd);

	int checkByIds(String ids,String ddztMc,Integer jyFlag,DingDanShenHeJiLu shjl);

	/**
	 * �������֤�ź�״̬��ȡ������Ϣ(��Ϊ�����п��ܺ������֤�ŵ�Ψһ�ԣ�ͬһ�����֤�ſ����ж������������ֶ�����¼ʱֻ���ص�һ����¼)
	 * @param sfzh
	 * @param ddztMc
	 * @return
	 */
	DingDan getDingDanBySfzhZt(String sfzh, String ddztMc);

	DingDan getQrcodeInfoByCphZt(String cyclCph, String ddztMc);

	/**
	 * ���ݳ��ƺź�״̬��ȡ������Ϣ(�����Ƕ��״̬�µĶ�������Ϊ�����п��ܺ��Գ��ƺŵ�Ψһ�ԣ�ͬһ�����ƺſ����ж������������ֶ�����¼ʱֻ���ص�һ����¼)
	 * @param cph
	 * @param ddztMcs
	 * @return
	 */
	DingDan getDingDanByCphZts(String cph, String ddztMcs);

	DingDan getByZt(Integer yjbfh, Integer ejbfh, String ddztMc, Integer yjzt, Integer ejzt);

	boolean checkDdhIfExist(String ddh);

	boolean checkIfExistByZt(Integer yjbfh,Integer ejbfh,String ddztMc, Integer yjzt, Integer ejzt);

	DingDan getByCphJL(String cph);

	long getIdByDdh(String ddh);

	boolean checkIfExistByIdCph(Long id, String cph);

	String createDdhByDateYMD();

}