package com.znczCxtc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface YongHuMapper {

	//通过用户信息查询用户
	YongHu getYongHu(YongHu yh);

	String getMmByYhm(@Param("yhm") String yhm);
	
	int add(YongHu yh);

	int edit(YongHu yh);

	int queryForInt(@Param("yhm") String yhm,@Param("shzt") Integer shzt);
	
	List<YongHu> queryList(@Param("yhm") String yhm, @Param("shzt") Integer shzt, @Param("rowNum") int rowNum, @Param("rows") int rows, String sort, String order);

	YongHu selectById(@Param("id") String id);
	
	int updateMmById(@Param("mm") String mm, @Param("id") Integer id);

	public int checkByIds(@Param("idList") List<String> idList, @Param("shjg") Boolean shjg);
}
