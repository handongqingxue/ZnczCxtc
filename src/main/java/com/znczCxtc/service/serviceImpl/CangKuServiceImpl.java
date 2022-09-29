package com.znczCxtc.service.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.dao.*;
import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;

@Service
public class CangKuServiceImpl implements CangKuService {

	@Autowired
	private CangKuMapper cangKuDao;

	@Override
	public int add(CangKu ck) {
		// TODO Auto-generated method stub
		return cangKuDao.add(ck);
	}

	@Override
	public int deleteByIds(String ids) {
		// TODO Auto-generated method stub
		int count=0;
		List<String> idList = Arrays.asList(ids.split(","));
		count = cangKuDao.deleteByIds(idList);
		return count;
	}

	@Override
	public int edit(CangKu ck) {
		// TODO Auto-generated method stub
		return cangKuDao.edit(ck);
	}

	@Override
	public int queryForInt(String mc) {
		// TODO Auto-generated method stub
		return cangKuDao.queryForInt(mc);
	}

	@Override
	public List<CangKu> queryList(String mc, int page, int rows, String sort, String order) {
		// TODO Auto-generated method stub
		return cangKuDao.queryList(mc, (page-1)*rows, rows, sort, order);
	}

	@Override
	public CangKu selectById(String id) {
		// TODO Auto-generated method stub
		return cangKuDao.selectById(id);
	}
}
