package com.znczCxtc.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.dao.*;
import com.znczCxtc.service.*;
import com.znczCxtc.entity.*;

@Service
public class JueSeServiceImpl implements JueSeService {

	@Autowired
	private JueSeMapper jueSeDao;

	@Override
	public int add(JueSe js) {
		// TODO Auto-generated method stub
		return jueSeDao.add(js);
	}

	@Override
	public int queryForInt(String mc) {
		// TODO Auto-generated method stub
		return jueSeDao.queryForInt(mc);
	}

	@Override
	public List<JueSe> queryList(String mc, int page, int rows, String sort, String order) {
		// TODO Auto-generated method stub
		return jueSeDao.queryList(mc, (page-1)*rows, rows, sort, order);
	}

	@Override
	public List<JueSe> queryCBBList() {
		// TODO Auto-generated method stub
		return jueSeDao.queryCBBList();
	}
}
