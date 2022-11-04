package com.znczCxtc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface CheLiangShenHeJiLuMapper {

	int add(CheLiangShenHeJiLu clshjl);

	int queryForInt(@Param("clCph") String clCph, @Param("shrYhm") String shrYhm, @Param("shsjks") String shsjks, @Param("shsjjs") String shsjjs);

	List<CheLiangShenHeJiLu> queryList(@Param("clCph") String clCph, @Param("shrYhm") String shrYhm, @Param("shsjks") String shsjks, @Param("shsjjs") String shsjjs,
			@Param("rowNum") int rowNum, @Param("rows") int rows, String sort, String order);

	int deleteByIds(List<String> idList);
}
