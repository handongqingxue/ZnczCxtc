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
	private DingDanShenHeJiLuMapper dingDanShenHeJiLuDao;

	@Override
	public int queryForInt(String ddh, Integer shlx, String shsjks, String shsjjs, String cyclCph, String shrYhm, String yssMc, String wzMc, String fhdwMc, String shdwMc, String sjXm,
			String sjSfzh) {
		// TODO Auto-generated method stub
		return dingDanShenHeJiLuDao.queryForInt(ddh, shlx, shsjks, shsjjs, cyclCph, shrYhm, yssMc, wzMc, fhdwMc, shdwMc, sjXm, sjSfzh);
	}

	@Override
	public List<DingDanShenHeJiLu> queryList(String ddh, Integer shlx, String shsjks, String shsjjs, String cyclCph, String shrYhm, String yssMc, String wzMc, String fhdwMc, String shdwMc,
			String sjXm, String sjSfzh, int page, int rows, String sort, String order) {
		// TODO Auto-generated method stub
		return dingDanShenHeJiLuDao.queryList(ddh, shlx, shsjks, shsjjs, cyclCph, shrYhm, yssMc, wzMc, fhdwMc, shdwMc, sjXm, sjSfzh, (page-1)*rows, rows, sort, order);
	}

	@Override
	public int deleteByIds(String ids) {
		// TODO Auto-generated method stub
		int count=0;
		List<String> idList = Arrays.asList(ids.split(","));
		count=dingDanShenHeJiLuDao.deleteByIds(idList);
		return count;
	}

}
