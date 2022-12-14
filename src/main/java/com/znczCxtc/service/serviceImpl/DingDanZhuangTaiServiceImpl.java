package com.znczCxtc.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.dao.*;
import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;

@Service
public class DingDanZhuangTaiServiceImpl implements DingDanZhuangTaiService {

	@Autowired
	private DingDanZhuangTaiMapper dingDanZhuangTaiDao;

	@Override
	public int add(DingDanZhuangTai ddzt) {
		// TODO Auto-generated method stub
		return dingDanZhuangTaiDao.add(ddzt);
	}

	@Override
	public int edit(DingDanZhuangTai ddzt) {
		// TODO Auto-generated method stub
		return dingDanZhuangTaiDao.edit(ddzt);
	}

	@Override
	public int queryForInt(String mc) {
		// TODO Auto-generated method stub
		return dingDanZhuangTaiDao.queryForInt(mc);
	}

	@Override
	public List<DingDanZhuangTai> queryList(String mc, int page, int rows, String sort, String order) {
		// TODO Auto-generated method stub
		return dingDanZhuangTaiDao.queryList(mc, (page-1)*rows, rows, sort, order);
	}

	@Override
	public DingDanZhuangTai selectById(String id) {
		// TODO Auto-generated method stub
		return dingDanZhuangTaiDao.selectById(id);
	}

	@Override
	public List<DingDanZhuangTai> queryCBBList() {
		// TODO Auto-generated method stub
		return dingDanZhuangTaiDao.queryCBBList();
	}
}
