package com.znczCxtc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface SiJiMapper {

	public int add(SiJi sj);

	public int deleteByIds(List<String> idList);

	public int edit(SiJi sj);

	public int queryForInt(@Param("xm") String xm, @Param("sjh") String sjh, @Param("sfzh") String sfzh, @Param("zyzt") Integer zyzt, @Param("shzt") Integer shzt);

	public List<SiJi> queryList(@Param("xm") String xm, @Param("sjh") String sjh, @Param("sfzh") String sfzh, @Param("zyzt") Integer zyzt, @Param("shzt") Integer shzt, @Param("start") int start, @Param("rows") int rows, String sort, String order);
	
	public SiJi selectById(String id);

	public int checkByIds(@Param("idList") List<String> idList, @Param("shjg") Boolean shjg);

	public List<SiJi> queryCBBList();

	public int getIdBySfzh(@Param("sfzh") String sfzh);

	public int updateFileById(SiJi sj);
}
