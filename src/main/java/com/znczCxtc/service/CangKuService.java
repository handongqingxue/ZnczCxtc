package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.*;

public interface CangKuService {

	public int add(CangKu ck);

	public int deleteByIds(String ids);

	public int edit(CangKu ck);

	public int queryForInt(String mc);

	public List<CangKu> queryList(String mc, int page, int rows, String sort, String order);

	public CangKu selectById(String id);
}
