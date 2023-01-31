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
	 * 根据身份证号和状态获取订单信息(因为测试中可能忽略身份证号的唯一性，同一个身份证号可能有多条订单，出现多条记录时只返回第一条记录)
	 * @param sfzh
	 * @param ddztMc
	 * @return
	 */
	DingDan getDingDanBySfzhZt(String sfzh, String ddztMc);

	DingDan getQrcodeInfoByCphZt(String cyclCph, String ddztMc);

	/**
	 * 根据车牌号和状态获取订单信息(可能是多个状态下的订单，因为测试中可能忽略车牌号的唯一性，同一个车牌号可能有多条订单，出现多条记录时只返回第一条记录)
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