package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.*;

public interface ExportExcelService {

	List<GuoBangJiLu> queryGBJLList(String ddh, String cyclCph, String gbsjks, String gbsjjs, Integer page, Integer rows,
			int dcfw);

	List<DingDan> queryDDZHCXList(String ddh, Integer ddztId, String ddztMc, String cyclCph, String jhysrq,
			String yssMc, String wzMc, String fhdwMc, String shdwMc, String cysjXm, String cysjSfzh, String jcsjs,
			String jcsje, String ccsjs, String ccsje, Integer page, Integer rows, int dcfw);

	List<DingDanShenHeJiLu> queryDDSHJLList(String ddh, Integer shlx, String shsjks, String shsjjs, String cyclCph,
			String shrYhm, String yssMc, String wzMc, String fhdwMc, String shdwMc, String sjXm, String sjSfzh,
			Integer page, Integer rows, int dcfw);

}
