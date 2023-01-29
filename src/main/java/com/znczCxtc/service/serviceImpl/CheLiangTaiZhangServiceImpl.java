package com.znczCxtc.service.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.dao.*;
import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;

@Service
public class CheLiangTaiZhangServiceImpl implements CheLiangTaiZhangService {

	@Autowired
	private CheLiangTaiZhangMapper cheLiangTaiZhangDao;

	@Override
	public int uploadJinChang(CheLiangTaiZhang cltz) {
		// TODO Auto-generated method stub
		return cheLiangTaiZhangDao.uploadJinChang(cltz);
	}

	@Override
	public int uploadChuChang(CheLiangTaiZhang cltz) {
		// TODO Auto-generated method stub
		return cheLiangTaiZhangDao.uploadChuChang(cltz);
	}

	@Override
	public int queryForInt(String ddh, String cyclCph, String ddztIds, String ddztMcs, String jcsjs, String jcsje,
			String ccsjs, String ccsje) {
		// TODO Auto-generated method stub
		List<String> ddztIdList = null;
		if(!StringUtils.isBlank(ddztIds))
			ddztIdList = Arrays.asList(ddztIds.split(","));
		
		List<String> ddztMcList = null;
		if(!StringUtils.isBlank(ddztMcs))
			ddztMcList = Arrays.asList(ddztMcs.split(","));
		return cheLiangTaiZhangDao.queryForInt(ddh, cyclCph, ddztIdList, ddztMcList, jcsjs, jcsje, ccsjs, ccsje);
	}

	@Override
	public List<CheLiangTaiZhang> queryList(String ddh, String cph, String ddztIds, String ddztMcs, String jcsjs,
			String jcsje, String ccsjs, String ccsje, int page, int rows, String sort, String order) {
		// TODO Auto-generated method stub
		List<String> ddztIdList = null;
		if(!StringUtils.isBlank(ddztIds))
			ddztIdList = Arrays.asList(ddztIds.split(","));
		
		List<String> ddztMcList = null;
		if(!StringUtils.isBlank(ddztMcs))
			ddztMcList = Arrays.asList(ddztMcs.split(","));
		return cheLiangTaiZhangDao.queryList(ddh, cph, ddztIdList, ddztMcList, jcsjs, jcsje, ccsjs, ccsje, 
				(page-1)*rows, rows, sort, order);
	}

	@Override
	public CheLiangTaiZhang selectById(String id) {
		// TODO Auto-generated method stub
		return cheLiangTaiZhangDao.selectById(id);
	}
}
