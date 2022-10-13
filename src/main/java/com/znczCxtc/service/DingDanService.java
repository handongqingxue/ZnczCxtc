package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.*;

public interface DingDanService {

	int queryForInt(String ddh, Integer ddztId, String ddztMc, String cph, String jhysrq, String yssMc, String wzMc, 
			String fhdwMc, String shdwMc, String cysjXm, String cysjSfzh, String jcsjs, String jcsje, String ccsjs, String ccsje);

	List<DingDan> queryList(String ddh, Integer ddztId, String ddztMc, String cph, String jhysrq, String yssMc, String wzMc, 
			String fhdwMc, String shdwMc, String cysjXm, String cysjSfzh, String jcsjs, String jcsje, String ccsjs, String ccsje, 
			int page, int rows, String sort, String order);

	DingDan selectById(String id);

	int add(DingDan dd);

	int deleteByIds(String ids);

	int edit(DingDan dd);

	int editByZt(DingDan dd);

	int checkByIds(String ids,String ddztMc,Integer jyFlag,ShenHeJiLu shjl);

	DingDan getDingDan(String cph, String ddztMc);

	DingDan getByZt(Integer yjbfh, Integer ejbfh, String ddztMc, Integer yjzt, Integer ejzt);

	boolean checkDdhIfExist(String ddh);

	boolean checkIfExistByZt(Integer yjbfh,Integer ejbfh,String ddztMc, Integer yjzt, Integer ejzt);

	DingDan getByCphJL(String cph);

	int getIdByDdh(String ddh);

	boolean checkIfExistByIdCph(Integer id, String cph);

	String createDdhByDateYMD();

}