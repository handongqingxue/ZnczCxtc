package com.znczCxtc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface YongHuShenHeJiLuMapper {

	int add(YongHuShenHeJiLu yhshjl);

	int queryForInt(@Param("yhm") String yhm, @Param("shrYhm") String shrYhm, @Param("shsjks") String shsjks, @Param("shsjjs") String shsjjs);

	List<YongHuShenHeJiLu> queryList(@Param("yhm") String yhm, @Param("shrYhm") String shrYhm, @Param("shsjks") String shsjks, @Param("shsjjs") String shsjjs, 
			@Param("rowNum") int rowNum, @Param("rows") int rows, String sort, String order);
}
