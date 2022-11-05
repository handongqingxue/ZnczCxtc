package com.znczCxtc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface SiJiShenHeJiLuMapper {

	int add(SiJiShenHeJiLu sjshjl);

	int queryForInt(@Param("sjXm") String sjXm, @Param("shrYhm") String shrYhm, @Param("shsjks") String shsjks, @Param("shsjjs") String shsjjs);

	List<SiJiShenHeJiLu> queryList(@Param("sjXm") String sjXm, @Param("shrYhm") String shrYhm, @Param("shsjks") String shsjks, @Param("shsjjs") String shsjjs,
			@Param("rowNum") int rowNum, @Param("rows") int rows, String sort, String order);

}
