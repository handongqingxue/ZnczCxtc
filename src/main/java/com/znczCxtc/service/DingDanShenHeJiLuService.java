package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.DingDanShenHeJiLu;

public interface DingDanShenHeJiLuService {

	int queryForInt(String ddh, Integer shlx, String shsjks, String shsjjs, String cyclCph, String shrYhm, String yssMc, String wzMc, String fhdwMc, String shdwMc, String sjXm,
			String sjSfzh);

	List<DingDanShenHeJiLu> queryList(String ddh, Integer shlx, String shsjks, String shsjjs, String cyclCph, String shrYhm, String yssMc, String wzMc, String fhdwMc, String shdwMc,
			String sjXm, String sjSfzh, int page, int rows, String sort, String order);

	int deleteByIds(String ids);

}
