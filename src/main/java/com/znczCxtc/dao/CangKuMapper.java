package com.znczCxtc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface CangKuMapper {

	public int add(CangKu ck);

	public int deleteByIds(List<String> idList);

	public int edit(CangKu ck);

	public int queryForInt(@Param("mc") String mc);

	public List<CangKu> queryList(@Param("mc") String mc, int i, int rows, String sort, String order);

	public CangKu selectById(String id);
}
