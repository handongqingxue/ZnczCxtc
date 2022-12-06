package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.*;

public interface YongHuService {

	int add(YongHu yh);
	
	int edit(YongHu yh);

	boolean checkMm(String mm, String yhm);

	int queryForInt(String yhm,Boolean check);

	List<YongHu> queryList(String yhm, Boolean check, int page, int rows, String sort, String order);

	YongHu selectById(String id);

	int updateMmById(String mm, Integer id);

}
