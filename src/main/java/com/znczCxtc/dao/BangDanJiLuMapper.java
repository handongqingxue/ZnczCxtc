package com.znczCxtc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface BangDanJiLuMapper {

	int add(BangDanJiLu bdjl);

	int deleteByIds(List<String> idList);

	int edit(BangDanJiLu bdjl);

	int queryForInt(@Param("ddh") String ddh);
	
	List<BangDanJiLu> queryList(@Param("ddh") String ddh, @Param("rowNum") int rowNum, @Param("rows") int rows, String sort, String order);
	
	BangDanJiLu selectById(@Param("id") String id);

	BangDanJiLu selectByDdId(@Param("ddId") Integer ddId);

	int deleteByDdId(@Param("ddId") Long ddId);

	int getCountByDdId(@Param("ddId") Long ddId);
}
