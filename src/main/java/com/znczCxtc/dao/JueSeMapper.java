package com.znczCxtc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface JueSeMapper {

	int add(JueSe js);

	int queryForInt(@Param("mc") String mc);

	List<JueSe> queryList(@Param("mc") String mc, @Param("rowNum") int rowNum, @Param("rows") int rows, @Param("sort") String sort, @Param("order") String order);

	JueSe selectById(@Param("id") String id);
	
	List<JueSe> queryCBBList();
}
