package com.znczCxtc.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.dao.*;
import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;

@Service
public class SiJiShenHeJiLuServiceImpl implements SiJiShenHeJiLuService {

	@Autowired
	private SiJiShenHeJiLuMapper siJiShenHeJiLuDao;
	
	@Override
	public int queryForInt(String sjXm, String shrYhm, String shsjks, String shsjjs) {
		// TODO Auto-generated method stub
		return siJiShenHeJiLuDao.queryForInt(sjXm, shrYhm, shsjks, shsjjs);
	}

	@Override
	public List<SiJiShenHeJiLu> queryList(String sjXm, String shrYhm, String shsjks, String shsjjs, int page, int rows,
			String sort, String order) {
		// TODO Auto-generated method stub
		return siJiShenHeJiLuDao.queryList(sjXm, shrYhm, shsjks, shsjjs, (page-1)*rows, rows, sort, order);
	}

	@Override
	public int deleteByIds(String ids) {
		// TODO Auto-generated method stub
		return 0;
	}

}
