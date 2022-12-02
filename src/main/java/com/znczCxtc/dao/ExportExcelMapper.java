package com.znczCxtc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface ExportExcelMapper {

	List<DingDan> queryDDZHCXList(@Param("ddh") String ddh, @Param("ddztId") Integer ddztId, @Param("ddztMc") String ddztMc, @Param("cyclCph") String cyclCph, @Param("jhysrq") String jhysrq,
			@Param("yssMc") String yssMc, @Param("wzMc") String wzMc, @Param("fhdwMc") String fhdwMc, @Param("shdwMc") String shdwMc, @Param("cysjXm") String cysjXm, @Param("cysjSfzh") String cysjSfzh, @Param("jcsjs") String jcsjs,
			@Param("jcsje") String jcsje, @Param("ccsjs") String ccsjs, @Param("ccsje") String ccsje, @Param("rowNum") int rowNum, @Param("rows") int rows, @Param("dcfw") int dcfw);

	List<DingDan> queryDDZHCXList(@Param("ddh") String ddh, @Param("ddztId") Integer ddztId, @Param("ddztMc") String ddztMc, @Param("cyclCph") String cyclCph, @Param("jhysrq") String jhysrq,
			@Param("yssMc") String yssMc, @Param("wzMc") String wzMc, @Param("fhdwMc") String fhdwMc, @Param("shdwMc") String shdwMc, @Param("cysjXm") String cysjXm, @Param("cysjSfzh") String cysjSfzh, @Param("jcsjs") String jcsjs,
			@Param("jcsje") String jcsje, @Param("ccsjs") String ccsjs, @Param("ccsje") String ccsje, @Param("dcfw") int dcfw);

	List<DingDanShenHeJiLu> queryDDSHJLList(@Param("ddh") String ddh, @Param("shlx") Integer shlx, @Param("shsjks") String shsjks, @Param("shsjjs") String shsjjs, @Param("cyclCph") String cyclCph,
			@Param("shrYhm") String shrYhm, @Param("yssMc") String yssMc, @Param("wzMc") String wzMc, @Param("fhdwMc") String fhdwMc, @Param("shdwMc") String shdwMc, @Param("sjXm") String sjXm, @Param("sjSfzh") String sjSfzh,
			@Param("rowNum") int rowNum, @Param("rows") Integer rows, @Param("dcfw") int dcfw);

	List<DingDanShenHeJiLu> queryDDSHJLList(@Param("ddh") String ddh, @Param("shlx") Integer shlx, @Param("shsjks") String shsjks, @Param("shsjjs") String shsjjs, @Param("cyclCph") String cyclCph, 
			@Param("shrYhm") String shrYhm, @Param("yssMc") String yssMc, @Param("wzMc") String wzMc, @Param("fhdwMc") String fhdwMc, @Param("shdwMc") String shdwMc, @Param("sjXm") String sjXm, @Param("sjSfzh") String sjSfzh, @Param("dcfw") int dcfw);

	List<BangDanJiLu> queryBDJLList(@Param("ddh") String ddh, @Param("rowNum") int rowNum, @Param("rows") Integer rows, @Param("dcfw") int dcfw);

	List<BangDanJiLu> queryBDJLList(@Param("ddh") String ddh, @Param("dcfw") int dcfw);

	List<GuoBangJiLu> queryGBJLList(@Param("ddh") String ddh, @Param("cyclCph") String cyclCph, @Param("gbsjks") String gbsjks, @Param("gbsjjs") String gbsjjs,
			@Param("rowNum") int rowNum, @Param("rows") int rows, @Param("dcfw") int dcfw);

	List<GuoBangJiLu> queryGBJLList(@Param("ddh") String ddh, @Param("cyclCph") String cyclCph, @Param("gbsjks") String gbsjks, @Param("gbsjjs") String gbsjjs, @Param("dcfw") int dcfw);

	List<GuoBangJiLu> queryDJYList(@Param("ddh") String ddh, @Param("ddztMc") String ddztMc, @Param("cysjXm") String cysjXm, @Param("cysjSfzh") String cysjSfzh, @Param("cyclCph") String cyclCph,
			@Param("yssMc") String yssMc, @Param("fhdwMc") String fhdwMc, @Param("shdwMc") String shdwMc, @Param("gbsjks") String gbsjks, @Param("gbsjjs") String gbsjjs, @Param("gblx") Integer gblx, 
			@Param("rowNum") int rowNum, @Param("rows") Integer rows, @Param("dcfw") int dcfw);

	List<GuoBangJiLu> queryDJYList(@Param("ddh") String ddh, @Param("ddztMc") String ddztMc, @Param("cysjXm") String cysjXm, @Param("cysjSfzh") String cysjSfzh, @Param("cyclCph") String cyclCph,
			@Param("yssMc") String yssMc, @Param("fhdwMc") String fhdwMc, @Param("shdwMc") String shdwMc, @Param("gbsjks") String gbsjks, @Param("gbsjjs") String gbsjjs, @Param("gblx") Integer gblx, @Param("dcfw") int dcfw);

	List<WuZiLeiXing> queryWZLXList(@Param("mc") String mc, @Param("rowNum") int rowNum, @Param("rows") Integer rows, @Param("dcfw") int dcfw);

	List<WuZiLeiXing> queryWZLXList(@Param("mc") String mc, @Param("dcfw") int dcfw);

	List<WuZi> queryWuZiList(@Param("mc") String mc, @Param("wzlxmc") String wzlxmc, @Param("rowNum") int rowNum, @Param("rows") int rows, @Param("dcfw") int dcfw);

	List<WuZi> queryWuZiList(@Param("mc") String mc, @Param("wzlxmc") String wzlxmc, @Param("dcfw") int dcfw);

	List<YunShuShang> queryYunShuShangList(@Param("mc") String mc, @Param("rowNum") int rowNum, @Param("rows") int rows, @Param("dcfw") int dcfw);

	List<YunShuShang> queryYunShuShangList(@Param("mc") String mc, @Param("dcfw") int dcfw);

	List<FaHuoDanWei> queryFaHuoDanWeiList(@Param("mc") String mc, @Param("rowNum") int rowNum, @Param("rows") int rows, @Param("dcfw") int dcfw);

	List<FaHuoDanWei> queryFaHuoDanWeiList(@Param("mc") String mc, @Param("dcfw") int dcfw);

	List<ShouHuoDanWei> queryShouHuoDanWeiList(@Param("mc") String mc, @Param("ywdl") Boolean ywdl, @Param("rowNum") int rowNum, @Param("rows") int rows, @Param("dcfw") int dcfw);

	List<ShouHuoDanWei> queryShouHuoDanWeiList(@Param("mc") String mc, @Param("ywdl") Boolean ywdl, @Param("dcfw") int dcfw);

	List<CangKu> queryCangKuList(@Param("mc") String mc, @Param("rowNum") int rowNum, @Param("rows") int rows, @Param("dcfw") int dcfw);

	List<CangKu> queryCangKuList(@Param("mc") String mc, @Param("dcfw") int dcfw);

	List<CheLiang> queryCLZHCXList(@Param("cph") String cph, @Param("cllx") Integer cllx, @Param("sfzy") Boolean sfzy, @Param("pfjd") Integer pfjd, @Param("shztList") List<String> shztList, @Param("bz") String bz, 
			@Param("rowNum") int rowNum, @Param("rows") int rows, @Param("dcfw") int dcfw);

	List<CheLiang> queryCLZHCXList(@Param("cph") String cph, @Param("cllx") Integer cllx, @Param("sfzy") Boolean sfzy, @Param("pfjd") Integer pfjd, @Param("shztList") List<String> shztList, @Param("bz") String bz, @Param("dcfw") int dcfw);

	List<CheLiangShenHeJiLu> queryCLSHJLList(@Param("clCph") String clCph, @Param("shrYhm") String shrYhm, @Param("shsjks") String shsjks, @Param("shsjjs") String shsjjs, 
			@Param("rowNum") int rowNum, @Param("rows") int rows, @Param("dcfw") int dcfw);

	List<CheLiangShenHeJiLu> queryCLSHJLList(@Param("clCph") String clCph, @Param("shrYhm") String shrYhm, @Param("shsjks") String shsjks, @Param("shsjjs") String shsjjs, @Param("dcfw") int dcfw);

	List<CheLiangTaiZhang> queryCLTZList(@Param("ddh") String ddh, @Param("cph") String cph, @Param("ddztIdList") List<String> ddztIdList, @Param("ddztMcList") List<String> ddztMcList, @Param("jcsjs") String jcsjs,
			@Param("jcsje") String jcsje, @Param("ccsjs") String ccsjs, @Param("ccsje") String ccsje, @Param("rowNum") int rowNum, @Param("rows") int rows, @Param("dcfw") int dcfw);

	List<CheLiangTaiZhang> queryCLTZList(@Param("ddh") String ddh, @Param("cph") String cph, @Param("ddztIdList") List<String> ddztIdList, @Param("ddztMcList") List<String> ddztMcList,
			@Param("jcsjs") String jcsjs, @Param("jcsje") String jcsje, @Param("ccsjs") String ccsjs, @Param("ccsje") String ccsje, @Param("dcfw") int dcfw);
}
