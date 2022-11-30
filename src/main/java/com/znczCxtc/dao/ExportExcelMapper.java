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
}
