package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.*;

public interface CheLiangTaiZhangService {
	
	public int uploadJinChang(CheLiangTaiZhang cltz);
	
	public int uploadChuChang(CheLiangTaiZhang cltz);

	int deleteByIds(String ids);

	public int queryForInt(String ddh, String cyclCph, String ddztIds, String ddztMcs, String jcsjs, String jcsje,
			String ccsjs, String ccsje);

	public List<CheLiangTaiZhang> queryList(String ddh, String cyclCph, String ddztIds, String ddztMcs, String jcsjs,
			String jcsje, String ccsjs, String ccsje, int page, int rows, String sort, String order);

	public CheLiangTaiZhang selectById(String id);
}
