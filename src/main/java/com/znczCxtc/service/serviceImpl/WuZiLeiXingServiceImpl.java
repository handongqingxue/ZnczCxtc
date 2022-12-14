package com.znczCxtc.service.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.dao.*;
import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;

@Service
public class WuZiLeiXingServiceImpl implements WuZiLeiXingService {

	@Autowired
	private WuZiLeiXingMapper wuZiLeiXingDao;

	@Override
	public int add(WuZiLeiXing wzlx) {
		// TODO Auto-generated method stub
		return wuZiLeiXingDao.add(wzlx);
	}

	@Override
	public int deleteByIds(String ids) {
		// TODO Auto-generated method stub
		int count=0;
		List<String> idList = Arrays.asList(ids.split(","));
		count=wuZiLeiXingDao.deleteByIds(idList);
		return count;
	}

	@Override
	public int edit(WuZiLeiXing wzlx) {
		// TODO Auto-generated method stub
		return wuZiLeiXingDao.edit(wzlx);
	}

	@Override
	public int queryForInt(String mc) {
		// TODO Auto-generated method stub
		return wuZiLeiXingDao.queryForInt(mc);
	}

	@Override
	public List<WuZiLeiXing> queryList(String mc, int page, int rows, String sort, String order) {
		// TODO Auto-generated method stub
		return wuZiLeiXingDao.queryList(mc, (page-1)*rows, rows, sort, order);
	}

	@Override
	public WuZiLeiXing selectById(String id) {
		// TODO Auto-generated method stub
		return wuZiLeiXingDao.selectById(id);
	}

	@Override
	public List<WuZiLeiXing> queryCBBList() {
		// TODO Auto-generated method stub
		return wuZiLeiXingDao.queryCBBList();
	}
}
