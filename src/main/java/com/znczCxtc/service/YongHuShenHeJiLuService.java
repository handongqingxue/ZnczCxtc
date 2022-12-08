package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.*;

public interface YongHuShenHeJiLuService {

	int queryForInt(String yhm, String shrYhm, String shsjks, String shsjjs);

	List<YongHuShenHeJiLu> queryList(String yhm, String shrYhm, String shsjks, String shsjjs, int page, int rows,
			String sort, String order);

	int deleteByIds(String ids);
}
