package com.znczCxtc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface CheLiangMapper {

	public int add(CheLiang cl);

	public int deleteByIds(List<String> idList);

	public int shenHeCheLiang(@Param("idList") List<String> idList, @Param("flag") String flag);

	public int edit(CheLiang cl);

	public int queryForInt(@Param("cph") String cph, @Param("cllx") Integer cllx, @Param("sfzy") Boolean sfzy, @Param("pfjd") Integer pfjd, @Param("shztList") List<String> shztList, @Param("bz") String bz);

	public List<CheLiang> queryList(@Param("cph") String cph, @Param("cllx") Integer cllx, @Param("sfzy") Boolean sfzy, @Param("pfjd") Integer pfjd, @Param("shztList") List<String> shztList, @Param("bz") String bz, @Param("rowNum") int rowNum, @Param("rows") int rows, String sort, String order);

	public CheLiang selectById(String id);
}
