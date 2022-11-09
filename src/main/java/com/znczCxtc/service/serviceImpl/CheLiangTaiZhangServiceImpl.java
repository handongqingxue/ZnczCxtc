package com.znczCxtc.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.dao.*;
import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;

@Service
public class CheLiangTaiZhangServiceImpl implements CheLiangTaiZhangService {

	@Autowired
	private CheLiangTaiZhangMapper cheLiangTaiZhangDao;

	@Override
	public int uploadJinChang(CheLiangTaiZhang cltz) {
		// TODO Auto-generated method stub
		return cheLiangTaiZhangDao.uploadJinChang(cltz);
	}

	@Override
	public int uploadChuChang(CheLiangTaiZhang cltz) {
		// TODO Auto-generated method stub
		return cheLiangTaiZhangDao.uploadChuChang(cltz);
	}
}
