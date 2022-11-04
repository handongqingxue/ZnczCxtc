package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.*;

public interface CheLiangShenHeJiLuService {

	int queryForInt(String clCph, String shrYhm, String shsjks, String shsjjs);

	List<CheLiangShenHeJiLu> queryList(String clCph, String shrYhm, String shsjks, String shsjjs, int page, int rows, String sort, String order);

	int deleteByIds(String ids);
}
