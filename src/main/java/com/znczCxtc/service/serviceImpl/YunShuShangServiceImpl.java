package com.znczCxtc.service.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.dao.*;
import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;

@Service
public class YunShuShangServiceImpl implements YunShuShangService {

	@Autowired
	private YunShuShangMapper yunShuShangDao;
	
	@Override
	public int add(YunShuShang yss) {
		// TODO Auto-generated method stub
		return yunShuShangDao.add(yss);
	}

	@Override
	public int deleteByIds(String ids) {
		// TODO Auto-generated method stub
		int count=0;
		List<String> idList = Arrays.asList(ids.split(","));
		count=yunShuShangDao.deleteByIds(idList);
		return count;
	}

	@Override
	public int edit(YunShuShang yss) {
		// TODO Auto-generated method stub
		return yunShuShangDao.edit(yss);
	}

	@Override
	public int queryForInt(String mc) {
		// TODO Auto-generated method stub
		return yunShuShangDao.queryForInt(mc);
	}

	@Override
	public List<YunShuShang> queryList(String mc, int page, int rows, String sort, String order) {
		// TODO Auto-generated method stub
		return yunShuShangDao.queryList(mc, (page-1)*rows, rows, sort, order);
	}

	@Override
	public YunShuShang selectById(String id) {
		// TODO Auto-generated method stub
		return yunShuShangDao.selectById(id);
	}
	
	@Override
	public List<YunShuShang> queryCBBList() {
		// TODO Auto-generated method stub
		return yunShuShangDao.queryCBBList();
	}
}
