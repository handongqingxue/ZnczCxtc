package com.znczCxtc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface ShouHuoDanWeiMapper {

	public int add(ShouHuoDanWei shdw);

	public int deleteByIds(List<String> idList);

	public int edit(ShouHuoDanWei shdw);

	public int queryForInt(@Param("mc") String mc, @Param("ywdl") Boolean ywdl);

	public List<ShouHuoDanWei> queryList(@Param("mc") String mc, @Param("ywdl") Boolean ywdl, @Param("start") int start, @Param("rows") int rows, String sort, String order);

	public ShouHuoDanWei selectById(String id);

	List<ShouHuoDanWei> queryCBBList();

}
