package com.znczCxtc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface CheLiangTaiZhangMapper {

	public int uploadJinChang(CheLiangTaiZhang cltz);
	
	public int uploadChuChang(CheLiangTaiZhang cltz);

	public int deleteByIds(List<String> idList);

	public int queryForInt(@Param("ddh") String ddh, @Param("cyclCph") String cyclCph, @Param("ddztIdList") List<String> ddztIdList, @Param("ddztMcList") List<String> ddztMcList, 
			@Param("jcsjs") String jcsjs, @Param("jcsje") String jcsje, @Param("ccsjs") String ccsjs, @Param("ccsje") String ccsje);

	public List<CheLiangTaiZhang> queryList(@Param("ddh") String ddh, @Param("cyclCph") String cyclCph, @Param("ddztIdList") List<String> ddztIdList, @Param("ddztMcList") List<String> ddztMcList, 
			@Param("jcsjs") String jcsjs, @Param("jcsje") String jcsje, @Param("ccsjs") String ccsjs, @Param("ccsje") String ccsje, @Param("rowNum") int rowNum, @Param("rows") int rows, String sort, String order);

	public CheLiangTaiZhang selectById(String id);
}
