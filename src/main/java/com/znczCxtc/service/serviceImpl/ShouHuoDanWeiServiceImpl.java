package com.znczCxtc.service.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.entity.*;
import com.znczCxtc.dao.*;
import com.znczCxtc.service.*;

@Service
public class ShouHuoDanWeiServiceImpl implements ShouHuoDanWeiService {

	@Autowired
	private ShouHuoDanWeiMapper shouHuoDanWeiDao;
	
	@Override
	public int add(ShouHuoDanWei shdw) {
		// TODO Auto-generated method stub
		return shouHuoDanWeiDao.add(shdw);
	}

	@Override
	public int deleteByIds(String ids) {
		// TODO Auto-generated method stub
		int count=0;
		List<String> idList = Arrays.asList(ids.split(","));
		count=shouHuoDanWeiDao.deleteByIds(idList);
		return count;
	}

	@Override
	public int edit(ShouHuoDanWei shdw) {
		// TODO Auto-generated method stub
		return shouHuoDanWeiDao.edit(shdw);
	}

	@Override
	public int queryForInt(String mc) {
		// TODO Auto-generated method stub
		return shouHuoDanWeiDao.queryForInt(mc);
	}

	@Override
	public List<ShouHuoDanWei> queryList(String mc, int page, int rows, String sort, String order) {
		// TODO Auto-generated method stub
		return shouHuoDanWeiDao.queryList(mc, (page-1)*rows, rows, sort, order);
	}

	@Override
	public ShouHuoDanWei selectById(String id) {
		// TODO Auto-generated method stub
		return shouHuoDanWeiDao.selectById(id);
	}
	
	@Override
	public List<ShouHuoDanWei> queryCBBList() {
		// TODO Auto-generated method stub
		return shouHuoDanWeiDao.queryCBBList();
	}
}
