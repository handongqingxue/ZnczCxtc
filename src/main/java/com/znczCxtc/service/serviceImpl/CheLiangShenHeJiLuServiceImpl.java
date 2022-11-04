package com.znczCxtc.service.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.dao.*;
import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;

@Service
public class CheLiangShenHeJiLuServiceImpl implements CheLiangShenHeJiLuService {

	@Autowired
	private CheLiangShenHeJiLuMapper cheLiangShenHeJiLuDao;

	@Override
	public int queryForInt(String clCph, String shrYhm, String shsjks, String shsjjs) {
		// TODO Auto-generated method stub
		return cheLiangShenHeJiLuDao.queryForInt(clCph, shrYhm, shsjks, shsjjs);
	}

	@Override
	public List<CheLiangShenHeJiLu> queryList(String clCph, String shrYhm, String shsjks, String shsjjs, int page,
			int rows, String sort, String order) {
		// TODO Auto-generated method stub
		return cheLiangShenHeJiLuDao.queryList(clCph, shrYhm, shsjks, shsjjs, (page-1)*rows, rows, sort, order);
	}

	@Override
	public int deleteByIds(String ids) {
		// TODO Auto-generated method stub
		int count=0;
		List<String> idList = Arrays.asList(ids.split(","));
		count=cheLiangShenHeJiLuDao.deleteByIds(idList);
		return count;
	}
}
