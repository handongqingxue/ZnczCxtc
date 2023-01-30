package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.*;

public interface SiJiShenHeJiLuService {

	int deleteByIds(String ids);

	int queryForInt(String sjXm, String shrYhm, String shsjks, String shsjjs);

	List<SiJiShenHeJiLu> queryList(String sjXm, String shrYhm, String shsjks, String shsjjs, int page, int rows, String sort, String order);
}
