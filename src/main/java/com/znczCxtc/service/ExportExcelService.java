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

	List<CangKu> queryCangKuList(String mc, Integer page, Integer rows, int dcfw);

	List<CheLiang> queryCLZHCXList(String cph, Integer cllx, Boolean sfzy, Integer pfjd, String shzt, String bz,
			Integer page, Integer rows, int dcfw);

	List<CheLiangShenHeJiLu> queryCLSHJLList(String clCph, String shrYhm, String shsjks, String shsjjs, Integer page,
			Integer rows, int dcfw);

	List<CheLiangTaiZhang> queryCLTZList(String ddh, String cph, String ddztIds, String ddztMcs, String jcsjs,
			String jcsje, String ccsjs, String ccsje, Integer page, Integer rows, int dcfw);

	List<SiJi> querySiJiList(String xm, String sjh, String sfzh, Integer zyzt, Integer shzt, Integer page, Integer rows,
			int dcfw);

	List<SiJiShenHeJiLu> querySJSHJLList(String sjXm, String shrYhm, String shsjks, String shsjjs, Integer page,
			Integer rows, int dcfw);

	List<HaoMa> queryHaoMaList(String dlMc, String hm, String pdh, Integer hmztId, Integer page, Integer rows, int dcfw);

	List<DuiLie> queryDuiLieList(String mc, String dm, Integer zt, Integer page, Integer rows, int dcfw);

	List<YongHu> queryYongHuList(String yhm, Integer shzt, int page, int rows, int dcfw);

}
