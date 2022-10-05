package com.znczCxtc.service.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.dao.*;
import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;

@Service
public class DuiLieServiceImpl implements DuiLieService {

	@Autowired
	private DuiLieMapper duiLieDao;

	@Override
	public int add(DuiLie dl) {
		// TODO Auto-generated method stub
		return duiLieDao.add(dl);
	}

	@Override
	public int deleteByIds(String ids) {
		// TODO Auto-generated method stub
		int count=0;
		List<String> idList = Arrays.asList(ids.split(","));
		count = duiLieDao.deleteByIds(idList);
		return count;
	}

	@Override
	public int edit(DuiLie dl) {
		// TODO Auto-generated method stub
		return duiLieDao.edit(dl);
	}
	
	@Override
	public int queryForInt(String mc, String dm, Integer zt) {
		// TODO Auto-generated method stub
		return duiLieDao.queryForInt(mc,dm,zt);
	}

	@Override
	public List<DuiLie> queryList(String mc, String dm, Integer zt, int page, int rows, String sort, String order) {
		// TODO Auto-generated method stub
		return duiLieDao.queryList(mc, dm, zt, (page-1)*rows, rows, sort, order);
	}

	@Override
	public DuiLie selectById(String id) {
		// TODO Auto-generated method stub
		return duiLieDao.selectById(id);
	}

}
