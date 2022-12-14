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

	@Override
	public int editByDdId(DuiFangGuoBangJiLu dfgbjl) {
		// TODO Auto-generated method stub
		return duiFangGuoBangJiLuDao.editByDdId(dfgbjl);
	}

	@Override
	public DuiFangGuoBangJiLu selectByDdId(String ddId) {
		// TODO Auto-generated method stub
		return duiFangGuoBangJiLuDao.selectByDdId(ddId);
	}

	@Override
	public boolean checkIfExistByDdId(Long ddId) {
		// TODO Auto-generated method stub
		int count=duiFangGuoBangJiLuDao.getCountByDdId(ddId);
		return count==0?false:true;
	}

	@Override
	public int updateFileByDdId(DuiFangGuoBangJiLu dfgbjl) {
		// TODO Auto-generated method stub
		return duiFangGuoBangJiLuDao.updateFileByDdId(dfgbjl);
	}
}
