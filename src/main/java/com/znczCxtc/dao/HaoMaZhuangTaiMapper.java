package com.znczCxtc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface HaoMaZhuangTaiMapper {
	
	int add(HaoMaZhuangTai hmzt);

	int edit(HaoMaZhuangTai hmzt);

	int queryForInt(@Param("mc") String mc);
	
	List<HaoMaZhuangTai> queryList(@Param("mc") String mc, @Param("rowNum") int rowNum, @Param("rows") int rows, String sort, String order);

	HaoMaZhuangTai selectById(@Param("id") String id);

	public List<HaoMaZhuangTai> queryHaoMaZhuangTaiCBBList();

	int getIdByMc(@Param("mc") String mc);
}
