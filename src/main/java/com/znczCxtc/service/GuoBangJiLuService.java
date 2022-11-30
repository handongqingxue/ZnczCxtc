package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.*;

public interface GuoBangJiLuService {

	int add(GuoBangJiLu gbjl);

	int edit(GuoBangJiLu gbjl);

	int queryForInt(String ddh, String cyclCph, String gbsjks, String gbsjjs);

	List<GuoBangJiLu> queryList(String ddh, String cyclCph, String gbsjks, String gbsjjs, int page, int rows, String sort, String order);

	GuoBangJiLu selectById(String id);

	int queryDJYForInt(String ddh, String ddztMc, String cysjXm, String cysjSfzh, String cyclCph, String yssMc, String fhdwMc, String shdwMc, String gbsjks, String gbsjjs, Integer gblx);

	List<GuoBangJiLu> queryDJYList(String ddh, String ddztMc, String cysjXm, String cysjSfzh, String cyclCph, String yssMc, String fhdwMc, String shdwMc, String gbsjks, String gbsjjs, Integer gblx, int page, int rows,
			String sort, String order);

	GuoBangJiLu selectPrintInfo(Integer ddId, Integer gblx);

	boolean checkIfExistByDdId(Integer gblx, Long ddId);

	int deleteByDdId(Integer gblx,Long ddId);

}
