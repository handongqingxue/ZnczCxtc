package com.znczCxtc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface DuiLieMapper {

	int add(DuiLie dl);

	int deleteByIds(List<String> idList);

	int edit(DuiLie dl);

	int queryForInt(@Param("mc") String mc, @Param("dm") String dm, @Param("zt") Integer zt);

	List<DuiLie> queryList(@Param("mc") String mc, @Param("dm") String dm, @Param("zt") Integer zt, @Param("start") int start, @Param("rows") int rows, String sort, String order);

	DuiLie selectById(String id);

}
