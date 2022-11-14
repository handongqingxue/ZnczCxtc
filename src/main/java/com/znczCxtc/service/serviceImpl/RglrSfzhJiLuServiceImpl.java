package com.znczCxtc.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.dao.*;
import com.znczCxtc.service.*;

@Service
public class RglrSfzhJiLuServiceImpl implements RglrSfzhJiLuService {

	@Autowired
	private RglrSfzhJiLuMapper rglrSfzhJiLuDao;

	@Override
	public List<String> queryXzSfzhCBBList(int page, int rows, String sort, String order) {
		// TODO Auto-generated method stub
		return rglrSfzhJiLuDao.queryXzSfzhCBBList((page-1)*rows, rows, sort, order);
	}
}
