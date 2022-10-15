package com.znczCxtc.service.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.dao.*;
import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;

@Service
public class DingDanShenHeJiLuServiceImpl implements DingDanShenHeJiLuService {
	
	@Autowired
	private DingDanShenHeJiLuMapper shenHeJiLuDao;

	@Override
	public int queryForInt(String ddh, Integer shlx, String shsjks, String shsjjs, String cph, String shrYhm, String yssMc, String wzMc, String fhdwMc, String shbmMc, String sjxm,
			String sjsfzh) {
		// TODO Auto-generated method stub
		return shenHeJiLuDao.queryForInt(ddh, shlx, shsjks, shsjjs, cph, shrYhm, yssMc, wzMc, fhdwMc, shbmMc, sjxm, sjsfzh);
	}

	@Override
	public List<DingDanShenHeJiLu> queryList(String ddh, Integer shlx, String shsjks, String shsjjs, String cph, String shrYhm, String yssMc, String wzMc, String fhdwMc, String shbmMc,
			String sjxm, String sjsfzh, int page, int rows, String sort, String order) {
		// TODO Auto-generated method stub
		return shenHeJiLuDao.queryList(ddh, shlx, shsjks, shsjjs, cph, shrYhm, yssMc, wzMc, fhdwMc, shbmMc, sjxm, sjsfzh, (page-1)*rows, rows, sort, order);
	}

	@Override
	public int deleteByIds(String ids) {
		// TODO Auto-generated method stub
		int count=0;
		List<String> idList = Arrays.asList(ids.split(","));
		count=shenHeJiLuDao.deleteByIds(idList);
		return count;
	}

}
