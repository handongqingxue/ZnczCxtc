package com.znczCxtc.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.entity.*;
import com.znczCxtc.dao.*;
import com.znczCxtc.service.*;

@Service
public class DuiFangGuoBangJiLuServiceImpl implements DuiFangGuoBangJiLuService {

	@Autowired
	private DuiFangGuoBangJiLuMapper duiFangGuoBangJiLuDao;

	@Override
	public int add(DuiFangGuoBangJiLu dfgbjl) {
		// TODO Auto-generated method stub
		return duiFangGuoBangJiLuDao.add(dfgbjl);
	}
}
