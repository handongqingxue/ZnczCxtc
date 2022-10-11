package com.znczCxtc.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.dao.*;
import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;

@Service
public class HaoMaZhuangTaiServiceImpl implements HaoMaZhuangTaiService {

	@Autowired
	private HaoMaZhuangTaiMapper haoMaZhuangTaiDao;
	
	@Override
	public int add(HaoMaZhuangTai hmzt) {
		// TODO Auto-generated method stub
		return haoMaZhuangTaiDao.add(hmzt);
	}

	@Override
	public int edit(HaoMaZhuangTai hmzt) {
		// TODO Auto-generated method stub
		return haoMaZhuangTaiDao.edit(hmzt);
	}

	@Override
	public int queryForInt(String mc) {
		// TODO Auto-generated method stub
		return haoMaZhuangTaiDao.queryForInt(mc);
	}

	@Override
	public List<HaoMaZhuangTai> queryList(String mc, int page, int rows, String sort, String order) {
		// TODO Auto-generated method stub
		return haoMaZhuangTaiDao.queryList(mc, (page-1)*rows, rows, sort, order);
	}

	@Override
	public HaoMaZhuangTai selectById(String id) {
		// TODO Auto-generated method stub
		return haoMaZhuangTaiDao.selectById(id);
	}

	@Override
	public List<HaoMaZhuangTai> queryHaoMaZhuangTaiCBBList() {
		// TODO Auto-generated method stub
		return haoMaZhuangTaiDao.queryHaoMaZhuangTaiCBBList();
	}
}
