package com.znczCxtc.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.entity.*;
import com.znczCxtc.dao.*;
import com.znczCxtc.service.*;

@Service
public class SiJiServiceImpl implements SiJiService {

	@Autowired
	private SiJiMapper siJiDao;
	
	@Override
	public int add(SiJi sj) {
		// TODO Auto-generated method stub
		return siJiDao.add(sj);
	}

	@Override
	public int edit(SiJi sj) {
		// TODO Auto-generated method stub
		return siJiDao.edit(sj);
	}

	@Override
	public int queryForInt(String xm, String sjh, String sfzh, Integer zyzt,Integer shzt) {
		// TODO Auto-generated method stub
		return siJiDao.queryForInt(xm,sjh,sfzh,zyzt,shzt);
	}

	@Override
	public List<SiJi> queryList(String xm, String sjh, String sfzh, Integer zyzt, Integer shzt, int page, int rows, String sort,
			String order) {
		// TODO Auto-generated method stub
		return siJiDao.queryList(xm, sjh, sfzh, zyzt, shzt, (page-1)*rows, rows, sort, order);
	}

	@Override
	public SiJi selectById(String id) {
		// TODO Auto-generated method stub
		return siJiDao.selectById(id);
	}
}
