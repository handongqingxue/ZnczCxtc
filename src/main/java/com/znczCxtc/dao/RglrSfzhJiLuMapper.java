package com.znczCxtc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RglrSfzhJiLuMapper {

	List<String> queryXzSfzhCBBList(@Param("rowNum") int rowNum, @Param("rows") int rows, @Param("sort") String sort, @Param("order") String order);
}
