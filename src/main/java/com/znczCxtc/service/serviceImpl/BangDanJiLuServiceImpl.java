package com.znczCxtc.service.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.dao.*;
import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;

@Service
public class BangDanJiLuServiceImpl implements BangDanJiLuService {

	@Autowired
	private BangDanJiLuMapper bangDanJiLuDao;

	@Override
	public int add(BangDanJiLu bdjl) {
		// TODO Auto-generated method stub
		return bangDanJiLuDao.add(bdjl);
	}

	@Override
	public int deleteByIds(String ids) {
		// TODO Auto-generated method stub
		int count=0;
		List<String> idList = Arrays.asList(ids.split(","));
		count=bangDanJiLuDao.deleteByIds(idList);
		return count;
	}

	@Override
	public int edit(BangDanJiLu bdjl) {
		// TODO Auto-generated method stub
		return bangDanJiLuDao.edit(bdjl);
	}

	@Override
	public int queryForInt(String ddh) {
		// TODO Auto-generated method stub
		return bangDanJiLuDao.queryForInt(ddh);
	}

	@Override
	public List<BangDanJiLu> queryList(String ddh, int page, int rows, String sort, String order) {
		// TODO Auto-generated method stub
		return bangDanJiLuDao.queryList(ddh, (page-1)*rows, rows, sort, order);
	}

	@Override
	public BangDanJiLu selectById(String id) {
		// TODO Auto-generated method stub
		return bangDanJiLuDao.selectById(id);
	}

	@Override
	public BangDanJiLu selectByDdId(Integer ddId) {
		// TODO Auto-generated method stub
		return bangDanJiLuDao.selectByDdId(ddId);
	}

	@Override
	public boolean checkIfExistByDdId(Long ddId) {
		// TODO Auto-generated method stub
		int count=bangDanJiLuDao.getCountByDdId(ddId);
		return count==0?false:true;
	}

	@Override
	public int deleteByDdId(Long ddId) {
		// TODO Auto-generated method stub
		return bangDanJiLuDao.deleteByDdId(ddId);
	}
}
