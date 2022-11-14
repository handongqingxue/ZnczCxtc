package com.znczCxtc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface RglrSfzhJiLuMapper {

	List<String> queryXzSfzhCBBList(@Param("rowNum") int rowNum, @Param("rows") int rows, @Param("sort") String sort, @Param("order") String order);

	int getCount(@Param("ddId") Long ddId, @Param("sfzh") String sfzh);

	int add(RglrSfzhJiLu rglrSfzhJiLu);
}
