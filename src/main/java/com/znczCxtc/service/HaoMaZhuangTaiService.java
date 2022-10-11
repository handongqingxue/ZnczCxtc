package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.*;

public interface HaoMaZhuangTaiService {

	int add(HaoMaZhuangTai hmzt);

	int edit(HaoMaZhuangTai hmzt);

	int queryForInt(String mc);

	List<HaoMaZhuangTai> queryList(String mc, int page, int rows, String sort, String order);

	HaoMaZhuangTai selectById(String id);

	public List<HaoMaZhuangTai> queryHaoMaZhuangTaiCBBList();
}
