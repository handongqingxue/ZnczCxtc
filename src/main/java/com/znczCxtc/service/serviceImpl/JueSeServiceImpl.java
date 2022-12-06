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
	public List<JueSe> queryCBBList() {
		// TODO Auto-generated method stub
		return jueSeDao.queryCBBList();
	}
}
