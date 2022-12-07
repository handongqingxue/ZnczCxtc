package com.znczCxtc.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.dao.*;
import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;

@Service
public class YongHuShenHeJiLuServiceImpl implements YongHuShenHeJiLuService {

	@Autowired
	private YongHuShenHeJiLuMapper yongHuShenHeJiLuDao;

	@Override
	public int queryForInt(String yhm, String shrYhm, String shsjks, String shsjjs) {
		// TODO Auto-generated method stub
		return yongHuShenHeJiLuDao.queryForInt(yhm, shrYhm, shsjks, shsjjs);
	}

	@Override
	public List<YongHuShenHeJiLu> queryList(String yhm, String shrYhm, String shsjks, String shsjjs, int page, int rows,
			String sort, String order) {
		// TODO Auto-generated method stub
		return yongHuShenHeJiLuDao.queryList(yhm, shrYhm, shsjks, shsjjs, (page-1)*rows, rows, sort, order);
	}
}
