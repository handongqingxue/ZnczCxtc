package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.*;

public interface ExportExcelService {

	List<DingDan> queryDDZHCXList(String ddh, Integer ddztId, String ddztMc, String cyclCph, String jhysrq,
			String yssMc, String wzMc, String fhdwMc, String shdwMc, String cysjXm, String cysjSfzh, String jcsjs,
			String jcsje, String ccsjs, String ccsje, Integer page, Integer rows, int dcfw);

	List<DingDanShenHeJiLu> queryDDSHJLList(String ddh, Integer shlx, String shsjks, String shsjjs, String cyclCph,
			String shrYhm, String yssMc, String wzMc, String fhdwMc, String shdwMc, String sjXm, String sjSfzh,
			Integer page, Integer rows, int dcfw);

	List<BangDanJiLu> queryBDJLList(String ddh, Integer page, Integer rows, int dcfw);

	List<GuoBangJiLu> queryGBJLList(String ddh, String cyclCph, String gbsjks, String gbsjjs, Integer page, Integer rows,
			int dcfw);

	List<GuoBangJiLu> queryDJYList(String ddh, String ddztMc, String cysjXm, String cysjSfzh, String cyclCph,
			String yssMc, String fhdwMc, String shdwMc, String gbsjks, String gbsjjs, Integer gblx, Integer page,
			Integer rows, int dcfw);

	List<WuZiLeiXing> queryWZLXList(String mc, Integer page, Integer rows, int dcfw);

	List<WuZi> queryWuZiList(String mc, String wzlxmc, Integer page, Integer rows, int dcfw);

	List<YunShuShang> queryYunShuShangList(String mc, Integer page, Integer rows, int dcfw);

	List<FaHuoDanWei> queryFaHuoDanWeiList(String mc, Integer page, Integer rows, int dcfw);

	List<ShouHuoDanWei> queryShouHuoDanWeiList(String mc, Boolean ywdl, Integer page, Integer rows, int dcfw);

}
