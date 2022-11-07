package com.znczCxtc.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.dao.*;
import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;

@Service
public class HaoMaServiceImpl implements HaoMaService {

	@Autowired
	private HaoMaMapper haoMaDao;

	@Override
	public int queryForInt(String dlMc, String hm, String pdh, Integer ztId) {
		// TODO Auto-generated method stub
		return haoMaDao.queryForInt(dlMc,hm,pdh,ztId);
	}

	@Override
	public List<HaoMa> queryList(String dlMc, String hm, String pdh, Integer ztId, int page, int rows, String sort,
			String order) {
		// TODO Auto-generated method stub
		return haoMaDao.queryList(dlMc, hm, pdh, ztId, (page-1)*rows, rows, sort, order);
	}

	@Override
	public int newHaoMaChaXun(HaoMa hm) {
		// TODO Auto-generated method stub
		return haoMaDao.newHaoMaChaXun(hm);
	}

	@Override
	public HaoMa selectHaoMaById(String id) {
		// TODO Auto-generated method stub
		return haoMaDao.selectHaoMaById(id);
	}

	@Override
	public List<HaoMa> getJhPdList() {
		// TODO Auto-generated method stub
		return haoMaDao.getJhPdList();
	}
}
