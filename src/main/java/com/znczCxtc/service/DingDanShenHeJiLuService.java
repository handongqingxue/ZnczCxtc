package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.DingDanShenHeJiLu;

public interface DingDanShenHeJiLuService {

	int queryForInt(String ddh, Integer shlx, String shsjks, String shsjjs, String cph, String shrYhm, String yssMc, String wzMc, String fhdwMc, String shbmMc, String sjxm,
			String sjsfzh);

	List<DingDanShenHeJiLu> queryList(String ddh, Integer shlx, String shsjks, String shsjjs, String cph, String shrYhm, String yssMc, String wzMc, String fhdwMc, String shbmMc,
			String sjxm, String sjsfzh, int page, int rows, String sort, String order);

	int deleteByIds(String ids);

}
