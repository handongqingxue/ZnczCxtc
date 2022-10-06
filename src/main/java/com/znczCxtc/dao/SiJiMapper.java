package com.znczCxtc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface SiJiMapper {

	public int add(SiJi sj);

	public int queryForInt(@Param("xm") String xm, @Param("sfz") String sfz, @Param("zyzt") Integer zyzt, @Param("shzt") String shzt);

	public List<SiJi> queryList(@Param("xm") String xm, @Param("sfz") String sfz, @Param("zyzt") Integer zyzt, @Param("shzt") String shzt, @Param("start") int start, @Param("rows") int rows, String sort, String order);
}
